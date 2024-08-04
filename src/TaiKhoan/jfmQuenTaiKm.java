package TaiKhoan;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ConnectDatabase.DBConnect;
import View.MainTheme;
import View.jfmDangNhap;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class jfmQuenTaiKm extends JFrame {

	private JPanel contentPane;
	private JTextField textField_taikhoan;
	private JTextField textField_ten;
	private JTextField textField_email;
	public static String nameLogin = "";
	private JButton btn_LayMK;
	private JButton btn_Thoat;
	PreparedStatement ps = null;
    ResultSet rs = null;
    
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jfmQuenTaiKm frame = new jfmQuenTaiKm();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public jfmQuenTaiKm() {
		initComponents();
	}
	
	/**
	 * Create the frame.
	 * @return 
	 */
	public void initComponents() {
		setTitle("Quên Mật Khẩu !");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("src\\img\\Logo_HAU.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 423, 233);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblinThngTin = new JLabel();
		lblinThngTin.setText("Điền thông tin để lấy lại mật khẩu");
		lblinThngTin.setHorizontalAlignment(SwingConstants.CENTER);
		lblinThngTin.setForeground(Color.BLUE);
		lblinThngTin.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblinThngTin.setBounds(54, 0, 310, 52);
		contentPane.add(lblinThngTin);
		
		JLabel lblTiKhon = new JLabel();
		lblTiKhon.setText("Tài Khoản");
		lblTiKhon.setHorizontalAlignment(SwingConstants.CENTER);
		lblTiKhon.setForeground(Color.BLUE);
		lblTiKhon.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTiKhon.setBounds(64, 45, 82, 25);
		contentPane.add(lblTiKhon);
		
		JLabel lblTn = new JLabel();
		lblTn.setText("Tên");
		lblTn.setHorizontalAlignment(SwingConstants.CENTER);
		lblTn.setForeground(Color.BLUE);
		lblTn.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTn.setBounds(64, 81, 82, 25);
		contentPane.add(lblTn);
		
		JLabel lblEmail = new JLabel();
		lblEmail.setText("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setForeground(Color.BLUE);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEmail.setBounds(64, 117, 82, 25);
		contentPane.add(lblEmail);
		
		textField_taikhoan = new JTextField();
		textField_taikhoan.setBounds(177, 48, 153, 20);
		contentPane.add(textField_taikhoan);
		textField_taikhoan.setColumns(10);
		
		textField_ten = new JTextField();
		textField_ten.setBounds(177, 84, 153, 20);
		contentPane.add(textField_ten);
		textField_ten.setColumns(10);
		
		textField_email = new JTextField();
		textField_email.setBounds(177, 120, 153, 20);
		contentPane.add(textField_email);
		textField_email.setColumns(10);
		
		btn_LayMK = new JButton("Hoàn Thành");
		btn_LayMK.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_LayMK.setForeground(new Color(0, 51, 255));
		btn_LayMK.setBounds(64, 160, 119, 23);
		btn_LayMK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbtForgetActionPerformed(e);
			}
		});
		contentPane.add(btn_LayMK);
		
		btn_Thoat = new JButton("Thoát");
		btn_Thoat.setForeground(new Color(0, 51, 255));
		btn_Thoat.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_Thoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jmiExitfActionPerformed(e);
			}
		});
		btn_Thoat.setBounds(219, 160, 119, 23);
		contentPane.add(btn_Thoat);
	}
	
    public void resetForm() {
        textField_taikhoan.setText("");
        textField_ten.setText("");
        textField_email.setText("");
        textField_taikhoan.requestFocus();
    }
	
	public void send() {
        String strnull = "";
        String taiKhoan = textField_taikhoan.getText();
        String ten = textField_ten.getText();
        String email =textField_email.getText();
        if (textField_taikhoan.equals(strnull) || textField_ten.equals(strnull) || textField_email.equals(strnull)) {
            JOptionPane.showMessageDialog(null, "Không để trống!");
            this.resetForm();
        } else if (DBConnect.open()) {
            try {
                boolean blean = true;
                ps = DBConnect.cnn.prepareStatement("select fldTenDangNhap,fldMatKhau,fldHoTen,fldEmail from tblDangNhap ");
                rs = ps.executeQuery();
                while (rs.next()) {
                    String taikhoanDB = "" + rs.getString("fldTenDangNhap");
                    String matkhauDB = "" + rs.getString("fldMatKhau");
                    String TenDB ="" +rs.getString("fldHoTen");
                    String EmailDB ="" +rs.getString("fldEmail");
                    if (taiKhoan.equals(taikhoanDB) && ten.equals(TenDB) && email.equals(EmailDB)) {
                    	JOptionPane.showMessageDialog(this, "Thông Tin Mật Khẩu Là:"+matkhauDB, "", JOptionPane.ERROR_MESSAGE);
                        //dispose();
                    } else {
                        JOptionPane.showMessageDialog(this, "Nhập Sai Thông Tin Vui Lòng Thử Lại", "Fail", JOptionPane.ERROR_MESSAGE);
                        this.resetForm();
                    }

                }

            } catch (SQLException ex) {
                Logger.getLogger(jfmDangNhap.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
	
	private void jmiExitfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiLogOffActionPerformed
        dispose();
    }//GEN-LAST:event_jmiLogOffActionPerformed
	
	private void jbtForgetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLoginActionPerformed
        send();
    }//GEN-LAST:event_jbLoginActionPerformed
}
