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
@Table(name = "GIA")
public class Gia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@NotBlank(message = "Cannot be blank")
	private Integer Id;
	
	@ManyToOne
	@JoinColumn(name="MaSanPham")
	SanPham gia_sanpham;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
//	@NotBlank(message = "Cannot be blank")
	private Date ThoiGian;
	
//	@NotBlank(message = "Cannot be blank")
	private Double Gia;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public SanPham getGia_sanpham() {
		return gia_sanpham;
	}

	public void setGia_sanpham(SanPham gia_sanpham) {
		this.gia_sanpham = gia_sanpham;
	}

	public Date getThoiGian() {
		return ThoiGian;
	}

	public void setThoiGian(Date thoiGian) {
		ThoiGian = thoiGian;
	}

	public Double getGia() {
		return Gia;
	}

	public void setGia(Double gia) {
		Gia = gia;
	}

	
	
}
