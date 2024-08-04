package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import Khoa.jpnKhoa;
import MonHoc.jpnMonHoc;
import Search.Search;
import GiangVien.jpnGiangVien;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.Font;
import java.awt.font.ImageGraphicAttribute;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JDesktopPane;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import javax.swing.JEditorPane;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.border.LineBorder;



public class MainTheme extends JFrame {

	private JPanel contentPane;
	private JTextField txtMenu;
	private JPanel panel_1;                                                                                                                                                         
	private JTabbedPane tabbedPane;
	private JButton btnKhoa;
	private JButton btnMonHoc;
	private JButton btnGiangVien;
	private JPanel panel;
	public static String nameLogin;
	private JTextField jtfCurrent;
	private JLabel jlbUser;
	
	private Date today = new Date();
    Locale local = new Locale("vi", "VI");
	DateFormat d = DateFormat.getDateInstance(DateFormat.MEDIUM, local);
    String date = d.format(today);
	private JLabel jlbToday;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainTheme frame = new MainTheme();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

    private void setUser() {
        nameLogin = jfmDangNhap.nameLogin;
        jlbUser.setText(nameLogin);

        jlbToday.setText(date);
    }
	
	public MainTheme() {
		initComponents();	
		setUser();
		
        Timer dongho = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Calendar lich = Calendar.getInstance();
                int gio = lich.get(Calendar.HOUR);
                int phut = lich.get(Calendar.MINUTE);
                int giay = lich.get(Calendar.SECOND);
                jtfCurrent.setText(" " + gio + " : " + phut + " : " + giay);
            }
        });
        dongho.start();
		
	}

	/**
	 * Create the frame.
	 */
	public void initComponents() {
		this.setTitle("Quản Lý Giảng Viên");
		setResizable(false);
		this.setLocationRelativeTo(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage("src\\img\\Logo_HAU.png"));
		setBackground(new Color(0, 204, 204));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 854, 452);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mn_TaiKhoan = new JMenu("Tài Khoản");
		menuBar.add(mn_TaiKhoan);
		
		JMenuItem mntm_DangXuat = new JMenuItem("Đăng Xuất");
		mn_TaiKhoan.add(mntm_DangXuat);
		mntm_DangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiLogOffActionPerformed(evt);
            }
        });
		
		JSeparator separator = new JSeparator();
		mn_TaiKhoan.add(separator);
		
		JMenuItem mntm_Thoat = new JMenuItem("Thoát");
		mn_TaiKhoan.add(mntm_Thoat);
		mntm_Thoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiExitActionPerformed(evt);
            }
        });
		
		JMenu mn_CongCu = new JMenu("Công Cụ");
		menuBar.add(mn_CongCu);
		
		JMenuItem mntm_GiangVien = new JMenuItem("Giảng Viên");
		mn_CongCu.add(mntm_GiangVien);
		mntm_GiangVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	jbInputTeacherActionPerformed(evt);
            }
        });
		
		JSeparator separator_1 = new JSeparator();
		mn_CongCu.add(separator_1);
		
		JMenuItem mntm_MonHoc = new JMenuItem("Môn Học");
		mn_CongCu.add(mntm_MonHoc);
		mntm_MonHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	jBnMonHocActionPerformed(evt);
            }
        });
		
		JSeparator separator_2 = new JSeparator();
		mn_CongCu.add(separator_2);
		
		JMenuItem mntm_Khoa = new JMenuItem("Khoa");
		mn_CongCu.add(mntm_Khoa);
		mntm_Khoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	jBnKhoaActionPerformed(evt);
            }
        });
		
		JMenu mn_TimKiem = new JMenu("Tìm Kiếm");
		menuBar.add(mn_TimKiem);
		
		mn_TimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jmTimKiemMouseClicked(evt);
            }
        });
		
		JMenu mn_AboutMe = new JMenu("About Me");
		menuBar.add(mn_AboutMe);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		mn_AboutMe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jmAboutMeMouseClicked(evt);
            }
        });
		
		mn_AboutMe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmAboutMeActionPerformed(evt);
            }
        });

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(153, 204, 255));
		panel.setBounds(10, 183, 150, 170);
		contentPane.add(panel);
		panel.setLayout(null);
		
		btnGiangVien = new JButton("Giảng Viên");
		btnGiangVien.setForeground(new Color(0, 0, 153));
		btnGiangVien.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnGiangVien.setBounds(0, 0, 150, 27);
		panel.add(btnGiangVien);
		btnGiangVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	jbInputTeacherActionPerformed(evt);
            }
        });

		
		btnMonHoc = new JButton("Môn Học");
		btnMonHoc.setForeground(new Color(0, 0, 102));
		btnMonHoc.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnMonHoc.setBounds(0, 38, 150, 27);
		panel.add(btnMonHoc);
		btnMonHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	jBnMonHocActionPerformed(evt);
            }
        });
		
		btnKhoa = new JButton("Khoa");
		btnKhoa.setForeground(new Color(0, 0, 102));
		btnKhoa.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnKhoa.setBounds(0, 76, 150, 27);
		panel.add(btnKhoa);
		btnKhoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	jBnKhoaActionPerformed(evt);
            }
        });
		
		JButton btn_TimKiem = new JButton("Tìm Kiếm");
		btn_TimKiem.setForeground(new Color(0, 0, 102));
		btn_TimKiem.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_TimKiem.setBounds(0, 114, 150, 27);
		panel.add(btn_TimKiem);
		btn_TimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	jBnTimKiemActionPerformed(evt);
            }
        });
		
		
		txtMenu = new JTextField();
		txtMenu.setBackground(new Color(0, 0, 0));
		txtMenu.setForeground(new Color(0, 204, 255));
		txtMenu.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtMenu.setHorizontalAlignment(SwingConstants.CENTER);
		txtMenu.setText("Menu");
		txtMenu.setBounds(10, 113, 150, 59);
		contentPane.add(txtMenu);
		txtMenu.setColumns(10);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setForeground(new Color(0, 51, 255));
		tabbedPane.setFont(new Font("Tahoma", Font.BOLD, 11));
		tabbedPane.setBounds(174, 11, 654, 370);
		contentPane.add(tabbedPane);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		tabbedPane.addTab("Main", null, panel_1, null);
		panel_1.setLayout(null);
		
		
        JLabel lblImage = new JLabel();
        lblImage.setBounds(118, 11, 429, 321); 
        panel_1.add(lblImage);

        ImageIcon icon = new ImageIcon("src\\img\\Logo_HAU.png"); 
        Image image = icon.getImage().getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(image);
        lblImage.setIcon(scaledIcon);
        
        JPanel panel_2 = new JPanel();
        panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel_2.setBounds(10, 11, 150, 86);
        contentPane.add(panel_2);
        panel_2.setLayout(null);
        
        JLabel lbl_tenTK = new JLabel("User :");
        lbl_tenTK.setFont(new Font("Tahoma", Font.BOLD, 11));
        lbl_tenTK.setForeground(new Color(0, 51, 255));
        lbl_tenTK.setBounds(10, 21, 42, 14);
        panel_2.add(lbl_tenTK);
        
        jlbUser = new JLabel();
        jlbUser.setForeground(new Color(102, 0, 0));
        jlbUser.setFont(new Font("Tahoma", Font.BOLD, 11));
        jlbUser.setBounds(62, 21, 78, 14);
        panel_2.add(jlbUser);
        
        jlbToday = new JLabel();
        jlbToday.setForeground(new Color(0, 51, 255));
        jlbToday.setFont(new Font("Tahoma", Font.BOLD, 11));
        jlbToday.setBounds(62, 46, 78, 29);
        panel_2.add(jlbToday);
        
        JLabel lblNewLabel = new JLabel("Time :");
        lblNewLabel.setForeground(new Color(0, 51, 255));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNewLabel.setBounds(10, 53, 46, 14);
        panel_2.add(lblNewLabel);
        
        jtfCurrent = new JTextField();
        jtfCurrent.setHorizontalAlignment(SwingConstants.CENTER);
        jtfCurrent.setForeground(new Color(0, 51, 255));
        jtfCurrent.setFont(new Font("Tahoma", Font.BOLD, 11));
        jtfCurrent.setBounds(20, 360, 130, 20);
        contentPane.add(jtfCurrent);
        jtfCurrent.setColumns(10);
		
		
	}
	private void jbInputTeacherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbInputTeacherActionPerformed
		jpnGiangVien jpngiangvien =new jpnGiangVien();
		tabbedPane.removeAll();
		tabbedPane.add("Giảng Viên",jpngiangvien);	

    }//GEN-LAST:event_jbInputTeacherActionPerformed
	
	private void jBnKhoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
		jpnKhoa jpnkhoa =new jpnKhoa();
		tabbedPane.removeAll();
		tabbedPane.add("Khoa",jpnkhoa);
    }//GEN-LAST:event_jButton6ActionPerformed
	
	private void jBnMonHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
		jpnMonHoc jpnMonHoc=new jpnMonHoc();
		tabbedPane.removeAll();
		tabbedPane.add("Môn Học",jpnMonHoc);
    }//GEN-LAST:event_jButton5ActionPerformed
	
	private void jBnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
		Search search= new Search();
		tabbedPane.removeAll();
		tabbedPane.add("Tìm Kiếm",search);
    }//GEN-LAST:event_jButton5ActionPerformed
	
	private void jmTimKiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmTimKiemMouseClicked
		Search search= new Search();
		tabbedPane.removeAll();
		tabbedPane.add("Tìm Kiếm",search);
    }//GEN-LAST:event_jmTimKiemMouseClicked
	
	private void jmiLogOffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiLogOffActionPerformed
        dispose();
        jfmDangNhap login = new jfmDangNhap();
        login.setVisible(true);
    }//GEN-LAST:event_jmiLogOffActionPerformed
	
	private void jmiExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jmiExitActionPerformed
	
	private void jmAboutMeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmHoTroActionPerformed
    }//GEN-LAST:event_jmHoTroActionPerformed

    private void jmAboutMeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmHoTroMouseClicked
        AboutMe aboutMe = new AboutMe();
        aboutMe.setLocationRelativeTo(null);
        aboutMe.setVisible(true);

    }//GEN-LAST:event_jmHoTroMouseClicked
}
