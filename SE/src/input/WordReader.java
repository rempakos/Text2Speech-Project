package input;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import commands.OpenDocument;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import view.Text2SpeechEditorView;

public class WordReader implements DocumentReader
{
	public WordReader()
	{

	}

	public void read()
	{
		try 
		{
			FileInputStream fis = new FileInputStream(OpenDocument.getOpenFilePath());
			XWPFDocument xdoc = new XWPFDocument(OPCPackage.open(fis));
			XWPFWordExtractor extractor = new XWPFWordExtractor(xdoc);
			System.out.println(extractor.getText());
			Text2SpeechEditorView.getFileContents().append(extractor.getText());
			Text2SpeechEditorView.getFileContents().append("\n");

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