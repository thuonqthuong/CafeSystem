package ptithcm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="CHAMLUONG")
public class ChamLuong {
	@Id
//	@NotBlank(message = "Cannot be blank")
	@Column(name = "MaLuong")
	private String maluong;
	
	@ManyToOne
	@JoinColumn(name="MaNV")
	NhanVien chamluong_nhanvien;
	
//	@NotBlank(message = "Cannot be blank")
	@Column(name = "LuongCB")
	private Double luongcb;
	
	@Column(name = "HeSoLuong")
	private Float hesoluong;
	
	@Column(name = "TienThuong")
	private Double tienthuong;
	
	public NhanVien getChamluong_nhanvien() {
		return chamluong_nhanvien;
	}
	public void setChamluong_nhanvien(NhanVien chamluong_nhanvien) {
		this.chamluong_nhanvien = chamluong_nhanvien;
	}
	public String getMaluong() {
		return maluong;
	}
	public void setMaluong(String maluong) {
		this.maluong = maluong;
	}
	public Double getLuongcb() {
		return luongcb;
	}
	public void setLuongcb(Double luongcb) {
		this.luongcb = luongcb;
	}
	public Float getHesoluong() {
		return hesoluong;
	}
	public void setHesoluong(Float hesoluong) {
		this.hesoluong = hesoluong;
	}
	public Double getTienthuong() {
		return tienthuong;
	}
	public void setTienthuong(Double tienthuong) {
		this.tienthuong = tienthuong;
	}
	
}
