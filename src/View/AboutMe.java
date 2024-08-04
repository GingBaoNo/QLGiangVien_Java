package View;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class AboutMe extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AboutMe frame = new AboutMe();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public AboutMe() {
		initComponents();
	}
	
	/**
	 * Create the frame.
	 * @return 
	 */
	public void initComponents() {
		this.setLocationRelativeTo(null);
		this.setTitle("About Me");
		setIconImage(Toolkit.getDefaultToolkit().getImage("src\\img\\Logo_HAU.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nhóm 4");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(0, 51, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 29));
		lblNewLabel.setBounds(87, 11, 269, 61);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Thành Viên:");
		lblNewLabel_1.setForeground(new Color(0, 51, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(65, 78, 89, 23);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Phan Hoàng Anh - 2155010020");
		lblNewLabel_1_1.setForeground(new Color(0, 51, 255));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_1.setBounds(179, 78, 212, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Nguyễn Gia Bảo - 2155010030");
		lblNewLabel_1_1_1.setForeground(new Color(0, 51, 255));
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_1_1.setBounds(179, 103, 212, 14);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Nguyễn Trung Dức - 2155010080");
		lblNewLabel_1_1_2.setForeground(new Color(0, 51, 255));
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_1_2.setBounds(179, 153, 212, 14);
		contentPane.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Bùi Công Hiếu - 2155010095");
		lblNewLabel_1_1_3.setForeground(new Color(0, 51, 255));
		lblNewLabel_1_1_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_1_3.setBounds(179, 178, 212, 14);
		contentPane.add(lblNewLabel_1_1_3);
		
		JLabel lblNewLabel_1_1_4 = new JLabel("Trần Ngọc Chương -2155010045");
		lblNewLabel_1_1_4.setForeground(new Color(0, 51, 255));
		lblNewLabel_1_1_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_1_4.setBounds(179, 128, 212, 14);
		contentPane.add(lblNewLabel_1_1_4);
		
		JButton btn_close = new JButton("Đóng");
		btn_close.setForeground(new Color(0, 51, 255));
		btn_close.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_close.setBounds(172, 227, 89, 23);
		btn_close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
		contentPane.add(btn_close);
	}
	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
	       dispose();
	    }//GEN-LAST:event_jButton1ActionPerformed
}
