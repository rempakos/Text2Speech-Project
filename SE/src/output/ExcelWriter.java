package output;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import commands.OpenDocument;
import commands.SaveDocument;
import view.Text2SpeechEditorView;

public class ExcelWriter implements DocumentWriter
{
	public ExcelWriter()
	{

	}

	public void write()
	{
		try {
			Map<String, String[]> data = new TreeMap<String, String[]>();

			File file = OpenDocument.getOpenNewFile();
			System.out.println(file.getCanonicalPath());
			Scanner s = new Scanner(Text2SpeechEditorView.getFileContents().getText());

			ArrayList<String> list = new ArrayList<String>();

			while (s.hasNextLine()) {	
				list.add(s.nextLine()); // process the line
			}
			s.close();//Scanner no longer required

			
			for(String line: list)
			{
				String[] splited = line.split("\t"); //Split by 'TAB'
				data.put(line, splited);
			}

			XSSFWorkbook workbook = new XSSFWorkbook();// Blank workbook

			XSSFSheet sheet = workbook.createSheet("Sheet1");// Create a blank sheet

			
			Set<String> keyset = data.keySet(); // Iterate over data and write to sheet
			int rownum = 0;
			for (String key : keyset) {
				Row row = sheet.createRow(rownum++); // this creates a new row in the sheet
				Object[] objArr = data.get(key);
				int cellnum = 0;
				for (Object obj : objArr) {
					Cell cell = row.createCell(cellnum++);// this line creates a cell in the next column of that row
					if (obj instanceof String)
						cell.setCellValue((String)obj);
					else if (obj instanceof Integer)
						cell.setCellValue((Integer)obj);
				}
			}
			try {
				FileOutputStream out = new FileOutputStream(SaveDocument.getSaveNewFile());
				workbook.write(out);
				out.close();
				System.out.println(".xlsx document written successfully on disk.");
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}catch (FileNotFoundException ed) 
		{
			ed.printStackTrace();
		} 
		catch (IOException ex)
		{
			ex.printStackTrace();
		} 
		catch (NullPointerException ez)
		{
			ez.printStackTrace();
		}
		catch (Exception E)
		{
			E.printStackTrace();
		} 
	}
}		