package mvwish;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import java.awt.Font;

public class MVW_RealMain extends JFrame{
	private JButton btnLogout, btnExit, btnList, btnMyPage, btnAdmin;
	private JLabel lblLogo;
	private JLabel lblNewLabel;
	
	public MVW_RealMain() {
		super("MVWish!");
		setSize(1080, 720);
		
		
		
		JPanel pn1 = new JPanel();
		pn1.setBackground(new Color(0, 0, 0));
		pn1.setBounds(0, 0, 1064, 158);
		getContentPane().add(pn1);
		pn1.setLayout(null);
		
		lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(MVW_RealMain.class.getResource("/mvwish/images/logo.jpg")));
		lblLogo.setForeground(new Color(255, 255, 255));
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setBounds(12, 10, 225, 138);
		pn1.add(lblLogo);
		
		btnList = new JButton("영화 목록");
		btnList.setBounds(311, 53, 165, 53);
		pn1.add(btnList);
		
		btnMyPage = new JButton("마이페이지");
		btnMyPage.setBounds(519, 53, 165, 53);
		pn1.add(btnMyPage);
		
		btnAdmin = new JButton("관리자 모드");
		btnAdmin.setBounds(720, 53, 165, 53);
		pn1.add(btnAdmin);
		
		btnLogout = new JButton("로그아웃");
		btnLogout.setBounds(870, 0, 97, 23);
		pn1.add(btnLogout);
		
		btnExit = new JButton("종료");
		btnExit.setBounds(967, 0, 97, 23);
		pn1.add(btnExit);
		
		lblNewLabel = new JLabel("님 환영합니다!");
		lblNewLabel.setFont(new Font("KoPubWorld돋움체 Medium", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(701, 0, 157, 23);
		pn1.add(lblNewLabel);
		
		JPanel pn2 = new JPanel();
		pn2.setForeground(new Color(255, 255, 255));
		pn2.setBackground(new Color(0, 0, 0));
		pn2.setBounds(0, 157, 1064, 524);
		getContentPane().add(pn2);
		pn2.setLayout(null);
		
		// 버튼 숨김
		btnAdmin.setVisible(false);
		
		// ----------------------------------- 위쪽은 UI ----------------------------------------
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		getContentPane().setLayout(null);
		setVisible(true);
		
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	
	public static void main(String[] args) {
		new MVW_RealMain();
	}
}
