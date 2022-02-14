package ptithcm.entity;

import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.transaction.Transactional;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Transactional
@Table(name="TAIKHOAN")
public class TaiKhoan {
	@Id
//	@NotBlank(message = "Cannot be blank")
	private String Username;

//	@NotBlank(message = "Cannot be blank")
	private String Password;
	
	@ManyToOne
	@Cascade(CascadeType.SAVE_UPDATE)
	@JoinColumn(name="MaQuyen")
	Quyen quyen;
	
	private Boolean Stts;
	
	@OneToMany(mappedBy = "taikhoan", fetch = FetchType.EAGER)
	Collection<NhanVien> nhanvien;
	
	public Collection<NhanVien> getNhanViens() {
		return nhanvien;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public Quyen getQuyen() {
		return quyen;
	}

	public void setQuyen(Quyen quyen) {
		this.quyen = quyen;
	}

	public Collection<NhanVien> getNhanvien() {
		return nhanvien;
	}

	public void setNhanvien(Collection<NhanVien> nhanvien) {
		this.nhanvien = nhanvien;
	}

	public Boolean getStts() {
		return Stts;
	}

	public void setStts(Boolean stts) {
		Stts = stts;
	}

	
}
