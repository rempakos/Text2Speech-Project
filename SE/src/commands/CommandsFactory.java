package commands;

import java.awt.event.ActionListener;


public class CommandsFactory {
	public ActionListener createCommand(String command)
	{
		if(command.equals("Open Document"))
		{
			return (ActionListener) new OpenDocument();
		}
		else if(command.equals("Save Document"))
		{
			return (ActionListener) new SaveDocument();
		}
		else if(command.contentEquals("Decode AtBash"))
		{
			return (ActionListener) new DecodeDocumentAtBash();
		}
		else if(command.contentEquals("Decode Rot-13"))
		{
			return (ActionListener) new DecodeDocumentRot13();
		}
		else if(command.contentEquals("Encode AtBash"))
		{
			return (ActionListener) new EncodeDocumentAtBash();
		}
		else if(command.contentEquals("Encode Rot-13")) 
		{
			return (ActionListener) new EncodeDocumentRot13();
		}
		else if(command.contentEquals("Instructions"))
		{

			return (ActionListener) new HelpWindow();
		}
		else return null;  //temporary
	}
}
