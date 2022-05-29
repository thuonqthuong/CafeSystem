package ptithcm.dto;

public class GiaDTO {
	private String masanpham;
	private String tensanpham;
	private String congthuc;
	private String ghichu;
	private Double gia;
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
	public GiaDTO(String masanpham, String tensanpham, String congthuc, String ghichu, Double gia) {
		super();
		this.masanpham = masanpham;
		this.tensanpham = tensanpham;
		this.congthuc = congthuc;
		this.ghichu = ghichu;
		this.gia = gia;
	}
	public GiaDTO() {
		super();
	}
	
}
