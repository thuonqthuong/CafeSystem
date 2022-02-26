package ptithcm.entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
	@Column(name = "MaQuyen")
	private String maquyen;
	
//	@NotBlank(message = "Cannot be blank")
	@Column(name = "TenQuyen")
	private String tenquyen;
	
	@OneToMany(mappedBy="quyen", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	Collection<TaiKhoan> taikhoan;
	
	public Collection<TaiKhoan> getTaiKhoans() {
		return taikhoan;
	}

	public String getMaquyen() {
		return maquyen;
	}

	public void setMaquyen(String maquyen) {
		this.maquyen = maquyen;
	}

	public String getTenquyen() {
		return tenquyen;
	}

	public void setTenquyen(String tenquyen) {
		this.tenquyen = tenquyen;
	}

	public Collection<TaiKhoan> getTaikhoan() {
		return taikhoan;
	}

	public void setTaikhoan(Collection<TaiKhoan> taikhoan) {
		this.taikhoan = taikhoan;
	}
	
}
