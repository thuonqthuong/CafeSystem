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
@Table(name = "CT_NGUYENLIEU")
public class CTNguyenLieu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@NotBlank(message = "Cannot be blank")
	@Column(name = "Id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="MaSanPham")
	SanPham ctnguyenlieu_sanpham;
	
	@ManyToOne
	@JoinColumn(name="MaNguyenLieu")
	NguyenLieu ctnguyenlieu_nguyenlieu;
	
	@ManyToOne
	@JoinColumn(name="MaDonVi")
	DonVi ctnguyenlieu_donvi;
	
	@Column(name = "SoLuong")
	private Float soluong;

	public NguyenLieu getCtnguyenlieu_nguyenlieu() {
		return ctnguyenlieu_nguyenlieu;
	}

	public void setCtnguyenlieu_nguyenlieu(NguyenLieu ctnguyenlieu_nguyenlieu) {
		this.ctnguyenlieu_nguyenlieu = ctnguyenlieu_nguyenlieu;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public SanPham getCtnguyenlieu_sanpham() {
		return ctnguyenlieu_sanpham;
	}

	public void setCtnguyenlieu_sanpham(SanPham ctnguyenlieu_sanpham) {
		this.ctnguyenlieu_sanpham = ctnguyenlieu_sanpham;
	}

	public DonVi getCtnguyenlieu_donvi() {
		return ctnguyenlieu_donvi;
	}

	public void setCtnguyenlieu_donvi(DonVi ctnguyenlieu_donvi) {
		this.ctnguyenlieu_donvi = ctnguyenlieu_donvi;
	}

	public Float getSoluong() {
		return soluong;
	}

	public void setSoluong(Float soluong) {
		this.soluong = soluong;
	}
	
	
}
