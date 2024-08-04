package MonHoc;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import Check.Check;
import Khoa.jpnKhoa;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class jpnMonHoc extends JPanel {
	private JTable table;
	private JTextField text_MaMon;
	private JTextField text_TenMon;
	private JTextField text_SoTin;
	private JTextField text_HocKy;
	private JTextField text_PhongHoc;
	private JComboBox comboBox_HinhThucThi;
	private JButton btn_Add;
	private JButton btn_Update;
	private JButton btn_Delete;
	private JButton btn_Clear;
	
	
	
	private DefaultTableModel dtm;
    private DefaultComboBoxModel dcbmthi;
    private ArrayList<MonHoc> list;
    
    public static void main(String[] args) {
        // Create an instance of frmGiaoVien
        jpnMonHoc giaoVienForm = new jpnMonHoc();

        // Create a JFrame to hold the frmGiaoVien panel
        javax.swing.JFrame frame = new javax.swing.JFrame();
        frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Giao Vien");
        frame.setSize(800, 600);

        // Add the frmGiaoVien panel to the JFrame
        frame.getContentPane().add(giaoVienForm);

        // Set the JFrame visible
        frame.setVisible(true);
      }
    
	public jpnMonHoc() {
		initComponents();
        dcbmthi = new DefaultComboBoxModel();

        dtm = new DefaultTableModel();


        dcbmthi.addElement("Thi Viết");
        dcbmthi.addElement("Thi Thực Hành");
        dcbmthi.addElement("Thi Vấn Đáp");
        comboBox_HinhThucThi.setModel(dcbmthi);

        dtm.addColumn("Mã MH");
        dtm.addColumn("Tên MH");
        dtm.addColumn("Số Trình");
        dtm.addColumn("Hình Thức Thi");
        dtm.addColumn("Học Kỳ");
        dtm.addColumn("Phòng Học");

        loaddata();
	}
	
	private void loaddata() {
        try {

            IMonHocDAO monHocDAO = (IMonHocDAO) Class.forName("MonHoc.MonHocDAO").newInstance();
            list = new MonHocDAO().getAll();
            for (MonHoc mh : list) {
                dtm.addRow(toObjectsData(mh));
            }
            table.setModel(dtm);
        } catch (InstantiationException ex) {
            Logger.getLogger(jpnMonHoc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(jpnMonHoc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(jpnMonHoc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

		
	public static Object[] toObjectsData(MonHoc hoc) {
        Object[] objectsData = {hoc.getMamh(), hoc.getTenmh(), hoc.getSotrinh(), hoc.getHinhthucthi(), hoc.getHocky(), hoc.getPhonghoc()};
        return objectsData;
    }
	/**
	 * Create the panel.
	 * @return 
	 */
	public void initComponents() {
		setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBackground(new Color(204, 255, 255));
		panel_1.setLayout(null);
		panel_1.setBounds(0, 0, 649, 342);
		add(panel_1);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã Môn", "Tên Môn", "Số Tín", "Hình Thức Thi", "Học Kỳ", "Phòng Học"
			}
		){
            boolean[] canEdit = new boolean [] {
                    false, false, false, false, false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }
            });
		table.setBounds(10, 11, 629, 140);
		table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbMonHocMouseClicked(evt);
            }
        });
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 11, 629, 137);
		panel_1.add(scrollPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(new Color(153, 255, 255));
		panel.setBounds(10, 157, 629, 174);
		panel_1.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mã Môn");
		lblNewLabel.setForeground(new Color(0, 51, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(60, 25, 57, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tên Môn");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setForeground(new Color(0, 51, 255));
		lblNewLabel_1.setBounds(60, 79, 63, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Số tín");
		lblNewLabel_2.setForeground(new Color(0, 51, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(60, 130, 46, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Học kỳ");
		lblNewLabel_3.setForeground(new Color(0, 51, 255));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(277, 25, 46, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Phòng học");
		lblNewLabel_3_1.setForeground(new Color(0, 51, 255));
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3_1.setBounds(277, 79, 79, 14);
		panel.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Hình thức thi");
		lblNewLabel_3_2.setForeground(new Color(0, 51, 255));
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3_2.setBounds(197, 130, 94, 14);
		panel.add(lblNewLabel_3_2);
		
		text_MaMon = new JTextField();
		text_MaMon.setBounds(119, 22, 132, 20);
		panel.add(text_MaMon);
		text_MaMon.setColumns(10);
		
		text_TenMon = new JTextField();
		text_TenMon.setBounds(119, 76, 132, 20);
		panel.add(text_TenMon);
		text_TenMon.setColumns(10);
		
		text_SoTin = new JTextField();
		text_SoTin.setBounds(119, 127, 68, 20);
		panel.add(text_SoTin);
		text_SoTin.setColumns(10);
		
		text_HocKy = new JTextField();
		text_HocKy.setBounds(349, 22, 111, 20);
		panel.add(text_HocKy);
		text_HocKy.setColumns(10);
		
		text_PhongHoc = new JTextField();
		text_PhongHoc.setBounds(349, 76, 111, 20);
		panel.add(text_PhongHoc);
		text_PhongHoc.setColumns(10);
		
		comboBox_HinhThucThi = new JComboBox();
		comboBox_HinhThucThi.setBounds(287, 126, 94, 21);
		panel.add(comboBox_HinhThucThi);
		
		btn_Add = new JButton("Thêm");
		btn_Add.setForeground(new Color(0, 0, 0));
		btn_Add.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_Add.setBounds(494, 21, 89, 23);
		panel.add(btn_Add);
		btn_Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNewActionPerformed(evt);
            }
        });
		
		btn_Update = new JButton("Sửa");
		btn_Update.setForeground(new Color(0, 0, 0));
		btn_Update.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_Update.setBounds(494, 75, 89, 23);
		panel.add(btn_Update);
		btn_Update.setEnabled(false);
		btn_Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbUpdateActionPerformed(evt);
            }
        });
		
		btn_Delete = new JButton("Xóa");
		btn_Delete.setForeground(new Color(0, 0, 0));
		btn_Delete.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_Delete.setBounds(494, 126, 89, 23);
		panel.add(btn_Delete);
		btn_Delete.setEnabled(false);
		btn_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDeleteActionPerformed(evt);
            }
        });
		
		btn_Clear = new JButton("Làm Mới");
		btn_Clear.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_Clear.setBounds(395, 126, 89, 23);
		panel.add(btn_Clear);
		btn_Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExitActionPerformed(evt);
            }
        });

	}
	
	private void jtfSoTrinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfSoTrinhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfSoTrinhActionPerformed
    private void jbNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNewActionPerformed
        String maMH = text_MaMon.getText();
        String tenMH = text_TenMon.getText();
        String soTrinh = text_SoTin.getText();
        String htThi = (String) comboBox_HinhThucThi.getSelectedItem();
        String hocKy = text_HocKy.getText();
        String phongHoc = text_PhongHoc.getText();
        Check c = new Check();
        if (!checkinfo()) {
            return;
        }

        int strinh;
        strinh = Integer.parseInt(soTrinh);
        int hky;
        hky = Integer.parseInt(hocKy);

        MonHoc monHoc = new MonHoc(maMH, tenMH, strinh, htThi, hky, phongHoc);
        ArrayList<MonHoc> listCheck = new MonHocDAO().CheckID(maMH);
        if (listCheck.size() > 0) {
            JOptionPane.showMessageDialog(this, "Mã ID bị trùng", "vui lòng kiểm tra lại", JOptionPane.ERROR_MESSAGE);
            text_MaMon.setText("");
            text_MaMon.requestFocus();
        } else {
            MonHoc insert = new MonHocDAO().addNew(monHoc);
            if (insert != null) {
                showAll();
            }
        }

    }//GEN-LAST:event_jbNewActionPerformed

    private void jbUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbUpdateActionPerformed
    	String maMH = text_MaMon.getText();
        String tenMH = text_TenMon.getText();
        String soTrinh = text_SoTin.getText();
        String htThi = (String) comboBox_HinhThucThi.getSelectedItem();
        String hocKy = text_HocKy.getText();
        String phongHoc = text_PhongHoc.getText();
        Check c = new Check();
        if (!checkinfo()) {
            return;
        }
        int strinh;
        strinh = Integer.parseInt(soTrinh);
        int hky;
        hky = Integer.parseInt(hocKy);
        MonHoc monHoc = new MonHoc(maMH, tenMH, strinh, htThi, hky, phongHoc);
        MonHoc update = new MonHocDAO().updateByID(monHoc);
        if (update != null) {
            showAll();
        }
        btn_Add.setEnabled(true);
        btn_Update.setEnabled(false);
        btn_Delete.setEnabled(false);
        text_MaMon.setEnabled(true);
    }//GEN-LAST:event_jbUpdateActionPerformed

    private void jtbMonHocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbMonHocMouseClicked
    	int row = table.getSelectedRow();
        if (row >= 0) {
            text_MaMon.setText(table.getValueAt(row, 0).toString()); // Gán dữ liệu vào trường Mã Môn
            text_TenMon.setText(table.getValueAt(row, 1).toString()); // Gán dữ liệu vào trường Tên Môn
            text_SoTin.setText(table.getValueAt(row, 2).toString());
            comboBox_HinhThucThi.setSelectedItem(table.getValueAt(row, 3));
            text_HocKy.setText(table.getValueAt(row, 4).toString());
            text_PhongHoc.setText(table.getValueAt(row, 5).toString());
            
            btn_Add.setEnabled(false);
            btn_Update.setEnabled(true);
            btn_Delete.setEnabled(true);
            text_MaMon.setEnabled(false);
        }

        
