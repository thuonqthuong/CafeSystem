package ptithcm.entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
	@Column(name = "MaNguyenLieu")
	private String manguyenlieu;
	
	@ManyToOne
	@JoinColumn(name="MaDonVi")
	DonVi nguyenlieu_donvi;
	
//	@NotBlank(message = "Cannot be blank")
	@Column(name = "TenNguyenLieu")
	private String tennguyenlieu;
	
//	@NotBlank(message = "Cannot be blank")
	@Column(name = "SoLuong")
	private int soluong;
	
	@Column(name = "GhiChu")
	private String ghichu;
	
	@OneToMany(mappedBy="ctnguyenlieu_nguyenlieu", fetch = FetchType.EAGER, orphanRemoval = true, cascade = CascadeType.ALL)
	Collection<CTNguyenLieu> ctnguyenlieu;
	
	@OneToMany(mappedBy="ctphieunhap_nguyenlieu", fetch = FetchType.EAGER, orphanRemoval = true, cascade = CascadeType.ALL)
	Collection<CTPhieuNhap> ctphieunhap;
	
	public Collection<CTNguyenLieu> getCTNguyenLieus() {
		return ctnguyenlieu;
	}
	
	public Collection<CTPhieuNhap> getCTPhieuNhaps() {
		return ctphieunhap;
	}

	public DonVi getNguyenlieu_donvi() {
		return nguyenlieu_donvi;
	}

	public void setNguyenlieu_donvi(DonVi nguyenlieu_donvi) {
		this.nguyenlieu_donvi = nguyenlieu_donvi;
	}
	
	public String getManguyenlieu() {
		return manguyenlieu;
	}

	public void setManguyenlieu(String manguyenlieu) {
		this.manguyenlieu = manguyenlieu;
	}

	public String getTennguyenlieu() {
		return tennguyenlieu;
	}

	public void setTennguyenlieu(String tennguyenlieu) {
		this.tennguyenlieu = tennguyenlieu;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public String getGhichu() {
		return ghichu;
	}

	public void setGhichu(String ghichu) {
		this.ghichu = ghichu;
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
