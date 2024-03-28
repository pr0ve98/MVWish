package mvwish;

import javax.swing.JFrame;

public class MVW_Login extends JFrame{
	
	public MVW_Login() {
		super("MVWish! Login");
		setSize(540, 720);
		
		// ----------------------------------- 위쪽은 UI ----------------------------------------
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		getContentPane().setLayout(null);
		setVisible(true);
		// ----------------------------------- 아래쪽은 메소드 ----------------------------------------
				
	}
	
	public static void main(String[] args) {
		new MVW_Login();
	}
}
