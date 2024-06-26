package mvwish;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class FirstMain extends JFrame{
	private JButton btnSignUp, btnSignIn, btnExit;
	private JLabel lblLogo;
	private JLabel lblLogin;
	
	public FirstMain() {
		super("MVWish!");
		setSize(1080, 720);
		
		JPanel pn1 = new JPanel();
		pn1.setBackground(new Color(0, 0, 0));
		pn1.setBounds(0, 0, 1064, 158);
		getContentPane().add(pn1);
		pn1.setLayout(null);
		
		lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(FirstMain.class.getResource("/mvwish/img/logo.jpg")));
		lblLogo.setForeground(new Color(255, 255, 255));
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setBounds(12, 10, 225, 138);
		pn1.add(lblLogo);
		
		btnSignIn = new JButton("로그인");
		btnSignIn.setBackground(new Color(255, 255, 255));
		btnSignIn.setFont(new Font("G마켓 산스 TTF Light", Font.PLAIN, 14));
		btnSignIn.setBounds(870, 0, 97, 23);
		pn1.add(btnSignIn);
		
		btnExit = new JButton("");
		btnExit.setIcon(new ImageIcon(FirstMain.class.getResource("/mvwish/img/exit.png")));
		btnExit.setForeground(new Color(255, 255, 255));
		btnExit.setBackground(new Color(255, 0, 0));
		btnExit.setFont(new Font("G마켓 산스 TTF Light", Font.BOLD, 14));
		btnExit.setBounds(967, 0, 97, 23);
		pn1.add(btnExit);
		
		btnSignUp = new JButton("회원가입");
		btnSignUp.setFont(new Font("G마켓 산스 TTF Light", Font.PLAIN, 14));
		btnSignUp.setBackground(new Color(255, 255, 255));
		btnSignUp.setBounds(773, 0, 97, 23);
		pn1.add(btnSignUp);
		
		JPanel pn2 = new JPanel();
		pn2.setForeground(new Color(255, 255, 255));
		pn2.setBackground(new Color(0, 0, 0));
		pn2.setBounds(0, 157, 1064, 524);
		getContentPane().add(pn2);
		pn2.setLayout(null);
		
		lblLogin = new JLabel("");
		lblLogin.setIcon(new ImageIcon(FirstMain.class.getResource("/mvwish/img/main.jpg")));
		lblLogin.setBounds(0, 0, 1064, 524);
		pn2.add(lblLogin);
		
		// ----------------------------------- 위쪽은 UI ----------------------------------------
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		getContentPane().setLayout(null);
		setVisible(true);
		// ----------------------------------- 아래쪽은 메소드 ----------------------------------------
		
		// 회원가입
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new SignUp();
			}
		});
		btnSignUp.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				dispose();
				new SignUp();
			}
		});
		
		// 로그인
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Login();
			}
		});
		btnSignIn.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				dispose();
				new Login();
			}
		});
		
		// 종료
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				System.exit(0);
			}
		});
	}
	
	public static void main(String[] args) {
		new FirstMain();
	}
}
