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
@Table(name="HOADON")
public class HoaDon {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@NotBlank(message = "Cannot be blank")
	private Integer MaHoaDon;
	
	@ManyToOne
	@JoinColumn(name="MaNV")
	NhanVien hoadon_nhanvien;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
//	@NotBlank(message = "Cannot be blank")
	private Date NgayLap;
	
//	@NotBlank(message = "Cannot be blank")
	private Double TongTien;

	public Integer getMaHoaDon() {
		return MaHoaDon;
	}

	public void setMaHoaDon(Integer maHoaDon) {
		MaHoaDon = maHoaDon;
	}

	public NhanVien getHoadon_nhanvien() {
		return hoadon_nhanvien;
	}

	public void setHoadon_nhanvien(NhanVien hoadon_nhanvien) {
		this.hoadon_nhanvien = hoadon_nhanvien;
	}

	public Date getNgayLap() {
		return NgayLap;
	}

	public void setNgayLap(Date ngayLap) {
		NgayLap = ngayLap;
	}

	public Double getTongTien() {
		return TongTien;
	}

	public void setTongTien(Double tongTien) {
		TongTien = tongTien;
	}

	
}
