package GiangVien;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import Check.Check;
import Khoa.IKhoaDAO;
import Khoa.Khoa;
import Khoa.KhoaDAO;
import MonHoc.IMonHocDAO;
import MonHoc.MonHoc;

import java.awt.Color;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;

public class jpnGiangVien extends JPanel {
	private JTable table;
	private JTextField textMaGV;
	private JTextField textTenGV;
	private JTextField textEmail;
	private JTextField textField_ngaySinh;
	private JTextField textField_DiaChi;
	private JTextField textField_SDT;
	private JComboBox comboBox_MonHoc;
	private JComboBox comboBox_Khoa;
	private JButton btn_Delete;
	private JButton btn_Update;
	private JButton btn_Add;
	private JScrollPane scrollPane;
	private JButton btn_Clear;
	
	private DefaultTableModel dtm;
    private DefaultComboBoxModel dcbm_mh;
    private DefaultComboBoxModel dcbm_kh;
    ArrayList<MonHoc> listmh = null;
    ArrayList<Khoa> listkh =null;
    ArrayList<GiangVien> listgv = null;
	private JRadioButton rdbtn_gioiTinh;
    public static String regexDDMMYYYY = "^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d$";
    
    public static void main(String[] args) {
        // Create an instance of frmGiaoVien
        jpnGiangVien giaoVienForm = new jpnGiangVien();

        // Create a JFrame to hold the frmGiaoVien panel
        javax.swing.JFrame frame = new javax.swing.JFrame();
        frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Giang Vien");
        frame.setSize(800, 600);

        // Add the frmGiaoVien panel to the JFrame
        frame.getContentPane().add(giaoVienForm);

        // Set the JFrame visible
        frame.setVisible(true);
      }
	
