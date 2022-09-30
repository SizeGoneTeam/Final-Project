package entity;

public class BidHistory {
	private int mabid;
	private String tenKH;
	private int price;
	private int maSach;
	private String ngayTao;
	
	
	public BidHistory(int mabid, String tenKH, int price, int maSach, String ngayTao) {
		this.mabid = mabid;
		this.tenKH = tenKH;
		this.price = price;
		this.maSach = maSach;
		this.ngayTao = ngayTao;
	}
	public int getMaSach() {
		return maSach;
	}
	public void setMaSach(int maSach) {
		this.maSach = maSach;
	}
	public String getNgayTao() {
		return ngayTao;
	}
	public void setNgayTao(String ngayTao) {
		this.ngayTao = ngayTao;
	}

	public int getMabid() {
		return mabid;
	}
	public void setMabid(int mabid) {
		this.mabid = mabid;
	}
	public String getTenKH() {
		return tenKH;
	}
	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "BidHistory [mabid=" + mabid + ", tenKH=" + tenKH + ", price=" + price + ", maSach=" + maSach
				+ ", ngayTao=" + ngayTao + "]";
	}

}
