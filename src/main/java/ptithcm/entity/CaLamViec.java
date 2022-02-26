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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "CALAMVIEC")
public class CaLamViec {
	@Id
	@Column(name = "MaCa")
	private String maca;
	
	@ManyToOne
	@JoinColumn(name="MaDiaDiem")
	DiaDiem calamviec_diadiem;

	@Temporal(TemporalType.TIME)
	@Column(name = "GioBatDau")
	private java.util.Date giobatdau;
	
	@Temporal(TemporalType.TIME)
	@Column(name = "GioKetThuc")
	private java.util.Date gioketthuc;
	
	@OneToMany(mappedBy="ctcalamviec_calamviec", fetch = FetchType.EAGER, orphanRemoval = true, cascade = CascadeType.ALL)
	Collection<CTCaLamViec> ctcalamviec;
	
	public Collection<CTCaLamViec> getCTCaLamViecs() {
		return ctcalamviec;
	}

	public DiaDiem getCalamviec_diadiem() {
		return calamviec_diadiem;
	}

	public void setCalamviec_diadiem(DiaDiem calamviec_diadiem) {
		this.calamviec_diadiem = calamviec_diadiem;
	}

	public Collection<CTCaLamViec> getCtcalamviec() {
		return ctcalamviec;
	}

	public void setCtcalamviec(Collection<CTCaLamViec> ctcalamviec) {
		this.ctcalamviec = ctcalamviec;
	}

	public String getMaca() {
		return maca;
	}

	public void setMaca(String maca) {
		this.maca = maca;
	}

	public java.util.Date getGiobatdau() {
		return giobatdau;
	}

	public void setGiobatdau(java.util.Date giobatdau) {
		this.giobatdau = giobatdau;
	}

	public java.util.Date getGioketthuc() {
		return gioketthuc;
	}

	public void setGioketthuc(java.util.Date gioketthuc) {
		this.gioketthuc = gioketthuc;
	}
	
}
