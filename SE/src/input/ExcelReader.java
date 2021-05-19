package input;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import commands.OpenDocument;

import view.Text2SpeechEditorView;

public class ExcelReader implements DocumentReader
{
	public ExcelReader(){}

	public void read()
	{
		try  
		{  
			//file = new File(path);   //creating a new file instance  
			FileInputStream fis = new FileInputStream(OpenDocument.getOpenNewFile());   //obtaining bytes from the file  
			//creating Workbook instance that refers to .xlsx file  
			XSSFWorkbook wb = new XSSFWorkbook(fis);   
			XSSFSheet sheet = wb.getSheetAt(0);     //creating a Sheet object to retrieve object  
			Iterator<Row> itr = sheet.iterator();    //iterating over excel file  
			while (itr.hasNext())                 
			{  
				Row row = itr.next();  
				Iterator<Cell> cellIterator = row.cellIterator();   //iterating over each column  
				while (cellIterator.hasNext())   
				{  
					Cell cell = cellIterator.next();  
					switch (cell.getCellType() )               
					{  
					case STRING:    //field that represents string cell type  
						System.out.print(cell.getStringCellValue() + "\t\t\t");  
						break;  
					case NUMERIC:    //field that represents number cell type  
						System.out.print(cell.getNumericCellValue() + "\t\t\t");  
						break;  
					default:  
					}
					Text2SpeechEditorView.getFileContents().append(cell.toString() + "\t");
				}  
				System.out.println("");
				Text2SpeechEditorView.getFileContents().append("\n");
			}  
		}  
		catch (FileNotFoundException ed) 
		{
			// TODO Auto-generated catch block
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
