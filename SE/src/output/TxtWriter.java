package output;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import org.apache.commons.io.FileUtils;
import java.io.File;

import commands.SaveDocument;
import view.Text2SpeechEditorView;

public class TxtWriter implements DocumentWriter{

	public TxtWriter()
	{

	}

	public void write()
	{
		
		String savedText = Text2SpeechEditorView.getFileContents().getText();
		try {
			File newFile = new File(SaveDocument.getSaveNewFile().toString());
			FileUtils.writeStringToFile(newFile, savedText, StandardCharsets.UTF_8);
			System.out.println(".txt document written successfully on disk.");

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
