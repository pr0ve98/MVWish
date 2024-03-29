package mvwish;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SpringLayout;

public class MVW_RealMain extends JFrame{
	private JButton btnLogout, btnExit, btnMyPage, btnAdmin, btnGenreSearch;
	private JLabel lblLogo;
	private JLabel lblNewLabel;
	private JComboBox cbGenre;
	private JPanel pn2;
	
	private MVW_VO vo = null;
	private MVW_DAO dao = new MVW_DAO();
	private JTextField txtMovieSearch;
	private JLabel lblMovieImage1;
	private JLabel lblMovieImage2;
	private JLabel lblMovieImage3;
	private JLabel lblMovieImage4;
	private JLabel lblMovieName1;
	private JLabel lblMovieStar1;
	private JLabel lblMovieScore1;
	private JLabel lblNewLabel_8;
	private JScrollBar scrollBar;
	
	public MVW_RealMain(String mid) {
		super("MVWish!");
		getContentPane().setBackground(new Color(0, 0, 0));
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
		
		btnMyPage = new JButton("마이페이지");
		btnMyPage.setFont(new Font("G마켓 산스 TTF Medium", Font.PLAIN, 15));
		btnMyPage.setBounds(874, 53, 165, 53);
		pn1.add(btnMyPage);
		
		btnAdmin = new JButton("관리자 모드");
		btnAdmin.setFont(new Font("G마켓 산스 TTF Medium", Font.PLAIN, 14));
		btnAdmin.setBounds(938, 125, 114, 23);
		pn1.add(btnAdmin);
		
		btnLogout = new JButton("로그아웃");
		btnLogout.setBackground(new Color(255, 255, 255));
		btnLogout.setFont(new Font("G마켓 산스 TTF Light", Font.PLAIN, 14));
		btnLogout.setBounds(870, 0, 97, 23);
		pn1.add(btnLogout);
		
		btnExit = new JButton("종료");
		btnExit.setBackground(new Color(255, 0, 0));
		btnExit.setForeground(new Color(255, 255, 255));
		btnExit.setFont(new Font("G마켓 산스 TTF Light", Font.BOLD, 14));
		btnExit.setBounds(967, 0, 97, 23);
		pn1.add(btnExit);
		
		lblNewLabel = new JLabel(mid+"님 환영합니다!");
		lblNewLabel.setFont(new Font("G마켓 산스 TTF Medium", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(566, 0, 292, 23);
		pn1.add(lblNewLabel);
		
		cbGenre = new JComboBox();
		cbGenre.setFont(new Font("G마켓 산스 TTF Medium", Font.PLAIN, 12));
		cbGenre.setBounds(518, 68, 102, 23);
		pn1.add(cbGenre);
		
		btnGenreSearch = new JButton("장르별 검색");
		btnGenreSearch.setFont(new Font("G마켓 산스 TTF Medium", Font.PLAIN, 12));
		btnGenreSearch.setBounds(632, 68, 108, 23);
		pn1.add(btnGenreSearch);
		
		txtMovieSearch = new JTextField();
		txtMovieSearch.setBounds(250, 60, 157, 38);
		pn1.add(txtMovieSearch);
		txtMovieSearch.setColumns(10);
		
		JButton btnSearch = new JButton("검색");
		btnSearch.setFont(new Font("G마켓 산스 TTF Medium", Font.PLAIN, 12));
		btnSearch.setBounds(422, 67, 69, 23);
		pn1.add(btnSearch);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(-14, 157, 1092, 581);
		getContentPane().add(scrollPane);
		
		pn2 = new JPanel();
		pn2.setForeground(new Color(255, 255, 255));
		pn2.setBackground(new Color(0, 0, 0));
		pn2.setBounds(0, 157, 1064, 2000);
		scrollPane.setViewportView(pn2);
		pn2.setLayout(null);
		
		lblMovieImage1 = new JLabel("New label");
		lblMovieImage1.setBounds(58, 50, 193, 276);
		lblMovieImage1.setHorizontalAlignment(SwingConstants.CENTER);
		lblMovieImage1.setForeground(new Color(255, 255, 255));
		lblMovieImage1.setBackground(new Color(255, 255, 255));
		pn2.add(lblMovieImage1);
		
		lblMovieImage2 = new JLabel("New label");
		lblMovieImage2.setBounds(309, 50, 193, 276);
		lblMovieImage2.setHorizontalAlignment(SwingConstants.CENTER);
		lblMovieImage2.setForeground(Color.WHITE);
		lblMovieImage2.setBackground(Color.WHITE);
		pn2.add(lblMovieImage2);
		
		lblMovieImage3 = new JLabel("New label");
		lblMovieImage3.setBounds(560, 50, 193, 276);
		lblMovieImage3.setHorizontalAlignment(SwingConstants.CENTER);
		lblMovieImage3.setForeground(Color.WHITE);
		lblMovieImage3.setBackground(Color.WHITE);
		pn2.add(lblMovieImage3);
		
		lblMovieImage4 = new JLabel("New label");
		lblMovieImage4.setBounds(811, 50, 193, 276);
		lblMovieImage4.setHorizontalAlignment(SwingConstants.CENTER);
		lblMovieImage4.setForeground(Color.WHITE);
		lblMovieImage4.setBackground(Color.WHITE);
		pn2.add(lblMovieImage4);
		
		lblMovieName1 = new JLabel("영화 제목");
		lblMovieName1.setBounds(58, 336, 194, 40);
		lblMovieName1.setFont(new Font("G마켓 산스 TTF Bold", Font.PLAIN, 25));
		lblMovieName1.setForeground(new Color(255, 255, 255));
		pn2.add(lblMovieName1);
		
		lblMovieStar1 = new JLabel("★");
		lblMovieStar1.setBounds(58, 370, 24, 24);
		lblMovieStar1.setFont(new Font("굴림", Font.PLAIN, 20));
		lblMovieStar1.setForeground(new Color(255, 255, 255));
		pn2.add(lblMovieStar1);
		
		lblMovieScore1 = new JLabel("3.5");
		lblMovieScore1.setBounds(82, 371, 50, 24);
		lblMovieScore1.setFont(new Font("G마켓 산스 TTF Medium", Font.PLAIN, 20));
		lblMovieScore1.setForeground(new Color(255, 255, 255));
		pn2.add(lblMovieScore1);
		
		lblNewLabel_8 = new JLabel("2시간 13분");
		lblNewLabel_8.setBounds(144, 373, 107, 24);
		lblNewLabel_8.setFont(new Font("G마켓 산스 TTF Medium", Font.PLAIN, 15));
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setForeground(new Color(128, 128, 128));
		pn2.add(lblNewLabel_8);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(58, 402, 193, 48);
		textPane.setText("장르: 어드벤처, 어쩌구, 저쩌구, 이것저것, 장르가 많아요");
		textPane.setFont(new Font("G마켓 산스 TTF Medium", Font.PLAIN, 15));
		textPane.setForeground(new Color(128, 128, 128));
		textPane.setBackground(new Color(0, 0, 0));
		pn2.add(textPane);

		JLabel lblMovieName2 = new JLabel("영화 제목");
		lblMovieName2.setBounds(319, 336, 194, 40);
		lblMovieName2.setForeground(Color.WHITE);
		lblMovieName2.setFont(new Font("G마켓 산스 TTF Bold", Font.PLAIN, 25));
		pn2.add(lblMovieName2);
		
		JLabel lblMovieStar2 = new JLabel("★");
		lblMovieStar2.setBounds(319, 370, 24, 24);
		lblMovieStar2.setForeground(Color.WHITE);
		lblMovieStar2.setFont(new Font("굴림", Font.PLAIN, 20));
		pn2.add(lblMovieStar2);
		
		JLabel lblMovieScore2 = new JLabel("3.5");
		lblMovieScore2.setBounds(343, 371, 50, 24);
		lblMovieScore2.setForeground(Color.WHITE);
		lblMovieScore2.setFont(new Font("G마켓 산스 TTF Medium", Font.PLAIN, 20));
		pn2.add(lblMovieScore2);
		
		JLabel lblNewLabel_8_1 = new JLabel("2시간 13분");
		lblNewLabel_8_1.setBounds(405, 373, 107, 24);
		lblNewLabel_8_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8_1.setForeground(Color.GRAY);
		lblNewLabel_8_1.setFont(new Font("G마켓 산스 TTF Medium", Font.PLAIN, 15));
		pn2.add(lblNewLabel_8_1);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(319, 402, 193, 48);
		textPane_1.setText("장르: 어드벤처, 어쩌구, 저쩌구, 이것저것, 장르가 많아요");
		textPane_1.setForeground(Color.GRAY);
		textPane_1.setFont(new Font("G마켓 산스 TTF Medium", Font.PLAIN, 15));
		textPane_1.setBackground(Color.BLACK);
		pn2.add(textPane_1);
		
		JLabel lblMovieName3 = new JLabel("영화 제목");
		lblMovieName3.setBounds(570, 336, 194, 40);
		lblMovieName3.setForeground(Color.WHITE);
		lblMovieName3.setFont(new Font("G마켓 산스 TTF Bold", Font.PLAIN, 25));
		pn2.add(lblMovieName3);
		
		JLabel lblMovieStar3 = new JLabel("★");
		lblMovieStar3.setBounds(570, 370, 24, 24);
		lblMovieStar3.setForeground(Color.WHITE);
		lblMovieStar3.setFont(new Font("굴림", Font.PLAIN, 20));
		pn2.add(lblMovieStar3);
		
		JLabel lblMovieScore3 = new JLabel("3.5");
		lblMovieScore3.setBounds(594, 371, 50, 24);
		lblMovieScore3.setForeground(Color.WHITE);
		lblMovieScore3.setFont(new Font("G마켓 산스 TTF Medium", Font.PLAIN, 20));
		pn2.add(lblMovieScore3);
		
		JLabel lblNewLabel_8_1_1 = new JLabel("2시간 13분");
		lblNewLabel_8_1_1.setBounds(656, 373, 107, 24);
		lblNewLabel_8_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8_1_1.setForeground(Color.GRAY);
		lblNewLabel_8_1_1.setFont(new Font("G마켓 산스 TTF Medium", Font.PLAIN, 15));
		pn2.add(lblNewLabel_8_1_1);
		
		JTextPane textPane_1_1 = new JTextPane();
		textPane_1_1.setBounds(570, 402, 193, 48);
		textPane_1_1.setText("장르: 어드벤처, 어쩌구, 저쩌구, 이것저것, 장르가 많아요");
		textPane_1_1.setForeground(Color.GRAY);
		textPane_1_1.setFont(new Font("G마켓 산스 TTF Medium", Font.PLAIN, 15));
		textPane_1_1.setBackground(Color.BLACK);
		pn2.add(textPane_1_1);
		
		JLabel lblMovieName4 = new JLabel("영화 제목");
		lblMovieName4.setBounds(821, 336, 194, 40);
		lblMovieName4.setForeground(Color.WHITE);
		lblMovieName4.setFont(new Font("G마켓 산스 TTF Bold", Font.PLAIN, 25));
		pn2.add(lblMovieName4);
		
		JLabel lblMovieStar4 = new JLabel("★");
		lblMovieStar4.setBounds(821, 370, 24, 24);
		lblMovieStar4.setForeground(Color.WHITE);
		lblMovieStar4.setFont(new Font("굴림", Font.PLAIN, 20));
		pn2.add(lblMovieStar4);
		
		JLabel lblMovieScore4 = new JLabel("3.5");
		lblMovieScore4.setBounds(845, 371, 50, 24);
		lblMovieScore4.setForeground(Color.WHITE);
		lblMovieScore4.setFont(new Font("G마켓 산스 TTF Medium", Font.PLAIN, 20));
		pn2.add(lblMovieScore4);
		
		JLabel lblNewLabel_8_1_1_1 = new JLabel("2시간 13분");
		lblNewLabel_8_1_1_1.setBounds(907, 373, 107, 24);
		lblNewLabel_8_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8_1_1_1.setForeground(Color.GRAY);
		lblNewLabel_8_1_1_1.setFont(new Font("G마켓 산스 TTF Medium", Font.PLAIN, 15));
		pn2.add(lblNewLabel_8_1_1_1);
		
		JTextPane textPane_1_1_1 = new JTextPane();
		textPane_1_1_1.setBounds(821, 402, 193, 48);
		textPane_1_1_1.setText("장르: 어드벤처, 어쩌구, 저쩌구, 이것저것, 장르가 많아요");
		textPane_1_1_1.setForeground(Color.GRAY);
		textPane_1_1_1.setFont(new Font("G마켓 산스 TTF Medium", Font.PLAIN, 15));
		textPane_1_1_1.setBackground(Color.BLACK);
		pn2.add(textPane_1_1_1);
		
		ArrayList<MVW_VO> vos = dao.movieInput();
		for(MVW_VO v: vos) {
			System.out.println(v);
		}
			
		// 버튼 숨김
		btnAdmin.setVisible(false);
		
		// 관리자로 접속시 관리자모드 버튼 보이기
		if(mid.equals("admin")) btnAdmin.setVisible(true);
		
		// ----------------------------------- 위쪽은 UI ----------------------------------------
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		getContentPane().setLayout(null);
		
		// 종료버튼
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
		
		// 로그아웃 버튼
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MVW_First();
			}
		});
		btnLogout.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				dispose();
				new MVW_First();
			}
		});
		
		// 관리자모드 버튼
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MVW_Admin();
			}
		});
		
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MVW_RealMain("admin");
	}
}