//        btn_Update.setEnabled(true);
//        btn_Delete.setEnabled(true);
        
    }//GEN-LAST:event_jtbMonHocMouseClicked

    private void jbDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDeleteActionPerformed
        String maMh = text_MaMon.getText();
        int b = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn xóa dữ liệu này?", "Thông Báo", JOptionPane.YES_NO_OPTION);
        if (b == JOptionPane.YES_OPTION) {
            try {
                new MonHocDAO().delMonHoc(maMh);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Dữ liệu chưa thể xóa, có tồn tại điểm của môn này, hãy xóa dữ liệu điểm trước", "Thông báo", JOptionPane.ERROR_MESSAGE);
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "Dữ liệu chưa thể xóa, có tồn tại điểm của môn này, hãy xóa dữ liệu điểm trước", "Thông báo", JOptionPane.ERROR_MESSAGE);
            }
            while (dtm.getRowCount() > 0) {
                dtm.removeRow(0);
            }
            resetForm();
            loaddata();
            btn_Add.setEnabled(true);
            btn_Update.setEnabled(false);
            btn_Delete.setEnabled(false);
            text_MaMon.setEnabled(true);
        }
    }//GEN-LAST:event_jbDeleteActionPerformed
    private void showAll() {
        while (dtm.getRowCount() > 0) {
            dtm.removeRow(0);
        }
        ArrayList<MonHoc> hocs = new MonHocDAO().getAll();
        for (MonHoc mh : hocs) {
            Vector v = new Vector();
            v.add(mh.getMamh());
            v.add(mh.getTenmh());
            v.add(mh.getSotrinh());
            v.add(mh.getHinhthucthi());
            v.add(mh.getHocky());
            v.add(mh.getPhonghoc());

            dtm.addRow(v);
        }
        resetForm();
        // jtfthi.setText("");
    }

    public void resetForm() {
        text_MaMon.setText("");
        text_TenMon.setText("");
        text_PhongHoc.setText("");
        text_SoTin.setText("");
        text_HocKy.setText("");
        text_MaMon.requestFocus();
    }

    public boolean checkinfo() {
        Check c = new Check();
        if (!c.checkID(text_MaMon.getText())) {
            JOptionPane.showMessageDialog(this, "Nhập mã sai", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            text_MaMon.setText("");
            text_MaMon.requestFocus();
            return false;
        } else if (!c.checkSpace(text_TenMon.getText()) || !c.check(text_TenMon.getText())) {
            JOptionPane.showMessageDialog(this, "Nhập tên môn học sai", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            text_TenMon.setText("");
            text_TenMon.requestFocus();
            return false;

        } else if (!c.checkSpace(text_SoTin.getText()) || !c.checkNumber(text_SoTin.getText())) {
            JOptionPane.showMessageDialog(this, "Kiểm tra lại số trình", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            text_SoTin.setText("");
            text_SoTin.requestFocus();
            return false;
        } else if (!c.checkSpace(text_HocKy.getText()) || !c.checkNumber(text_HocKy.getText())) {
            JOptionPane.showMessageDialog(this, "Nhập sai học kỳ phải là số", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            text_HocKy.setText("");
            text_HocKy.requestFocus();
            return false;
        } else if (!c.checkSpace(text_PhongHoc.getText()) || !c.check(text_PhongHoc.getText())) {
            JOptionPane.showMessageDialog(this, "Nhập tên phòng học sai", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            text_PhongHoc.setText("");
            text_PhongHoc.requestFocus();
            return false;

        }
        return true;
    }
    private void jbExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExitActionPerformed
        this.resetForm();
    }//GEN-LAST:event_jbExitActionPerformed
}
