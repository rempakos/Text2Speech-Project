package input;

import model.Document;

public class DocumentReaderFactory {
	private ReaderAtBashDecorator readerAtbashDecorator;
	private ReaderRot13Decorator readerRot13Decorator;
	
	public DocumentReaderFactory()
	{
		
	}
	
	public DocumentReader createReader(String name,String path,String format)
	{

		if(format.equals("txt"))
		{
			if(Document.getIsEncoded().equals("encodedNOT") && Document.getEncodingType().equals("none")) 
			{
				TxtReader txt = new TxtReader();
				return txt;
			}else{
				if(Document.getIsEncoded().equals("encoded") && Document.getEncodingType().equals("atbash")) 
				{
					readerAtbashDecorator = new  ReaderAtBashDecorator(new TxtReader());
					DocumentReader readDoc = readerAtbashDecorator;
					return readDoc;
				}
				else if(Document.getIsEncoded().equals("encoded") && Document.getEncodingType().equals("rot13")) 
				{
					readerRot13Decorator = new ReaderRot13Decorator(new TxtReader());
					DocumentReader readDoc = readerRot13Decorator;
					return readDoc;
				}
			}

		}
		else if(format.equals("docx"))
		{
			if(Document.getIsEncoded().equals("encodedNOT") && Document.getEncodingType().equals("none")) {
				WordReader word = new WordReader();
				return word;
			}else{
				if(Document.getIsEncoded().equals("encoded") && Document.getEncodingType().equals("atbash")) 
				{
					readerAtbashDecorator = new  ReaderAtBashDecorator(new WordReader());
					DocumentReader readDoc = readerAtbashDecorator;
					return readDoc;
				}
				else if(Document.getIsEncoded().equals("encoded") && Document.getEncodingType().equals("rot13")) 
				{
					readerRot13Decorator = new ReaderRot13Decorator(new WordReader());
					DocumentReader readDoc = readerRot13Decorator;
					return readDoc;
				}
			}

		}
		else if(format.equals("xlsx"))
		{
			if(Document.getIsEncoded().equals("encodedNOT") && Document.getEncodingType().equals("none")) {
				ExcelReader excel = new ExcelReader();
				return excel;
			}else{
				if(Document.getIsEncoded().equals("encoded") && Document.getEncodingType().equals("atbash")) 
				{
					readerAtbashDecorator = new  ReaderAtBashDecorator(new ExcelReader());
					DocumentReader readDoc = readerAtbashDecorator;
					return readDoc;
				}
				else if(Document.getIsEncoded().equals("encoded") && Document.getEncodingType().equals("rot13")) 
				{
					readerRot13Decorator = new ReaderRot13Decorator(new ExcelReader());
					DocumentReader readDoc = readerRot13Decorator;
					return readDoc;
				}
			}

		}
		throw new IllegalArgumentException("Invalid file format");
	}
}

