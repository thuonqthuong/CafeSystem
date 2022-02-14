package ptithcm.entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="QUYEN")
public class Quyen {
	@Id
//	@NotBlank(message = "Cannot be blank")
	private String MaQuyen;
	
//	@NotBlank(message = "Cannot be blank")
	private String TenQuyen;
	
	@OneToMany(mappedBy="quyen", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	Collection<TaiKhoan> taikhoan;
	
	public String getMaQuyen() {
		return MaQuyen;
	}
	public void setMaQuyen(String maQuyen) {
		MaQuyen = maQuyen;
	}
	public String getTenQuyen() {
		return TenQuyen;
	}
	public void setTenQuyen(String tenQuyen) {
		TenQuyen = tenQuyen;
	}
	public Collection<TaiKhoan> getTaiKhoans() {
		return taikhoan;
	}
}
