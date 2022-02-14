package ptithcm.entity;

import java.util.Collection;

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
	private String MaDonVi;
	
//	@NotBlank(message = "Cannot be blank")
	private String TenDonVi;
	
	private String GhiChu;
	
	@OneToMany(mappedBy="cthoadon_donvi", fetch = FetchType.EAGER)
	Collection<CTHoaDon> cthoadon;
	
	@OneToMany(mappedBy="nguyenlieu_donvi", fetch = FetchType.EAGER)
	Collection<NguyenLieu> nguyenlieu;
	
	@OneToMany(mappedBy="ctphieunhap_donvi", fetch = FetchType.EAGER)
	Collection<CTPhieuNhap> ctphieunhap;
	
	@OneToMany(mappedBy="ctnguyenlieu_donvi", fetch = FetchType.EAGER)
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

	public String getMaDonVi() {
		return MaDonVi;
	}

	public void setMaDonVi(String maDonVi) {
		MaDonVi = maDonVi;
	}

	public String getTenDonVi() {
		return TenDonVi;
	}

	public void setTenDonVi(String tenDonVi) {
		TenDonVi = tenDonVi;
	}

	public String getGhiChu() {
		return GhiChu;
	}

	public void setGhiChu(String ghiChu) {
		GhiChu = ghiChu;
	}
	
	
}
