package model;

import java.io.IOException;


import input.DocumentReader;
import input.DocumentReaderFactory;
import output.DocumentWriter;
import output.DocumentWriterFactory;
import view.Text2SpeechEditorView;

public class Document {
	private static Integer currentJTextLen;
	private DocumentReader documentReader;
	private DocumentReaderFactory docReaderFactory;
	private DocumentWriter documentWriter;
	private DocumentWriterFactory docWriterFactory;
	
	private static String currentFileName;
	private static String currentFilePath;
	private static String currentFileFormat;
	
	private static String isEncoded;
	private static String encodingType;
	
	public Document(){}

	public void open(String name,String path,String format)
	{
			Text2SpeechEditorView.getEncodeRot13().setEnabled(true);
			Text2SpeechEditorView.getEncodeAtbash().setEnabled(true);
			Text2SpeechEditorView.getDecodeRot13().setEnabled(true);
			Text2SpeechEditorView.getDecodeAtbash().setEnabled(true);
			Text2SpeechEditorView.getSave().setEnabled(true);
			Document.setCurrentFileName(name);
			Document.setCurrentFilePath(path);
			Document.setCurrentFileFormat(format);

			docReaderFactory = new DocumentReaderFactory();
			documentReader = docReaderFactory.createReader(name,path,format);


			documentReader.read();

			setCurrentJTextLen(Text2SpeechEditorView.getFileContents().getText().length());


	}	
	
	public void save(String name,String path,String format) throws IOException
	{
		docWriterFactory = new DocumentWriterFactory();
		documentWriter = docWriterFactory.createWriter(name,path,format);
		documentWriter.write();
	}
	
	public void encode(String name, String path, String format) throws IOException {
		docWriterFactory = new DocumentWriterFactory();
		documentWriter = docWriterFactory.createWriter(name,path,format);
		documentWriter.write();
	}
	public void decode(String name, String path, String format) {
		docReaderFactory = new DocumentReaderFactory();
		documentReader = docReaderFactory.createReader(name, path, format);
		documentReader.read();
	}
	
	//GETTER-SETTER SECTION

	public static String getCurrentFileName() {
		return currentFileName;
	}

	public static void setCurrentFileName(String currentFileName) {
		Document.currentFileName = currentFileName;
	}

	public static String getCurrentFilePath() {
		return currentFilePath;
	}

	public static void setCurrentFilePath(String currentFilePath) {
		Document.currentFilePath = currentFilePath;
	}

	public static String getCurrentFileFormat() {
		return currentFileFormat;
	}

	public static void setCurrentFileFormat(String currentFileFormat) {
		Document.currentFileFormat = currentFileFormat;
	}
	public static String getIsEncoded() {
		return isEncoded;
	}
	public static void setIsEncoded(String isEncoded) {
		Document.isEncoded = isEncoded;
	}
	public static String getEncodingType() {
		return encodingType;
	}
	public static void setEncodingType(String encodingType) {
		Document.encodingType = encodingType;
	}

	public static Integer getCurrentJTextLen() {
		return currentJTextLen;
	}

	public static void setCurrentJTextLen(Integer currentJTextLen) {
		Document.currentJTextLen = currentJTextLen;
	}
}
