package entity;

public class Product {
	private int MaSach;
	private String TenSach;
	private String Anh;
	private int Price;
	private int SoLuong;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(int maSach, String tenSach, String anh, int price, int soLuong) {
		MaSach = maSach;
		TenSach = tenSach;
		Anh = anh;
		Price = price;
		SoLuong = soLuong;
	}

	public int getMaSach() {
		return MaSach;
	}

	public void setMaSach(int maSach) {
		MaSach = maSach;
	}

	public String getTenSach() {
		return TenSach;
	}

	public void setTenSach(String tenSach) {
		TenSach = tenSach;
	}

	public String getAnh() {
		return Anh;
	}

	public void setAnh(String anh) {
		Anh = anh;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(int price) {
		Price = price;
	}

	public int getSoLuong() {
		return SoLuong;
	}

	public void setSoLuong(int soLuong) {
		SoLuong = soLuong;
	}

	@Override
	public String toString() {
		return "Product [MaSach=" + MaSach + ", TenSach=" + TenSach + ", Anh=" + Anh + ", Price=" + Price + ", SoLuong="
				+ SoLuong + "]";
	}


}
