package input;

public abstract class ReaderDecorator implements DocumentReader 
{
	protected DocumentReader componentReader;
	
	public ReaderDecorator(DocumentReader componentReader)
	{
		this.componentReader = componentReader;
	}
	
	public abstract void read();
}
