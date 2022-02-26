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
@Table(name = "DIADIEM")
public class DiaDiem {
	@Id
	@Column(name = "MaDiaDiem")
	private String madiadiem;
	
//	@NotBlank(message = "Cannot be blank")
	@Column(name = "TrangThai")
	private boolean trangthai;
	
//	@NotBlank(message = "Cannot be blank")
	@Column(name = "ViTri")
	private String vitri;
	
	@OneToMany(mappedBy="phieunhap_diadiem", fetch = FetchType.EAGER, orphanRemoval = true, cascade = CascadeType.ALL)
	Collection<PhieuNhap> phieunhap;
	
	@OneToMany(mappedBy="calamviec_diadiem", fetch = FetchType.EAGER, orphanRemoval = true, cascade = CascadeType.ALL)
	Collection<CaLamViec> calamviec;
	
	public Collection<PhieuNhap> getPhieuNhaps() {
		return phieunhap;
	}
	
	public Collection<CaLamViec> getCaLamViecs() {
		return calamviec;
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

	public String getMadiadiem() {
		return madiadiem;
	}

	public void setMadiadiem(String madiadiem) {
		this.madiadiem = madiadiem;
	}

	public boolean isTrangthai() {
		return trangthai;
	}

	public void setTrangthai(boolean trangthai) {
		this.trangthai = trangthai;
	}

	public String getVitri() {
		return vitri;
	}

	public void setVitri(String vitri) {
		this.vitri = vitri;
	}
	
	
}
