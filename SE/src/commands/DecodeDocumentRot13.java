package commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Document;

public class DecodeDocumentRot13 implements ActionListener 
{
	private Document decodeDoc;	
	private String decodeFileName;
	private String decodeFilePath;
	private String decodeFileFormat;
	
	public DecodeDocumentRot13() {}

	@Override
	public void actionPerformed(ActionEvent e) {
		Document.setEncodingType("rot13");
		Document.setIsEncoded("encoded");
		
		decodeDoc = new Document();
		decodeFileName = Document.getCurrentFileName();
		decodeFilePath = Document.getCurrentFilePath();
		decodeFileFormat = Document.getCurrentFileFormat();
		
		decodeDoc.decode(decodeFileName, decodeFilePath, decodeFileFormat);


	}

}
