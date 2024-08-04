package Search;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import GiangVien.GiangVien;
import GiangVien.GiangVienDAO;
import GiangVien.IGiangVienDAO;
import GiangVien.jpnGiangVien;

import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

public class Search extends JPanel {
	private JTable table;
	private JTextField textField;
	private JTable table_khoa;
	private JTextField textField_1;
	private DefaultTableModel dtm;
    private DefaultTableModel dtmkHOA;
    
    public static void main(String[] args) {
        // Create an instance of frmGiaoVien
        Search giaoVienForm = new Search();

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

	/**
	 * Create the panel.
	 */
	public Search() {
        initComponents();
        dtm = new DefaultTableModel();
        dtmkHOA = new DefaultTableModel();

        //TIm kiem sinh vien theo ma lop
        dtm.addColumn("ID");
        dtm.addColumn("Họ Tên");
        dtm.addColumn("Ngày Sinh");
        dtm.addColumn("Giới Tính");
        dtm.addColumn("Môn Dạy");
        dtm.addColumn("Khoa");
        dtm.addColumn("Email");
        dtm.addColumn("Địa Chỉ");
        dtm.addColumn("Số ĐT");
        table.setModel(dtm);

        //TIm Kiem diem theo ma sv
        dtmkHOA.addColumn("ID");
        dtmkHOA.addColumn("Họ Tên");
        dtmkHOA.addColumn("Ngày Sinh");
        dtmkHOA.addColumn("Giới Tính");
        dtmkHOA.addColumn("Môn Dạy");
        dtmkHOA.addColumn("Khoa");
        dtmkHOA.addColumn("Email");
        dtmkHOA.addColumn("Địa Chỉ");
        dtmkHOA.addColumn("Số ĐT");
        table_khoa.setModel(dtmkHOA);

    }
	
	
	public void initComponents() {
		setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(0, 0, 649, 342);
		add(panel_1);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		tabbedPane.setBackground(new Color(204, 255, 255));
		tabbedPane.setBounds(0, 0, 649, 342);
		panel_1.add(tabbedPane);
		
		JPanel panel_TimKiemTheoMa = new JPanel();
		panel_TimKiemTheoMa.setBackground(new Color(204, 255, 255));
		tabbedPane.addTab("Tìm Kiếm Theo Mã", null, panel_TimKiemTheoMa, null);
		panel_TimKiemTheoMa.setLayout(null);
		
		
		
		table = new JTable();
		table.setBounds(111, 181, 239, 10);
		table.setModel(new DefaultTableModel(
	        	new Object[][] {
	        	},
	        	new String[] {
	        		"New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
	        	}
	        ) {
			boolean[] canEdit = new boolean [] {
                    false, false, false, false, false, false, false, false,false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }});
		table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jtbTTGVMouseReleased(evt);
            }
        });
		
		JScrollPane scrollPane_ma = new JScrollPane(table);
		scrollPane_ma.setBounds(10, 42, 624, 261);
		panel_TimKiemTheoMa.add(scrollPane_ma);
		
		
		textField = new JTextField();
		textField.setBounds(150, 11, 175, 20);
		panel_TimKiemTheoMa.add(textField);
		textField.setColumns(10);
		textField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfmagvKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfmagvKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfmagvKeyTyped(evt);
            }
        });
		
		JLabel lbl_NhapMaGV = new JLabel("Nhập Mã Giảng Viên :");
		lbl_NhapMaGV.setForeground(new Color(0, 0, 255));
		lbl_NhapMaGV.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_NhapMaGV.setBounds(20, 14, 120, 14);
		panel_TimKiemTheoMa.add(lbl_NhapMaGV);
		
		JButton btn_TimKiem_Ma = new JButton("Tìm Kiếm");
		btn_TimKiem_Ma.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_TimKiem_Ma.setForeground(new Color(0, 0, 204));
		btn_TimKiem_Ma.setBounds(335, 10, 89, 23);
		panel_TimKiemTheoMa.add(btn_TimKiem_Ma);
		btn_TimKiem_Ma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	jbtnsearchmagvActionPerformed(evt);
            }
        });
		
		JPanel panel_TimKiemTheoKhoa = new JPanel();
		panel_TimKiemTheoKhoa.setBackground(new Color(204, 255, 255));
		tabbedPane.addTab("Tìm Kiếm Theo Khoa", null, panel_TimKiemTheoKhoa, null);
		panel_TimKiemTheoKhoa.setLayout(null);
		
		
		table_khoa = new JTable();
		table_khoa.setBounds(387, 154, 1, 1);
		table_khoa.setModel(new DefaultTableModel(
	        	new Object[][] {
	        	},
	        	new String[] {
	        		"New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
	        	}
	        ) {boolean[] canEdit = new boolean [] {
                    false, false, false, false, false, false, false, false,false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }});
		
		table_khoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jtbTTKHMouseReleased(evt);
            }
        });
		
		JScrollPane scrollPane_Khoa = new JScrollPane(table_khoa);
		scrollPane_Khoa.setBounds(10, 42, 624, 261);
		panel_TimKiemTheoKhoa.add(scrollPane_Khoa);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(122, 11, 175, 20);
		panel_TimKiemTheoKhoa.add(textField_1);
		textField_1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfmakhoaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfmakhoaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfmakhoaKeyTyped(evt);
            }
        });
		
		JLabel lbl_NhapMaKhoa = new JLabel("Nhập Mã Khoa :");
		lbl_NhapMaKhoa.setForeground(Color.BLUE);
		lbl_NhapMaKhoa.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_NhapMaKhoa.setBounds(21, 14, 91, 14);
		panel_TimKiemTheoKhoa.add(lbl_NhapMaKhoa);
		
		JButton btn_TimKiem_Khoa = new JButton("Tìm Kiếm");
		btn_TimKiem_Khoa.setForeground(new Color(0, 0, 204));
		btn_TimKiem_Khoa.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_TimKiem_Khoa.setBounds(307, 10, 91, 23);
		panel_TimKiemTheoKhoa.add(btn_TimKiem_Khoa);
		btn_TimKiem_Khoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	jbtSearchActionPerformed(evt);
            }
        });
		
		
	}
	private void jtbTTGVMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbTTSVMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jtbTTSVMouseReleased
	
	private void jtbTTKHMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbTTSVMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jtbTTSVMouseReleased
	
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
	
	public void timkiem() {
        while (dtm.getRowCount() > 0) {
            dtm.removeRow(0);
        }
        String magv = textField.getText();
        try {
            try {
                IGiangVienDAO giangvienDAO = (IGiangVienDAO) Class.forName("GiangVien.GiangVienDAO").newInstance();
                ArrayList<GiangVien> list = giangvienDAO.findByID(magv);
                for (GiangVien gv : list) {
                    dtm.addRow(toObjectsData(gv));
                }
            } catch (InstantiationException ex) {
                Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
	
	public void timkiemKhoa() {
        while (dtmkHOA.getRowCount() > 0) {
            dtmkHOA.removeRow(0);
        }
        String makh = textField_1.getText();
        try {
            try {
                IGiangVienDAO giangvienDAO = (IGiangVienDAO) Class.forName("GiangVien.GiangVienDAO").newInstance();
                ArrayList<GiangVien> list = giangvienDAO.findByIDKhoa(makh);
                for (GiangVien gv : list) {
                    dtmkHOA.addRow(toObjectsData(gv));
                }
            } catch (InstantiationException ex) {
                Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
	private void jbtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSearchActionPerformed
        timkiemKhoa();
    }//GEN-LAST:event_jbtSearchActionPerformed

    private void jtfmakhoaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfmalopKeyTyped
    }//GEN-LAST:event_jtfmalopKeyTyped

    private void jtfmakhoaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfmalopKeyReleased
        timkiemKhoa();
    }//GEN-LAST:event_jtfmalopKeyReleased

    private void jtfmakhoaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfmalopKeyPressed
        timkiemKhoa();
    }//GEN-LAST:event_jtfmalopKeyPressed

    private void jtfmagvKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfmasvKeyPressed
        timkiem();
    }//GEN-LAST:event_jtfmasvKeyPressed

    private void jtfmagvKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfmasvKeyReleased
        timkiem();
    }//GEN-LAST:event_jtfmasvKeyReleased

    private void jtfmagvKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfmasvKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfmasvKeyTyped

    private void jbtnsearchmagvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnsearchmasvActionPerformed
        timkiem();
    }//GEN-LAST:event_jbtnsearchmasvActionPerformed

    private void jtbbangkhoaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbbangdiemMouseReleased
       
    }//GEN-LAST:event_jtbbangdiemMouseReleased

    private void jtbbangkhoaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtbbangdiemKeyReleased

    }//GEN-LAST:event_jtbbangdiemKeyReleased
}
