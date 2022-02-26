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
@Table(name = "CT_CALAMVIEC")
public class CTCaLamViec {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@NotBlank(message = "Cannot be blank")
	@Column(name = "Id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="MaNV")
	NhanVien ctcalamviec_nhanvien;
	
	@ManyToOne
	@JoinColumn(name="MaCa")
	CaLamViec ctcalamviec_calamviec;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
//	@NotBlank(message = "Cannot be blank")
	@Column(name = "Ngay")
	private Date ngay;

	public NhanVien getCtcalamviec_nhanvien() {
		return ctcalamviec_nhanvien;
	}

	public void setCtcalamviec_nhanvien(NhanVien ctcalamviec_nhanvien) {
		this.ctcalamviec_nhanvien = ctcalamviec_nhanvien;
	}

	public CaLamViec getCtcalamviec_calamviec() {
		return ctcalamviec_calamviec;
	}

	public void setCtcalamviec_calamviec(CaLamViec ctcalamviec_calamviec) {
		this.ctcalamviec_calamviec = ctcalamviec_calamviec;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getNgay() {
		return ngay;
	}

	public void setNgay(Date ngay) {
		this.ngay = ngay;
	}
	
}
