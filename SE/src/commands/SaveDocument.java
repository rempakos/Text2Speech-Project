package commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.apache.commons.compress.utils.FileNameUtils;

import model.Document;
import view.Text2SpeechEditorView;

public class SaveDocument implements ActionListener{
	private static String saveFilePath;
	private static File saveNewFile;
	private static String saveFileFormat;
	private Document doc;
	private JFileChooser fileSaver;

	public SaveDocument(){}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		doc = new Document();
		fileSaver = new JFileChooser();
		int result = fileSaver.showSaveDialog(fileSaver);

		if(fileSaver.getSelectedFile() != null) {
			saveNewFile = fileSaver.getSelectedFile();
			saveFilePath = fileSaver.getSelectedFile().getAbsolutePath();
			saveFileFormat = FileNameUtils.getExtension(saveNewFile.toString());
		}
		else {
			saveFilePath = "";
			saveFileFormat = "";
		}





		if (result == JFileChooser.APPROVE_OPTION && validType(saveFileFormat,saveFilePath) == true) {				

			try {
				doc.save(saveNewFile.toString(), saveFilePath, saveFileFormat);
			} catch (IOException eIO) {
				eIO.printStackTrace();
			}


		}else if(result == JFileChooser.CANCEL_OPTION){
			JOptionPane.showMessageDialog(Text2SpeechEditorView.getFrame(),"Exiting file chooser . . .","Cancelled!", JOptionPane.WARNING_MESSAGE);
		}else if(result == JFileChooser.ERROR_OPTION){
			JOptionPane.showMessageDialog(Text2SpeechEditorView.getFrame(),"Encountered a fatal error!", "ERROR", JOptionPane.ERROR_MESSAGE);
		}else if(validType(saveFileFormat, saveFilePath) == false){
			JOptionPane.showMessageDialog(Text2SpeechEditorView.getFrame(),"You type a valid save file format!", "ERROR", JOptionPane.ERROR_MESSAGE);
		}else if(!fileSaver.getCurrentDirectory().exists() ) {
			JOptionPane.showMessageDialog(Text2SpeechEditorView.getFrame(),"You type a valid save file format!", "ERROR", JOptionPane.ERROR_MESSAGE);
		}else{return;}
	}

	public boolean validType(String format, String path) {
		if(format.equals("txt") && path != null) {return true;}
		else if(format.equals("docx") && path != null){return true;}
		else if(format.equals("xlsx") && path != null){return true;}
		else{return false;}	
	}

	// GETTER-SETTER SECTION
	public static File getSaveNewFile()
	{
		return saveNewFile;
	}

	public static String getSaveFilePath()
	{
		return saveFilePath;
	}

	public static String getSaveFileFormat()
	{
		return saveFileFormat;
	}


}
