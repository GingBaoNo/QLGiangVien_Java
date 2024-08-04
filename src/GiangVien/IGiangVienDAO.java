/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GiangVien;

import java.util.ArrayList;


/**
 *
 * @author Anonymous
 */
public interface IGiangVienDAO {
    public ArrayList<GiangVien> getAll();
    public ArrayList<GiangVien> findByIDMonHoc(String mamh);
    public GiangVien addNew(GiangVien gv);
    public GiangVien updateByID(GiangVien gv);
    public ArrayList<GiangVien> CheckID(String magv);
	public ArrayList<GiangVien> findByID(String magv);
	public ArrayList<GiangVien> findByIDKhoa(String makh);
    
}