	public jpnGiangVien() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		try {
            initComponents();
            dcbm_mh = new DefaultComboBoxModel();
            dcbm_kh = new DefaultComboBoxModel();
            dtm = new DefaultTableModel();
            IMonHocDAO monHocDAO = (IMonHocDAO) Class.forName("MonHoc.MonHocDAO").newInstance();
            IKhoaDAO khoaDAO = (IKhoaDAO) Class.forName("Khoa.KhoaDAO").newInstance();
            listmh = monHocDAO.getAll();
            listkh = khoaDAO.getAll();
            for (MonHoc mh : listmh) {
                dcbm_mh.addElement(mh.getMamh());
            }
            comboBox_MonHoc.setModel(dcbm_mh);
            for (Khoa kh : listkh) {
                dcbm_kh.addElement(kh.getMakhoa());
            }
            comboBox_Khoa.setModel(dcbm_kh);

            dtm.addColumn("ID");
            dtm.addColumn("Họ Tên");
            dtm.addColumn("Ngày Sinh");
            dtm.addColumn("Giới Tính");
            dtm.addColumn("Môn Dạy");
            dtm.addColumn("Khoa");
            dtm.addColumn("Email");
            dtm.addColumn("Địa Chỉ");
            dtm.addColumn("Số ĐT");
            data();
            // loaddata();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(jpnGiangVien.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(jpnGiangVien.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(jpnGiangVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void data() {
        try {
            IGiangVienDAO giaoVienDAO = (IGiangVienDAO) Class.forName("GiangVien.GiangVienDAO").newInstance();
            listgv = new GiangVienDAO().getAll();
            for (GiangVien gv : listgv) {
                dtm.addRow(toObjectsData(gv));
            }
            table.setModel(dtm);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(jpnGiangVien.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(jpnGiangVien.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(jpnGiangVien.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    private static Object[] toObjectsData(GiangVien gv) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String date = dateFormat.format(gv.getNgaysinh());
        boolean flag = gv.isGioitinh();
        String gioitinh = "Nam";
        if (!flag) {
            gioitinh = "Nữ";
        }

        Object[] objectsData = {gv.getMagv(), gv.getHotengv(), date, gioitinh,gv.getMamh(),gv.getMakh(), gv.getEmail(), gv.getDiachi(), gv.getSdt()};
        return objectsData;
    }
   
	/**
	 * Create the panel.
	 */
	private void initComponents() {
		setBackground(new Color(204, 255, 255));
		setLayout(null);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"ID", "H\u1ECD T\u00EAn", "Ng\u00E0y Sinh", "Gi\u1EDBi T\u00EDnh", "M\u00F4n D\u1EA1y", "Khoa", "Email", "\u0110\u1ECBa Ch\u1EC9", "SDT"
			}
		){
            boolean[] canEdit = new boolean [] {
                    false, false, false, false, false, false, false, false,false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }
            });
		table.setBorder(null);
		table.setBounds(10, 11, 631, 158);
		table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbTTGVMouseClicked(evt);
            }
        });
		
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 11, 631, 139);
		add(scrollPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(new Color(153, 255, 255));
		panel.setBounds(10, 154, 631, 178);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mã Giảng Viên");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setForeground(new Color(0, 51, 255));
		lblNewLabel.setBounds(33, 11, 90, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Họ Tên");
		lblNewLabel_1.setForeground(new Color(0, 51, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(33, 49, 90, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Email");
		lblNewLabel_2.setForeground(new Color(0, 51, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(33, 86, 46, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Môn Dạy");
		lblNewLabel_3.setForeground(new Color(0, 51, 255));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(33, 117, 90, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Ngày Sinh");
		lblNewLabel_4.setForeground(new Color(0, 51, 255));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setBounds(327, 11, 69, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Giới Tính");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_5.setForeground(new Color(0, 51, 255));
		lblNewLabel_5.setBounds(327, 49, 69, 14);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Địa Chỉ");
		lblNewLabel_6.setForeground(new Color(0, 51, 255));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_6.setBounds(327, 86, 46, 14);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("SDT");
		lblNewLabel_7.setForeground(new Color(0, 51, 255));
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_7.setBounds(327, 116, 46, 17);
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Khoa");
		lblNewLabel_8.setForeground(new Color(0, 51, 255));
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_8.setBounds(33, 153, 46, 14);
		panel.add(lblNewLabel_8);
		
		textMaGV = new JTextField();
		textMaGV.setBounds(119, 8, 171, 20);
		panel.add(textMaGV);
		textMaGV.setColumns(10);
		
		textTenGV = new JTextField();
		textTenGV.setBounds(119, 46, 171, 20);
		panel.add(textTenGV);
		textTenGV.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.setBounds(118, 83, 172, 20);
		panel.add(textEmail);
		textEmail.setColumns(10);
		
		textField_ngaySinh = new JTextField();
		textField_ngaySinh.setBounds(406, 8, 192, 20);
		panel.add(textField_ngaySinh);
		textField_ngaySinh.setColumns(10);
		
		rdbtn_gioiTinh = new JRadioButton("Nam/Nữ");
		rdbtn_gioiTinh.setBounds(409, 45, 90, 23);
		panel.add(rdbtn_gioiTinh);
		
		textField_DiaChi = new JTextField();
		textField_DiaChi.setBounds(406, 83, 192, 20);
		panel.add(textField_DiaChi);
		textField_DiaChi.setColumns(10);
		
		textField_SDT = new JTextField();
		textField_SDT.setBounds(406, 114, 192, 20);
		panel.add(textField_SDT);
		textField_SDT.setColumns(10);
		
		comboBox_MonHoc = new JComboBox();
		comboBox_MonHoc.setBounds(117, 113, 173, 21);
		panel.add(comboBox_MonHoc);
		comboBox_MonHoc.setModel(new javax.swing.DefaultComboBoxModel(new String[] {" ", "Item 1", "Item 2", "Item 3", "Item 4" }));
		
		comboBox_Khoa = new JComboBox();
		comboBox_Khoa.setBounds(117, 149, 173, 21);
		panel.add(comboBox_Khoa);
		comboBox_Khoa.setModel(new javax.swing.DefaultComboBoxModel(new String[] {" ", "Item 1", "Item 2", "Item 3", "Item 4" }));
		
		btn_Delete = new JButton("Xóa");
		btn_Delete.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_Delete.setBounds(509, 149, 89, 23);
		panel.add(btn_Delete);
		btn_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDeleteActionPerformed(evt);
            }
        });
		
		btn_Update = new JButton("Sửa");
		btn_Update.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_Update.setBounds(410, 149, 89, 23);
		panel.add(btn_Update);
		btn_Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbUpdateActionPerformed(evt);
            }
        });
		
		btn_Add = new JButton("Thêm");
		btn_Add.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_Add.setBounds(311, 149, 89, 23);
		panel.add(btn_Add);
		btn_Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAddActionPerformed(evt);
            }
        });
		
		btn_Clear = new JButton("Làm Mới");
		btn_Clear.setForeground(new Color(0, 0, 0));
		btn_Clear.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_Clear.setBounds(509, 45, 89, 23);
		panel.add(btn_Clear);
		btn_Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExitActionPerformed(evt);
            }
        });

	}
	public boolean checkinfo() {
        Check c = new Check();
        if (!c.checkID(textMaGV.getText())) {
            JOptionPane.showMessageDialog(this, "Nhập mã sai", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            textMaGV.setText("");
            textMaGV.requestFocus();
            return false;
        } else if (!c.checkSpace(textTenGV.getText()) || !c.check(textTenGV.getText())) {
            JOptionPane.showMessageDialog(this, "Nhập tên sai", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            textTenGV.setText("");
            return false;

        } else if (!c.checkSpace(textEmail.getText()) || !c.check(textEmail.getText())) {
            JOptionPane.showMessageDialog(this, "Email nhập sai", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            textEmail.setText("");
            textEmail.requestFocus();
            return false;


        } else if (!c.checkSpace(textField_DiaChi.getText())) {
            JOptionPane.showMessageDialog(this, "Nhập địa chỉ sai", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            textField_DiaChi.setText("");
            textField_DiaChi.requestFocus();
            return false;

        } else if (!c.checkSpace(textField_SDT.getText()) || !c.checkPhone(textField_SDT.getText())) {
            JOptionPane.showMessageDialog(this, "Nhập phone sai", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            textField_SDT.setText("");
            textField_SDT.requestFocus();
            return false;
        }
        return true;
    }
    private void jbAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAddActionPerformed
        String magv = textMaGV.getText();
        String hoten = textTenGV.getText();
        String email = textEmail.getText();
        String sdt = textField_SDT.getText();
        String ngaysinh = textField_ngaySinh.getText();
        boolean gioitinh = rdbtn_gioiTinh.isSelected();
        String diachi = textField_DiaChi.getText();
        String mamh = listmh.get(comboBox_MonHoc.getSelectedIndex()).getMamh();
        String makh = listkh.get(comboBox_Khoa.getSelectedIndex()).getMakhoa();
        
        Check c = new Check();
        if (!checkinfo()) {
            return;
        }


        Date d = null;
        if (ngaysinh == null || ngaysinh.equals("") || !ngaysinh.matches(regexDDMMYYYY)) {
            JOptionPane.showMessageDialog(this, "Nhập ngày sinh sai", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            textField_ngaySinh.setText("");
            textField_ngaySinh.requestFocus();
            return;
        } else {
            try {
                d = new SimpleDateFormat("dd/MM/yyyy").parse(ngaysinh);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(this, "Nhập ngày sinh sai", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        GiangVien giangVien = new GiangVien(magv, hoten, d, gioitinh, email, diachi, sdt, mamh, makh);
        ArrayList<GiangVien> listCheck = new GiangVienDAO().CheckID(magv);
        if (listCheck.size() > 0) {
            JOptionPane.showMessageDialog(this, "Mã ID bị trùng", "vui lòng kiểm tra lại", JOptionPane.ERROR_MESSAGE);
            textMaGV.setText("");
            textMaGV.requestFocus();

        } else {
            GiangVien insert = new GiangVienDAO().addNew(giangVien);
            if (insert != null) {
                showAll();
            }
        }

    }//GEN-LAST:event_jbAddActionPerformed

    private void jbUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbUpdateActionPerformed
    	String magv = textMaGV.getText();
        String hoten = textTenGV.getText();
        String email = textEmail.getText();
        String sdt = textField_SDT.getText();
        String ngaysinh = textField_ngaySinh.getText();
        boolean gioitinh = rdbtn_gioiTinh.isSelected();
        String diachi = textField_DiaChi.getText();
        String mamh = listmh.get(comboBox_MonHoc.getSelectedIndex()).getMamh();
        String makh = listkh.get(comboBox_Khoa.getSelectedIndex()).getMakhoa();

        Date d = null;
        if (ngaysinh == null || ngaysinh.equals("") || !ngaysinh.matches(regexDDMMYYYY)) {
            JOptionPane.showMessageDialog(this, "Nhập ngày sinh sai", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            textField_ngaySinh.setText("");
            textField_ngaySinh.requestFocus();
            return;
        } else {
            try {
                d = new SimpleDateFormat("dd/MM/yyyy").parse(ngaysinh);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(this, "Nhập ngày sinh sai", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        GiangVien giangVien = new GiangVien(magv, hoten, d, gioitinh, email, diachi, sdt, mamh, makh);
        GiangVien update = new GiangVienDAO().updateByID(giangVien);
        if (update != null) {
            showAll();
        }
        btn_Add.setEnabled(true);
        btn_Update.setEnabled(false);
        btn_Delete.setEnabled(false);
        textMaGV.setEnabled(true);
    }//GEN-LAST:event_jbUpdateActionPerformed

    private void jtbTTGVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbTTGVMouseClicked
        textMaGV.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
        textTenGV.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
        textField_ngaySinh.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
        String sex = table.getValueAt(table.getSelectedRow(), 3).toString();
        if (sex.equals("true")) {
            rdbtn_gioiTinh.setSelected(true);
        } else {
            rdbtn_gioiTinh.setSelected(false);
        }
        comboBox_MonHoc.setSelectedItem(table.getValueAt(table.getSelectedRow(), 4).toString());
        comboBox_Khoa.setSelectedItem(table.getValueAt(table.getSelectedRow(), 5).toString());
        textEmail.setText(table.getValueAt(table.getSelectedRow(), 6).toString());
        textField_DiaChi.setText(table.getValueAt(table.getSelectedRow(), 7).toString());
        textField_SDT.setText(table.getValueAt(table.getSelectedRow(), 8).toString());


        btn_Add.setEnabled(false);
        btn_Update.setEnabled(true);
        btn_Delete.setEnabled(true);
        textMaGV.setEnabled(false);
    }//GEN-LAST:event_jtbTTGVMouseClicked
    public void resetForm() {
        textMaGV.setText("");
        textTenGV.setText("");
        textEmail.setText("");
        textField_DiaChi.setText("");
        textField_SDT.setText("");
        textField_ngaySinh.setText("");
        textMaGV.requestFocus();
    }
    private void jbDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDeleteActionPerformed
        int b = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn xóa dữ liệu này?", "Thông Báo", JOptionPane.YES_NO_OPTION);
        if (b == JOptionPane.YES_OPTION) {

            String magv = textMaGV.getText();
            try {
                new GiangVienDAO().deleteIDGV(magv);
            } catch (SQLException ex) {
                Logger.getLogger(jpnGiangVien.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(jpnGiangVien.class.getName()).log(Level.SEVERE, null, ex);
            }

            while (dtm.getRowCount() > 0) {
                dtm.removeRow(0);
            }
            resetForm();
            data();
            btn_Add.setEnabled(true);
            btn_Update.setEnabled(false);
            btn_Delete.setEnabled(false);
            textMaGV.setEnabled(true);
        }
    }//GEN-LAST:event_jbDeleteActionPerformed

    private void jbExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExitActionPerformed
        this.resetForm();
    }//GEN-LAST:event_jbExitActionPerformed

    private void showAll() {
        while (dtm.getRowCount() > 0) {
            dtm.removeRow(0);
        }
        int selectedIndex_mh = comboBox_MonHoc.getSelectedIndex();
        MonHoc getmh = listmh.get(selectedIndex_mh);
        ArrayList<GiangVien> list = new GiangVienDAO().findByIDMonHoc(getmh.getMamh());
        int selectedIndex_kh = comboBox_Khoa.getSelectedIndex();
        Khoa getmk = listkh.get(selectedIndex_kh);
        for (GiangVien gv : list) {
            Vector vector = new Vector();
            vector.add(gv.getMagv());
            vector.add(gv.getHotengv());
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            vector.add(dateFormat.format(gv.getNgaysinh()));
            if (gv.isGioitinh() == true) {
                vector.add("Nam");
            } else {
                vector.add("Nữ");
            }
            vector.add(gv.getMamh());
            vector.add(gv.getMakh());
            vector.add(gv.getEmail());
            vector.add(gv.getDiachi());
            vector.add(gv.getSdt());
            dtm.addRow(vector);
        }
        resetForm();

    }
}
