package output;

public class WriterRot13Decorator extends WriterDecorator {

	public WriterRot13Decorator(DocumentWriter componentWriter) {
		// TODO Auto-generated constructor stub
		super(componentWriter);

	}
	
	public void Rot13Encoder()
	{
		System.out.println("encoder-rot13");
	}

	@Override
	public void write() {
		// TODO Auto-generated method stub
		
	}
}
