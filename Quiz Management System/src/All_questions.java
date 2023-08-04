import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Point;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;
import project.ConnectionProvider;
import javax.swing.JScrollPane;

public class All_questions {

	JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					All_questions window = new All_questions();
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
	public All_questions() {
		initialize();
		try {
			Connection con=ConnectionProvider.getCon();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select *from question");
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
		lblNewLabel.setBounds(10, 0, 65, 68);
		lblNewLabel.setIcon(new ImageIcon("quiz\\all questions.png"));
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("All Questions");
		lblNewLabel_1.setBounds(80, 10, 411, 62);
		lblNewLabel_1.setFont(new Font("Algerian", Font.BOLD, 40));
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBounds(974, 0, 78, 68);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin_page hp=new Admin_page();
				Admin_page.open=0;
				hp.frame.setVisible(false);
				frame.dispose();
			}
		});
		btnNewButton.setIcon(new ImageIcon(getClass().getResource("/quiz/Close.png")));
		frame.getContentPane().add(btnNewButton);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 71, 1052, 13);
		frame.getContentPane().add(separator);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 94, 1009, 312);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(0, 0, 1052, 498);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3.setIcon(new ImageIcon(getClass().getResource("/quiz/adminbg.png")));
		frame.getContentPane().add(lblNewLabel_3);
	}
}
