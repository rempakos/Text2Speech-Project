package input;


import model.Document;
import view.Text2SpeechEditorView;

public class ReaderRot13Decorator extends ReaderDecorator 
{

	
	
	public ReaderRot13Decorator(DocumentReader componentReader) 
	{
		super(componentReader);
	}
	
	private String decode(String text) {
		String temp = "";
        for (int i = 0; i < text.length(); i++) {
        	
            char c = text.charAt(i);
            if       (c >= 'a' && c <= 'm') c += 13;
            else if  (c >= 'A' && c <= 'M') c += 13;
            else if  (c >= 'n' && c <= 'z') c -= 13;
            else if  (c >= 'N' && c <= 'Z') c -= 13;
            temp = temp + c;
        }
        return temp;
	}

	public void Rot13Decoder()
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
		this.Rot13Decoder();
	}
}
