import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Point;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import project.ConnectionProvider;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Add_question {

	JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextArea lblNewLabel_1_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_question window = new Add_question();
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
	public Add_question() {
		initialize();
		try {
			Connection con=ConnectionProvider.getCon();
			Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs=st.executeQuery("select count(id) from question");
			if(rs.first())
			{
				int id=rs.getInt(1);
				id=id+1;
				String str=String.valueOf(id);
				lblNewLabel_1_1.setText(str);
			}
			else {
				lblNewLabel_1_1.setText("1");
			}
			}
		catch(Exception e)
		{
			JFrame jf=new JFrame();
			jf.setAlwaysOnTop(true);
			JOptionPane.showMessageDialog(jf, e);
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setLocation(new Point(150, 183));
		frame.setBounds(150, 150, 1066, 535);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(getClass().getResource("/quiz/add new question.png")));
		lblNewLabel.setBounds(10, 0, 65, 68);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Add Question");
		lblNewLabel_1.setFont(new Font("Algerian", Font.BOLD, 40));
		lblNewLabel_1.setBounds(80, 10, 411, 62);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin_page hp=new Admin_page();
				Admin_page.open=0;
				hp.frame.setVisible(false);
				frame.dispose();
			}
		});
		btnNewButton.setIcon(new ImageIcon(getClass().getResource("/quiz/Close.png")));
		btnNewButton.setBounds(967, 0, 85, 68);
		frame.getContentPane().add(btnNewButton);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 71, 1052, 13);
		frame.getContentPane().add(separator);
		
		JLabel lblNewLabel_2 = new JLabel("Question ID :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(90, 88, 134, 22);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_2 = new JLabel("Question:");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2_2.setBounds(120, 142, 131, 22);
		frame.getContentPane().add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Option 1:");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2_3.setBounds(120, 214, 134, 22);
		frame.getContentPane().add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("Option 2:");
		lblNewLabel_2_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2_4.setBounds(120, 259, 114, 27);
		frame.getContentPane().add(lblNewLabel_2_4);
		
		JLabel lblNewLabel_2_5 = new JLabel("Option 3:");
		lblNewLabel_2_5.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2_5.setBounds(120, 300, 114, 27);
		frame.getContentPane().add(lblNewLabel_2_5);
		
		JLabel lblNewLabel_2_6 = new JLabel("Option 4:");
		lblNewLabel_2_6.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2_6.setBounds(120, 337, 107, 29);
		frame.getContentPane().add(lblNewLabel_2_6);
		
		JLabel lblNewLabel_2_7 = new JLabel("Answer:");
		lblNewLabel_2_7.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2_7.setBounds(120, 376, 114, 32);
		frame.getContentPane().add(lblNewLabel_2_7);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setBounds(239, 138, 570, 32);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_1.setColumns(10);
		textField_1.setBounds(239, 210, 570, 32);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_2.setColumns(10);
		textField_2.setBounds(239, 252, 570, 32);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_3.setColumns(10);
		textField_3.setBounds(239, 294, 570, 32);
		frame.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_4.setColumns(10);
		textField_4.setBounds(239, 336, 570, 32);
		frame.getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_5.setColumns(10);
		textField_5.setBounds(239, 378, 570, 29);
		frame.getContentPane().add(textField_5);
		
		JButton btnNewButton_1 = new JButton("Save");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id=lblNewLabel_1_1.getText();
				String name=textField.getText();
				String opt1=textField_1.getText();
				String opt2=textField_2.getText();
				String opt3=textField_3.getText();
				String opt4=textField_4.getText();
				String answer=textField_5.getText();
				try {
					Connection con=ConnectionProvider.getCon();
					PreparedStatement ps=con.prepareStatement("insert into question values(?,?,?,?,?,?,?)");
					ps.setString(1, id);
					ps.setString(2, name);
					ps.setString(3, opt1);
					ps.setString(4, opt2);
					ps.setString(5, opt3);
					ps.setString(6, opt4);
					ps.setString(7, answer);
					ps.executeUpdate();
					JFrame jf=new JFrame();
					jf.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(jf, "Successfully Update");
					jf.setVisible(false);
					frame.dispose();
					Add_question adp=new Add_question();
					adp.frame.setVisible(true);
				}
				catch(Exception e1) {
					JFrame jf=new JFrame();
					jf.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(jf,e1);
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setIcon(new ImageIcon(getClass().getResource("/quiz/save.png")));
		btnNewButton_1.setBounds(121, 441, 114, 32);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Clear");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1_1.setIcon(new ImageIcon(getClass().getResource("/quiz/clear.png")));
		btnNewButton_1_1.setBounds(668, 441, 114, 32);
		frame.getContentPane().add(btnNewButton_1_1);
		
		lblNewLabel_1_1 = new JTextArea("00");
		lblNewLabel_1_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(234, 85, 31, 32);
		lblNewLabel_1_1.setEditable(true);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(getClass().getResource("/quiz/adminbg.png")));
		lblNewLabel_3.setBounds(0, 0, 1052, 498);
		frame.getContentPane().add(lblNewLabel_3);
	}
}
