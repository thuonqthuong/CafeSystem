package ptithcm.entity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "NGUYENLIEU")
public class NguyenLieu {
	@Id
	private String MaNguyenLieu;
	
	@ManyToOne
	@JoinColumn(name="MaDonVi")
	DonVi nguyenlieu_donvi;
	
//	@NotBlank(message = "Cannot be blank")
	private String TenNguyenLieu;
	
//	@NotBlank(message = "Cannot be blank")
	private Float Soluong;
	
	private String GhiChu;
	
	@OneToMany(mappedBy="ctnguyenlieu_nguyenlieu", fetch = FetchType.EAGER)
	Collection<CTNguyenLieu> ctnguyenlieu;
	
	@OneToMany(mappedBy="ctphieunhap_nguyenlieu", fetch = FetchType.EAGER)
	Collection<CTPhieuNhap> ctphieunhap;
	
	public Collection<CTNguyenLieu> getCTNguyenLieus() {
		return ctnguyenlieu;
	}
	
	public Collection<CTPhieuNhap> getCTPhieuNhaps() {
		return ctphieunhap;
	}

	public String getMaNguyenLieu() {
		return MaNguyenLieu;
	}

	public void setMaNguyenLieu(String maNguyenLieu) {
		MaNguyenLieu = maNguyenLieu;
	}

	public DonVi getNguyenlieu_donvi() {
		return nguyenlieu_donvi;
	}

	public void setNguyenlieu_donvi(DonVi nguyenlieu_donvi) {
		this.nguyenlieu_donvi = nguyenlieu_donvi;
	}

	public String getTenNguyenLieu() {
		return TenNguyenLieu;
	}

	public void setTenNguyenLieu(String tenNguyenLieu) {
		TenNguyenLieu = tenNguyenLieu;
	}

	public Float getSoluong() {
		return Soluong;
	}

	public void setSoluong(Float soluong) {
		Soluong = soluong;
	}

	public String getGhiChu() {
		return GhiChu;
	}

	public void setGhiChu(String ghiChu) {
		GhiChu = ghiChu;
	}

	public Collection<CTNguyenLieu> getCtnguyenlieu() {
		return ctnguyenlieu;
	}

	public void setCtnguyenlieu(Collection<CTNguyenLieu> ctnguyenlieu) {
		this.ctnguyenlieu = ctnguyenlieu;
	}

	public Collection<CTPhieuNhap> getCtphieunhap() {
		return ctphieunhap;
	}

	public void setCtphieunhap(Collection<CTPhieuNhap> ctphieunhap) {
		this.ctphieunhap = ctphieunhap;
	}

	
}
