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
@Table(name = "GIA")
public class Gia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@NotBlank(message = "Cannot be blank")
	@Column(name = "Id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="MaSanPham")
	SanPham gia_sanpham;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
//	@NotBlank(message = "Cannot be blank")
	@Column(name = "ThoiGian")
	private Date thoigian;
	
//	@NotBlank(message = "Cannot be blank")
	@Column(name = "Gia")
	private Double gia;

	public SanPham getGia_sanpham() {
		return gia_sanpham;
	}

	public void setGia_sanpham(SanPham gia_sanpham) {
		this.gia_sanpham = gia_sanpham;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getThoigian() {
		return thoigian;
	}

	public void setThoigian(Date thoigian) {
		this.thoigian = thoigian;
	}

	public Double getGia() {
		return gia;
	}

	public void setGia(Double gia) {
		this.gia = gia;
	}

}
