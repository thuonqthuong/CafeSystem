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
@Table(name="HOADON")
public class HoaDon {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@NotBlank(message = "Cannot be blank")
	@Column(name = "MaHoaDon")
	private Integer mahoadon;
	
	@ManyToOne
	@JoinColumn(name="MaNV")
	NhanVien hoadon_nhanvien;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
//	@NotBlank(message = "Cannot be blank")
	@Column(name = "NgayLap")
	private Date ngaylap;
	
//	@NotBlank(message = "Cannot be blank")
	@Column(name = "TongTien")
	private Double tongtien;

	public NhanVien getHoadon_nhanvien() {
		return hoadon_nhanvien;
	}

	public void setHoadon_nhanvien(NhanVien hoadon_nhanvien) {
		this.hoadon_nhanvien = hoadon_nhanvien;
	}

	public Integer getMahoadon() {
		return mahoadon;
	}

	public void setMahoadon(Integer mahoadon) {
		this.mahoadon = mahoadon;
	}

	public Date getNgaylap() {
		return ngaylap;
	}

	public void setNgaylap(Date ngaylap) {
		this.ngaylap = ngaylap;
	}

	public Double getTongtien() {
		return tongtien;
	}

	public void setTongtien(Double tongtien) {
		this.tongtien = tongtien;
	}

}
