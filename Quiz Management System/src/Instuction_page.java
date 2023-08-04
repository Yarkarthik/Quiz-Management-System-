import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JSeparator;

public class Instuction_page {

	JFrame frame;
	JTextArea txtrDuringTheExam;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Instuction_page window = new Instuction_page();
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
	public String rollNo;
	public Instuction_page() {
		initialize();
	}
	 
	public Instuction_page(String rollNo1) {
		initialize();
		rollNo=rollNo1;
		JOptionPane.showMessageDialog(null,rollNo1);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 1366, 768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtrDuringTheExam = new JTextArea();
		txtrDuringTheExam.setText("During the exam :\r\n\r\n\n\n1. The student may not use his or her textbook, course notes, or receive help from a proctor or any other outside source.\r\n\r\n\n\n2. Students must complete the 10-question multiple-choice exam within the 10-minute time frame allotted for the exam.\n\n\r\n\r\n3. Students must not stop the session and then return to it. This is especially important in the online environment where the system will \n\"time-out\" and not allow the student or you to reenter the exam.\n\n \r\n\r\n\n\nAll the Best !");
		txtrDuringTheExam.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtrDuringTheExam.setBounds(37, 85, 1045, 352);
		txtrDuringTheExam.setEditable(false);
		frame.getContentPane().add(txtrDuringTheExam);
		
		JLabel lblNewLabel = new JLabel("Instructions To Follow ");
		lblNewLabel.setFont(new Font("Algerian", Font.BOLD, 40));
		lblNewLabel.setBounds(84, 13, 570, 52);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(getClass().getResource("/quiz/index student.png")));
		lblNewLabel_1.setBounds(10, 0, 64, 65);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame jf=new JFrame();
				jf.setAlwaysOnTop(true);
				int a=JOptionPane.showConfirmDialog(jf, "Do you want to Exit from Instruction Page","select",JOptionPane.YES_NO_OPTION);
				if(a==0)
				{
					Home_page hp=new Home_page();
					hp.frame.setVisible(true);
					frame.dispose();
				}
			}
		});
		btnNewButton.setIcon(new ImageIcon(getClass().getResource("/quiz/Close.png")));
		btnNewButton.setBounds(1267, -3, 85, 68);
		frame.getContentPane().add(btnNewButton);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 62, 1352, 9);
		frame.getContentPane().add(separator);
		
		JButton btnNewButton_1 = new JButton("Start Quiz/Exam");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Quizpage qp =new Quizpage(rollNo);
				qp.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(117, 629, 165, 40);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Student_details hp =new Student_details();
				hp.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(getClass().getResource("/quiz/Back.png")));
		btnNewButton_2.setBounds(889, 629, 165, 40);
		frame.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(getClass().getResource("/quiz/student.png")));
		lblNewLabel_2.setBounds(0, 0, 1352, 731);
		frame.getContentPane().add(lblNewLabel_2);
	}
}
