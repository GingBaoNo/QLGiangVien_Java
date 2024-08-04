package GiangVien;

import java.util.ArrayList;
import java.util.Date;

import Khoa.Khoa;
import MonHoc.MonHoc;


public class GiangVien {
	private String magv;
    private String hotengv;
    private Date ngaysinh;
    private boolean  gioitinh;
    private String email;
    private String diachi;
    private String sdt;
    private String mamh;
    private String makh;
    private ArrayList<MonHoc> listMh;
    private ArrayList<Khoa> listKh;

    public ArrayList<MonHoc> getListMh() {
        return listMh;
    }

    public void setListMh(ArrayList<MonHoc> listMh) {
        this.listMh = listMh;
    }
    
    public ArrayList<Khoa> getListKh() {
        return listKh;
    }

    public void setListKh(ArrayList<Khoa> listKh) {
        this.listKh = listKh;
    }
    
    public GiangVien() {
    	
    }
    
    public GiangVien(String magv, String hotengv, Date ngaysinh, boolean gioitinh, String email, String diachi, String sdt, String mamh, String makh) {
        this.magv = magv;
        this.hotengv = hotengv;
        this.ngaysinh = ngaysinh;
        this.gioitinh = gioitinh;
        this.email = email;
        this.diachi = diachi;
        this.sdt = sdt;
        this.mamh = mamh;
        this.makh =makh;
    }

	public String getMagv() {
		return magv;
	}

	public void setMagv(String magv) {
		this.magv = magv;
	}

	public String getHotengv() {
		return hotengv;
	}

	public void setHotengv(String hotengv) {
		this.hotengv = hotengv;
	}

	public Date getNgaysinh() {
		return ngaysinh;
	}

	public void setNgaysinh(Date ngaysinh) {
		this.ngaysinh = ngaysinh;
	}

	public boolean isGioitinh() {
		return gioitinh;
	}

	public void setGioitinh(boolean gioitinh) {
		this.gioitinh = gioitinh;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getMamh() {
		return mamh;
	}

	public void setMamh(String mamh) {
		this.mamh = mamh;
	}

	public String getMakh() {
		return makh;
	}

	public void setMakh(String makh) {
		this.makh = makh;
	}
	
	
}
