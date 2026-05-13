import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Paint;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class QuestionGUI {

	private JFrame frame;
	private JPanel questionPanel;
	private JPanel ans1, ans2, questionDisplay;
	private JButton a, b, c, d;

	public QuestionGUI() throws FileNotFoundException, InterruptedException, AWTException {
		stuff();
	}

	public void stuff() {
		// TODO Auto-generated method stub
		Color red = new Color(255, 0, 0);
		ArrayList<String> question = new ArrayList<>();
		ArrayList<String> answers = new ArrayList<>();
		for (int i = 1; i < 101; i++) {
			question.add(i + "");
			answers.add(i + "");
		}

		double max = 5;
		double min = 2;

		frame = new JFrame();

		boolean lop = true;

		frame.dispose();
		frame = new JFrame("Answer thine question");
		frame.setLayout(new BoxLayout(frame, BoxLayout.X_AXIS));
		frame.setIconImage(new ImageIcon("icon.png").getImage());
		frame.setSize(new Dimension(1920, 1080));
		
		questionPanel = new JPanel();
		
		Dimension questionDimension = new Dimension(750, 500);
		
		questionPanel.setSize(questionDimension);
		questionPanel.setMinimumSize(questionDimension);
		questionPanel.setPreferredSize(questionDimension);
		questionPanel.setMaximumSize(questionDimension);
		questionPanel.setOpaque(false);
		frame.setLocationRelativeTo(null);
		frame.setUndecorated(true);
		frame.setAlwaysOnTop(true);
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(255,255,255,255));
		frame.setOpacity((float) 0.25);
		frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		questionPanel.setLayout(new GridLayout(3, 1));
		questionPanel.setBackground(Color.WHITE);

		int index = (int) (Math.random() * question.size());
		ArrayList<String> answer = new ArrayList<>();
		answer.add(answers.get(index));
		for (int i = 0; i < 3; i++) {
			boolean ah = false;
			int ran = (int) (Math.random() * answers.size());
			String ranAn = answers.get(ran);
			for (int o = 0; o < answer.size(); o++) {
				if (ranAn.equals(answer.get(o))) {
					ah = true;
				}
			}
			answer.add(ranAn);
			if (ah) {
				answer.remove(answer.size() - 1);
				i--;
			}
		}
		Collections.shuffle(answer);
		Collections.shuffle(answer);
		Collections.shuffle(answer);
		Collections.shuffle(answer);

		JLabel l = new JLabel(question.get(index));
		l.setFont(new Font("Arial", Font.BOLD, 40));

		questionDisplay = new JPanel();
		questionDisplay.setLayout(new GridBagLayout());
		questionDisplay.add(l);
		questionDisplay.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		ans1 = new JPanel();
		ans1.setLayout(new GridLayout(1, 2));

		a = new JButton(answer.get(0));
		a.setFocusPainted(false);
		a.setFont(new Font("Arial", Font.BOLD, 40));
		a.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(a.getText());
				if (isAnswer(answers.get(index), a.getText())) {
					frame.dispose();
				} else {
					a.setEnabled(false);
					a.setBackground(red);
				}
			}
		});

		b = new JButton(answer.get(1));
		b.setFocusPainted(false);
		b.setFont(new Font("Arial", Font.BOLD, 40));
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(b.getText());
				if (isAnswer(answers.get(index), b.getText())) {
					frame.dispose();
				} else {
					b.setEnabled(false);
					b.setBackground(red);
				}
			}
		});

		ans1.add(a);
		ans1.add(b);

		ans2 = new JPanel();
		ans2.setLayout(new GridLayout(1, 2));

		c = new JButton(answer.get(2));
		c.setFocusPainted(false);
		c.setFont(new Font("Arial", Font.BOLD, 40));
		c.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(c.getText());
				if (isAnswer(answers.get(index), c.getText())) {
					frame.dispose();
				} else {
					c.setEnabled(false);
					c.setBackground(red);
				}
			}
		});

		d = new JButton(answer.get(3));
		d.setFocusPainted(false);
		d.setFont(new Font("Arial", Font.BOLD, 40));
		d.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(d.getText());
				if (isAnswer(answers.get(index), d.getText())) {
					frame.dispose();
				} else {
					d.setEnabled(false);
					d.setBackground(red);
				}
			}
		});

		ans2.add(c);
		ans2.add(d);

		questionPanel.add(questionDisplay);
		questionPanel.add(ans1);
		questionPanel.add(ans2);
		
		frame.add(questionPanel);
		
		frame.setVisible(true);
	}

	public boolean isAnswer(String correct, String answer) {
		if (correct.equals(answer)) {
			return true;
		} else {
			return false;
		}
	}
}
