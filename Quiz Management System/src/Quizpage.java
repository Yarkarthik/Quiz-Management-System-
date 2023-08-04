import java.awt.EventQueue;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Panel;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.Timer;

import project.ConnectionProvider;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class Quizpage {

	JFrame frame;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_13;
	private JLabel lblNewLabel_9_2;
	private JLabel lblNewLabel_9_4;
	private JLabel lblNewLabel_15;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private JRadioButton rdbtnNewRadioButton_2;
	private JRadioButton rdbtnNewRadioButton_2_3;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9_1;
	private JButton btnNewButton;
	private Timer time;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Quizpage window = new Quizpage(null);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public String questionId="1";
	public String answer;
	public int min=0;
	public int sec=0;
	public int marks=0;
	
	public void nextquestion()
	{
		int questionId1=Integer.parseInt(questionId);
		questionId1=questionId1+1;
		
		questionId=String.valueOf(questionId1);
		rdbtnNewRadioButton.setSelected(false);
		rdbtnNewRadioButton_1.setSelected(false);
		rdbtnNewRadioButton_2.setSelected(false);
		rdbtnNewRadioButton_2_3.setSelected(false);
		
		if(questionId.equals("10"))
		{
			btnNewButton.setVisible(false);
		}
	}
	
	public void previousquestion()
	{
		int questionId1=Integer.parseInt(questionId);
		questionId1=questionId1-1;
		
		questionId=String.valueOf(questionId1);
		rdbtnNewRadioButton.setSelected(false);
		rdbtnNewRadioButton_1.setSelected(false);
		rdbtnNewRadioButton_2.setSelected(false);
		rdbtnNewRadioButton_2_3.setSelected(false);
		
		if(questionId.equals("1"))
		{
			btnNewButton.setVisible(false);
		}
	}
	
	public void answerCheck() {
		String studentAnswer="";
		if(rdbtnNewRadioButton.isSelected())
		{
			studentAnswer=rdbtnNewRadioButton.getText();
		}
		else if(rdbtnNewRadioButton_1.isSelected())
		{
			studentAnswer=rdbtnNewRadioButton_1.getText();
		}
		else if(rdbtnNewRadioButton_2.isSelected())
		{
			studentAnswer=rdbtnNewRadioButton_2.getText();
		}
		else
		{
			studentAnswer=rdbtnNewRadioButton_2_3.getText();
		}
		if(studentAnswer.equals(answer))
		{
			marks=marks+1;
			String marks1=String.valueOf(marks);
			lblNewLabel_9_1.setText(marks1);
		}
		
		
		nextquestion();
		
		
	}
	public void question()
	{
		try {
			Connection con=ConnectionProvider.getCon();
			Statement st=con.createStatement();
			ResultSet rsl=st.executeQuery("select *from question where id='"+questionId+"'");
			while(rsl.next())
			{
				lblNewLabel_9_4.setText(rsl.getString(1));
				lblNewLabel_15.setText(rsl.getString(2));
				rdbtnNewRadioButton.setText(rsl.getString(3));
				rdbtnNewRadioButton_1.setText(rsl.getString(4));
				rdbtnNewRadioButton_2.setText(rsl.getString(5));
				rdbtnNewRadioButton_2_3.setText(rsl.getString(6));
				answer=rsl.getString(7);
			}
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	public void submit() {
		String rollNo=lblNewLabel_13.getText();
		answerCheck();
		try {
			Connection con=ConnectionProvider.getCon();
			Statement st=con.createStatement();
			st.executeUpdate("update student set marks='"+marks+"' where rollNo='"+rollNo+"'");
			String marks1=String.valueOf(marks);
			frame.setVisible(false);
			
			Result_page rp=new Result_page(marks1);
			rp.frame.setVisible(true);
			frame.dispose();
			
			 
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	/**
	 * Create the application.
	 */
	public Quizpage() {
		initialize();
	}
	
	public Quizpage(String rollNo) {
		initialize();
		
		
		lblNewLabel_13.setText(rollNo);
		SimpleDateFormat dFormat=new SimpleDateFormat("dd-MM-yyyy");
		Date date=new Date();
		lblNewLabel_3.setText(dFormat.format(date));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 205, 170));
		panel.setBounds(303, 94, 1049, 637);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		try {
			Connection con=ConnectionProvider.getCon();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select *from student where rollNo='"+rollNo+"'");
			while(rs.next())
			{
				lblNewLabel_9_2.setText(rs.getString(1));
			}
			ResultSet rsl=st.executeQuery("select *from question where id='"+questionId+"'");
			while(rsl.next())
			{
				lblNewLabel_9_4.setText(rsl.getString(1));
				lblNewLabel_15.setText(rsl.getString(2));
				rdbtnNewRadioButton.setText(rsl.getString(3));
				rdbtnNewRadioButton_1.setText(rsl.getString(4));
				rdbtnNewRadioButton_2.setText(rsl.getString(5));
				rdbtnNewRadioButton_2_3.setText(rsl.getString(6));
				answer=rsl.getString(7);
			}
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		
		 
		frame.setLocationRelativeTo(frame);
		time=new Timer(1000,new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblNewLabel_8.setText(String.valueOf(sec));
				lblNewLabel_7.setText(String.valueOf(min));
				
				if(sec==60)
				{
					sec=0;
					min++;
					if(min==10)
					{
						time.stop();
						answerCheck();
						submit();
					}
				}
				sec++;
			}
			
		});
		time.start();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 20));
		frame.getContentPane().setLocation(new Point(150, 183));
		frame.setBounds(0, 0, 1366, 768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Panel panel = new Panel();
		panel.setBackground(Color.CYAN);
		panel.setBounds(0, 0, 1352, 97);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(24, 5, 60, 60);
		panel.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(getClass().getResource("/quiz/index student.png")));
		
		JLabel lblNewLabel_1 = new JLabel("WELCOME");
		lblNewLabel_1.setBounds(86, 13, 244, 61);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Algerian", Font.BOLD, 50));
		
		JLabel lblNewLabel_2 = new JLabel("Date:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(669, 26, 67, 39);
		panel.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("label");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3.setBounds(740, 32, 134, 26);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Total Time:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_4.setBounds(1064, 13, 134, 31);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Time Taken:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_5.setBounds(1059, 46, 139, 31);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("10 Min");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_6.setBounds(1225, 13, 78, 31);
		panel.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("00");
		lblNewLabel_7.setForeground(Color.RED);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_7.setBounds(1225, 46, 31, 31);
		panel.add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel("00");
		lblNewLabel_8.setForeground(Color.RED);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_8.setBounds(1261, 46, 31, 31);
		panel.add(lblNewLabel_8);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.CYAN);
		panel_1.setBounds(0, 94, 305, 637);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_11 = new JLabel("Name:");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_11.setBounds(21, 61, 76, 25);
		panel_1.add(lblNewLabel_11);
		
		JLabel lblNewLabel_10 = new JLabel("Roll Number:");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_10.setBounds(21, 22, 149, 25);
		panel_1.add(lblNewLabel_10);
		
		JLabel lblNewLabel_9 = new JLabel("Total Question:");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_9.setBounds(21, 112, 160, 25);
		panel_1.add(lblNewLabel_9);
		
		JLabel lblNewLabel_12 = new JLabel("Your Marks:");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_12.setBounds(21, 205, 149, 25);
		panel_1.add(lblNewLabel_12);
		
		lblNewLabel_13 = new JLabel("10000");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_13.setBounds(190, 25, 89, 19);
		panel_1.add(lblNewLabel_13);
		
		lblNewLabel_9_1 = new JLabel("00");
		lblNewLabel_9_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_9_1.setBounds(217, 205, 45, 19);
		panel_1.add(lblNewLabel_9_1);
		
		lblNewLabel_9_2 = new JLabel("SHIVAgaddam");
		lblNewLabel_9_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_9_2.setBounds(107, 61, 172, 25);
		panel_1.add(lblNewLabel_9_2);
		
		JLabel lblNewLabel_9_3 = new JLabel("10");
		lblNewLabel_9_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_9_3.setBounds(217, 112, 45, 25);
		panel_1.add(lblNewLabel_9_3);
		
		lblNewLabel_9_4 = new JLabel("00");
		lblNewLabel_9_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_9_4.setBounds(217, 155, 45, 29);
		panel_1.add(lblNewLabel_9_4);
		
		JLabel lblNewLabel_14 = new JLabel("Question Number:");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_14.setBounds(21, 157, 201, 25);
		panel_1.add(lblNewLabel_14);
		
		lblNewLabel_15 = new JLabel("QuestionDemo1");
		lblNewLabel_15.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_15.setBounds(375, 125, 953, 41);
		frame.getContentPane().add(lblNewLabel_15);
		
		rdbtnNewRadioButton = new JRadioButton("New radio button");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButton.isSelected())
				{
					rdbtnNewRadioButton_1.setSelected(false);
					rdbtnNewRadioButton_2.setSelected(false);
					rdbtnNewRadioButton_2_3.setSelected(false);
				}
			}
		});
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		rdbtnNewRadioButton.setBounds(375, 205, 428, 33);
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		rdbtnNewRadioButton_1 = new JRadioButton("New radio button");
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButton_1.isSelected())
				{
					rdbtnNewRadioButton.setSelected(false);
					rdbtnNewRadioButton_2.setSelected(false);
					rdbtnNewRadioButton_2_3.setSelected(false);
				}
			}
		});
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		rdbtnNewRadioButton_1.setBounds(375, 260, 428, 33);
		frame.getContentPane().add(rdbtnNewRadioButton_1);
		
		rdbtnNewRadioButton_2 = new JRadioButton("New radio button");
		rdbtnNewRadioButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButton_2.isSelected())
				{
					rdbtnNewRadioButton.setSelected(false);
					rdbtnNewRadioButton_1.setSelected(false);
					rdbtnNewRadioButton_2_3.setSelected(false);
				}
			}
		});
		rdbtnNewRadioButton_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		rdbtnNewRadioButton_2.setBounds(375, 317, 428, 33);
		frame.getContentPane().add(rdbtnNewRadioButton_2);
		
		btnNewButton = new JButton("Next");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				answerCheck();
				question();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setIcon(new ImageIcon(getClass().getResource("/quiz/Next.png")));
		btnNewButton.setBounds(426, 613, 126, 33);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Submit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a=JOptionPane.showConfirmDialog(null,"Do you really want to submit","Select",JOptionPane.YES_NO_OPTION);
				if(a==0)
				{
					answerCheck();
					submit();
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.setIcon(new ImageIcon(getClass().getResource("/quiz/save.png")));
		btnNewButton_1.setBounds(1042, 613, 142, 33);
		frame.getContentPane().add(btnNewButton_1);
		
		rdbtnNewRadioButton_2_3 = new JRadioButton("New radio button");
		rdbtnNewRadioButton_2_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButton_2_3.isSelected())
				{
					rdbtnNewRadioButton_1.setSelected(false);
					rdbtnNewRadioButton_2.setSelected(false);
					rdbtnNewRadioButton.setSelected(false);
				}
			}
		});
		rdbtnNewRadioButton_2_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		rdbtnNewRadioButton_2_3.setBounds(375, 370, 428, 33);
		frame.getContentPane().add(rdbtnNewRadioButton_2_3);
	}
}
