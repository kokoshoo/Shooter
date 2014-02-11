package Main;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShooterMain app = new ShooterMain();
		JFrame frame = new JFrame("Shooter");
		String text = new String();
		JPanel panel = new JPanel(new BorderLayout());
		JLabel label = new JLabel();
		
		text = "Controls: Use space to shoot; W to go up; S to go down.";
		label.setText(text);
		
		app.setPreferredSize(new Dimension(400,400));
		app.setFocusable(true);
		
		panel.add(app, BorderLayout.LINE_START);
		panel.add(label, BorderLayout.AFTER_LAST_LINE);
		
		
		frame.setPreferredSize(new Dimension(420,456));
		frame.setContentPane(panel);
		frame.pack();
		frame.setVisible(true);
		app.init();
		app.start();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
