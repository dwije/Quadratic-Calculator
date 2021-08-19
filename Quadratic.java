package quadraticcalc;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Quadratic implements ActionListener {
	
	private static JFrame frame;
	private static JPanel panel;
	private static JLabel labelA;
	private static JLabel labelB;
	private static JLabel labelC;
	private static JTextField AText;
	private static JTextField BText;
	private static JTextField CText;
	private static JButton calculateButton;
	private static JLabel invalidInput;
	private static JLabel numberOfSolutions, solution1, solution2;
	
	public static void GUI() {
		frame = new JFrame("Quadratic Calculator");
		panel = new JPanel();
		frame.setSize(700,500);
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setLayout(null);
		
		labelA = new JLabel("A =");
		labelA.setBounds(50, 50, 80, 25);
		panel.add(labelA);
		
		labelB = new JLabel("B =");
		labelB.setBounds(50, 100, 80, 25);
		panel.add(labelB);
		
		labelC = new JLabel("C =");
		labelC.setBounds(50, 150, 80, 25);
		panel.add(labelC);
			
		AText = new JTextField();
		AText.setBounds(80, 50, 75, 25);
		BText = new JTextField();
		BText.setBounds(80, 100, 75, 25);
		CText = new JTextField();
		CText.setBounds(80, 150, 75, 25);
		
		panel.add(AText);
		panel.add(BText);
		panel.add(CText);
		
		calculateButton = new JButton("Calculate");
		calculateButton.setBounds(70, 200, 100, 30);
		calculateButton.addActionListener(new Quadratic());
		panel.add(calculateButton);
		
		invalidInput = new JLabel("");
		invalidInput.setBounds(50, 250, 500, 40);
		invalidInput.setForeground(Color.RED);
		invalidInput.setFont(invalidInput.getFont().deriveFont(20f));
		panel.add(invalidInput);
		
		numberOfSolutions = new JLabel("");
		numberOfSolutions.setBounds(300, 50, 400, 30);
		panel.add(numberOfSolutions);
		numberOfSolutions.setFont(numberOfSolutions.getFont().deriveFont(20f));
		
		solution1 = new JLabel("");
		solution1.setBounds(300, 100, 400, 30);
		solution1.setFont(solution1.getFont().deriveFont(20f));
		panel.add(solution1);
		
		solution2 = new JLabel("");
		solution2.setBounds(300, 150, 400, 30);
		solution2.setFont(solution2.getFont().deriveFont(20f));
		panel.add(solution2);
		
		frame.setVisible(true);
	}
	
	public static void calculate (double a, double b, double c) {
		double discriminant = Math.pow(b, 2) - 4*a*c;
		if (discriminant > 0) {
			calculate2(a, b, c);
		} else if (discriminant == 0) {
			calculate1(a, b, c);
		} else noSolutions();
	}
	
	public static void calculate2 (double a, double b, double c) {
		double x1 = ((-1*b)-Math.sqrt(Math.pow(b, 2)-4*a*c)) / 2*a;
		double x2 = ((-1*b)+Math.sqrt(Math.pow(b, 2)-4*a*c)) / 2*a;
		numberOfSolutions.setText("2 Solutions:");
		solution1.setText("x = " + x1);
		solution2.setText("x = " + x2);
	}
	
	public static void calculate1 (double a, double b, double c) {
		double x = ((-1*b)+Math.sqrt(Math.pow(b, 2)-4*a*c)) / 2*a;
		solution2.setText("");
		numberOfSolutions.setText("1 Solution:");
		solution1.setText("x = " + x);
	}
	
	public static void noSolutions() {
		solution1.setText("");
		solution2.setText("");
		numberOfSolutions.setText("There are no solutions.");
	}

	public static void main(String[] args) {
		GUI();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		boolean validInput = true;
		double A = 0;
		double B = 0;
		double C = 0;
		String a = AText.getText();
		String b = BText.getText();
		String c = CText.getText();
		try {
			A = Double.parseDouble(a);
			B = Double.parseDouble(b);
			C = Double.parseDouble(c);
		} catch (NumberFormatException e) {
			numberOfSolutions.setText("");
			solution1.setText("");
			solution2.setText("");
			invalidInput.setText("Please enter valid inputs (numbers or decimals).");
			validInput = false;
		}
		if (validInput == true) {
			invalidInput.setText("");
			calculate(A,B,C);
		}
	}
}