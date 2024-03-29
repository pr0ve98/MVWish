package mvwish;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MVW_Admin extends JFrame {
	
	public MVW_Admin() {
		super("MVWish! 관리자 전용 모드");
		setSize(1080, 720);
		
		
		JPanel pn1 = new JPanel();
		pn1.setBackground(new Color(255, 255, 255));
		pn1.setBounds(0, 0, 1064, 104);
		getContentPane().add(pn1);
		pn1.setLayout(null);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(MVW_Admin.class.getResource("/mvwish/images/logo2.jpg")));
		lblLogo.setBounds(240, 10, 135, 84);
		pn1.add(lblLogo);
		
		JLabel lblTitle = new JLabel("MVWish 관리자모드");
		lblTitle.setFont(new Font("G마켓 산스 TTF Bold", Font.PLAIN, 42));
		lblTitle.setBounds(387, 10, 414, 89);
		pn1.add(lblTitle);
		
		JButton btnNewButton_2 = new JButton("종료");
		btnNewButton_2.setFont(new Font("G마켓 산스 TTF Medium", Font.BOLD, 14));
		btnNewButton_2.setBackground(new Color(255, 0, 0));
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBounds(906, 64, 146, 30);
		pn1.add(btnNewButton_2);
		
		JPanel pn2 = new JPanel();
		pn2.setBackground(new Color(255, 255, 255));
		pn2.setBounds(0, 105, 1064, 473);
		getContentPane().add(pn2);
		pn2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 10, 1040, 453);
		pn2.add(scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		
		JPanel pn3 = new JPanel();
		pn3.setBackground(new Color(255, 255, 255));
		pn3.setBounds(0, 577, 1064, 104);
		getContentPane().add(pn3);
		pn3.setLayout(null);
		
		JButton btnNewButton = new JButton("영화 추가");
		btnNewButton.setFont(new Font("G마켓 산스 TTF Medium", Font.PLAIN, 16));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBounds(122, 24, 192, 56);
		pn3.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("영화 편집");
		btnNewButton_1.setFont(new Font("G마켓 산스 TTF Medium", Font.PLAIN, 16));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(436, 24, 192, 56);
		pn3.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("영화 삭제");
		btnNewButton_1_1.setFont(new Font("G마켓 산스 TTF Medium", Font.PLAIN, 16));
		btnNewButton_1_1.setBackground(Color.WHITE);
		btnNewButton_1_1.setBounds(750, 24, 192, 56);
		pn3.add(btnNewButton_1_1);
		
		// ----------------------------------- 위쪽은 UI ----------------------------------------
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		getContentPane().setLayout(null);
		setVisible(true);
		
		
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}
	
	public static void main(String[] args) {
		new MVW_Admin();
	}
}
