import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Admin_page {

	JFrame frame;
	public static int open=0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_page window = new Admin_page();
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
	public Admin_page() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 1366, 768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1373, 75);
		frame.getContentPane().add(menuBar);
		
		JMenu mnNewMenu = new JMenu(" Add New Question ");
		mnNewMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(open==0)
				{
				Add_question aq= new Add_question();
				aq.frame.setVisible(true);
				aq.frame.setAlwaysOnTop(true);
				open=1;
				}
				else {
					JFrame jf =new JFrame();
					jf.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(jf, "One Form Is Already Open");
				}
			}
		});
		mnNewMenu.setMargin(new Insets(0, 5, 0, 30));
		mnNewMenu.setFont(new Font("Tahoma", Font.BOLD, 14));
		mnNewMenu.setIcon(new ImageIcon(getClass().getResource("/quiz/add new question.png")));
		menuBar.add(mnNewMenu);
		
		JMenu mnUpdateQuestion = new JMenu("  Update Question");
		mnUpdateQuestion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(open==0)
				{
				Update_question uq= new Update_question();
				uq.frame.setVisible(true);
				uq.frame.setAlwaysOnTop(true);
				open=1;
				}
				else {
					JFrame jf =new JFrame();
					jf.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(jf, "One Form Is Already Open");
				}
			}
		});
		mnUpdateQuestion.setFont(new Font("Tahoma", Font.BOLD, 14));
		mnUpdateQuestion.setIcon(new ImageIcon(getClass().getResource("/quiz/Update Question.png")));
		mnUpdateQuestion.setMargin(new Insets(0, 5, 0, 30));
		menuBar.add(mnUpdateQuestion);
		
		JMenu mnAllQuestions = new JMenu("  All Questions  ");
		mnAllQuestions.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(open==0)
				{
				All_questions aq= new All_questions();
				aq.frame.setVisible(true);
				aq.frame.setAlwaysOnTop(true);
				open=1;
				}
				else {
					JFrame jf =new JFrame();
					jf.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(jf, "One Form Is Already Open");
				}
			}
		});
		mnAllQuestions.setIcon(new ImageIcon(getClass().getResource("/quiz/all questions.png")));
		mnAllQuestions.setMargin(new Insets(0, 5, 0, 30));
		mnAllQuestions.setFont(new Font("Tahoma", Font.BOLD, 14));
		menuBar.add(mnAllQuestions);
		
		JMenu mnDeleteQuestions = new JMenu("  Delete Question  ");
		mnDeleteQuestions.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(open==0)
				{
				Delete_question dq= new Delete_question();
				dq.frame.setVisible(true);
				dq.frame.setAlwaysOnTop(true);
				open=1;
				}
				else {
					JFrame jf =new JFrame();
					jf.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(jf, "One Form Is Already Open");
				}
			}
		});
		mnDeleteQuestions.setIcon(new ImageIcon(getClass().getResource("/quiz/delete Question.png")));
		mnDeleteQuestions.setMargin(new Insets(0, 5, 0, 30));
		mnDeleteQuestions.setFont(new Font("Tahoma", Font.BOLD, 14));
		menuBar.add(mnDeleteQuestions);
		
		JMenu mnAllStudentsDetails = new JMenu("All Students Details");
		mnAllStudentsDetails.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(open==0)
				{
				All_Student_Results asr= new All_Student_Results ();
				asr.frame.setAlwaysOnTop(true);
				asr.frame.setVisible(true);
				open=1;
				}
				else {
					JFrame jf =new JFrame();
					jf.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(jf, "One Form Is Already Open");
				}
			}
		});
		mnAllStudentsDetails.setIcon(new ImageIcon(getClass().getResource("/quiz/all student result.png")));
		mnAllStudentsDetails.setMargin(new Insets(0, 5, 0, 30));
		mnAllStudentsDetails.setFont(new Font("Tahoma", Font.BOLD, 14));
		menuBar.add(mnAllStudentsDetails);
		
		JMenu mnLogout = new JMenu("   Logout   ");
		mnLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFrame jf=new JFrame();
				jf.setAlwaysOnTop(true);
				int a=JOptionPane.showConfirmDialog(jf, "Do you really want to Logout","select",JOptionPane.YES_NO_OPTION);
				if(a==0)
				{
					Admin_login_page alp=new Admin_login_page();
					alp.frame.setVisible(true);
					frame.dispose();
				}
			}
		});
		
		mnLogout.setIcon(new ImageIcon(getClass().getResource("/quiz/Logout.png")));
		mnLogout.setMargin(new Insets(0, 5, 0, 30));
		mnLogout.setFont(new Font("Tahoma", Font.BOLD, 14));
		menuBar.add(mnLogout);
		
		JMenu mnExit = new JMenu("        Exit    ");
		mnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFrame jf=new JFrame();
				jf.setAlwaysOnTop(true);
				int a=JOptionPane.showConfirmDialog(jf, "Do you want to Exit from Admin Page","select",JOptionPane.YES_NO_OPTION);
				if(a==0)
				{
					Home_page hp=new Home_page();
					hp.frame.setVisible(true);
					frame.dispose();
				}
			}
		});
		mnExit.setIcon(new ImageIcon(getClass().getResource("/quiz/Close.png")));
		mnExit.setMargin(new Insets(0, 5, 0, 30));
		mnExit.setFont(new Font("Tahoma", Font.BOLD, 14));
		menuBar.add(mnExit);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(getClass().getResource("/quiz/index background.png")));
		lblNewLabel.setBounds(0, 71, 1384, 650);
		frame.getContentPane().add(lblNewLabel);
	}
}
