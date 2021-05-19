package output;

import model.Document;

public class DocumentWriterFactory {
	private WriterAtBashDecorator writerAtbashDecorator;
	private WriterRot13Decorator writerRot13Decorator;
	
	public DocumentWriterFactory()
	{
		
	}
	
	public DocumentWriter createWriter(String name,String path,String format)
	{

		if(format.equals("txt"))
		{
			if(Document.getIsEncoded().equals("encodedNOT") && Document.getEncodingType().equals("none")) 
			{
				TxtWriter txt = new TxtWriter();
				return txt;
			}else{
				if(Document.getIsEncoded().equals("encoded") && Document.getEncodingType().equals("atbash")) 
				{					
					writerAtbashDecorator = new  WriterAtBashDecorator(new TxtWriter());
					DocumentWriter writeDoc = writerAtbashDecorator;
					return writeDoc;
				}
				else if(Document.getIsEncoded().equals("encoded") && Document.getEncodingType().equals("rot13")) 
				{
					writerRot13Decorator = new WriterRot13Decorator(new TxtWriter());
					DocumentWriter writeDoc = writerRot13Decorator;
					return writeDoc;
				}
			}

		}
		else if(format.equals("docx"))
		{
			if(Document.getIsEncoded().equals("encodedNOT") && Document.getEncodingType().equals("none")) {
				WordWriter word = new WordWriter();
				return word;
			}else{
				if(Document.getIsEncoded().equals("encoded") && Document.getEncodingType().equals("atbash")) 
				{
					writerAtbashDecorator = new WriterAtBashDecorator(new WordWriter());
					DocumentWriter writeDoc = writerAtbashDecorator;
					return writeDoc;
				}
				else if(Document.getIsEncoded().equals("encoded") && Document.getEncodingType().equals("rot13")) 
				{
					writerRot13Decorator = new WriterRot13Decorator(new WordWriter());
					DocumentWriter writeDoc = writerRot13Decorator;
					return writeDoc;
				}
			}

		}
		else if(format.equals("xlsx"))
		{
			if(Document.getIsEncoded().equals("encodedNOT") && Document.getEncodingType().equals("none")) {
				ExcelWriter excel = new ExcelWriter();
				return excel;
			}else{
				if(Document.getIsEncoded().equals("encoded") && Document.getEncodingType().equals("atbash")) 
				{
					writerAtbashDecorator = new  WriterAtBashDecorator(new ExcelWriter());
					DocumentWriter writeDoc = writerAtbashDecorator;
					return writeDoc;
				}
				else if(Document.getIsEncoded().equals("encoded") && Document.getEncodingType().equals("rot13")) 
				{
					writerRot13Decorator = new WriterRot13Decorator(new ExcelWriter());
					DocumentWriter writeDoc = writerRot13Decorator;
					return writeDoc;
				}
			}

		}
		throw new IllegalArgumentException("Invalid file format");
	}
}
