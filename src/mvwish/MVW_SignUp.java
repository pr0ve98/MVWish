package mvwish;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;

public class MVW_SignUp extends JFrame {
	private JTextField txtMid, txtName, txtAge;
	private JPasswordField pwdField, pwdOkField;
	private JButton  btnInput, btnCancel, btnSame;
	private JComboBox cbGender;
	private JLabel lblMidError, lblPwdError, lblPwdOkError,lblNameError,lblAgeError;
	
	MVW_DAO dao = new MVW_DAO();
	MVW_VO vo = null;
	int res = 0, cnt = 0;
	boolean tf = false;

	public MVW_SignUp() {
		super("회원가입");
		setSize(1080, 720);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(0, 0, 1064, 103);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MVW_SignUp.class.getResource("/mvwish/images/logo2.jpg")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(425, 10, 181, 83);
		panel.add(lblNewLabel);
		
		JPanel pn2 = new JPanel();
		pn2.setBackground(new Color(0, 0, 0));
		pn2.setBounds(0, 101, 1064, 580);
		getContentPane().add(pn2);
		pn2.setLayout(null);
		
		JLabel lblMid = new JLabel("아이디");
		lblMid.setBounds(339, 27, 129, 38);
		lblMid.setFont(new Font("G마켓 산스 TTF Bold", Font.BOLD, 16));
		lblMid.setForeground(new Color(255, 255, 255));
		lblMid.setHorizontalAlignment(SwingConstants.CENTER);
		pn2.add(lblMid);
		
		btnSame = new JButton("중복확인");
		btnSame.setBounds(701, 31, 82, 30);
		btnSame.setBackground(new Color(255, 255, 255));
		btnSame.setFont(new Font("G마켓 산스 TTF Medium", Font.PLAIN, 12));
		pn2.add(btnSame);
		
		JLabel lblPwd = new JLabel("비밀번호");
		lblPwd.setBounds(339, 98, 129, 38);
		lblPwd.setFont(new Font("G마켓 산스 TTF Bold", Font.BOLD, 16));
		lblPwd.setForeground(new Color(255, 255, 255));
		lblPwd.setHorizontalAlignment(SwingConstants.CENTER);
		pn2.add(lblPwd);
		
		JLabel lblPwdOk = new JLabel("비밀번호 확인");
		lblPwdOk.setBounds(339, 173, 129, 38);
		lblPwdOk.setFont(new Font("G마켓 산스 TTF Bold", Font.BOLD, 16));
		lblPwdOk.setForeground(new Color(255, 255, 255));
		lblPwdOk.setHorizontalAlignment(SwingConstants.CENTER);
		pn2.add(lblPwdOk);
		
		JLabel lblName = new JLabel("이름");
		lblName.setBounds(339, 249, 129, 38);
		lblName.setFont(new Font("G마켓 산스 TTF Bold", Font.BOLD, 16));
		lblName.setForeground(new Color(255, 255, 255));
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		pn2.add(lblName);
		
		JLabel lblAge = new JLabel("나이");
		lblAge.setBounds(339, 320, 129, 38);
		lblAge.setFont(new Font("G마켓 산스 TTF Bold", Font.BOLD, 16));
		lblAge.setForeground(new Color(255, 255, 255));
		lblAge.setHorizontalAlignment(SwingConstants.CENTER);
		pn2.add(lblAge);
		
		JLabel lblGender = new JLabel("성별");
		lblGender.setBounds(339, 397, 129, 38);
		lblGender.setFont(new Font("G마켓 산스 TTF Bold", Font.BOLD, 16));
		lblGender.setForeground(new Color(255, 255, 255));
		lblGender.setHorizontalAlignment(SwingConstants.CENTER);
		pn2.add(lblGender);
		
		btnInput = new JButton("가입하기");
		btnInput.setBounds(299, 479, 174, 58);
		btnInput.setBackground(new Color(255, 255, 255));
		btnInput.setFont(new Font("G마켓 산스 TTF Medium", Font.PLAIN, 16));
		pn2.add(btnInput);
		
		btnCancel = new JButton("취소");
		btnCancel.setBounds(609, 479, 174, 58);
		btnCancel.setBackground(new Color(255, 255, 255));
		btnCancel.setFont(new Font("G마켓 산스 TTF Medium", Font.PLAIN, 16));
		pn2.add(btnCancel);
		
		txtMid = new JTextField();
		txtMid.setBounds(560, 27, 129, 38);
		txtMid.setFont(new Font("G마켓 산스 TTF Medium", Font.PLAIN, 14));
		pn2.add(txtMid);
		txtMid.setColumns(10);
		
		txtName = new JTextField();
		txtName.setBounds(560, 249, 225, 38);
		txtName.setFont(new Font("G마켓 산스 TTF Medium", Font.PLAIN, 14));
		txtName.setColumns(10);
		pn2.add(txtName);
		
		txtAge = new JTextField();
		txtAge.setBounds(560, 320, 225, 38);
		txtAge.setFont(new Font("G마켓 산스 TTF Medium", Font.PLAIN, 14));
		txtAge.setColumns(10);
		pn2.add(txtAge);
		
		cbGender = new JComboBox();
		cbGender.setBounds(560, 397, 225, 38);
		cbGender.setFont(new Font("G마켓 산스 TTF Medium", Font.PLAIN, 14));
		cbGender.setBackground(new Color(255, 255, 255));
		cbGender.setModel(new DefaultComboBoxModel(new String[] {"표시 안함", "남자", "여자"}));
		pn2.add(cbGender);
		
		pwdField = new JPasswordField();
		pwdField.setBounds(560, 98, 223, 38);
		pwdField.setFont(new Font("굴림", Font.PLAIN, 14));
		pn2.add(pwdField);
		
		pwdOkField = new JPasswordField();
		pwdOkField.setBounds(560, 173, 223, 38);
		pwdOkField.setFont(new Font("굴림", Font.PLAIN, 14));
		pn2.add(pwdOkField);
		
		lblMidError = new JLabel("※ 아이디는 4~12글자 영문대소문자, 숫자, 밑줄만 사용 가능합니다.");
		lblMidError.setBounds(395, 65, 405, 30);
		lblMidError.setFont(new Font("G마켓 산스 TTF Medium", Font.PLAIN, 13));
		lblMidError.setForeground(new Color(255, 0, 0));
		pn2.add(lblMidError);
		
		lblPwdError = new JLabel("※ 비밀번호는 20자리까지만 가능하며 영문 대소문자/숫자/~`!@#$%^&*()_+-=만 입력할 수 있습니다.");
		lblPwdError.setBounds(293, 146, 609, 15);
		lblPwdError.setFont(new Font("G마켓 산스 TTF Medium", Font.PLAIN, 13));
		lblPwdError.setForeground(new Color(255, 0, 0));
		pn2.add(lblPwdError);
		
		lblPwdOkError = new JLabel("※ 비밀번호가 같지 않습니다.");
		lblPwdOkError.setBounds(505, 224, 184, 15);
		lblPwdOkError.setForeground(Color.RED);
		lblPwdOkError.setFont(new Font("G마켓 산스 TTF Medium", Font.PLAIN, 13));
		pn2.add(lblPwdOkError);
		
		lblNameError = new JLabel("※ 이름은 영문 대소문자/한글로만 입력하세요.");
		lblNameError.setBounds(458, 297, 278, 15);
		lblNameError.setForeground(Color.RED);
		lblNameError.setFont(new Font("G마켓 산스 TTF Medium", Font.PLAIN, 13));
		pn2.add(lblNameError);
		
		lblAgeError = new JLabel("※ 나이는 숫자로만 입력하세요.");
		lblAgeError.setBounds(503, 372, 188, 15);
		lblAgeError.setForeground(Color.RED);
		lblAgeError.setFont(new Font("G마켓 산스 TTF Medium", Font.PLAIN, 13));
		pn2.add(lblAgeError);
		lblMidError.setVisible(false);
		
		lblMidError.setVisible(false);
		lblPwdError.setVisible(false);
		lblPwdOkError.setVisible(false);
		lblNameError.setVisible(false);
		lblAgeError.setVisible(false);
		
		// ----------------------------------- 위쪽은 UI ----------------------------------------
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		getContentPane().setLayout(null);
		setVisible(true);
		// ----------------------------------- 아래쪽은 메소드 ----------------------------------------
		
		// 아이디 중복체크 버튼
		btnSame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf = idCheck();
				if(tf == true) {
					JOptionPane.showMessageDialog(null, "사용 가능한 아이디입니다.");
					lblMidError.setVisible(false);
				}
				cnt++;
			}
		});
		btnSame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				tf = idCheck();
				if(tf == true) {
					JOptionPane.showMessageDialog(null, "사용 가능한 아이디입니다.");
					lblMidError.setVisible(false);
				}
				cnt++;
			}
		});
		
		// 회원가입 버튼
		btnInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblMidError.setVisible(false);
				lblPwdError.setVisible(false);
				lblPwdOkError.setVisible(false);
				lblNameError.setVisible(false);
				lblAgeError.setVisible(false);
				
				if(cnt != 0) {
					tf = idCheck();
					if(tf == true) {
						MVW_Input();
					}
				}
				else JOptionPane.showMessageDialog(null, "아이디 중복확인을 해주세요.","중복확인",JOptionPane.ERROR_MESSAGE);
			}
		});
		btnInput.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				lblMidError.setVisible(false);
				lblPwdError.setVisible(false);
				lblPwdOkError.setVisible(false);
				lblNameError.setVisible(false);
				lblAgeError.setVisible(false);
				
				if(cnt != 0) {
					tf = idCheck();
					if(tf == true) {
						MVW_Input();
					}
				}
				else JOptionPane.showMessageDialog(null, "아이디 중복확인을 해주세요.","중복확인",JOptionPane.ERROR_MESSAGE);
			}
		});
		
		// 취소 버튼
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				res = JOptionPane.showConfirmDialog(null, "가입을 취소하시겠습니까?","가입 취소",JOptionPane.YES_NO_OPTION);
				if(res == 0) {
					dispose();
					new MVW_First();
				}
			}
		});
		btnCancel.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				res = JOptionPane.showConfirmDialog(null, "가입을 취소하시겠습니까?","가입 취소",JOptionPane.YES_NO_OPTION);
				if(res == 0) {
					dispose();
					new MVW_First();
				}
			}
		});
	}
	
	// 아이디 중복체크 메소드
	protected boolean idCheck() {
		String mid = txtMid.getText();
		vo = dao.getMidSearch(mid);
		
		if(!Pattern.matches("^[a-zA-Z0-9_]{4,12}$", mid)){
			lblMidError.setVisible(true);
			txtMid.setText("");
			txtMid.requestFocus();
		}
		// 중복 체크
		else if(vo.getMid() != null) {
			lblMidError.setVisible(false);
			JOptionPane.showMessageDialog(null, "이미 등록된 아이디입니다. 다른 아이디를 입력하세요.");
			txtMid.setText("");
			txtMid.requestFocus();
		}
		else tf = true;
		return tf;
	}

	// 회원가입 메소드
	protected void MVW_Input() {
		String mid = txtMid.getText();
		String pwd = String.valueOf(pwdField.getPassword());
		String pwdOk = String.valueOf(pwdOkField.getPassword());
		String name = txtName.getText();
		String age = txtAge.getText();
		String gender = cbGender.getSelectedItem().toString();
		
		// 유효성 검사
		if(!Pattern.matches("^[a-zA-Z0-9~`!@#$%^&*()_+-=]{1,20}$", pwd)){
			lblPwdError.setVisible(true);
			pwdField.setText("");
			pwdField.requestFocus();
		}
		else if(!pwd.equals(pwdOk)) {
			lblPwdOkError.setVisible(true);
			pwdOkField.setText("");
			pwdOkField.requestFocus();
		}
		else if(!Pattern.matches("^[a-zA-Z가-힇]+$", name)) {
			lblNameError.setVisible(true);
			txtName.setText("");
			txtName.requestFocus();
		}
		else if(!Pattern.matches("^[0-9]+$", age)) {
			lblAgeError.setVisible(true);
			txtAge.setText("");
			txtAge.requestFocus();
		}
		else {
			if(cnt == 0) {
				JOptionPane.showMessageDialog(null, "아이디 중복확인을 해주세요.","중복확인",JOptionPane.ERROR_MESSAGE);
			}
			else {
				vo.setMid(mid);
				vo.setPassword(pwd);
				vo.setName(name);
				vo.setAge(Integer.parseInt(age));
				vo.setGender(gender);
				res = dao.setMVWJoin(vo);
				
				if(res != 0) {
					JOptionPane.showMessageDialog(null, "MVWish에 오신 걸 환영합니다!");
					dispose();
					new MVW_First();
				}
				else {
					JOptionPane.showMessageDialog(null, "회원을 등록할 수 없어요!","회원등록 실패",JOptionPane.ERROR_MESSAGE);
					txtMid.requestFocus();
				}
			}
			
		}
	}

//	public static void main(String[] args) {
//		new MVW_SignUp();
//	}
}
