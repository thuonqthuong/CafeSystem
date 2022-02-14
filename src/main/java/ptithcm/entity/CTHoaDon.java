package ptithcm.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CT_HOADON")
public class CTHoaDon {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	
	@ManyToOne
	@JoinColumn(name="MaSanPham")
	SanPham cthoadon_sanpham;
	
	@ManyToOne
	@JoinColumn(name="MaHoaDon")
	HoaDon hoadon;
	
	@ManyToOne
	@JoinColumn(name="MaDonVi")
	DonVi cthoadon_donvi;
	
	private Float SoLuong;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public SanPham getCthoadon_sanpham() {
		return cthoadon_sanpham;
	}

	public void setCthoadon_sanpham(SanPham cthoadon_sanpham) {
		this.cthoadon_sanpham = cthoadon_sanpham;
	}

	public HoaDon getHoadon() {
		return hoadon;
	}

	public void setHoadon(HoaDon hoadon) {
		this.hoadon = hoadon;
	}

	public DonVi getCthoadon_donvi() {
		return cthoadon_donvi;
	}

	public void setCthoadon_donvi(DonVi cthoadon_donvi) {
		this.cthoadon_donvi = cthoadon_donvi;
	}

	public Float getSoLuong() {
		return SoLuong;
	}

	public void setSoLuong(Float soLuong) {
		SoLuong = soLuong;
	}

	
}
