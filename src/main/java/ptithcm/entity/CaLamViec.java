package ptithcm.entity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "CALAMVIEC")
public class CaLamViec {
	@Id
	private String MaCa;
	
	@ManyToOne
	@JoinColumn(name="MaDiaDiem")
	DiaDiem calamviec_diadiem;

	@Temporal(TemporalType.TIME)
	private java.util.Date GioBatDau;
	
	@Temporal(TemporalType.TIME)
	private java.util.Date GioKetThuc;
	
	@OneToMany(mappedBy="ctcalamviec_calamviec", fetch = FetchType.EAGER)
	Collection<CTCaLamViec> ctcalamviec;
	
	public Collection<CTCaLamViec> getCTCaLamViecs() {
		return ctcalamviec;
	}

	public String getMaCa() {
		return MaCa;
	}

	public void setMaCa(String maCa) {
		MaCa = maCa;
	}

	public DiaDiem getCalamviec_diadiem() {
		return calamviec_diadiem;
	}

	public void setCalamviec_diadiem(DiaDiem calamviec_diadiem) {
		this.calamviec_diadiem = calamviec_diadiem;
	}

	public java.util.Date getGioBatDau() {
		return GioBatDau;
	}

	public void setGioBatDau(java.util.Date gioBatDau) {
		GioBatDau = gioBatDau;
	}

	public java.util.Date getGioKetThuc() {
		return GioKetThuc;
	}

	public void setGioKetThuc(java.util.Date gioKetThuc) {
		GioKetThuc = gioKetThuc;
	}

	public Collection<CTCaLamViec> getCtcalamviec() {
		return ctcalamviec;
	}

	public void setCtcalamviec(Collection<CTCaLamViec> ctcalamviec) {
		this.ctcalamviec = ctcalamviec;
	}
	
}
