package mvwish;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings({"serial","rawtypes","unused","unchecked"})
public class Admin extends JFrame {
	private JTable table;
	private JButton btnExit, btnMovieAdd, btnMovieEdit, btnMovieDelete;
	private Vector title, vData;
	private DefaultTableModel dtm;
	private JScrollPane scrollPane;
	
	private VO vo = null;
	private DAO dao = new DAO();
	int res = 0;
	private JButton btnNewButton;
	
	public Admin() {
		super("MVWish! 관리자 전용 모드");
		setSize(1080, 720);
		
		JPanel pn1 = new JPanel();
		pn1.setBackground(new Color(255, 255, 255));
		pn1.setBounds(0, 0, 1064, 104);
		getContentPane().add(pn1);
		pn1.setLayout(null);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(Admin.class.getResource("/mvwish/img/logo2.jpg")));
		lblLogo.setBounds(240, 10, 135, 84);
		pn1.add(lblLogo);
		
		JLabel lblTitle = new JLabel("MVWish 관리자모드");
		lblTitle.setFont(new Font("G마켓 산스 TTF Bold", Font.PLAIN, 42));
		lblTitle.setBounds(387, 10, 414, 89);
		pn1.add(lblTitle);
		
		btnExit = new JButton("나가기");
		btnExit.setFont(new Font("G마켓 산스 TTF Medium", Font.BOLD, 14));
		btnExit.setBackground(new Color(255, 0, 0));
		btnExit.setForeground(new Color(255, 255, 255));
		btnExit.setBounds(906, 64, 146, 30);
		pn1.add(btnExit);
		
		btnNewButton = new JButton("새로고침");
		btnNewButton.setFont(new Font("G마켓 산스 TTF Light", Font.PLAIN, 12));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBounds(12, 71, 97, 23);
		pn1.add(btnNewButton);
		
		JPanel pn2 = new JPanel();
		pn2.setBackground(new Color(255, 255, 255));
		pn2.setBounds(0, 105, 1064, 473);
		getContentPane().add(pn2);
		pn2.setLayout(null);
		
		JPanel pn3 = new JPanel();
		pn3.setBackground(new Color(255, 255, 255));
		pn3.setBounds(0, 577, 1064, 104);
		getContentPane().add(pn3);
		pn3.setLayout(null);
		
		btnMovieAdd = new JButton("영화 추가");
		btnMovieAdd.setFont(new Font("G마켓 산스 TTF Medium", Font.PLAIN, 16));
		btnMovieAdd.setBackground(new Color(255, 255, 255));
		btnMovieAdd.setBounds(122, 24, 192, 56);
		pn3.add(btnMovieAdd);
		
		btnMovieEdit = new JButton("영화 편집");
		btnMovieEdit.setFont(new Font("G마켓 산스 TTF Medium", Font.PLAIN, 16));
		btnMovieEdit.setBackground(Color.WHITE);
		btnMovieEdit.setBounds(436, 24, 192, 56);
		pn3.add(btnMovieEdit);
		
		btnMovieDelete = new JButton("영화 삭제");
		btnMovieDelete.setFont(new Font("G마켓 산스 TTF Medium", Font.PLAIN, 16));
		btnMovieDelete.setBackground(Color.WHITE);
		btnMovieDelete.setBounds(750, 24, 192, 56);
		pn3.add(btnMovieDelete);
		
		//JTable
		title = new Vector<>();
		title.add("idx");
		title.add("제목");
		title.add("러닝타임");
		title.add("장르");
		title.add("평점");
		title.add("이미지파일");
		
		vData = dao.getMovieList();
		dtm = new DefaultTableModel(vData, title);
		
		table = new JTable(dtm);
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(12, 10, 1040, 453);
		pn2.add(scrollPane);
		
		table.getColumnModel().getColumn(0).setMaxWidth(35);
		table.getColumnModel().getColumn(1).setMaxWidth(250);
		table.getColumnModel().getColumn(2).setMaxWidth(70);
		table.getColumnModel().getColumn(3).setMaxWidth(400);
		table.getColumnModel().getColumn(4).setMaxWidth(70);
		table.getColumnModel().getColumn(5).setMaxWidth(100);
		table.getTableHeader().setReorderingAllowed(false);
		
		// ----------------------------------- 위쪽은 UI ----------------------------------------
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		getContentPane().setLayout(null);
		setVisible(true);
		// ----------------------------------- 아래쪽은 메소드 ----------------------------------------
		
		// 영화 추가
		btnMovieAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new movieAdd();
			}
		});
		btnMovieAdd.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				dispose();
				new movieAdd();
			}
		});
		
		btnMovieEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idxStr = JOptionPane.showInputDialog("편집할 영화 idx 번호를 입력하세요.");
				if(idxStr == null) idxStr = "0";
				int idx = Integer.parseInt(idxStr);
				if(idx != 0) {
					dispose();
					new movieEdit(idx);
				}
				else JOptionPane.showMessageDialog(null, "편집을 취소합니다.");
			}
		});
		
		// 영화 삭제
		btnMovieDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idxStr = JOptionPane.showInputDialog("삭제할 영화 idx 번호를 입력하세요.");
				if(idxStr == null) idxStr = "0";
				int idx = Integer.parseInt(idxStr);
				vo = dao.movieSearch(idx);
				if(vo.getMovieName() != null) {
					int ans = JOptionPane.showConfirmDialog(null, vo.getMovieName()+" 영화를 삭제하시겠습니까?","영화 삭제",JOptionPane.YES_NO_OPTION);
					if(ans == 0) {
						res = dao.movieDelete(vo);
						if(res != 0) JOptionPane.showMessageDialog(null, "삭제 완료!");
						else JOptionPane.showMessageDialog(null, "삭제 실패...");
					}
				}
				else JOptionPane.showMessageDialog(null, "삭제를 취소합니다.");
			}
		});
		
		// 새로고침
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Admin();
			}
		});
		
		
		// 종료
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Main("admin");
			}
		});
		btnExit.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				dispose();
				new Main("admin");
			}
		});
	}
	
//	public static void main(String[] args) {
//		new Admin();
//	}
}
