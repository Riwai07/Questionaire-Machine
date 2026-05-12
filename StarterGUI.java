import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class StarterGUI {
	
	private JFrame window;
	private JButton stop,start;
	public boolean questioning;
	
	public StarterGUI(){
		makeGUI();
	}
	public void makeGUI() {
		window = new JFrame("Questionaire Machine");
		window.setSize(new Dimension(500, 400));
		window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setLocationRelativeTo(null);
		window.setLayout(new GridLayout(1, 2));

		stop = new JButton("Stop");
		stop.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				stopQuestions();
			}
			
		});
		start = new JButton("Start");
		start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				startQuestions();
			}
			
		});
		
		window.setVisible(true);
	}
	
	public void stopQuestions() {
		questioning = false;
	}
	public void startQuestions() {
		questioning = true;
	}
}
	