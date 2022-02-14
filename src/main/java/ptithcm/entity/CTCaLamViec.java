package ptithcm.entity;

import java.util.Date;

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
	private Integer Id;
	
	@ManyToOne
	@JoinColumn(name="MaNV")
	NhanVien ctcalamviec_nhanvien;
	
	@ManyToOne
	@JoinColumn(name="MaCa")
	CaLamViec ctcalamviec_calamviec;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
//	@NotBlank(message = "Cannot be blank")
	private Date Ngay;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

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

	public Date getNgay() {
		return Ngay;
	}

	public void setNgay(Date ngay) {
		Ngay = ngay;
	}

	
}
