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
@Table(name = "CT_HOADON")
public class CTHoaDon {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="MaSanPham")
	SanPham cthoadon_sanpham;
	
	@ManyToOne
	@JoinColumn(name="MaHoaDon")
	HoaDon hoadon;
//	
//	@ManyToOne
//	@JoinColumn(name="MaDonVi")
//	DonVi cthoadon_donvi;
	
	@Column(name = "SoLuong")
	private int soluong;

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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	
}
