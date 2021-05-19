package output;

import java.io.IOException;

import view.Text2SpeechEditorView;

public class WriterAtBashDecorator extends WriterDecorator 
{

	public WriterAtBashDecorator(DocumentWriter componentWriter) 
	{
		super(componentWriter);
		// TODO Auto-generated constructor stub
	}
	
	private String getSubStrings(String input)
    {
        String out = "";
        for(int i = 0; i < input.length(); i += 5)
        {
            if(i + 5 <= input.length())
            {
                out += (input.substring(i, i + 5) + " ");
            }
            else
            {
                out += (input.substring(i) + " ");
            }
        }
        return out;
    }
	
	private String removeUnwantedChars(String input)
    {
        String out = "";
        for(char c : input.toCharArray())
        {
            if(Character.isLetterOrDigit(c))
            {
                out += c;
            }
        }
        return out;
    }
	
	
	public String encode(String plaintext)
    {
        String ciphertext = "";
        plaintext = removeUnwantedChars(plaintext.toLowerCase());
        for(char c : plaintext.toCharArray())
        {
            if(Character.isLetter(c))
            {
                ciphertext += (char) ('a' + ('z' - c));
            }
            else
            {
                ciphertext += c;
            }
        }
        return getSubStrings(ciphertext).trim();
    }


	public void AtBashEncoder()
	{
		
		String currentText = Text2SpeechEditorView.getFileContents().getText();
		Text2SpeechEditorView.getFileContents().setText("");
		currentText = currentText.substring(0, currentText.length()/2);
		Text2SpeechEditorView.getFileContents().setText(encode(currentText));
		

	}

	@Override
	public void write() {
		System.out.println("i am at write");
		//this.AtBashDecoder();

		try {
			componentWriter.write();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.AtBashEncoder();
	}
}
