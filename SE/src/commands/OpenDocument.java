package commands;

import org.apache.commons.compress.utils.FileNameUtils;

import view.Text2SpeechEditorView;
import model.Document;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;




public class OpenDocument implements ActionListener{
	private static String openFilePath;
	private static File openNewFile;
	private static String openFileFormat;
	private Document doc;
	private JFileChooser fileChooser;

	public OpenDocument(){}

	@Override
	public void actionPerformed(ActionEvent e) {		
		fileChooser = new JFileChooser();
		int result = fileChooser.showOpenDialog(null);
		
		
		if(fileChooser.getSelectedFile() != null) {
			openNewFile = fileChooser.getSelectedFile();
			openFilePath = fileChooser.getSelectedFile().getAbsolutePath();
			openFileFormat = FileNameUtils.getExtension(openNewFile.toString());
		}
		else {
			openFilePath = "";
			openFileFormat = "";
		}
		
		//openNewFile = fileChooser.getSelectedFile();
		//openFilePath = fileChooser.getSelectedFile().getAbsolutePath();
		//openFileFormat = FileNameUtils.getExtension(openNewFile.toString());

		if (result == JFileChooser.APPROVE_OPTION && validType(openFileFormat,openFilePath) == true) {
			Text2SpeechEditorView.getFileContents().setEditable(true);
			Text2SpeechEditorView.getFrame().repaint();
			Text2SpeechEditorView.getFileContents().setText(null);
			////
			Document.setEncodingType("none");
			Document.setIsEncoded("encodedNOT");
			////

			////
			doc = new Document();
			doc.open(openNewFile.toString(),openFilePath,openFileFormat);

		}else if(result == JFileChooser.CANCEL_OPTION){
			JOptionPane.showMessageDialog(Text2SpeechEditorView.getFrame(),"Exiting file chooser . . .","Cancelled!", JOptionPane.WARNING_MESSAGE);
		}else if(result == JFileChooser.ERROR_OPTION) {
			JOptionPane.showMessageDialog(Text2SpeechEditorView.getFrame(),"Encountered a fatal error!","ERROR", JOptionPane.ERROR_MESSAGE);
		}else if(validType(openFileFormat, openFilePath) == false) {
			JOptionPane.showMessageDialog(Text2SpeechEditorView.getFrame(),"You must select an existing file!","ERROR", JOptionPane.ERROR_MESSAGE);
		}else if(!fileChooser.getCurrentDirectory().exists() ) {
			JOptionPane.showMessageDialog(Text2SpeechEditorView.getFrame(),"You type a valid save file format!", "ERROR", JOptionPane.ERROR_MESSAGE);
		}else{return;}
	}
	public boolean validType(String format, String path) {
		if(format.equals("txt") && path != null) {return true;}
		else if(format.equals("docx") && path != null){return true;}
		else if(format.equals("xlsx") && path != null){return true;}
		else{return false;}	
	}
	
	//GETTER-SETTER SECTION

	public static File getOpenNewFile()
	{
		return openNewFile;
	}

	public static String getOpenFilePath()
	{
		return openFilePath;
	}

	public static String getOpenFileFormat()
	{
		return openFileFormat;
	}
}
