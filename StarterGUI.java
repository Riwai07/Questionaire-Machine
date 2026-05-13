import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
	
	private Color windowColor, buttonDeactivatedColor, buttonActivatedColor;
	private Color buttonBorderActivatedColor, buttonBorderDeactivatedColor;
	private LineBorder buttonActivatedBorder, buttonDeactivatedBorder;
	public boolean questioning;
	
	public StarterGUI(){
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
		window.setSize(new Dimension(500, 400));
		window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setLocationRelativeTo(null);
		window.setLayout(new GridBagLayout());
		window.setAlwaysOnTop(true);
		window.setBackground(windowColor);
		window.setIconImage(new ImageIcon("icon.png").getImage());
		
		makeTimePanel();
		makeActivatePanel();
		window.setVisible(true);
	}
	
	private void makeTimePanel() {
		Font font = new Font("Dialog", Font.PLAIN, 11);
		hrPanel = new JPanel();
		hrField = new JTextField("0",5);
		hrField.setFont(font);
		JLabel hr = new JLabel("hours");
		hr.setFont(font);
		hrPanel.add(hrField);
		hrPanel.add(hr);
		
		minPanel = new JPanel();
		minField = new JTextField("0",5);
		minField.setFont(font);
		JLabel min = new JLabel("minutes");
		min.setFont(font);
		minPanel.add(minField);
		minPanel.add(min);
		
		secPanel = new JPanel();
		secField = new JTextField("5",5);
		secField.setFont(font);
		JLabel sec = new JLabel("seconds");
		sec.setFont(font);
		secPanel.add(secField);
		secPanel.add(sec);
		
		msPanel = new JPanel();
		msField = new JTextField("0",5);
		msField.setFont(font);
		JLabel ms = new JLabel("milliseconds");
		ms.setFont(font);
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
		c.ipady = 0;       //reset to default
		//c.weighty = 1.0;   //request any extra vertical space
		c.anchor = GridBagConstraints.PAGE_START; //bottom of space
		c.insets = new Insets(10,0,0,0);  //top padding
		c.gridx = 0;       //aligned with button 2
		c.gridy = 0;       //third row
		window.add(timePanel, c);
	}
	
	private void makeActivatePanel() {
		Dimension buttonDimension = new Dimension(225,50);
		Font font = new Font("Dialog", Font.BOLD, 13);
		stop = new JButton("Stop");
		stop.setSize(buttonDimension);
		stop.setMinimumSize(buttonDimension);
		stop.setMaximumSize(buttonDimension);
		stop.setPreferredSize(buttonDimension);
		stop.setEnabled(false);
		stop.setBorder(buttonDeactivatedBorder);
		stop.setBackground(buttonDeactivatedColor);
		stop.setFocusPainted(false);
		stop.setFont(font);
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
		start.setFont(font);
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
		c.ipady = 0;       //reset to default
		c.weighty = 1.0;   //request any extra vertical space
		c.anchor = GridBagConstraints.PAGE_END; //bottom of space
		c.insets = new Insets(10,0,0,0);  //top padding
		c.gridx = 0;       //aligned with button 2
		c.gridy = 2;       //third row
		window.add(activatePanel, c);
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
		System.out.println("ah");
	}
	public long getTime() {
		calcTime();
		return time;
	}
}
	