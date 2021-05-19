package output;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import commands.SaveDocument;
import view.Text2SpeechEditorView;

public class WordWriter implements DocumentWriter {

	public void write()  
	{
		try
		{                                  
			XWPFDocument document  = new XWPFDocument();
			FileOutputStream out = new FileOutputStream(SaveDocument.getSaveNewFile());
			XWPFParagraph para = document.createParagraph();
			XWPFRun run = para.createRun();

			run.setText(Text2SpeechEditorView.getFileContents().getText());
			document.write(out);
			out.close();

			System.out.println(".word document written successfully on disk.");

		}
		catch (FileNotFoundException ed) 
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