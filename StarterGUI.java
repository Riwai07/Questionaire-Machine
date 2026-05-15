import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;

public class StarterGUI {
	
	private JFrame window;
	
	//Button Stuff
	private JButton stop,start;
	private JPanel activatePanel;
	
	//Time Stuff
	private JPanel timePanel, hrPanel, minPanel, secPanel, msPanel;
	private JTextField hrField, minField, secField, msField;
	public long time, hours, minutes, seconds, millisec; 
	
	//Import Button Stuff yay
	private JButton openImport;
	private JPanel yea;
	
	private Font buttonFont, timeFont;
	
	private Color windowColor, buttonDeactivatedColor, buttonActivatedColor;
	private Color buttonBorderActivatedColor, buttonBorderDeactivatedColor;
	private LineBorder buttonActivatedBorder, buttonDeactivatedBorder;
	public boolean questioning;
	
	public String importedSet;
	
	//Stuff for the import window
	private JFrame importWindow;
	private JPanel panelImportThing;
	private JTextArea importBox;
	private JScrollPane importScroll;
	
	public StarterGUI(){
		buttonFont = new Font("Dialog", Font.BOLD, 13);
		timeFont = new Font("Dialog", Font.PLAIN, 11);;
		
		importedSet = "1\t1\n2\t2\n3\t3\n4\t4";
		
		time = 0;
		hours = 0;
		minutes = 0;
		seconds = 0;
		millisec = 0;
		
		windowColor = new Color(238,238,238);
		buttonActivatedColor = new Color(255,255,255);
		buttonDeactivatedColor = new Color(248,248,248);
		buttonBorderActivatedColor = new Color(100,100,100);
		buttonBorderDeactivatedColor = new Color(170,170,170);
		
		buttonActivatedBorder = new LineBorder(buttonBorderActivatedColor);
		buttonDeactivatedBorder = new LineBorder(buttonBorderDeactivatedColor);
		
		makeGUI();
	}
	public void makeGUI() {
		window = new JFrame("Questionaire Machine");
		window.setSize(new Dimension(500, 250));
		window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setLocationRelativeTo(null);
		window.setLayout(new GridBagLayout());
		window.setAlwaysOnTop(true);
		window.setBackground(windowColor);
		window.setIconImage(new ImageIcon("icon.png").getImage());
		
		makeTimePanel();
		makeCoolPanelForImporting();
		makeActivatePanel();
		window.setVisible(true);
	}
	
	private void makeTimePanel() {
		hrPanel = new JPanel();
		hrField = new JTextField("0",5);
		hrField.setFont(timeFont);
		JLabel hr = new JLabel("hours");
		hr.setFont(timeFont);
		hrPanel.add(hrField);
		hrPanel.add(hr);
		
		minPanel = new JPanel();
		minField = new JTextField("0",5);
		minField.setFont(timeFont);
		JLabel min = new JLabel("minutes");
		min.setFont(timeFont);
		minPanel.add(minField);
		minPanel.add(min);
		
		secPanel = new JPanel();
		secField = new JTextField("5",5);
		secField.setFont(timeFont);
		JLabel sec = new JLabel("seconds");
		sec.setFont(timeFont);
		secPanel.add(secField);
		secPanel.add(sec);
		
		msPanel = new JPanel();
		msField = new JTextField("0",5);
		msField.setFont(timeFont);
		JLabel ms = new JLabel("milliseconds");
		ms.setFont(timeFont);
		msPanel.add(msField);
		msPanel.add(ms);
		
		timePanel = new JPanel();
		timePanel.setLayout(new FlowLayout());
		timePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		timePanel.add(hrPanel);
		timePanel.add(minPanel);
		timePanel.add(secPanel);
		timePanel.add(msPanel);
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 0;
		c.anchor = GridBagConstraints.PAGE_START;
		c.insets = new Insets(10,0,0,0);
		c.gridx = 0;
		c.gridy = 0;
		window.add(timePanel, c);
	}
	
