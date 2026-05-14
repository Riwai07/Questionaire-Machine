import java.awt.AWTException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class QuestionGUI {

	private JFrame frame;
	private JPanel mainPanel, questionPanel;
	private JPanel ans1, ans2, questionDisplay;
	private JButton a, b, c, d;
	public boolean pause;
	public LocalTime time;
	private String set;

	public QuestionGUI(String s) throws FileNotFoundException, InterruptedException, AWTException {
		pause = true;
		time = LocalTime.now();
		set = s;
		stuff();
	}

	public void stuff() {
		// TODO Auto-generated method stub
		Color red = Color.RED;
		ArrayList<String[]> cards = new ArrayList<>();
		String[] yerp = set.split("\n");
		String[] empty = {"ERROR","ERROR"};
		for(String s : yerp) {
			cards.add(s.split("\t"));
			try {
				System.out.print(cards.get(cards.size()-1)[0] + " ");
				System.out.println(cards.get(cards.size()-1)[1]);
			}catch(ArrayIndexOutOfBoundsException e) {
				cards.set(cards.size()-1, empty);
			}
		}
		for(int i = cards.size(); i < 4; i++) {
			cards.add(empty);
		}
		

		frame = new JFrame();

		frame.dispose();
		frame = new JFrame("Answer thine question");
		frame.setIconImage(new ImageIcon("icon.png").getImage());
		Dimension questionDimension = new Dimension(750, 500);
		
		frame.setSize(questionDimension);
		
		mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
		
		questionPanel = new JPanel();
		
		questionPanel.setSize(questionDimension);
		questionPanel.setMinimumSize(questionDimension);
		questionPanel.setPreferredSize(questionDimension);
		questionPanel.setMaximumSize(questionDimension);
		questionPanel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		questionPanel.setAlignmentY(JComponent.CENTER_ALIGNMENT);
		frame.setLocationRelativeTo(null);
		frame.setUndecorated(true);
		frame.setAlwaysOnTop(true);
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(255,255,255,255));
		frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		questionPanel.setLayout(new GridLayout(3, 1));
		questionPanel.setBackground(Color.WHITE);

		Random rand = new Random();
		int[] indexs = {rand.nextInt(cards.size()), rand.nextInt(cards.size()), rand.nextInt(cards.size()), rand.nextInt(cards.size())};
		for (int i = 0; i < indexs.length; i++) {
            for (int j = i + 1; j < indexs.length; j++) {
                if (indexs[i] == indexs[j]) {
                    int num;
                    boolean repeat;
                    do {
                        num = rand.nextInt(cards.size());
                        repeat = false;

                        for (int k = 0; k < indexs.length; k++) {
                            if (num == indexs[k]) {
                                repeat = true;
                                break;
                            }
                        }
                    } while (repeat);
                    indexs[j] = num;
                }
            }
        }
		
		System.out.println("nuit");
		ArrayList<String[]> answer = new ArrayList<>();
		answer.add(empty);
		answer.add(empty);
		answer.add(empty);
		answer.add(empty);
		answer.set(0,cards.get(indexs[0]));
		answer.set(1,cards.get(indexs[1]));
		answer.set(2,cards.get(indexs[2]));
		answer.set(3,cards.get(indexs[3]));
//		answer.add(cards.get(index));
//		for (int i = 0; i < 3; i++) {
//			boolean ah = false;
//			int ran = (int) (Math.random() * cards.size());
//			String[] ranAn = cards.get(ran);
//			for (int o = 0; o < answer.size(); o++) {
//				if (ranAn.equals(answer.get(o))) {
//					ah = true;
//				}
//			}
//			answer.add(ranAn);
//			if (ah) {
//				answer.remove(answer.size() - 1);
//				i--;
//			}
//		}
		Collections.shuffle(answer);
		Collections.shuffle(answer);
		Collections.shuffle(answer);
		Collections.shuffle(answer);
		
		int correctIndex = (int) (Math.random() * 4);
		System.out.println("THIS ONE " + correctIndex);

		JLabel l = new JLabel(answer.get(correctIndex)[0]);
		l.setFont(new Font("Arial", Font.BOLD, 40));

		questionDisplay = new JPanel();
		questionDisplay.setLayout(new GridBagLayout());
		questionDisplay.add(l);
		questionDisplay.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		ans1 = new JPanel();
		ans1.setLayout(new GridLayout(1, 2));

		a = new JButton(answer.get(0)[1]);
		a.setFocusPainted(false);
		a.setFont(new Font("Arial", Font.BOLD, 40));
		a.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(a.getText());
				if (correctIndex == 0) {
					pause = false;
					time = LocalTime.now();
					frame.dispose();
				} else {
					a.setEnabled(false);
					a.setBackground(red);
				}
			}
		});

		b = new JButton(answer.get(1)[1]);
		b.setFocusPainted(false);
		b.setFont(new Font("Arial", Font.BOLD, 40));
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(b.getText());
				if (correctIndex == 1) {
					pause = false;
					time = LocalTime.now();
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

		c = new JButton(answer.get(2)[1]);
		c.setFocusPainted(false);
		c.setFont(new Font("Arial", Font.BOLD, 40));
		c.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(c.getText());
				if (correctIndex == 2) {
					pause = false;
					time = LocalTime.now();
					frame.dispose();
				} else {
					c.setEnabled(false);
					c.setBackground(red);
				}
			}
		});

		d = new JButton(answer.get(3)[1]);
		d.setFocusPainted(false);
		d.setFont(new Font("Arial", Font.BOLD, 40));
		d.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(d.getText());
				if (correctIndex == 3) {
					pause = false;
					time = LocalTime.now();
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
		
		mainPanel.add(questionPanel);
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
