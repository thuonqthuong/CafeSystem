package ptithcm.entity;

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
	private String MaLuong;
	
	@ManyToOne
	@JoinColumn(name="MaNV")
	NhanVien chamluong_nhanvien;
	
//	@NotBlank(message = "Cannot be blank")
	private Double LuongCB;
	
	private Float HeSoLuong;
	
	private Double TienThuong;
	
	public String getMaLuong() {
		return MaLuong;
	}
	public void setMaLuong(String maLuong) {
		MaLuong = maLuong;
	}
	public NhanVien getChamluong_nhanvien() {
		return chamluong_nhanvien;
	}
	public void setChamluong_nhanvien(NhanVien chamluong_nhanvien) {
		this.chamluong_nhanvien = chamluong_nhanvien;
	}
	public Double getLuongCB() {
		return LuongCB;
	}
	public void setLuongCB(Double luongCB) {
		LuongCB = luongCB;
	}
	public Float getHeSoLuong() {
		return HeSoLuong;
	}
	public void setHeSoLuong(Float heSoLuong) {
		HeSoLuong = heSoLuong;
	}
	public Double getTienThuong() {
		return TienThuong;
	}
	public void setTienThuong(Double tienThuong) {
		TienThuong = tienThuong;
	}
	
}