	private void makeCoolPanelForImporting() {
		Dimension buttonDimension = new Dimension(465,50);
		
		yea = new JPanel();
		JPanel pp = new JPanel();
		yea.setLayout(new GridLayout(2,1,10,0));
		
		openImport = new JButton("Import Flashcards");
		openImport.setSize(buttonDimension);
		openImport.setMinimumSize(buttonDimension);
		openImport.setMaximumSize(buttonDimension);
		openImport.setPreferredSize(buttonDimension);
		openImport.setBorder(buttonActivatedBorder);
		openImport.setBackground(buttonActivatedColor);
		openImport.setFocusPainted(false);
		openImport.setFont(buttonFont);
		openImport.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {				
				importWindow.setVisible(true);
			}
			
		});
		pp.add(openImport);
		yea.add(pp);
		
		Dimension d = new Dimension(300, 750);
		importWindow = new JFrame("Import Flashcards");
		importWindow.setSize(d);
		importWindow.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		importWindow.setResizable(false);
		Point p = window.getLocation();
		importWindow.setLocation(new Point((int) (p.x - d.getWidth()),(int) (p.y + window.getHeight()/2 - d.getHeight()/2)));
		importWindow.setBackground(windowColor);
		importWindow.setIconImage(new ImageIcon("icon.png").getImage());
		
		JPanel stuff = new JPanel();
		stuff.setLayout(new BoxLayout(stuff, BoxLayout.PAGE_AXIS));
		
		JPanel smallerStuff = new JPanel();
		smallerStuff.setSize(300,100);
		
		JLabel ah = new JLabel("Copy and Paste Quizlet Sets. Format: Term Tab Definition");
		ah.setFont(timeFont);
		
		panelImportThing = new JPanel();
		importWindow.setSize(d);
		panelImportThing.setLayout(new BorderLayout());
		
		importBox = new JTextArea(importedSet);
		importBox.setLineWrap(true);      // wrap lines that are too long
		importBox.setWrapStyleWord(true); // wrap at word boundaries, not mid-word
        importScroll = new JScrollPane(importBox);
		
        panelImportThing.add(importScroll,BorderLayout.CENTER);
        smallerStuff.add(ah);
        stuff.add(smallerStuff);
        stuff.add(panelImportThing);
		importWindow.add(stuff);
		
		Thread importStuff = new Thread(new Runnable() {
			public void run() {
				setImport();
			}
			
		});
		importStuff.start();
	}
	
	private void makeActivatePanel() {
		Dimension buttonDimension = new Dimension(230,50);
		stop = new JButton("Stop");
		stop.setSize(buttonDimension);
		stop.setMinimumSize(buttonDimension);
		stop.setMaximumSize(buttonDimension);
		stop.setPreferredSize(buttonDimension);
		stop.setEnabled(false);
		stop.setBorder(buttonDeactivatedBorder);
		stop.setBackground(buttonDeactivatedColor);
		stop.setFocusPainted(false);
		stop.setFont(buttonFont);
		stop.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				stopButtonStuff();
			}
			
		});
		start = new JButton("Start");
		start.setSize(buttonDimension);
		start.setMinimumSize(buttonDimension);
		start.setMaximumSize(buttonDimension);
		start.setPreferredSize(buttonDimension);
		start.setEnabled(false);
		start.setBorder(buttonActivatedBorder);
		start.setBackground(buttonActivatedColor);
		start.setEnabled(true);
		start.setFocusPainted(false);
		start.setFont(buttonFont);
		start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				startButtonStuff();
			}
			
		});
		activatePanel = new JPanel();
		activatePanel.setLayout(new FlowLayout());
		activatePanel.add(start);
		activatePanel.add(stop);
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 0;
		c.weighty = 1.0;
		c.anchor = GridBagConstraints.PAGE_END;
		c.insets = new Insets(10,0,0,0);
		c.gridx = 0;
		c.gridy = 2;
		yea.add(activatePanel);
		window.add(yea, c);
	}
	
	
	public void calcTime() {
		hours = 0;
		minutes = 0;
		seconds = 0;
		millisec = 0;
		try {
			hours = Integer.parseInt(hrField.getText());
			System.out.print(hours + " ");
		}catch(NumberFormatException e) {
			System.out.print("nut ");
		}
		try {
			minutes = Integer.parseInt(minField.getText());
			System.out.print(minutes + " ");
		}catch(NumberFormatException e) {
			System.out.print("nut ");
		}
		try {
			seconds = Integer.parseInt(secField.getText());
			System.out.print(seconds + " ");
		}catch(NumberFormatException e) {
			System.out.print("nut ");
		}
		try {
			millisec = Integer.parseInt(msField.getText());
			System.out.println(millisec);
		}catch(NumberFormatException e) {
			System.out.println("nut");
		}
		
		time = (hours* 3600000) + (minutes * 60000) + (seconds * 1000) + millisec;
	}
	public void startButtonStuff() {
		startQuestions();
		calcTime();
		start.setEnabled(false);
		stop.setEnabled(true);
		
		start.setBackground(buttonDeactivatedColor);
		stop.setBackground(buttonActivatedColor);
		
		stop.setBorder(buttonActivatedBorder);
		start.setBorder(buttonDeactivatedBorder);
	}
	public void stopButtonStuff() {
		stopQuestions();
		stop.setEnabled(false);
		start.setEnabled(true);
		
		stop.setBackground(buttonDeactivatedColor);
		start.setBackground(buttonActivatedColor);
		
		start.setBorder(buttonActivatedBorder);
		stop.setBorder(buttonDeactivatedBorder);
	}
	
	public void stopQuestions() {
		questioning = false;
	}
	public void startQuestions() {
		questioning = true;
	}
	public long getTime() {
		calcTime();
		return time;
	}
	private void setImport() {
		while(true) {
			importedSet = importBox.getText();
			//System.out.println(importedSet);
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
	