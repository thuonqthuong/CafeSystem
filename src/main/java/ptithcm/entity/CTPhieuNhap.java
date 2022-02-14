package ptithcm.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CT_PHIEUNHAP")
public class CTPhieuNhap {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	
	@ManyToOne
	@JoinColumn(name="MaNguyenLieu")
	NguyenLieu ctphieunhap_nguyenlieu;
	
	@ManyToOne
	@JoinColumn(name="MaPhieuNhap")
	PhieuNhap phieunhap;
	
	@ManyToOne
	@JoinColumn(name="MaDonVi")
	DonVi ctphieunhap_donvi;
	
	private Float SoLuong;
	private Double DonGia;
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public NguyenLieu getCtphieunhap_nguyenlieu() {
		return ctphieunhap_nguyenlieu;
	}
	public void setCtphieunhap_nguyenlieu(NguyenLieu ctphieunhap_nguyenlieu) {
		this.ctphieunhap_nguyenlieu = ctphieunhap_nguyenlieu;
	}
	public PhieuNhap getPhieunhap() {
		return phieunhap;
	}
	public void setPhieunhap(PhieuNhap phieunhap) {
		this.phieunhap = phieunhap;
	}
	public Float getSoLuong() {
		return SoLuong;
	}
	public void setSoLuong(Float soLuong) {
		SoLuong = soLuong;
	}
	public Double getDonGia() {
		return DonGia;
	}
	public void setDonGia(Double donGia) {
		DonGia = donGia;
	}
	
}
