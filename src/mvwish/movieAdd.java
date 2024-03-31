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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class movieAdd extends JFrame {
	private JTextField txtName, txtRT, txtGenre, txtScore, txtImg;
	JButton btnAdd, btnExit;
	
	DAO dao = new DAO();
	VO vo = new VO();
	int res = 0;
	
	public movieAdd() {
		super("MVWish! 영화 추가");
		setSize(540, 550);
		
		JPanel pn1 = new JPanel();
		pn1.setForeground(new Color(255, 255, 255));
		pn1.setBackground(new Color(0, 0, 0));
		pn1.setBounds(0, 0, 524, 439);
		getContentPane().add(pn1);
		pn1.setLayout(null);
		
		JLabel lblMovieName = new JLabel("제목");
		lblMovieName.setFont(new Font("G마켓 산스 TTF Bold", Font.PLAIN, 16));
		lblMovieName.setHorizontalAlignment(SwingConstants.CENTER);
		lblMovieName.setForeground(new Color(255, 255, 255));
		lblMovieName.setBounds(91, 145, 94, 38);
		pn1.add(lblMovieName);
		
		JLabel lblRunningTime = new JLabel("러닝타임");
		lblRunningTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblRunningTime.setForeground(Color.WHITE);
		lblRunningTime.setFont(new Font("G마켓 산스 TTF Bold", Font.PLAIN, 16));
		lblRunningTime.setBounds(91, 193, 94, 38);
		pn1.add(lblRunningTime);
		
		JLabel lblGenre = new JLabel("장르");
		lblGenre.setHorizontalAlignment(SwingConstants.CENTER);
		lblGenre.setForeground(Color.WHITE);
		lblGenre.setFont(new Font("G마켓 산스 TTF Bold", Font.PLAIN, 16));
		lblGenre.setBounds(91, 241, 94, 38);
		pn1.add(lblGenre);
		
		JLabel lblScore = new JLabel("평점");
		lblScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblScore.setForeground(Color.WHITE);
		lblScore.setFont(new Font("G마켓 산스 TTF Bold", Font.PLAIN, 16));
		lblScore.setBounds(91, 289, 94, 38);
		pn1.add(lblScore);
		
		JLabel lblImg = new JLabel("파일이름");
		lblImg.setHorizontalAlignment(SwingConstants.CENTER);
		lblImg.setForeground(Color.WHITE);
		lblImg.setFont(new Font("G마켓 산스 TTF Bold", Font.PLAIN, 16));
		lblImg.setBounds(91, 337, 94, 38);
		pn1.add(lblImg);
		
		txtName = new JTextField();
		txtName.setFont(new Font("G마켓 산스 TTF Medium", Font.PLAIN, 15));
		txtName.setBounds(285, 145, 164, 38);
		pn1.add(txtName);
		txtName.setColumns(10);
		
		txtRT = new JTextField();
		txtRT.setFont(new Font("G마켓 산스 TTF Medium", Font.PLAIN, 15));
		txtRT.setColumns(10);
		txtRT.setBounds(285, 193, 164, 38);
		pn1.add(txtRT);
		
		txtGenre = new JTextField();
		txtGenre.setFont(new Font("G마켓 산스 TTF Medium", Font.PLAIN, 15));
		txtGenre.setColumns(10);
		txtGenre.setBounds(285, 241, 164, 38);
		pn1.add(txtGenre);
		
		txtScore = new JTextField();
		txtScore.setFont(new Font("G마켓 산스 TTF Medium", Font.PLAIN, 15));
		txtScore.setColumns(10);
		txtScore.setBounds(285, 289, 164, 38);
		pn1.add(txtScore);
		
		txtImg = new JTextField();
		txtImg.setFont(new Font("G마켓 산스 TTF Medium", Font.PLAIN, 15));
		txtImg.setColumns(10);
		txtImg.setBounds(285, 337, 164, 38);
		pn1.add(txtImg);
		
		JLabel lblLogo = new JLabel("New label");
		lblLogo.setIcon(new ImageIcon(movieAdd.class.getResource("/mvwish/img/logo2.jpg")));
		lblLogo.setBounds(194, 24, 130, 83);
		pn1.add(lblLogo);
		
		JPanel pn2 = new JPanel();
		pn2.setBackground(new Color(0, 0, 0));
		pn2.setBounds(0, 436, 524, 75);
		getContentPane().add(pn2);
		pn2.setLayout(null);
		
		btnAdd = new JButton("등록");
		btnAdd.setBackground(new Color(255, 255, 255));
		btnAdd.setFont(new Font("G마켓 산스 TTF Medium", Font.PLAIN, 15));
		btnAdd.setBounds(122, 0, 80, 40);
		pn2.add(btnAdd);
		
		btnExit = new JButton("나가기");
		btnExit.setBackground(new Color(255, 255, 255));
		btnExit.setFont(new Font("G마켓 산스 TTF Medium", Font.PLAIN, 15));
		btnExit.setBounds(322, 0, 80, 40);
		pn2.add(btnExit);
		
		// ----------------------------------- 위쪽은 UI ----------------------------------------
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		getContentPane().setLayout(null);
		setVisible(true);
		// ----------------------------------- 아래쪽은 메소드 ----------------------------------------
		
		// 영화 등록
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtScore.getText().equals("")) txtScore.setText("0.0");
				if(txtRT.getText().equals("")) txtRT.setText("미정");
				if(txtGenre.getText().equals("")) txtGenre.setText("미정");
				if(txtImg.getText().equals("")) txtImg.setText("미정.jpg");
				movieInput();
			}
		});
		btnAdd.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(txtScore.getText().equals("")) txtScore.setText("0.0");
				if(txtRT.getText().equals("")) txtRT.setText("미정");
				if(txtGenre.getText().equals("")) txtGenre.setText("미정");
				if(txtImg.getText().equals("")) txtImg.setText("미정.jpg");
				movieInput();
			}
		});
		
		// 종료
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Admin();
			}
		});
		btnExit.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				dispose();
				new Admin();
			}
		});
	}
	
	// 영화 추가 메소드
	void movieInput() {
		String name = txtName.getText();
		String rt = txtRT.getText();
		String genre = txtGenre.getText();
		Double score = Double.parseDouble(txtScore.getText());
		String img = txtImg.getText();
		
		if(name.equals("")) JOptionPane.showMessageDialog(null, "영화 제목을 입력하세요.");
		else {
			vo.setMovieName(name);
			vo.setRunningTime(rt);
			vo.setGenre(genre);
			vo.setScore(score);
			vo.setImg(img);
			res = dao.setMovieAdd(vo);
			if(res != 0) {
				JOptionPane.showMessageDialog(null, "영화 등록 완료!");
				txtName.setText("");
				txtRT.setText("");
				txtGenre.setText("");
				txtScore.setText("");
				txtImg.setText("");
				txtName.requestFocus();
			}
			else JOptionPane.showMessageDialog(null, "영화 등록 실패...");
		}
		
	}
	
//	public static void main(String[] args) {
//		new movieAdd();
//	}
}
