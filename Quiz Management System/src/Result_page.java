import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Result_page {

	JFrame frame;
	JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Result_page window = new Result_page();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Result_page() {
		initialize();
	}

	public Result_page(String marks) {
		// TODO Auto-generated constructor stub
		initialize();
		String marks1=marks;
		lblNewLabel_1.setText(marks1);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 1366, 768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Total Marks Obtained  :");
		lblNewLabel.setFont(new Font("Algerian", Font.BOLD, 45));
		lblNewLabel.setBounds(147, 232, 751, 175);
		frame.getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("00");
		lblNewLabel_1.setFont(new Font("Algerian", Font.BOLD, 45));
		lblNewLabel_1.setBounds(772, 265, 100, 108);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Successfully Updated");
		lblNewLabel_3.setFont(new Font("Algerian", Font.BOLD, 45));
		lblNewLabel_3.setBounds(199, 382, 592, 81);
		frame.getContentPane().add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Home_page hp=new Home_page();
				hp.frame.setVisible(true); 
				
			}
		});
		btnNewButton.setIcon(new ImageIcon(getClass().getResource("/quiz/Close.png")));
		btnNewButton.setBounds(1262, 10, 80, 74);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(getClass().getResource("/quiz/student.png")));
		lblNewLabel_2.setBounds(0, 0, 1352, 731);
		frame.getContentPane().add(lblNewLabel_2);
	}

	public void setVisible(boolean b) {
		frame.setVisible(b);
		
	}
}
