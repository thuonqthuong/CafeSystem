package ptithcm.entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.transaction.Transactional;
@Entity
@Transactional
@Table(name="TAIKHOAN")
public class TaiKhoan {
	@Id
	@Column(name = "Username")
	private String username;

	@Column(name = "Password")
	private String password;
	
	@ManyToOne
	@JoinColumn(name="MaQuyen")
	Quyen quyen;
	
	@Column(name = "Stts")
	private Boolean stts;
	
	@OneToMany(mappedBy = "taikhoan", fetch = FetchType.EAGER, orphanRemoval = true, cascade = CascadeType.ALL)
	Collection<NhanVien> nhanvien;
	
	public Collection<NhanVien> getNhanViens() {
		return nhanvien;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
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
		return stts;
	}


	public void setStts(Boolean stts) {
		this.stts = stts;
	}

}
