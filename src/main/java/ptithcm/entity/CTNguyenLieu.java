package ptithcm.entity;

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
	private Integer Id;
	
	@ManyToOne
	@JoinColumn(name="MaSanPham")
	SanPham ctnguyenlieu_sanpham;
	
	@ManyToOne
	@JoinColumn(name="MaNguyenLieu")
	NguyenLieu ctnguyenlieu_nguyenlieu;
	
	@ManyToOne
	@JoinColumn(name="MaDonVi")
	DonVi ctnguyenlieu_donvi;
	
	private Float SoLuong;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public SanPham getCtnguyenlieu_sanpham() {
		return ctnguyenlieu_sanpham;
	}

	public void setCtnguyenlieu_sanpham(SanPham ctnguyenlieu_sanpham) {
		this.ctnguyenlieu_sanpham = ctnguyenlieu_sanpham;
	}

	public NguyenLieu getCtnguyenlieu_nguyenlieu() {
		return ctnguyenlieu_nguyenlieu;
	}

	public void setCtnguyenlieu_nguyenlieu(NguyenLieu ctnguyenlieu_nguyenlieu) {
		this.ctnguyenlieu_nguyenlieu = ctnguyenlieu_nguyenlieu;
	}

	public Float getSoLuong() {
		return SoLuong;
	}

	public void setSoLuong(Float soLuong) {
		SoLuong = soLuong;
	}

}
