import java.awt.AWTException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class QuestionGUI {

	static JFrame frame;
	static JPanel ans1, ans2, questionDisplay;
	static JButton a, b, c, d;

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
		frame = new JFrame("Answer thine question or pee pee poo poo");
		frame.setSize(new Dimension(750, 500));
		frame.setLocationRelativeTo(null);
		frame.setUndecorated(true);
		frame.setAlwaysOnTop(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		frame.setLayout(new GridLayout(3, 1));

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
		a.setFont(new Font("Arial", Font.BOLD, 40));
		a.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(a.getText());
				if (isAnswer(answers.get(index), a.getText())) {
					frame.dispose();
				} else {
					a.setBackground(red);
				}
			}
		});

		b = new JButton(answer.get(1));
		b.setFont(new Font("Arial", Font.BOLD, 40));
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(b.getText());
				if (isAnswer(answers.get(index), b.getText())) {
					frame.dispose();
				} else {
					b.setBackground(red);
				}
			}
		});

		ans1.add(a);
		ans1.add(b);

		ans2 = new JPanel();
		ans2.setLayout(new GridLayout(1, 2));

		c = new JButton(answer.get(2));
		c.setFont(new Font("Arial", Font.BOLD, 40));
		c.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(c.getText());
				if (isAnswer(answers.get(index), c.getText())) {
					frame.dispose();
				} else {
					c.setBackground(red);
				}
			}
		});

		d = new JButton(answer.get(3));
		d.setFont(new Font("Arial", Font.BOLD, 40));
		d.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(d.getText());
				if (isAnswer(answers.get(index), d.getText())) {
					frame.dispose();
				} else {
					d.setBackground(red);
				}
			}
		});

		ans2.add(c);
		ans2.add(d);

		frame.add(questionDisplay);
		frame.add(ans1);
		frame.add(ans2);
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
