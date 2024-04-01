package mvwish;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class UserWish extends JFrame{
	private JLabel[] lblMovieImg = new JLabel[100];
	private JLabel[] lblMovieName = new JLabel[100];
	private JLabel[] lblMovieScore = new JLabel[100];
	private JLabel[] lblMovieRT = new JLabel[100];
	private JTextPane[] lblMovieGenre = new JTextPane[100];
	private int[] idx = new int[100];
	private JButton[] btnWish = new JButton[100];
	private JButton[] btnWishOff = new JButton[100];
	
	private JButton btnMyPage;
	private JLabel lblLogo, lblMovieStar1, lblNewLabel_1, lblWishTitle;
	private JPanel pn2;
	private JScrollPane scrollPane;
	
	
	private DAO dao = new DAO();
	ArrayList<VO> vos = null;
	private VO[] vo = new VO[100];
	int lblCount = 0;
	int res = 0;
	private JLabel lblNewLabel;
	
	public UserWish(String mid) {
		super("My Wish");
		getContentPane().setBackground(new Color(0, 0, 0));
		setSize(1080, 720);
		
		JPanel pn1 = new JPanel();
		pn1.setBackground(new Color(0, 0, 0));
		pn1.setBounds(0, 0, 1064, 158);
		getContentPane().add(pn1);
		pn1.setLayout(null);
		
		lblLogo = new JLabel("");
		lblLogo.setBounds(417, 10, 225, 138);
		lblLogo.setIcon(new ImageIcon(UserWish.class.getResource("/mvwish/img/logo.jpg")));
		lblLogo.setForeground(new Color(255, 255, 255));
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		pn1.add(lblLogo);
		
		btnMyPage = new JButton("메인으로");
		btnMyPage.setBounds(967, 125, 97, 23);
		btnMyPage.setBackground(new Color(255, 255, 255));
		btnMyPage.setFont(new Font("G마켓 산스 TTF Light", Font.PLAIN, 14));
		pn1.add(btnMyPage);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(0, 143, 1064, 15);
		lblNewLabel_1.setIcon(new ImageIcon(UserWish.class.getResource("/mvwish/img/lbl.jpg")));
		pn1.add(lblNewLabel_1);
		
		
		pn2 = new JPanel();
		pn2.setForeground(new Color(255, 255, 255));
		pn2.setBackground(new Color(0, 0, 0));
		pn2.setLayout(null);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(UserWish.class.getResource("/mvwish/img/noWish.jpg")));
		lblNewLabel.setBounds(39, 73, 1011, 435);
		pn2.add(lblNewLabel);
		
		vos = dao.movieWishView(mid);
		if(vos.size()!=0) lblNewLabel.setVisible(false);
		for(int i=0; i<vos.size(); i++) {
			vo[i] = dao.movieSearch(vos.get(i).getWishIdx());
		}
		movieList();
		
		scrollPane = new JScrollPane(pn2);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(-11, 157, 1075, 534);
		getContentPane().add(scrollPane);
		scrollPane.setViewportView(pn2);
		// 스크롤바 첫 위치 제일 위로 고정
		SwingUtilities.invokeLater(() -> scrollPane.getViewport().setViewPosition(new Point(0, 0)));
		scrollPane.getVerticalScrollBar().setUnitIncrement(16); // 마우스 휠 한번에 움직일 스크롤바 픽셀 수 지정
		
		lblWishTitle = new JLabel("  "+mid+"님의 위시리스트");
		lblWishTitle.setIcon(new ImageIcon(UserWish.class.getResource("/mvwish/img/heart.png")));
		lblWishTitle.setForeground(new Color(255, 255, 255));
		lblWishTitle.setFont(new Font("G마켓 산스 TTF Bold", Font.PLAIN, 30));
		lblWishTitle.setBounds(39, 22, 869, 41);
		pn2.add(lblWishTitle);
		
		
		// ----------------------------------- 위쪽은 UI ----------------------------------------
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		getContentPane().setLayout(null);
		setVisible(true);
		// ----------------------------------- 아래쪽은 메소드 ----------------------------------------
		
		// 메인으로 버튼
		btnMyPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Main(mid);
			}
		});
		btnMyPage.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				dispose();
				new Main(mid);
			};
		});
		
		
	}
	
	// DB에서 영화정보 가져온만큼 레이아웃 추가하는 메소드
	public void movieList() {
		int x=58, xS=82, xB=91, xR=144, yI=80, yN=366, yS=400, yG=422, yB=475, cnt=0;
		int scroll = 500;
		for(int i=0; i<vos.size(); i++) {
			pn2.setPreferredSize(new Dimension(1080, scroll));
			idx[i] = vos.get(i).getWishIdx();
			int movieIdx = idx[i];
			// 이미지
			lblMovieImg[i] = new JLabel("영화이미지"+(i+1));
			lblMovieImg[i].setBounds(x, yI, 192, 276);
			if(UserWish.class.getResource("/images/"+vo[i].getImg())== null) 
				lblMovieImg[i].setIcon(new ImageIcon(UserWish.class.getResource("/images/wait.jpg")));
			else lblMovieImg[i].setIcon(new ImageIcon(UserWish.class.getResource("/images/"+vo[i].getImg())));
			// 제목
			lblMovieName[i] = new JLabel(vo[i].getMovieName());
			lblMovieName[i].setBounds(x, yN, 194, 40);
			lblMovieName[i].setFont(new Font("G마켓 산스 TTF Bold", Font.PLAIN, 25));
			lblMovieName[i].setForeground(Color.WHITE);
			// 별
			lblMovieStar1 = new JLabel("★");
			lblMovieStar1.setBounds(x, yS+1, 24, 24);
			lblMovieStar1.setFont(new Font("G마켓 산스 TTF Medium", Font.PLAIN, 20));
			lblMovieStar1.setForeground(new Color(255, 204, 0));
			// 평점
			lblMovieScore[i] = new JLabel(String.valueOf(vo[i].getScore()));
			lblMovieScore[i].setBounds(xS, yS+1, 50, 24);
			lblMovieScore[i].setFont(new Font("G마켓 산스 TTF Medium", Font.PLAIN, 20));
			lblMovieScore[i].setForeground(new Color(255, 255, 255));
			// 러닝타임
			lblMovieRT[i] = new JLabel(vo[i].getRunningTime());
			lblMovieRT[i].setBounds(xR, yS+3, 107, 24);
			lblMovieRT[i].setFont(new Font("G마켓 산스 TTF Medium", Font.PLAIN, 15));
			lblMovieRT[i].setHorizontalAlignment(SwingConstants.CENTER);
			lblMovieRT[i].setForeground(new Color(128, 128, 128));
			// 장르
			lblMovieGenre[i] = new JTextPane();
			lblMovieGenre[i].setBounds(x, yG, 193, 48);
			lblMovieGenre[i].setText("장르: "+vo[i].getGenre());
			lblMovieGenre[i].setFont(new Font("G마켓 산스 TTF Medium", Font.PLAIN, 15));
			lblMovieGenre[i].setForeground(new Color(128, 128, 128));
			lblMovieGenre[i].setBackground(new Color(0, 0, 0));
			// 위시추가 버튼
			btnWish[i] = new JButton("♥ Wish ");
			btnWish[i].setBounds(xB, yB, 97, 23);
			btnWish[i].setFont(new Font("G마켓 산스 TTF Medium", Font.PLAIN, 12));
			btnWish[i].setBackground(new Color(255, 255, 255));
			btnWish[i].setForeground(new Color(0, 0, 0));
			btnWish[i].setVisible(false);
			// 위시해제 버튼
			btnWishOff[i] = new JButton("♡ 위시해제");
			btnWishOff[i].setBounds(xB, yB, 97, 23);
			btnWishOff[i].setFont(new Font("G마켓 산스 TTF Medium", Font.PLAIN, 12));
			btnWishOff[i].setBackground(new Color(255, 0, 0));
			btnWishOff[i].setForeground(new Color(255, 255, 255));
			
			pn2.add(lblMovieImg[i]);
			pn2.add(lblMovieName[i]);
			pn2.add(lblMovieStar1);
			pn2.add(lblMovieScore[i]);
			pn2.add(lblMovieRT[i]);
			pn2.add(lblMovieGenre[i]);
			pn2.add(btnWish[i]);
			pn2.add(btnWishOff[i]);
			
			final int btnIndex = i;

			// 위시 버튼 클릭
			btnWish[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					res = dao.userWishMovie(vos.get(btnIndex).getWishMid(), movieIdx);
					if(res != 0) {
						btnWish[btnIndex].setVisible(false);
						btnWishOff[btnIndex].setVisible(true);
					}
				}
			});
			// 위시해제 버튼 클릭
			btnWishOff[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					res = dao.userWishMovieDelete(vos.get(btnIndex).getWishMid(), movieIdx);
					if(res != 0) {
						btnWish[btnIndex].setVisible(true);
						btnWishOff[btnIndex].setVisible(false);
					}
				}
			});
			
			x += 261;
			xR += 261;
			xS += 261;
			xB += 265;
			cnt++;
			
			if(cnt % 4 == 0) {
				x=58; xS=82; xR=144; xB=91;
				yI += 450;
				yN += 450;
				yS += 450;
				yG += 450;
				yB += 450;
				scroll += 480;
				cnt = 0;
			}
		}
	}
	
//	public static void main(String[] args) {
//		new Main("user1");
//	}
}
