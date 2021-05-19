package input;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.apache.commons.io.FileUtils;

import commands.OpenDocument;
import view.Text2SpeechEditorView;

public class TxtReader implements DocumentReader{

	public TxtReader()
	{

	}

	public void read()
	{
		try {
			List<String> lines = FileUtils.readLines(OpenDocument.getOpenNewFile(), StandardCharsets.UTF_8);
			for(String line: lines)
			{

				Text2SpeechEditorView.getFileContents().append(line);
			}
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		} 
		catch (NullPointerException e)
		{
			e.printStackTrace();
		}
	}
}
