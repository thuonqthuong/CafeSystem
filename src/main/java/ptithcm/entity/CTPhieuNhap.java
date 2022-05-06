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
	private int id;

	@ManyToOne
	@JoinColumn(name = "MaNguyenLieu")
	NguyenLieu ctphieunhap_nguyenlieu;

	@ManyToOne
	@JoinColumn(name = "MaPhieuNhap")
	PhieuNhap phieunhap;

	@ManyToOne
	@JoinColumn(name = "MaDonVi")
	DonVi ctphieunhap_donvi;

	@Column(name = "SoLuong")
	private float soluong;

	@Column(name = "DonGia")
	private double dongia;
	
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getSoluong() {
		return soluong;
	}

	public void setSoluong(float soluong) {
		this.soluong = soluong;
	}

	public double getDongia() {
		return dongia;
	}

	public void setDongia(double dongia) {
		this.dongia = dongia;
	}

}
