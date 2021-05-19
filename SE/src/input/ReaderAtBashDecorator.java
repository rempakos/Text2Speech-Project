package input;


import model.Document;
import view.Text2SpeechEditorView;

public class ReaderAtBashDecorator extends ReaderDecorator 
{

	public ReaderAtBashDecorator(DocumentReader componentReader) 
	{
		super(componentReader);
	}
	
	
	public String decode(String ciphertext)
    {
        String plaintext = "";
        for(char c : ciphertext.toCharArray())
        {
            if(Character.isLetter(c))
            {
                plaintext += (char) ('z' + ('a' - c));
            }
            else
            {
                plaintext += c;
            }
        }
        return plaintext;
    }
	

	public void AtBashDecoder()
	{
		String currentText = Text2SpeechEditorView.getFileContents().getText();
		Text2SpeechEditorView.getFileContents().setText("");
		currentText = decode(currentText);		
		currentText = currentText.substring(0, currentText.length() - Document.getCurrentJTextLen());				
		Text2SpeechEditorView.getFileContents().setText(currentText);	
	}

	@Override
	public void read() {
		componentReader.read();
		this.AtBashDecoder();
	}
}
