import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import project.ConnectionProvider;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Student_details {

    JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField txtUniversityName;
	private JTextField txtPercentage;
	private JTextField txtPassedOutYear;
	private JTextField txtUniversityName_1;
	private JTextField txtPercentage_1;
	private JTextField txtPassedOutYear_1;
	private JTextField txtUniversityName_2;
	private JTextField txtPercentage_2;
	private JTextField txtPassedOutYear_2;
	private JTextField textField_15;
	private JTextArea txtrExaminationManagementSystem;
	private JLabel lblNewLabel_3;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student_details window = new Student_details();
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
	public Student_details() {
		initialize();
		txtrExaminationManagementSystem.setEditable(false);
		SimpleDateFormat dFormat=new SimpleDateFormat("dd-MM-yyyy");
		Date date=new Date();
		lblNewLabel_3.setText(dFormat.format(date));
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 1366, 768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(getClass().getResource("/quiz/index student.png")));
		lblNewLabel.setBounds(10, 0, 65, 68);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Fill The Form");
		lblNewLabel_1.setFont(new Font("Algerian", Font.BOLD, 40));
		lblNewLabel_1.setBounds(80, 10, 411, 62);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame jf=new JFrame();
				jf.setAlwaysOnTop(true);
				JOptionPane.showConfirmDialog(jf, "Do you want to Exit from Student Page","select",JOptionPane.YES_NO_OPTION);
				Admin_page hp=new Admin_page();
				hp.frame.setVisible(false);
				frame.dispose();
			}
		});
		btnNewButton.setIcon(new ImageIcon(getClass().getResource("/quiz/Close.png")));
		btnNewButton.setBounds(1267, 0, 85, 68);
		frame.getContentPane().add(btnNewButton);
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home_page hp =new Home_page();
				hp.setVisible(true);
				frame.dispose();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBack.setIcon(new ImageIcon(getClass().getResource("/quiz/Back.png")));
		btnBack.setBounds(1232, 689, 110, 32);
		frame.getContentPane().add(btnBack);
		
		JLabel lblNewLabel_2 = new JLabel("Date :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(830, 30, 65, 28);
		frame.getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(905, 30, 122, 23);
		frame.getContentPane().add(lblNewLabel_3);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 66, 1342, 6);
		frame.getContentPane().add(separator);
		
		JLabel lblNewLabel_4 = new JLabel("Student Name :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(43, 108, 142, 23);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Roll.no :");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setBounds(43, 154, 142, 23);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Mail Id :");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6.setBounds(43, 197, 142, 23);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Gender :");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_7.setBounds(43, 238, 142, 23);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Father Name :");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_8.setBounds(43, 287, 142, 25);
		frame.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Mother Name :");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_9.setBounds(43, 332, 142, 27);
		frame.getContentPane().add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Contact Number :");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_10.setBounds(43, 382, 142, 23);
		frame.getContentPane().add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("10th :");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_11.setBounds(43, 437, 142, 32);
		frame.getContentPane().add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("12th :");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_12.setBounds(43, 494, 142, 23);
		frame.getContentPane().add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("Graduation  :");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_13.setBounds(43, 544, 142, 28);
		frame.getContentPane().add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("Address :");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_14.setBounds(43, 599, 142, 23);
		frame.getContentPane().add(lblNewLabel_14);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField.setBounds(195, 105, 243, 32);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_1.setBounds(195, 153, 243, 32);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_2.setBounds(195, 195, 243, 32);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_3.setBounds(195, 286, 243, 32);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_4.setBounds(195, 332, 243, 32);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_5.setBounds(195, 378, 243, 32);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		txtUniversityName = new JTextField();
		txtUniversityName.setText("Enter the Board Name");
		txtUniversityName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtUniversityName.getText().equals("Enter the Board Name"))
				{
					txtUniversityName.setText("");
					txtUniversityName.setForeground(new Color(0,0,0));
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtUniversityName.getText().equals(""))
				{
					txtUniversityName.setText("Enter the Board Name");
					txtUniversityName.setForeground(new Color(153,153,153));
				}
			}
		});
		txtUniversityName.setForeground(Color.LIGHT_GRAY);
		txtUniversityName.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtUniversityName.setBounds(195, 438, 243, 32);
		frame.getContentPane().add(txtUniversityName);
		txtUniversityName.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel<Object>(new String[] {"Male", "Female", "Others"}));
		comboBox.setBounds(195, 237, 243, 32);
		frame.getContentPane().add(comboBox);
		
		txtPercentage = new JTextField();
		txtPercentage.setText("Enter Percentage");
		txtPercentage.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtPercentage.getText().equals("Enter Percentage"))
				{
					txtPercentage.setText("");
					txtPercentage.setForeground(new Color(0,0,0));
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtPercentage.getText().equals(""))
				{
					txtPercentage.setText("Enter Percentage");
					txtPercentage.setForeground(new Color(153,153,153));
				}
			}
		});
		txtPercentage.setForeground(Color.LIGHT_GRAY);
		txtPercentage.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtPercentage.setBounds(506, 438, 243, 32);
		frame.getContentPane().add(txtPercentage);
		txtPercentage.setColumns(10);
		
		txtPassedOutYear = new JTextField();
		txtPassedOutYear.setText("Enter Passed Out Year");
		txtPassedOutYear.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtPassedOutYear.getText().equals("Enter Passed Out Year"))
				{
					txtPassedOutYear.setText("");
					txtPassedOutYear.setForeground(new Color(0,0,0));
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtPassedOutYear.getText().equals(""))
				{
					txtPassedOutYear.setText("Enter Passed Out Year");
					txtPassedOutYear.setForeground(new Color(153,153,153));
				}
			}
		});
		txtPassedOutYear.setForeground(Color.LIGHT_GRAY);
		txtPassedOutYear.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtPassedOutYear.setBounds(809, 437, 243, 31);
		frame.getContentPane().add(txtPassedOutYear);
		txtPassedOutYear.setColumns(10);
		
		txtUniversityName_1 = new JTextField();
		txtUniversityName_1.setText("Enter the Group Name");
		txtUniversityName_1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtUniversityName_1.getText().equals("Enter the Group Name"))
				{
					txtUniversityName_1.setText("");
					txtUniversityName_1.setForeground(new Color(0,0,0));
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtUniversityName_1.getText().equals(""))
				{
					txtUniversityName_1.setText("Enter the Group Name");
					txtUniversityName_1.setForeground(new Color(153,153,153));
				}
			}
		});
		txtUniversityName_1.setForeground(Color.LIGHT_GRAY);
		txtUniversityName_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtUniversityName_1.setBounds(195, 491, 243, 32);
		frame.getContentPane().add(txtUniversityName_1);
		txtUniversityName_1.setColumns(10);
		
		txtPercentage_1 = new JTextField();
		txtPercentage_1.setText("Enter Percentage");
		txtPercentage_1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtPercentage_1.getText().equals("Enter Percentage"))
				{
					txtPercentage_1.setText("");
					txtPercentage_1.setForeground(new Color(0,0,0));
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtPercentage_1.getText().equals(""))
				{
					txtPercentage_1.setText("Enter Percentage");
					txtPercentage_1.setForeground(new Color(153,153,153));
				}
			}
		});
		txtPercentage_1.setForeground(Color.LIGHT_GRAY);
		txtPercentage_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtPercentage_1.setBounds(506, 492, 243, 31);
		frame.getContentPane().add(txtPercentage_1);
		txtPercentage_1.setColumns(10);
		
		txtPassedOutYear_1 = new JTextField();
		txtPassedOutYear_1.setText("Enter Passed Out Year");
		txtPassedOutYear_1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtPassedOutYear_1.getText().equals("Enter Passed Out Year"))
				{
					txtPassedOutYear_1.setText("");
					txtPassedOutYear_1.setForeground(new Color(0,0,0));
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtPassedOutYear_1.getText().equals(""))
				{
					txtPassedOutYear_1.setText("Enter Passed Out Year");
					txtPassedOutYear_1.setForeground(new Color(153,153,153));
				}
			}
		});
		txtPassedOutYear_1.setForeground(Color.LIGHT_GRAY);
		txtPassedOutYear_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtPassedOutYear_1.setBounds(809, 492, 243, 32);
		frame.getContentPane().add(txtPassedOutYear_1);
		txtPassedOutYear_1.setColumns(10);
		
		txtUniversityName_2 = new JTextField();
		txtUniversityName_2.setText("Enter the Branch Name");
		txtUniversityName_2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(txtUniversityName_2.getText().equals(""))
				{
					txtUniversityName_2.setText("Enter the Branch Name");
					txtUniversityName_2.setForeground(new Color(153,153,153));
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				if(txtUniversityName_2.getText().equals("Enter the Branch Name"))
				{
					txtUniversityName_2.setText("");
					txtUniversityName_2.setForeground(new Color(0,0,0));
				}
			}
		});
		txtUniversityName_2.setForeground(Color.LIGHT_GRAY);
		txtUniversityName_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtUniversityName_2.setBounds(195, 543, 243, 32);
		frame.getContentPane().add(txtUniversityName_2);
		txtUniversityName_2.setColumns(10);
		
		txtPercentage_2 = new JTextField();
		txtPercentage_2.setText("Enter Percentage");
		txtPercentage_2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtPercentage_2.getText().equals("Enter Percentage"))
				{
					txtPercentage_2.setText("");
					txtPercentage_2.setForeground(new Color(0,0,0));
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtPercentage_2.getText().equals(""))
				{
					txtPercentage_2.setText("Enter Percentage");
					txtPercentage_2.setForeground(new Color(153,153,153));
				}
			}
		});
		txtPercentage_2.setForeground(Color.LIGHT_GRAY);
		txtPercentage_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtPercentage_2.setBounds(506, 543, 243, 32);
		frame.getContentPane().add(txtPercentage_2);
		txtPercentage_2.setColumns(10);
		
		txtPassedOutYear_2 = new JTextField();
		txtPassedOutYear_2.setText("Enter Passed Out Year");
		txtPassedOutYear_2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtPassedOutYear_2.getText().equals("Enter Passed Out Year"))
				{
					txtPassedOutYear_2.setText("");
					txtPassedOutYear_2.setForeground(new Color(0,0,0));
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtPassedOutYear_2.getText().equals(""))
				{
					txtPassedOutYear_2.setText("Enter Passed Out Year");
					txtPassedOutYear_2.setForeground(new Color(153,153,153));
				}
			}
		});
		txtPassedOutYear_2.setForeground(Color.LIGHT_GRAY);
		txtPassedOutYear_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtPassedOutYear_2.setBounds(809, 542, 243, 33);
		frame.getContentPane().add(txtPassedOutYear_2);
		txtPassedOutYear_2.setColumns(10);
		
		textField_15 = new JTextField();
		textField_15.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_15.setBounds(195, 597, 857, 28);
		frame.getContentPane().add(textField_15);
		textField_15.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Save and Next");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=textField.getText();
				String rollNo=textField_1.getText();
				String email=textField_2.getText();
				String gender=(String)comboBox.getSelectedItem();
				String fatherName=textField_3.getText();
				String motherName=textField_4.getText();
				String contactNo=textField_5.getText();
				String tenthBoardName=txtUniversityName.getText();
				String tenthPercentage=txtPercentage.getText();
				String tenthPassoutYear=txtPassedOutYear.getText();
				String twelveGroupName=txtUniversityName_1.getText();
				String twelvePercentage=txtPercentage_1.getText();
				String twelvePassoutYear=txtPassedOutYear_1.getText();
				String graduationBranchName=txtUniversityName_2.getText();
				String graduationPercentage=txtPercentage_2.getText();
				String gradutionPassoutYear=txtPassedOutYear_2.getText();
				String address=textField_15.getText();
				String marks="0";
				
				try {
					Connection con=ConnectionProvider.getCon();
					PreparedStatement ps=con.prepareStatement("insert into student values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
					ps.setString(1,name);
					ps.setString(2,rollNo);
					ps.setString(3,email);
					ps.setString(4,gender);
					ps.setString(5,fatherName);
					ps.setString(6,motherName);
					ps.setString(7,contactNo);
					ps.setString(8,tenthBoardName);
					ps.setString(9,tenthPercentage);
					ps.setString(10,tenthPassoutYear);
					ps.setString(11,twelveGroupName);
					ps.setString(12,twelvePercentage);
					ps.setString(13,twelvePassoutYear);
					ps.setString(14,graduationBranchName);
					ps.setString(15,graduationPercentage);
					ps.setString(16,gradutionPassoutYear);
					ps.setString(17,address);
					ps.setString(18,marks);
					ps.executeUpdate();
					
					Instuction_page ip=new Instuction_page(rollNo);
					ip.frame.setVisible(true);
					frame.dispose();
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(getClass().getResource("/quiz/save.png")));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(309, 668, 411, 32);
		frame.getContentPane().add(btnNewButton_1);
		
		txtrExaminationManagementSystem = new JTextArea();
		txtrExaminationManagementSystem.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtrExaminationManagementSystem.setText("\r\nExamination Management System is Managing all the activites related to \r\r\nExamination , Enrollment and Examination Form process the Results ,\r\r\nCertificates and Grading Reports.");
		txtrExaminationManagementSystem.setBounds(558, 174, 749, 120);
		frame.getContentPane().add(txtrExaminationManagementSystem);
		
		JLabel lblNewLabel_15 = new JLabel("New label");
		lblNewLabel_15.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_15.setIcon(new ImageIcon(getClass().getResource("/quiz/student.png")));
		lblNewLabel_15.setBounds(0, -29, 1352, 760);
		frame.getContentPane().add(lblNewLabel_15);
	}
}
