import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Point;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;
import project.ConnectionProvider;

import java.awt.Color;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class All_Student_Results {

	JFrame frame;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					All_Student_Results window = new All_Student_Results();
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
	public All_Student_Results() {
		initialize();
		try {
			Connection con=ConnectionProvider.getCon();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select *from student");
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
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
		lblNewLabel.setIcon(new ImageIcon(getClass().getResource("/quiz/all student result.png")));
		lblNewLabel.setBounds(10, 10, 62, 78);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ALL STUDENT RESULT");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel_1.setBounds(82, 19, 539, 69);
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
		btnNewButton.setBounds(967, 10, 75, 78);
		frame.getContentPane().add(btnNewButton);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 90, 1052, 9);
		frame.getContentPane().add(separator);
		
		JLabel lblNewLabel_2 = new JLabel("Filter Students By Marks");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(10, 109, 254, 30);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				int marks;
				if(textField.getText().equals(""))
				{
					marks=0;
				}
				else
				{
					marks=Integer.parseInt(textField.getText());
				}
				try {
					Connection con=ConnectionProvider.getCon();
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery("select *from student where marks>="+marks+"");
					table.setModel(DbUtils.resultSetToTableModel(rs));
				}
				catch(Exception e1) {
					frame.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(frame, e1);
				}
			}
		});
		textField.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField.setBounds(278, 109, 126, 30);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 158, 1032, 330);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(getClass().getResource("/quiz/adminbg.png")));
		lblNewLabel_3.setBackground(Color.WHITE);
		lblNewLabel_3.setBounds(0, 0, 1052, 498);
		frame.getContentPane().add(lblNewLabel_3);
		
		
		
		
	}
}
