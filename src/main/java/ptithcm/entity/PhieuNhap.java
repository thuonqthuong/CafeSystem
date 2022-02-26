package ptithcm.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "PHIEUNHAP")
public class PhieuNhap {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@NotBlank(message = "Cannot be blank")
	@Column(name = "MaPhieuNhap")
	private Integer maphieunhap;
	
	@ManyToOne
	@JoinColumn(name="MaNV")
	NhanVien phieunhap_nhanvien;
	
	@ManyToOne
	@JoinColumn(name="maDiaDiem")
	DiaDiem phieunhap_diadiem;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
//	@NotBlank(message = "Cannot be blank")
	@Column(name = "NgayGio")
	private Date ngaygio;
	
	public NhanVien getPhieunhap_nhanvien() {
		return phieunhap_nhanvien;
	}

	public void setPhieunhap_nhanvien(NhanVien phieunhap_nhanvien) {
		this.phieunhap_nhanvien = phieunhap_nhanvien;
	}

	public DiaDiem getPhieunhap_diadiem() {
		return phieunhap_diadiem;
	}

	public void setPhieunhap_diadiem(DiaDiem phieunhap_diadiem) {
		this.phieunhap_diadiem = phieunhap_diadiem;
	}

	public Integer getMaphieunhap() {
		return maphieunhap;
	}

	public void setMaphieunhap(Integer maphieunhap) {
		this.maphieunhap = maphieunhap;
	}

	public Date getNgaygio() {
		return ngaygio;
	}

	public void setNgaygio(Date ngaygio) {
		this.ngaygio = ngaygio;
	}

}
