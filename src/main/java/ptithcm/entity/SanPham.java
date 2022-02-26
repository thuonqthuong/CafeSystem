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
@Table(name = "SANPHAM")
public class SanPham {
	@Id
//	@NotBlank(message = "Cannot be blank")
	@Column(name = "MaSanPham")
	private String masanpham;
	
	@Column(name = "CongThuc")
	private String congthuc;
	
//	@NotBlank(message = "Cannot be blank")
	@Column(name = "TenSanPham")
	private String tensanpham;
	
	@Column(name = "GhiChu")
	private String ghichu;
	
	@OneToMany(mappedBy="cthoadon_sanpham", fetch = FetchType.EAGER, orphanRemoval = true, cascade = CascadeType.ALL)
	Collection<CTHoaDon> cthoadon;
	
	@OneToMany(mappedBy="ctnguyenlieu_sanpham", fetch = FetchType.EAGER, orphanRemoval = true, cascade = CascadeType.ALL)
	Collection<CTNguyenLieu> ctnguyenlieu;
	
	@OneToMany(mappedBy="gia_sanpham", fetch = FetchType.EAGER, orphanRemoval = true, cascade = CascadeType.ALL)
	Collection<Gia> gia;
	
	public Collection<CTHoaDon> getCTHoaDons() {
		return cthoadon;
	}
	public Collection<CTNguyenLieu> getCTNguyenLieus() {
		return ctnguyenlieu;
	}
	public Collection<Gia> getGias() {
		return gia;
	}
	public String getMasanpham() {
		return masanpham;
	}
	public void setMasanpham(String masanpham) {
		this.masanpham = masanpham;
	}
	public String getCongthuc() {
		return congthuc;
	}
	public void setCongthuc(String congthuc) {
		this.congthuc = congthuc;
	}
	public String getTensanpham() {
		return tensanpham;
	}
	public void setTensanpham(String tensanpham) {
		this.tensanpham = tensanpham;
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
	public Collection<CTNguyenLieu> getCtnguyenlieu() {
		return ctnguyenlieu;
	}
	public void setCtnguyenlieu(Collection<CTNguyenLieu> ctnguyenlieu) {
		this.ctnguyenlieu = ctnguyenlieu;
	}
	public Collection<Gia> getGia() {
		return gia;
	}
	public void setGia(Collection<Gia> gia) {
		this.gia = gia;
	}
	
}
