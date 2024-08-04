package Khoa;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import Check.Check;

public class jpnKhoa extends JPanel {
	private JTable table;
	private JTextField textField_MaKhoa;
	private JTextField textField_TenKhoa;
	private JTextField textField_SDT;
	private JButton btn_Add;
	private JButton btn_Update;
	private JButton btn_Delete;
	private JButton btn_Clear;
	
	private DefaultTableModel dtm;
    ArrayList<Khoa> list = null;
    
    
    public static void main(String[] args) {
        // Create an instance of frmGiaoVien
        jpnKhoa giaoVienForm = new jpnKhoa();

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
	
	
	public jpnKhoa() {
		initComponents();
        dtm = new DefaultTableModel();
        dtm.addColumn("Mã Khoa");
        dtm.addColumn("Tên Khoa");
        dtm.addColumn("Số Điện Thoại");
        loaddata();
	}

	private void loaddata() {
        try {
            IKhoaDAO khoaDAO = (IKhoaDAO) Class.forName("Khoa.KhoaDAO").newInstance();
            list = new KhoaDAO().getAll();
            for (Khoa khoa : list) {
                dtm.addRow(toObjectsData(khoa));
            }
            table.setModel(dtm);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(jpnKhoa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(jpnKhoa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(jpnKhoa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
	
	private static Object[] toObjectsData(Khoa k) {
        Object[] objectsData = {k.getMakhoa(), k.getTenkhoa(), k.getSdt()};
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
		panel_1.setForeground(new Color(255, 255, 255));
		panel_1.setLayout(null);
		panel_1.setBounds(0, 0, 649, 342);
		add(panel_1);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã Khoa", "Tên Khoa", "Số điện thoại"
			}
		));
		table.setBounds(10, 11, 629, 150);
		table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbKhoaMouseClicked(evt);
            }
        });
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 11, 629, 157);
		panel_1.add(scrollPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(new Color(153, 255, 255));
		panel.setBounds(10, 179, 629, 152);
		panel_1.add(panel);
		panel.setLayout(null);
		
		JLabel lblTnKhoa = new JLabel("Tên Khoa");
		lblTnKhoa.setForeground(new Color(0, 51, 255));
		lblTnKhoa.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTnKhoa.setBounds(68, 65, 66, 14);
		panel.add(lblTnKhoa);
		
		JLabel lblSinThoi = new JLabel("Số điện thoại");
		lblSinThoi.setForeground(new Color(0, 51, 255));
		lblSinThoi.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSinThoi.setBounds(68, 105, 94, 14);
		panel.add(lblSinThoi);
		
		JLabel lblMKhoa = new JLabel("Mã Khoa");
		lblMKhoa.setForeground(new Color(0, 51, 255));
		lblMKhoa.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMKhoa.setBounds(68, 25, 59, 14);
		panel.add(lblMKhoa);
		
		textField_MaKhoa = new JTextField();
		textField_MaKhoa.setBounds(172, 22, 146, 20);
		panel.add(textField_MaKhoa);
		textField_MaKhoa.setColumns(10);
		
		textField_TenKhoa = new JTextField();
		textField_TenKhoa.setBounds(172, 62, 146, 20);
		panel.add(textField_TenKhoa);
		textField_TenKhoa.setColumns(10);
		
		textField_SDT = new JTextField();
		textField_SDT.setBounds(172, 102, 149, 20);
		panel.add(textField_SDT);
		textField_SDT.setColumns(10);
		
		btn_Add = new JButton("Thêm");
		btn_Add.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_Add.setForeground(new Color(0, 0, 0));
		btn_Add.setBounds(386, 35, 89, 23);
		panel.add(btn_Add);
		btn_Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	jbNewActionPerformed(evt);
            }
        });
		
		
		btn_Update = new JButton("Sửa");
		btn_Update.setForeground(new Color(0, 0, 0));
		btn_Update.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_Update.setBounds(510, 35, 89, 23);
		panel.add(btn_Update);
		btn_Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	jbUpdateActionPerformed(evt);
            }
        });
		
		btn_Delete = new JButton("Xóa");
		btn_Delete.setForeground(new Color(0, 0, 0));
		btn_Delete.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_Delete.setBounds(386, 87, 89, 23);
		panel.add(btn_Delete);
		btn_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	jbDeleteActionPerformed(evt);
            }
        });
		
		btn_Clear = new JButton("Làm Mới");
		btn_Clear.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_Clear.setBounds(510, 87, 89, 23);
		panel.add(btn_Clear);
		btn_Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	jbExitActionPerformed(evt);
            }
        });

	}
	
	private void jbNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNewActionPerformed
        if (!checkinfo()) {
            return;
        }
        String makhoa = textField_MaKhoa.getText();
        String tenkhoa = textField_TenKhoa.getText();
        String sdt = textField_SDT.getText();
        Khoa k = new Khoa(makhoa, tenkhoa, sdt);
        ArrayList<Khoa> listCheck = new KhoaDAO().checkID(makhoa);
        if (listCheck.size() > 0) {
            JOptionPane.showMessageDialog(this, "Mã ID bị trùng", "vui lòng kiểm tra lại", JOptionPane.ERROR_MESSAGE);
            textField_MaKhoa.setText("");
            textField_MaKhoa.requestFocus();
        } else {
            Khoa insert = new KhoaDAO().addNew(k);
            if (insert != null) {
                showAll();
            }
        }


    }//GEN-LAST:event_jbNewActionPerformed

    private void jbUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbUpdateActionPerformed
        if (!checkinfo()) {
            return;
        }
        String makhoa = textField_MaKhoa.getText();
        String tenkhoa = textField_TenKhoa.getText();
        String sdt = textField_SDT.getText();
        Khoa k = new Khoa(makhoa, tenkhoa, sdt);
        Khoa update = new KhoaDAO().updateByID(k);
        if (update != null) {
            showAll();
        }
        btn_Add.setEnabled(true);
        btn_Update.setEnabled(false);
        btn_Delete.setEnabled(false);
        textField_MaKhoa.setEnabled(true);
    }//GEN-LAST:event_jbUpdateActionPerformed

    private void jtbKhoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbKhoaMouseClicked
        textField_MaKhoa.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
        textField_TenKhoa.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
        textField_SDT.setText(table.getValueAt(table.getSelectedRow(), 2).toString());

        btn_Add.setEnabled(false);
        btn_Update.setEnabled(true);
        btn_Delete.setEnabled(true);
        textField_MaKhoa.setEnabled(false);
    }//GEN-LAST:event_jtbKhoaMouseClicked

    private void jbDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDeleteActionPerformed
        int b = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn xóa dữ liệu này?", "Thông Báo", JOptionPane.YES_NO_OPTION);
        if (b == JOptionPane.YES_OPTION) {
            try {
                String makhoa = textField_MaKhoa.getText();
                new KhoaDAO().deleteKhoa(makhoa);
            } catch (SQLException ex) {
                Logger.getLogger(jpnKhoa.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(jpnKhoa.class.getName()).log(Level.SEVERE, null, ex);
            }
            while (dtm.getRowCount() > 0) {
                dtm.removeRow(0);
            }

            ResetForm();
            loaddata();
            btn_Add.setEnabled(true);
            btn_Update.setEnabled(false);
            btn_Delete.setEnabled(false);
            textField_MaKhoa.setEnabled(true);
        }
    }//GEN-LAST:event_jbDeleteActionPerformed
    public void ResetForm() {
        textField_MaKhoa.setText("");
        textField_TenKhoa.setText("");
        textField_SDT.setText("");
        textField_MaKhoa.requestFocus();
    }
    private void jbExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExitActionPerformed
        this.ResetForm();
    }//GEN-LAST:event_jbExitActionPerformed
    private void showAll() {
        while (dtm.getRowCount() > 0) {
            dtm.removeRow(0);
        }

        ArrayList<Khoa> khoas = new KhoaDAO().getAll();
        for (Khoa khoa : khoas) {
            Vector v = new Vector();
            v.add(khoa.getMakhoa());
            v.add(khoa.getTenkhoa());
            v.add(khoa.getSdt());
            dtm.addRow(v);
        }
        ResetForm();
    }

    public boolean checkinfo() {
        Check c = new Check();
        if (!c.checkID(textField_MaKhoa.getText())) {
            JOptionPane.showMessageDialog(this, "Nhập Mã khoa sai", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            textField_MaKhoa.setText("");
            textField_MaKhoa.requestFocus();
            return false;
        } else if (!c.checkSpace(textField_TenKhoa.getText()) || !c.check(textField_TenKhoa.getText())) {
            JOptionPane.showMessageDialog(this, "Nhập tên Khoa sai", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            textField_TenKhoa.setText("");
            textField_TenKhoa.requestFocus();
            return false;

        } else if (!c.checkSpace(textField_SDT.getText()) || !c.checkPhone(textField_SDT.getText())) {
            JOptionPane.showMessageDialog(this, "Lỗi Số Điện Thoại", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            textField_SDT.setText("");
            textField_SDT.requestFocus();
            return false;
        }
        return true;
    }
	
	
}
