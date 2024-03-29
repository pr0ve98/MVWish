package mvwish;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class MVW_Login extends JFrame{
	private JPasswordField pwdField;
	private JTextField txtMid;
	private JLabel lblMidError, lblPwdError;
	private JButton btnLogin, btnCancle;
	
	private MVW_DAO dao = new MVW_DAO();
	private MVW_VO vo = null;
	int res = 0;
	
	public MVW_Login() {
		super("MVWish! Login");
		setSize(540, 550);
		
		
		JPanel pn1 = new JPanel();
		pn1.setForeground(new Color(255, 255, 255));
		pn1.setBackground(new Color(0, 0, 0));
		pn1.setBounds(0, 0, 524, 101);
		getContentPane().add(pn1);
		pn1.setLayout(null);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(MVW_Login.class.getResource("/mvwish/images/logo2.jpg")));
		lblLogo.setBounds(200, 10, 125, 81);
		pn1.add(lblLogo);
		
		JPanel pn2 = new JPanel();
		pn2.setForeground(new Color(255, 255, 255));
		pn2.setBackground(new Color(0, 0, 0));
		pn2.setBounds(0, 101, 524, 410);
		getContentPane().add(pn2);
		pn2.setLayout(null);
		
		JLabel lblMid = new JLabel("아이디");
		lblMid.setFont(new Font("G마켓 산스 TTF Bold", Font.PLAIN, 16));
		lblMid.setHorizontalAlignment(SwingConstants.CENTER);
		lblMid.setForeground(new Color(255, 255, 255));
		lblMid.setBounds(102, 61, 108, 44);
		pn2.add(lblMid);
		
		JLabel lblPwd = new JLabel("비밀번호");
		lblPwd.setHorizontalAlignment(SwingConstants.CENTER);
		lblPwd.setForeground(Color.WHITE);
		lblPwd.setFont(new Font("G마켓 산스 TTF Bold", Font.PLAIN, 16));
		lblPwd.setBounds(102, 169, 108, 44);
		pn2.add(lblPwd);
		
		pwdField = new JPasswordField();
		pwdField.setBounds(260, 176, 167, 32);
		pn2.add(pwdField);
		
		txtMid = new JTextField();
		txtMid.setBounds(260, 68, 167, 32);
		pn2.add(txtMid);
		txtMid.setColumns(10);
		
		btnLogin = new JButton("로그인");
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setBackground(new Color(255, 0, 0));
		btnLogin.setFont(new Font("G마켓 산스 TTF Medium", Font.PLAIN, 14));
		btnLogin.setBounds(102, 288, 108, 44);
		pn2.add(btnLogin);
		
		btnCancle = new JButton("취소");
		btnCancle.setForeground(new Color(0, 0, 0));
		btnCancle.setFont(new Font("G마켓 산스 TTF Medium", Font.PLAIN, 14));
		btnCancle.setBackground(new Color(255, 255, 255));
		btnCancle.setBounds(312, 288, 108, 44);
		pn2.add(btnCancle);
		
		lblMidError = new JLabel("※ 해당 아이디가 존재하지 않습니다.");
		lblMidError.setForeground(new Color(255, 0, 0));
		lblMidError.setFont(new Font("G마켓 산스 TTF Medium", Font.PLAIN, 13));
		lblMidError.setBounds(167, 110, 223, 32);
		pn2.add(lblMidError);
		
		lblPwdError = new JLabel("※ 비밀번호가 틀렸습니다.");
		lblPwdError.setForeground(Color.RED);
		lblPwdError.setFont(new Font("G마켓 산스 TTF Medium", Font.PLAIN, 13));
		lblPwdError.setBounds(192, 223, 167, 32);
		pn2.add(lblPwdError);
		
		lblMidError.setVisible(false);
		lblPwdError.setVisible(false);
		
		// ----------------------------------- 위쪽은 UI ----------------------------------------
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		getContentPane().setLayout(null);
		setVisible(true);
		// ----------------------------------- 아래쪽은 메소드 ----------------------------------------
				
		// 로그인 버튼
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login();
			}
		});
		btnLogin.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				login();
			}
		});
		
		// 취소 버튼
		btnCancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MVW_First();
			}
		});
		btnCancle.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				dispose();
				new MVW_First();
			}
		});
	}
	
	void login() {
		String mid = txtMid.getText();
		String pwd = String.valueOf(pwdField.getPassword());
		vo = dao.getMidSearch(mid);
		
		if(vo.getMid() == null) {
			lblMidError.setVisible(true);
			txtMid.setText("");
		}
		else if(mid.equals("")) {
			JOptionPane.showMessageDialog(null, "아이디를 입력하세요.");
			txtMid.requestFocus();
		}
		else if(pwd.equals("")) {
			JOptionPane.showMessageDialog(null, "비밀번호를 입력하세요.");
			pwdField.requestFocus();
		}
		else if(!vo.getPassword().equals(pwd)) {
			lblPwdError.setVisible(true);
		}
		else {
			dispose();
			new MVW_RealMain(vo.getMid());
		}
	}
	
//	public static void main(String[] args) {
//		new MVW_Login();
//	}
}
