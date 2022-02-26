package ptithcm.entity;

import javax.persistence.Column;
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
	@Column(name = "Id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="maNguyenLieu")
	NguyenLieu ctphieunhap_nguyenlieu;
	
	@ManyToOne
	@JoinColumn(name="MaPhieuNhap")
	PhieuNhap phieunhap;
	
	@ManyToOne
	@JoinColumn(name="maDonVi")
	DonVi ctphieunhap_donvi;
	
	@Column(name = "SoLuong")
	private Float soluong;
	
	@Column(name = "DonGia")
	private Double dongia;
	
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
	public DonVi getCtphieunhap_donvi() {
		return ctphieunhap_donvi;
	}
	public void setCtphieunhap_donvi(DonVi ctphieunhap_donvi) {
		this.ctphieunhap_donvi = ctphieunhap_donvi;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Float getSoluong() {
		return soluong;
	}
	public void setSoluong(Float soluong) {
		this.soluong = soluong;
	}
	public Double getDongia() {
		return dongia;
	}
	public void setDongia(Double dongia) {
		this.dongia = dongia;
	}
	
}
