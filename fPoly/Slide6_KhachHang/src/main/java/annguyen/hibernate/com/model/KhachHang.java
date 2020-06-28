package annguyen.hibernate.com.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class KhachHang {
	@Id
	private String maKhachHang;
	private String matKhau;
	private String hoVaten;
	private String email;
	private String dienThoai;
	
	public KhachHang() {
	}

	public KhachHang(String maKhachHang, String matKhau, String hoVaten, String email, String dienThoai) {
		super();
		this.maKhachHang = maKhachHang;
		this.matKhau = matKhau;
		this.hoVaten = hoVaten;
		this.email = email;
		this.dienThoai = dienThoai;
	}

	public String getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getHoVaten() {
		return hoVaten;
	}

	public void setHoVaten(String hoVaten) {
		this.hoVaten = hoVaten;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDienThoai() {
		return dienThoai;
	}

	public void setDienThoai(String dienThoai) {
		this.dienThoai = dienThoai;
	}

	@Override
	public String toString() {
		return "maKhachHang=" + maKhachHang + ", matKhau=" + matKhau + ", hoVaten=" + hoVaten + ", email="
				+ email + ", dienThoai=" + dienThoai;
	}
	
}