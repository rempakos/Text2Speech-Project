package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.DocumentListener;

import commands.CommandsFactory;
import commands.myDocumentListener;
import model.Document;

public class Text2SpeechEditorView {
	private static JFrame frame = new JFrame();
	private static CommandsFactory commFactory = new CommandsFactory();
	private static JTextArea fileContents = new JTextArea();
	private static JTextArea programInfo = new JTextArea("Ultimate Text2Speech Editor!!\n");
	private static Document doc = new Document();

	private static JMenuItem encodeRot13;
	private static JMenuItem encodeAtbash;
	private static JMenuItem decodeRot13;
	private static JMenuItem decodeAtbash;
	private static JMenuItem open;
	private static JMenuItem save;
	private static JMenuItem instructions;
	



	public Text2SpeechEditorView()
	{
		
	}
	
	public static void main(String[] args)
	{

		JFrame frame = new JFrame("Ultimate Text2SpeechEditor");
		JMenuBar menuBar = new JMenuBar();
		
		JScrollPane scroll = new JScrollPane(fileContents);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		JMenu menu = new JMenu("File");
		JMenu encode = new JMenu("Encode");
		JMenu decode = new JMenu("Decode");
		JMenu help = new JMenu("Help");
		JMenu Play = new JMenu("Play");
		
		menuBar.add(menu);
		menuBar.add(encode);
		menuBar.add(decode);
		menuBar.add(help);
		menuBar.add(Play);
		
		open = new JMenuItem("Open Document");
		save = new JMenuItem("Save Document");
		instructions = new JMenuItem("Instructions");
		
		encodeRot13 = new JMenuItem("Encode Rot-13");
		encodeAtbash = new JMenuItem("Encode AtBash");
		decodeRot13 = new JMenuItem("Decode Rot-13");
		decodeAtbash = new JMenuItem("Decode AtBash");

		
		//Begin disabled:
		fileContents.setEditable(false);		
		encodeRot13.setEnabled(false);
		encodeAtbash.setEnabled(false);
		decodeRot13.setEnabled(false);
		decodeAtbash.setEnabled(false);
		save.setEnabled(false);
		Play.setEnabled(false);
		///TEST
		encode.setEnabled(false);
		///
		
		menu.add(open);
		menu.add(save);
		help.add(instructions);
		encode.add(encodeRot13);
		encode.add(encodeAtbash);
		decode.add(decodeRot13);
		decode.add(decodeAtbash);
		
		
		open.addActionListener(commFactory.createCommand(open.getText()));
		save.addActionListener(commFactory.createCommand(save.getText()));
		encodeRot13.addActionListener(commFactory.createCommand(encodeRot13.getText()));
		encodeAtbash.addActionListener(commFactory.createCommand(encodeAtbash.getText()));
		decodeRot13.addActionListener(commFactory.createCommand(decodeRot13.getText()));
		decodeAtbash.addActionListener(commFactory.createCommand(decodeAtbash.getText()));
		instructions.addActionListener(commFactory.createCommand(instructions.getText()));
		
		DocumentListener docListener = (DocumentListener) new myDocumentListener();

		fileContents.setBounds(15,15,550,600);
		fileContents.setLineWrap(true);
		fileContents.setWrapStyleWord(true);
		fileContents.getDocument().addDocumentListener(docListener);
		fileContents.setBackground(new Color(200,200,200));
		fileContents.setBorder(BorderFactory.createBevelBorder(1));
		fileContents.setFont(new Font("Comic Sans", Font.ITALIC,15));
		
		programInfo.setBounds(595,15, 270, 450);
		programInfo.setLineWrap(true);
		programInfo.setWrapStyleWord(true);
		programInfo.setBackground(new Color(200,200,200));
		programInfo.setBorder(BorderFactory.createBevelBorder(1));
		programInfo.setFont(new Font("Algerian", Font.BOLD,25));
		programInfo.append("\n");
		programInfo.append("Made by:\n\n"+"George Deliopoulos\n" + "Rempakos Pantelis\n" + "Kazantzidhs Panagioths\n");
		programInfo.setEditable(false);




		
		frame.setPreferredSize(new Dimension(900, 700));
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		frame.setJMenuBar(menuBar);
		frame.add(fileContents);
		frame.add(programInfo);
		frame.pack();
		ImageIcon image = new ImageIcon(new ImageIcon("logo.png").getImage().getScaledInstance(800, 1000, Image.SCALE_DEFAULT));
		//image.getImage().getScaledInstance(20, 20, image.SCALE_DEFAULT);
		//Image newImage = image.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH);
		frame.setIconImage(image.getImage());
		frame.setVisible(true);
		
		
		//
		//ImageIcon imageIcon = new ImageIcon("./img/imageName.png"); // load the image to a imageIcon
		//Image image = imageIcon.getImage(); // transform it 
		//Image newimg = image.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		//imageIcon = new ImageIcon(newimg);  // transform it back
	}
	
	//SETTER-GETTER SECTION
	
	public static Document getDoc() {
		return doc;
	}
	public static JFrame getFrame()
	{
		return frame;
	}
	
	public static JTextArea getFileContents() {
		return fileContents;
	}
	
	public static void setFileContents(JTextArea fileContents) {
		Text2SpeechEditorView.fileContents = fileContents;
	}
	

	public static void setDoc(Document doc) {
		Text2SpeechEditorView.doc = doc;
	}

	public static JMenuItem getEncodeRot13() {
		return encodeRot13;
	}


	
	public static JMenuItem getEncodeAtbash() {
		return encodeAtbash;
	}


	
	public static JMenuItem getDecodeRot13() {
		return decodeRot13;
	}


	
	public static JMenuItem getDecodeAtbash() {
		return decodeAtbash;
	}
	public static JMenuItem getSave() {
		return save;
	}

	public static void setSave(JMenuItem save) {
		Text2SpeechEditorView.save = save;
	}




}
