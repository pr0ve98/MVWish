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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.DefaultComboBoxModel;

@SuppressWarnings({ "unchecked", "rawtypes", "serial" })
public class Main extends JFrame{
	private JLabel[] lblMovieImg = new JLabel[100];
	private JLabel[] lblMovieName = new JLabel[100];
	private JLabel[] lblMovieScore = new JLabel[100];
	private JLabel[] lblMovieRT = new JLabel[100];
	private JTextPane[] lblMovieGenre = new JTextPane[100];
	private int[] idx = new int[100];
	private JButton[] btnWish = new JButton[100];
	private JButton[] btnWishOff = new JButton[100];
	
	private JButton btnLogout, btnExit, btnMyPage, btnAdmin, btnGenreSearch, btnSearch, btnHome, btnWishRank;
	private JLabel lblLogo, lblMovieStar1, lblNewLabel, lblNewLabel_1, lblMovieRank;
	private JComboBox cbGenre;
	private JTextField txtMovieSearch;
	private JPanel pn2;
	private JScrollPane scrollPane;
	
	
	private VO vo = null;
	private VO vo2 = null;
	private DAO dao = new DAO();
	ArrayList<VO> vos = null;
	int lblCount = 0;
	int res = 0;
	
	public Main(String mid) {
		super("MVWish!");
		getContentPane().setBackground(new Color(0, 0, 0));
		setSize(1080, 720);
		
		JPanel pn1 = new JPanel();
		pn1.setBackground(new Color(0, 0, 0));
		pn1.setBounds(0, 0, 1064, 158);
		getContentPane().add(pn1);
		pn1.setLayout(null);
		
		lblLogo = new JLabel("");
		lblLogo.setBounds(12, 10, 225, 138);
		lblLogo.setIcon(new ImageIcon(Main.class.getResource("/mvwish/img/logo.jpg")));
		lblLogo.setForeground(new Color(255, 255, 255));
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		pn1.add(lblLogo);
		
		btnMyPage = new JButton("My Wish");
		btnMyPage.setIcon(new ImageIcon(Main.class.getResource("/mvwish/img/heart2.png")));
		btnMyPage.setBounds(926, 125, 126, 23);
		btnMyPage.setBackground(new Color(255, 255, 255));
		btnMyPage.setFont(new Font("G마켓 산스 TTF Medium", Font.PLAIN, 14));
		pn1.add(btnMyPage);
		
		btnAdmin = new JButton("관리자 모드");
		btnAdmin.setBounds(800, 125, 114, 23);
		btnAdmin.setBackground(new Color(255, 255, 255));
		btnAdmin.setFont(new Font("G마켓 산스 TTF Medium", Font.PLAIN, 14));
		pn1.add(btnAdmin);
		
		btnLogout = new JButton("로그아웃");
		btnLogout.setBounds(870, 0, 97, 23);
		btnLogout.setBackground(new Color(255, 255, 255));
		btnLogout.setFont(new Font("G마켓 산스 TTF Light", Font.PLAIN, 14));
		pn1.add(btnLogout);
		
		btnExit = new JButton("");
		btnExit.setBounds(967, 0, 97, 23);
		btnExit.setIcon(new ImageIcon(Main.class.getResource("/mvwish/img/exit.png")));
		btnExit.setBackground(new Color(255, 0, 0));
		btnExit.setForeground(new Color(255, 255, 255));
		btnExit.setFont(new Font("G마켓 산스 TTF Light", Font.BOLD, 14));
		pn1.add(btnExit);
		
		lblNewLabel = new JLabel(mid+"님 환영합니다!");
		lblNewLabel.setIcon(new ImageIcon(Main.class.getResource("/mvwish/img/userIcon.png")));
		lblNewLabel.setBounds(569, 1, 292, 23);
		lblNewLabel.setFont(new Font("G마켓 산스 TTF Medium", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		pn1.add(lblNewLabel);
		
		cbGenre = new JComboBox();
		cbGenre.setBackground(new Color(255, 255, 255));
		cbGenre.setModel(new DefaultComboBoxModel(new String[] {"장르 선택", "코미디", "액션", "범죄", "스릴러", "미스터리", "로코", "오컬트", "공포", "하이틴", "판타지", "뮤지컬", "가족", "애니메이션", "로맨스", "SF", "모험"}));
		cbGenre.setBounds(369, 113, 114, 24);
		cbGenre.setFont(new Font("G마켓 산스 TTF Medium", Font.PLAIN, 12));
		pn1.add(cbGenre);
		
		btnGenreSearch = new JButton("장르별 검색");
		btnGenreSearch.setBackground(new Color(255, 255, 255));
		btnGenreSearch.setBounds(494, 113, 108, 23);
		btnGenreSearch.setFont(new Font("G마켓 산스 TTF Medium", Font.PLAIN, 14));
		pn1.add(btnGenreSearch);
		
		txtMovieSearch = new JTextField();
		txtMovieSearch.setBounds(250, 60, 225, 38);
		pn1.add(txtMovieSearch);
		txtMovieSearch.setColumns(10);
		
		btnSearch = new JButton("검색");
		btnSearch.setBackground(new Color(255, 255, 255));
		btnSearch.setBounds(500, 67, 69, 23);
		btnSearch.setFont(new Font("G마켓 산스 TTF Medium", Font.PLAIN, 14));
		pn1.add(btnSearch);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(0, 143, 1064, 15);
		lblNewLabel_1.setIcon(new ImageIcon(Main.class.getResource("/mvwish/img/lbl.jpg")));
		pn1.add(lblNewLabel_1);
		
		btnHome = new JButton("");
		btnHome.setBackground(new Color(0, 0, 0));
		btnHome.setIcon(new ImageIcon(Main.class.getResource("/mvwish/img/logo.jpg")));
		btnHome.setBounds(12, 10, 225, 138);
		pn1.add(btnHome);
		
		btnWishRank = new JButton("인기 순위");
		btnWishRank.setFont(new Font("G마켓 산스 TTF Medium", Font.PLAIN, 14));
		btnWishRank.setBackground(Color.WHITE);
		btnWishRank.setBounds(249, 113, 108, 23);
		pn1.add(btnWishRank);
		
		
		pn2 = new JPanel();
		pn2.setForeground(new Color(255, 255, 255));
		pn2.setBackground(new Color(0, 0, 0));
		pn2.setLayout(null);
		
		vo = dao.getMidSearch(mid);
		
		vos = dao.movieView();
		lblCount = vos.size();
		movieList();
		
		lblMovieRank = new JLabel("  영화 인기리스트");
		lblMovieRank.setIcon(new ImageIcon(UserWish.class.getResource("/mvwish/img/rank.png")));
		lblMovieRank.setForeground(new Color(255, 255, 255));
		lblMovieRank.setFont(new Font("G마켓 산스 TTF Bold", Font.PLAIN, 30));
		lblMovieRank.setBounds(39, 22, 869, 41);
		pn2.add(lblMovieRank);
		lblMovieRank.setVisible(false);
		
		scrollPane = new JScrollPane(pn2);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(-11, 157, 1075, 534);
		getContentPane().add(scrollPane);
		scrollPane.setViewportView(pn2);
		SwingUtilities.invokeLater(() -> scrollPane.getViewport().setViewPosition(new Point(0, 0))); // 스크롤바 첫 위치 제일 위로 고정
		scrollPane.getVerticalScrollBar().setUnitIncrement(16); // 마우스 휠 한번에 움직일 스크롤바 픽셀 수 지정
		
		// 버튼 숨김
		btnAdmin.setVisible(false);
		
		// 관리자로 접속시 관리자모드 버튼 보이기
		if(mid.equals("admin")) btnAdmin.setVisible(true);
		
		
		// ----------------------------------- 위쪽은 UI ----------------------------------------
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		getContentPane().setLayout(null);
		setVisible(true);
		// ----------------------------------- 아래쪽은 메소드 ----------------------------------------
		
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
				new FirstMain();
			}
		});
		btnLogout.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				dispose();
				new FirstMain();
			}
		});
		
		// 관리자모드 버튼
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Admin();
			}
		});
		btnAdmin.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				dispose();
				new Admin();
			}
		});
		
		// My Wish 버튼
		btnMyPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new UserWish(mid);
			}
		});
		btnMyPage.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				dispose();
				new UserWish(mid);
			}
		});
		
		// 검색창에서 엔터로 검색
		txtMovieSearch.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					pn2.removeAll();
					String txt = txtMovieSearch.getText().trim();
					if(txt.equals("")) JOptionPane.showMessageDialog(null, "검색할 내용을 입력하세요.");
					else {
						vos = dao.txtSearch(txt);
						lblCount = vos.size();
						movieList();
								
						// 초기화 작업
						pn2.revalidate(); // 컴포넌트 재배치
						pn2.repaint(); // 다시 그리기
						txtMovieSearch.setText("");
					}
				}
			}
		});
		// 검색버튼 사용
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pn2.removeAll();
				String txt = txtMovieSearch.getText().trim();
				if(txt.equals("")) JOptionPane.showMessageDialog(null, "검색할 내용을 입력하세요.");
				else {
					vos = dao.txtSearch(txt);
					lblCount = vos.size();
					movieList();
					
					// 초기화 작업
					pn2.revalidate(); // 컴포넌트 재배치
				    pn2.repaint(); // 다시 그리기
				    txtMovieSearch.setText("");
				}
			}
		});
		btnSearch.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				pn2.removeAll();
				String txt = txtMovieSearch.getText().trim();
				if(txt.equals("")) JOptionPane.showMessageDialog(null, "검색할 내용을 입력하세요.");
				else {
					vos = dao.txtSearch(txt);
					lblCount = vos.size();
					movieList();
					
					// 초기화 작업
					pn2.revalidate(); // 컴포넌트 재배치
					pn2.repaint(); // 다시 그리기
					txtMovieSearch.setText("");
					
				}
			}
		});
		
		// 인기순위 버튼
		btnWishRank.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<VO> rank = new ArrayList<VO>();
				vos = new ArrayList<VO>();
				pn2.removeAll();
				pn2.add(lblMovieRank);
				
				rank = dao.getWishRank();
				lblCount = rank.size();
				for(int i=0; i<rank.size(); i++) {
					int rankIdx = rank.get(i).getWishIdx();
					vo = dao.movieSearch(rankIdx);
					vo.setMid(mid);
					vos.add(vo);
				}
				movieList();
				pn2.revalidate(); // 컴포넌트 재배치
			    pn2.repaint(); // 다시 그리기
			    lblMovieRank.setVisible(true);
			    SwingUtilities.invokeLater(() -> scrollPane.getViewport().setViewPosition(new Point(0, 0))); // 스크롤바 첫 위치 제일 위로 고정
			}
		});
		btnWishRank.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				ArrayList<VO> rank = new ArrayList<VO>();
				vos = new ArrayList<VO>();
				pn2.removeAll();
				pn2.add(lblMovieRank);
				
				rank = dao.getWishRank();
				lblCount = rank.size();
				for(int i=0; i<rank.size(); i++) {
					int rankIdx = rank.get(i).getWishIdx();
					vo = dao.movieSearch(rankIdx);
					vo.setMid(mid);
					vos.add(vo);
				}
				movieList();
				pn2.revalidate(); // 컴포넌트 재배치
			    pn2.repaint(); // 다시 그리기
			    lblMovieRank.setVisible(true);
			    SwingUtilities.invokeLater(() -> scrollPane.getViewport().setViewPosition(new Point(0, 0))); // 스크롤바 첫 위치 제일 위로 고정
			}
		});
		
		// 장르 검색 버튼
		btnGenreSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pn2.removeAll();
				String genre = cbGenre.getSelectedItem().toString();
				vos = dao.genreSearch(genre);
				lblCount = vos.size();
				movieList();
				pn2.revalidate(); // 컴포넌트 재배치
			    pn2.repaint(); // 다시 그리기
			    SwingUtilities.invokeLater(() -> scrollPane.getViewport().setViewPosition(new Point(0, 0))); // 스크롤바 첫 위치 제일 위로 고정
			}
		});
		
		
		// 홉 버튼
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pn2.removeAll();
				vos = dao.movieView();
				lblCount = vos.size();
				movieList();
				pn2.revalidate(); // 컴포넌트 재배치
			    pn2.repaint(); // 다시 그리기
			    SwingUtilities.invokeLater(() -> scrollPane.getViewport().setViewPosition(new Point(0, 0))); // 스크롤바 첫 위치 제일 위로 고정
			}
		});
		btnHome.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				pn2.removeAll();
				vos = dao.movieView();
				lblCount = vos.size();
				movieList();
				pn2.revalidate(); // 컴포넌트 재배치
			    pn2.repaint(); // 다시 그리기
			    SwingUtilities.invokeLater(() -> scrollPane.getViewport().setViewPosition(new Point(0, 0))); // 스크롤바 첫 위치 제일 위로 고정
			}
		});
		
		
	}
	
	// DB에서 영화정보 가져온만큼 레이아웃 추가하는 메소드
	public void movieList() {
		int x=58, xS=82, xB=91, xR=144, yI=80, yN=366, yS=400, yG=422, yB=475, cnt=0;
		int scroll = 500;
		for(int i=0; i<lblCount; i++) {
			pn2.setPreferredSize(new Dimension(1080, scroll));
			idx[i] = vos.get(i).getIdx();
			int movieIdx = idx[i];
			// 이미지
			lblMovieImg[i] = new JLabel("영화이미지"+(i+1));
			lblMovieImg[i].setBounds(x, yI, 192, 276);
			if(Main.class.getResource("/images/"+vos.get(i).getImg())== null) 
				lblMovieImg[i].setIcon(new ImageIcon(Main.class.getResource("/images/wait.jpg")));
			else lblMovieImg[i].setIcon(new ImageIcon(Main.class.getResource("/images/"+vos.get(i).getImg())));
			// 제목
			lblMovieName[i] = new JLabel(vos.get(i).getMovieName());
			lblMovieName[i].setBounds(x, yN, 194, 40);
			lblMovieName[i].setFont(new Font("G마켓 산스 TTF Bold", Font.PLAIN, 25));
			lblMovieName[i].setForeground(Color.WHITE);
			// 별
			lblMovieStar1 = new JLabel("★");
			lblMovieStar1.setBounds(x, yS+1, 24, 24);
			lblMovieStar1.setFont(new Font("G마켓 산스 TTF Medium", Font.PLAIN, 20));
			lblMovieStar1.setForeground(new Color(255, 204, 0));
			// 평점
			lblMovieScore[i] = new JLabel(String.valueOf((int)vos.get(i).getScore()));
			lblMovieScore[i].setBounds(xS, yS+1, 50, 24);
			lblMovieScore[i].setFont(new Font("G마켓 산스 TTF Medium", Font.PLAIN, 20));
			lblMovieScore[i].setForeground(new Color(255, 255, 255));
			// 러닝타임
			lblMovieRT[i] = new JLabel(vos.get(i).getRunningTime());
			lblMovieRT[i].setBounds(xR, yS+3, 107, 24);
			lblMovieRT[i].setFont(new Font("G마켓 산스 TTF Medium", Font.PLAIN, 15));
			lblMovieRT[i].setHorizontalAlignment(SwingConstants.CENTER);
			lblMovieRT[i].setForeground(new Color(128, 128, 128));
			// 장르
			lblMovieGenre[i] = new JTextPane();
			lblMovieGenre[i].setBounds(x, yG, 193, 48);
			lblMovieGenre[i].setText("장르: "+vos.get(i).getGenre());
			lblMovieGenre[i].setFont(new Font("G마켓 산스 TTF Medium", Font.PLAIN, 15));
			lblMovieGenre[i].setForeground(new Color(128, 128, 128));
			lblMovieGenre[i].setBackground(new Color(0, 0, 0));
			// 위시추가 버튼
			btnWish[i] = new JButton("♥ Wish ");
			btnWish[i].setBounds(xB, yB, 97, 23);
			btnWish[i].setFont(new Font("G마켓 산스 TTF Medium", Font.PLAIN, 12));
			btnWish[i].setBackground(new Color(255, 255, 255));
			btnWish[i].setForeground(new Color(0, 0, 0));
			// 위시해제 버튼
			btnWishOff[i] = new JButton("♡ 위시해제");
			btnWishOff[i].setBounds(xB, yB, 97, 23);
			btnWishOff[i].setFont(new Font("G마켓 산스 TTF Medium", Font.PLAIN, 12));
			btnWishOff[i].setBackground(new Color(255, 0, 0));
			btnWishOff[i].setForeground(new Color(255, 255, 255));
			btnWishOff[i].setVisible(false);
			
			pn2.add(lblMovieImg[i]);
			pn2.add(lblMovieName[i]);
			pn2.add(lblMovieStar1);
			pn2.add(lblMovieScore[i]);
			pn2.add(lblMovieRT[i]);
			pn2.add(lblMovieGenre[i]);
			pn2.add(btnWish[i]);
			pn2.add(btnWishOff[i]);
			
			final int btnIndex = i;
			
			// 유저의 위시리스트 테이블에 있나 확인한 후 결과에 따라 버튼 보여주기
			vo2 = dao.getWish(vo.getMid(), movieIdx);
			if(vo2.getWishMid() != null) {
				btnWish[btnIndex].setVisible(false);
				btnWishOff[btnIndex].setVisible(true);
			}
			else {
				btnWish[btnIndex].setVisible(true);
				btnWishOff[btnIndex].setVisible(false);
			}
			
			// 위시 버튼 클릭
			btnWish[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					res = dao.userWishMovie(vo.getMid(), movieIdx);
					if(res != 0) {
						btnWish[btnIndex].setVisible(false);
						btnWishOff[btnIndex].setVisible(true);
					}
				}
			});
			// 위시해제 버튼 클릭
			btnWishOff[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					res = dao.userWishMovieDelete(vo.getMid(), movieIdx);
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
//		new Main("admin");
//	}
}
