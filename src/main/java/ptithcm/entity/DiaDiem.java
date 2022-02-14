package ptithcm.entity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "DIADIEM")
public class DiaDiem {
	@Id
	private String MaDiaDiem;
	
//	@NotBlank(message = "Cannot be blank")
	private boolean TrangThai;
	
//	@NotBlank(message = "Cannot be blank")
	private String ViTri;
	
	@OneToMany(mappedBy="phieunhap_diadiem", fetch = FetchType.EAGER)
	Collection<PhieuNhap> phieunhap;
	
	@OneToMany(mappedBy="calamviec_diadiem", fetch = FetchType.EAGER)
	Collection<CaLamViec> calamviec;
	
	public Collection<PhieuNhap> getPhieuNhaps() {
		return phieunhap;
	}
	
	public Collection<CaLamViec> getCaLamViecs() {
		return calamviec;
	}

	public String getMaDiaDiem() {
		return MaDiaDiem;
	}

	public void setMaDiaDiem(String maDiaDiem) {
		MaDiaDiem = maDiaDiem;
	}

	public boolean isTrangThai() {
		return TrangThai;
	}

	public void setTrangThai(boolean trangThai) {
		TrangThai = trangThai;
	}

	public String getViTri() {
		return ViTri;
	}

	public void setViTri(String viTri) {
		ViTri = viTri;
	}

	public Collection<PhieuNhap> getPhieunhap() {
		return phieunhap;
	}

	public void setPhieunhap(Collection<PhieuNhap> phieunhap) {
		this.phieunhap = phieunhap;
	}

	public Collection<CaLamViec> getCalamviec() {
		return calamviec;
	}

	public void setCalamviec(Collection<CaLamViec> calamviec) {
		this.calamviec = calamviec;
	}
	
	
}
