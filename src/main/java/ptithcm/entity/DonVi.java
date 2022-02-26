package ptithcm.entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "DONVI")
public class DonVi {
	@Id
//	@NotBlank(message = "Cannot be blank")
	@Column(name = "MaDonVi")
	private String madonvi;
	
//	@NotBlank(message = "Cannot be blank")
	@Column(name = "TenDonVi")
	private String tendonvi;
	
	@Column(name = "GhiChu")
	private String ghichu;
	
	@OneToMany(mappedBy="cthoadon_donvi", fetch = FetchType.EAGER, orphanRemoval = true, cascade = CascadeType.ALL)
	Collection<CTHoaDon> cthoadon;
	
	@OneToMany(mappedBy="nguyenlieu_donvi", fetch = FetchType.EAGER, orphanRemoval = true, cascade = CascadeType.ALL)
	Collection<NguyenLieu> nguyenlieu;
	
	@OneToMany(mappedBy="ctphieunhap_donvi", fetch = FetchType.EAGER)
	Collection<CTPhieuNhap> ctphieunhap;
	
	@OneToMany(mappedBy="ctnguyenlieu_donvi", fetch = FetchType.EAGER, orphanRemoval = true, cascade = CascadeType.ALL)
	Collection<CTNguyenLieu> ctnguyenlieu;
	
	public Collection<CTHoaDon> getCTHoaDons() {
		return cthoadon;
	}
	
	public Collection<NguyenLieu> getNguyenLieus() {
		return nguyenlieu;
	}
	
	public Collection<CTPhieuNhap> getCTPhieuNhaps() {
		return ctphieunhap;
	}
	
	public Collection<CTNguyenLieu> getCTNguyenLieus() {
		return ctnguyenlieu;
	}

	public String getMadonvi() {
		return madonvi;
	}

	public void setMadonvi(String madonvi) {
		this.madonvi = madonvi;
	}

	public String getTendonvi() {
		return tendonvi;
	}

	public void setTendonvi(String tendonvi) {
		this.tendonvi = tendonvi;
	}

	public String getGhichu() {
		return ghichu;
	}

	public void setGhichu(String ghichu) {
		this.ghichu = ghichu;
	}

	public Collection<CTHoaDon> getCthoadon() {
		return cthoadon;
	}

	public void setCthoadon(Collection<CTHoaDon> cthoadon) {
		this.cthoadon = cthoadon;
	}

	public Collection<NguyenLieu> getNguyenlieu() {
		return nguyenlieu;
	}

	public void setNguyenlieu(Collection<NguyenLieu> nguyenlieu) {
		this.nguyenlieu = nguyenlieu;
	}

	public Collection<CTPhieuNhap> getCtphieunhap() {
		return ctphieunhap;
	}

	public void setCtphieunhap(Collection<CTPhieuNhap> ctphieunhap) {
		this.ctphieunhap = ctphieunhap;
	}

	public Collection<CTNguyenLieu> getCtnguyenlieu() {
		return ctnguyenlieu;
	}

	public void setCtnguyenlieu(Collection<CTNguyenLieu> ctnguyenlieu) {
		this.ctnguyenlieu = ctnguyenlieu;
	}

	
}
