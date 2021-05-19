package commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import model.Document;

public class EncodeDocumentRot13 implements ActionListener {

	private Document encodeDoc;	
	private String encodeFileName;
	private String encodeFilePath;
	private String encodeFileFormat;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Document.setEncodingType("rot13");
		Document.setIsEncoded("encoded");
		
		encodeDoc = new Document();
		encodeFileName = Document.getCurrentFileName();
		encodeFilePath = Document.getCurrentFilePath();
		encodeFileFormat = Document.getCurrentFileFormat();
		
		try {
			encodeDoc.encode(encodeFileName, encodeFilePath, encodeFileFormat);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
