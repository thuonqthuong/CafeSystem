package ptithcm.dto;

public class checkoutDTO {
	private String masanpham;
	private String tensanpham;
	private String congthuc;
	private String ghichu;
	private Double gia;
	private Double tongtien;
	private int soluong;
	public String getMasanpham() {
		return masanpham;
	}
	public void setMasanpham(String masanpham) {
		this.masanpham = masanpham;
	}
	public String getTensanpham() {
		return tensanpham;
	}
	public void setTensanpham(String tensanpham) {
		this.tensanpham = tensanpham;
	}
	public String getCongthuc() {
		return congthuc;
	}
	public void setCongthuc(String congthuc) {
		this.congthuc = congthuc;
	}
	public String getGhichu() {
		return ghichu;
	}
	public void setGhichu(String ghichu) {
		this.ghichu = ghichu;
	}
	public Double getGia() {
		return gia;
	}
	public void setGia(Double gia) {
		this.gia = gia;
	}
	public Double getTongtien() {
		return tongtien;
	}
	public void setTongtien(Double tongtien) {
		this.tongtien = tongtien;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public checkoutDTO(String masanpham, String tensanpham, String congthuc, String ghichu, Double gia, Double tongtien,
			int soluong) {
		super();
		this.masanpham = masanpham;
		this.tensanpham = tensanpham;
		this.congthuc = congthuc;
		this.ghichu = ghichu;
		this.gia = gia;
		this.tongtien = tongtien;
		this.soluong = soluong;
	}
	public checkoutDTO() {
		super();
	}
	
}
