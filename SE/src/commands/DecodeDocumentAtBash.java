package commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import model.Document;

public class DecodeDocumentAtBash implements ActionListener 
{
	private Document decodeDoc;	
	private String decodeFileName;
	private String decodeFilePath;
	private String decodeFileFormat;
	
	public DecodeDocumentAtBash() {}

	@Override
	public void actionPerformed(ActionEvent e) {
		Document.setEncodingType("atbash");
		Document.setIsEncoded("encoded");
		
		decodeDoc = new Document();
		decodeFileName = Document.getCurrentFileName();
		decodeFilePath = Document.getCurrentFilePath();
		decodeFileFormat = Document.getCurrentFileFormat();
		
		decodeDoc.decode(decodeFileName, decodeFilePath, decodeFileFormat);
	}
}
