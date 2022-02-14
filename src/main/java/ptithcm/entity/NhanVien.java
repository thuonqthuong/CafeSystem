package ptithcm.entity;

import java.util.Collection;
import java.util.Date;

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
	private String MaNV;
	@ManyToOne
	@JoinColumn(name="Username") 
	TaiKhoan taikhoan;
	
	private String Ho;
//	@NotBlank(message = "Cannot be blank")
	private String Ten;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private Date NgaySinh;
	
	private String DiaChi;
	
//	@NotBlank(message = "Cannot be blank")
	private String GioiTinh;
	
//	@NotBlank(message = "Cannot be blank")
	private String Email;
	
//	@NotBlank(message = "Cannot be blank")
	private String SDT;
	
//	@NotBlank(message = "Cannot be blank")
	private String CMND;
	
	@OneToMany(mappedBy="chamluong_nhanvien", fetch = FetchType.EAGER)
	Collection<ChamLuong> chamluong;
	
	@OneToMany(mappedBy="hoadon_nhanvien", fetch = FetchType.EAGER)
	Collection<HoaDon> hoadon;
	
	@OneToMany(mappedBy="phieunhap_nhanvien", fetch = FetchType.EAGER)
	Collection<PhieuNhap> phieunhap;
	
	@OneToMany(mappedBy="ctcalamviec_nhanvien", fetch = FetchType.EAGER)
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
	public String getMaNV() {
		return MaNV;
	}
	public void setMaNV(String maNV) {
		MaNV = maNV;
	}
	public TaiKhoan getTaikhoan() {
		return taikhoan;
	}
	public void setTaikhoan(TaiKhoan taikhoan) {
		this.taikhoan = taikhoan;
	}
	public String getHo() {
		return Ho;
	}
	public void setHo(String ho) {
		Ho = ho;
	}
	public String getTen() {
		return Ten;
	}
	public void setTen(String ten) {
		Ten = ten;
	}
	public Date getNgaySinh() {
		return NgaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		NgaySinh = ngaySinh;
	}
	public String getDiaChi() {
		return DiaChi;
	}
	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}
	public String getGioiTinh() {
		return GioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		GioiTinh = gioiTinh;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getSDT() {
		return SDT;
	}
	public void setSDT(String sDT) {
		SDT = sDT;
	}
	public String getCMND() {
		return CMND;
	}
	public void setCMND(String cMND) {
		CMND = cMND;
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
	
}
