package output;

public abstract class WriterDecorator implements DocumentWriter
{
	protected DocumentWriter componentWriter;
	
	public WriterDecorator(DocumentWriter componentWriter) 
	{
		this.componentWriter = componentWriter;
	}
	
	public abstract void write();
}
