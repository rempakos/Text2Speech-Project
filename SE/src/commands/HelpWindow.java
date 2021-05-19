package commands;


import view.Text2SpeechEditorView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class HelpWindow implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(Text2SpeechEditorView.getFrame(),
				"* Select File to browse and open a txt-word-excel document.\n\n" +
				"* Encode & Decode your documents in AtBash - Rot13 via the menu.\n\n"+
				"* Select Play to listen to an audio form of your document!\n\n"+
				"* Use 'Tabs' to separate CELLS when modifying an excel file!\n\n"
				+ "","Instructions:", JOptionPane.INFORMATION_MESSAGE);
	}
}