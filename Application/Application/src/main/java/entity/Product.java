package entity;

public class Product {
	private int MaSach;
	private String TenSach;
	private String Anh;
	private int Price;
	private String NguoiSoHuu;
	private String MoTa;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(int maSach, String tenSach, String anh, int price, String nguoiSoHuu, String moTa) {
		MaSach = maSach;
		TenSach = tenSach;
		Anh = anh;
		Price = price;
		NguoiSoHuu = nguoiSoHuu;
		MoTa = moTa;
	}

	public String getMoTa() {
		return MoTa;
	}

	public void setMoTa(String moTa) {
		MoTa = moTa;
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

	public String getNguoiSoHuu() {
		return NguoiSoHuu;
	}

	public void serNguoiSoHuu(String nguoiSoHuu) {
	    NguoiSoHuu = nguoiSoHuu;
	}

	@Override
	public String toString() {
		return "Product [MaSach=" + MaSach + ", TenSach=" + TenSach + ", Anh=" + Anh + ", Price=" + Price + ", SoLuong="
				+ NguoiSoHuu + ", MoTa=" + MoTa + "]";
	}




}
