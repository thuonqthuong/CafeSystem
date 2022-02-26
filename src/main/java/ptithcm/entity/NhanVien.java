package ptithcm.entity;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="NHANVIEN")
public class NhanVien {
	@Id
	@Column(name = "MaNV")
	private String manv;
	
	@ManyToOne
	@JoinColumn(name="Username") 
	TaiKhoan taikhoan;
	
	@Column(name = "Ho")
	private String ho;
	
//	@NotBlank(message = "Cannot be blank")
	@Column(name = "Ten")
	private String ten;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	@Column(name = "NgaySinh")
	private Date ngaysinh;
	
	@Column(name = "DiaChi")
	private String diachi;
	
//	@NotBlank(message = "Cannot be blank")
	@Column(name = "GioiTinh")
	private String gioitinh;
	
//	@NotBlank(message = "Cannot be blank")
	@Column(name = "Email")
	private String email;
	
//	@NotBlank(message = "Cannot be blank")
	@Column(name = "SDT")
	private String sdt;
	
//	@NotBlank(message = "Cannot be blank")
	@Column(name = "CMND")
	private String cmnd;
	
	@OneToMany(mappedBy="chamluong_nhanvien", fetch = FetchType.EAGER, orphanRemoval = true, cascade = CascadeType.ALL)
	Collection<ChamLuong> chamluong;
	
	@OneToMany(mappedBy="hoadon_nhanvien", fetch = FetchType.EAGER, orphanRemoval = true, cascade = CascadeType.ALL)
	Collection<HoaDon> hoadon;
	
	@OneToMany(mappedBy="phieunhap_nhanvien", fetch = FetchType.EAGER, orphanRemoval = true, cascade = CascadeType.ALL)
	Collection<PhieuNhap> phieunhap;
	
	@OneToMany(mappedBy="ctcalamviec_nhanvien", fetch = FetchType.EAGER, orphanRemoval = true, cascade = CascadeType.ALL)
	Collection<CTCaLamViec> ctcalamviec;
	
	public Collection<ChamLuong> getChamLuongs() {
		return chamluong;
	}
	public Collection<HoaDon> getHoaDons() {
		return hoadon;
	}
	public Collection<PhieuNhap> getPhieuNhaps() {
		return phieunhap;
	}
	public Collection<CTCaLamViec> getCTCaLamViecs() {
		return ctcalamviec;
	}
	public TaiKhoan getTaikhoan() {
		return taikhoan;
	}
	public void setTaikhoan(TaiKhoan taikhoan) {
		this.taikhoan = taikhoan;
	}
	public Collection<ChamLuong> getChamluong() {
		return chamluong;
	}
	public void setChamluong(Collection<ChamLuong> chamluong) {
		this.chamluong = chamluong;
	}
	public Collection<HoaDon> getHoadon() {
		return hoadon;
	}
	public void setHoadon(Collection<HoaDon> hoadon) {
		this.hoadon = hoadon;
	}
	public Collection<PhieuNhap> getPhieunhap() {
		return phieunhap;
	}
	public void setPhieunhap(Collection<PhieuNhap> phieunhap) {
		this.phieunhap = phieunhap;
	}
	public Collection<CTCaLamViec> getCtcalamviec() {
		return ctcalamviec;
	}
	public void setCtcalamviec(Collection<CTCaLamViec> ctcalamviec) {
		this.ctcalamviec = ctcalamviec;
	}
	public String getManv() {
		return manv;
	}
	public void setManv(String manv) {
		this.manv = manv;
	}
	public String getHo() {
		return ho;
	}
	public void setHo(String ho) {
		this.ho = ho;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public Date getNgaysinh() {
		return ngaysinh;
	}
	public void setNgaysinh(Date ngaysinh) {
		this.ngaysinh = ngaysinh;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public String getGioitinh() {
		return gioitinh;
	}
	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getCmnd() {
		return cmnd;
	}
	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}
	
}
