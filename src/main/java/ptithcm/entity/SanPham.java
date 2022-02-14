package ptithcm.entity;

import java.util.Collection;

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
	private String MaSanPham;
	
	private String CongThuc;
	
//	@NotBlank(message = "Cannot be blank")
	private String TenSanPham;
	
	private String GhiChu;
	
	@OneToMany(mappedBy="cthoadon_sanpham", fetch = FetchType.EAGER)
	Collection<CTHoaDon> cthoadon;
	
	@OneToMany(mappedBy="ctnguyenlieu_sanpham", fetch = FetchType.EAGER)
	Collection<CTNguyenLieu> ctnguyenlieu;
	
	@OneToMany(mappedBy="gia_sanpham", fetch = FetchType.EAGER)
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
	public String getMaSanPham() {
		return MaSanPham;
	}
	public void setMaSanPham(String maSanPham) {
		MaSanPham = maSanPham;
	}
	public String getCongThuc() {
		return CongThuc;
	}
	public void setCongThuc(String congThuc) {
		CongThuc = congThuc;
	}
	public String getTenSanPham() {
		return TenSanPham;
	}
	public void setTenSanPham(String tenSanPham) {
		TenSanPham = tenSanPham;
	}
	public String getGhiChu() {
		return GhiChu;
	}
	public void setGhiChu(String ghiChu) {
		GhiChu = ghiChu;
	}
	
	
}
