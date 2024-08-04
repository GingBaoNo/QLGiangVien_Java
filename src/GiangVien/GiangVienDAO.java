/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GiangVien;

import ConnectDatabase.DBConnect;
import MonHoc.MonHoc;
import MonHoc.MonHocDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Anonymous
 */
public class GiangVienDAO implements IGiangVienDAO {

    @Override
    public ArrayList<GiangVien> getAll() {
        // throw new UnsupportedOperationException("Not supported yet.");
        ArrayList<GiangVien> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("select *from tblGiangVien");
                rs = ps.executeQuery();
                list = new ArrayList<GiangVien>();
                while (rs.next()) {
                    GiangVien gv = new GiangVien();
                    gv.setMagv(rs.getString(1));
                    gv.setHotengv(rs.getString(2));
                    gv.setNgaysinh(new Date(rs.getDate(3).getTime()));
                    gv.setGioitinh(rs.getBoolean(4));
                    gv.setMamh(rs.getString(5));
                    gv.setMakh(rs.getString(6));
                    gv.setEmail(rs.getString(7));
                    gv.setDiachi(rs.getString(8));
                    gv.setSdt(rs.getString(9));
                    
                    list.add(gv);
                }
            } catch (SQLException ex) {
                Logger.getLogger(GiangVienDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DBConnect.close(ps, rs);
            }
        }
        return list;
    }

    @Override
    public ArrayList<GiangVien> findByIDMonHoc(String mamh) {
        ArrayList<GiangVien> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("select  * from tblGiangVien where fldMaMH = ?");
                ps.setString(1, mamh);
                rs = ps.executeQuery();
                list = new ArrayList<GiangVien>();
                while (rs.next()) {
                    GiangVien gv = new GiangVien();
                    gv.setMagv(rs.getString(1));
                    gv.setHotengv(rs.getString(2));
                    gv.setNgaysinh(new Date(rs.getDate(3).getTime()));
                    gv.setGioitinh(rs.getBoolean(4));
                    gv.setMamh(rs.getString(5));
                    gv.setMakh(rs.getString(6));
                    gv.setEmail(rs.getString(7));
                    gv.setDiachi(rs.getString(8));
                    gv.setSdt(rs.getString(9));
                    
                    list.add(gv);


                }
            } catch (SQLException ex) {
                Logger.getLogger(GiangVienDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DBConnect.close(ps, rs);
            }
        }
        return list;
    }
    
    public ArrayList<GiangVien> findByIDKhoa(String makh) {
        ArrayList<GiangVien> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("select  * from tblGiangVien where fldMaKhoa = ?");
                ps.setString(1, makh);
                rs = ps.executeQuery();
                list = new ArrayList<GiangVien>();
                while (rs.next()) {
                    GiangVien gv = new GiangVien();
                    gv.setMagv(rs.getString(1));
                    gv.setHotengv(rs.getString(2));
                    gv.setNgaysinh(new Date(rs.getDate(3).getTime()));
                    gv.setGioitinh(rs.getBoolean(4));
                    gv.setMamh(rs.getString(5));
                    gv.setMakh(rs.getString(6));
                    gv.setEmail(rs.getString(7));
                    gv.setDiachi(rs.getString(8));
                    gv.setSdt(rs.getString(9));
                    
                    list.add(gv);


                }
            } catch (SQLException ex) {
                Logger.getLogger(GiangVienDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DBConnect.close(ps, rs);
            }
        }
        return list;
    }
    
    @Override
    public ArrayList<GiangVien> findByID(String magv) {
        ArrayList<GiangVien> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("select  * from tblGiangVien where fldMaGV = ?");
                ps.setString(1, magv);
                rs = ps.executeQuery();
                list = new ArrayList<GiangVien>();
                while (rs.next()) {
                    GiangVien gv = new GiangVien();
                    gv.setMagv(rs.getString(1));
                    gv.setHotengv(rs.getString(2));
                    gv.setNgaysinh(new Date(rs.getDate(3).getTime()));
                    gv.setGioitinh(rs.getBoolean(4));
                    gv.setMamh(rs.getString(5));
                    gv.setMakh(rs.getString(6));
                    gv.setEmail(rs.getString(7));
                    gv.setDiachi(rs.getString(8));
                    gv.setSdt(rs.getString(9));
                    
                    list.add(gv);


                }
            } catch (SQLException ex) {
                Logger.getLogger(GiangVienDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DBConnect.close(ps, rs);
            }
        }
        return list;
    }

    @Override
    public GiangVien addNew(GiangVien gv) {
        PreparedStatement ps = null;
       
        if (DBConnect.open()) {
            try {
                //   ps = DBConnect.cnn.prepareStatement("insert into tblGiangVien.fldMaGV, tblGiangVien.fldHoTenGV,tblGVMH.fldMaMH, tblGiangVien.fldNgaySinh, tblGiangVien.fldGioiTinh, tblGiangVien.fldEmail, tblGiangVien.fldDiaChi, tblGiangVien.fldSDT from tblGiangVien inner join tblGVMH on tblGiangVien.fldMaGV=tblGVMH.fldMaGV values (?,?,?,?,?,?,?,?)");
                ps = DBConnect.cnn.prepareStatement("INSERT INTO tblGiangVien values (?,?,?,?,?,?,?,?,?)");
                ps.setString(1, gv.getMagv());
                ps.setString(2, gv.getHotengv());
                ps.setDate(3, new java.sql.Date(gv.getNgaysinh().getTime()));
                ps.setBoolean(4, gv.isGioitinh());
                ps.setString(5, gv.getMamh());
                ps.setString(6,  gv.getMakh());
                ps.setString(7, gv.getEmail());
                ps.setString(8, gv.getDiachi());
                ps.setString(9, gv.getSdt());
                
                int row = ps.executeUpdate();
                if (row < 1) {
                    gv = null;
                }
            } catch (SQLException ex) {
                Logger.getLogger(GiangVienDAO.class.getName()).log(Level.SEVERE, null, ex);
                gv = null;
            } finally {
                DBConnect.close(ps);
            }
        }
        return gv;
    }

    @Override
    public GiangVien updateByID(GiangVien gv) {
        PreparedStatement ps = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("update tblGiangVien set fldHoTenGV =?,"
                        + "fldNgaySinh=?,fldGioiTinh=?,"
                        + "fldMaMH= ?, fldMaKhoa= ?, fldEmail = ?, fldDiaChi = ?, "
                        + "fldSDT = ? where fldMaGV = ?");
                
                ps.setString(1, gv.getHotengv());
                ps.setString(2, gv.getMamh());
                ps.setDate(3, new java.sql.Date(gv.getNgaysinh().getTime()));
                
                ps.setBoolean(4, gv.isGioitinh());
                ps.setString(5, gv.getEmail());
                ps.setString(6, gv.getDiachi());
                ps.setString(7, gv.getSdt());
                ps.setString(8, gv.getMagv());

                int row = ps.executeUpdate();
                if (row < 1) {
                    gv = null;
                } 
            } catch (SQLException ex) {
                Logger.getLogger(GiangVienDAO.class.getName()).log(Level.SEVERE, null, ex);
                gv = null;
            } finally {
                DBConnect.close();
            }
        }
        return gv;
    }
    public void deleteIDGV(String GiaoVienID)throws SQLException,ClassNotFoundException{
    PreparedStatement ps = null;
        if (DBConnect.open()) {
            ps = DBConnect.cnn.prepareStatement("delete from tblGiangVien where fldMaGV= ?");
            ps.setString(1, GiaoVienID);
            ps.executeUpdate();
            DBConnect.close();
        }
    }

    @Override
    public ArrayList<GiangVien> CheckID(String magv) {
      ArrayList<GiangVien> list = null;
        PreparedStatement psCheck = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                psCheck = DBConnect.cnn.prepareStatement("select *from tblGiangVien where fldMaGV=?");
               psCheck.setString(1, magv);
                rs = psCheck.executeQuery();
                    list = new ArrayList<GiangVien>();
                    while (rs.next()) {
                        GiangVien giaoVien = new GiangVien();
                        giaoVien.setMagv(rs.getString(1));
                        list.add(giaoVien);
                    }
            } catch (SQLException ex) {
                Logger.getLogger(GiangVienDAO.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
            DBConnect.close(psCheck, rs);
            }
        }
        return  list;
    }

}
