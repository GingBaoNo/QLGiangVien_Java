package View;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import ConnectDatabase.DBConnect;
import TaiKhoan.jfmQuenTaiKm;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 *
 * @author Administrator
 */
public class jfmDangNhap extends javax.swing.JFrame {

    public static String nameLogin = "";
    PreparedStatement ps = null;
    ResultSet rs = null;

    public jfmDangNhap() {
        initComponents();

    }
    private void initComponents() {
    	setIconImage(Toolkit.getDefaultToolkit().getImage("src\\img\\Logo_HAU.png"));
        jLabel2 = new javax.swing.JLabel();
        jLabel2.setBounds(70, 0, 310, 52);
        jLabel3 = new javax.swing.JLabel();
        jLabel3.setBounds(80, 63, 59, 15);
        jLabel4 = new javax.swing.JLabel();
        jLabel4.setBounds(81, 106, 58, 15);
        jtfUsername = new javax.swing.JTextField();
        jtfUsername.setBounds(184, 57, 184, 29);
        jbCancel = new javax.swing.JButton();
        jbCancel.setBounds(247, 145, 133, 31);
        jbLogin = new javax.swing.JButton();
        jbLogin.setBounds(58, 145, 125, 31);
        jpPassword = new javax.swing.JPasswordField();
        jpPassword.setBounds(184, 100, 184, 29);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Đăng nhập");
        setResizable(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Nhập Tài Khoản Được Cung Cấp");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new Color(0, 51, 255));
        jLabel3.setText("Tài khoản");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new Color(0, 51, 255));
        jLabel4.setText("Mật khẩu");

        jtfUsername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfUsernameKeyReleased(evt);
            }
        });

        jbCancel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbCancel.setForeground(new java.awt.Color(0, 0, 204));
        jbCancel.setText("Thoát");
        jbCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelActionPerformed(evt);
            }
        });
        jbCancel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jbCancelKeyReleased(evt);
            }
        });

        jbLogin.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbLogin.setForeground(new java.awt.Color(0, 0, 204));
        jbLogin.setText("Đăng nhập");
        jbLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLoginActionPerformed(evt);
            }
        });
        jbLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jbLoginKeyReleased(evt);
            }
        });

        jpPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jpPasswordKeyReleased(evt);
            }
        });
        getContentPane().setLayout(null);
        getContentPane().add(jLabel2);
        getContentPane().add(jbLogin);
        getContentPane().add(jbCancel);
        getContentPane().add(jLabel4);
        getContentPane().add(jLabel3);
        getContentPane().add(jtfUsername);
        getContentPane().add(jpPassword);
        
        btn_QuenMK = new JButton("Quên Mật Khẩu");
        btn_QuenMK.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		jbForgetKeyReleased(null);
        	}
        });
        btn_QuenMK.setForeground(new Color(0, 51, 204));
        btn_QuenMK.setFont(new Font("Tahoma", Font.BOLD, 11));
        btn_QuenMK.setBounds(155, 187, 125, 23);
        getContentPane().add(btn_QuenMK);

        setSize(new Dimension(450, 260));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void resetForm() {
        jtfUsername.setText("");
        jpPassword.setText("");
        jtfUsername.requestFocus();
    }

    public void send() {
        String strnull = "";
        String user = jtfUsername.getText();
        String pass = jpPassword.getText();
        if (user.equals(strnull) || pass.equals(strnull)) {
            JOptionPane.showMessageDialog(null, "Không để trống tên đăng nhập và mật khẩu!");
            this.resetForm();
        } else if (DBConnect.open()) {
            try {
                boolean blean = true;
                ps = DBConnect.cnn.prepareStatement("select fldTenDangNhap,fldMatKhau from tblDangNhap ");
                rs = ps.executeQuery();
                while (rs.next()) {
                    String username = "" + rs.getString("fldTenDangNhap");
                    String password = "" + rs.getString("fldMatKhau");
                    if (user.equals(username) && pass.equals(password)) {
                        nameLogin = username;
                        MainTheme frame = new MainTheme();
    					frame.setLocationRelativeTo(null);
    					frame.setVisible(true);
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(this, "Tài khoản và mật khẩu không đúng vui lòng thử lại", "Login Fails", JOptionPane.ERROR_MESSAGE);
                        this.resetForm();
                    }

                }

            } catch (SQLException ex) {
                Logger.getLogger(jfmDangNhap.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    private void jbLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLoginActionPerformed
        send();
    }//GEN-LAST:event_jbLoginActionPerformed

    private void jtfUsernameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfUsernameKeyReleased
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER) {
            jpPassword.requestFocus();

        }
    }//GEN-LAST:event_jtfUsernameKeyReleased

    private void jpPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jpPasswordKeyReleased
        if (evt.getKeyCode() == evt.VK_ENTER) {
            send();
        }
    }//GEN-LAST:event_jpPasswordKeyReleased

    private void jbCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jbCancelActionPerformed

    private void jbLoginKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbLoginKeyReleased
        if (evt.getKeyCode()==evt.VK_ENTER) {
            send();
        }
    }//GEN-LAST:event_jbLoginKeyReleased
    
    private void jbForgetKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbCancelKeyReleased
        new jfmQuenTaiKm().setVisible(true);
    }//GEN-LAST:event_jbCancelKeyReleased

    private void jbCancelKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbCancelKeyReleased
        if (evt.getKeyCode()==evt.VK_ENTER) {
            System.exit(0);
        }
    }//GEN-LAST:event_jbCancelKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jfmDangNhap().setVisible(true);
            }
        });
    }
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton jbCancel;
    private javax.swing.JButton jbLogin;
    private javax.swing.JPasswordField jpPassword;
    private javax.swing.JTextField jtfUsername;
    private JButton btn_QuenMK;
    // End of variables declaration//GEN-END:variables
}
