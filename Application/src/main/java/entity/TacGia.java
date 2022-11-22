package entity;

public class TacGia {
	private int MaTacGia;
	private String TenTacGia;
	public TacGia(int maTacGia, String tenTacGia) {
		MaTacGia = maTacGia;
		TenTacGia = tenTacGia;
	}
	public int getMaTacGia() {
		return MaTacGia;
	}
	public void setMaTacGia(int maTacGia) {
		MaTacGia = maTacGia;
	}
	public String getTenTacGia() {
		return TenTacGia;
	}
	public void setTenTacGia(String tenTacGia) {
		TenTacGia = tenTacGia;
	}
	@Override
	public String toString() {
		return "TacGia [MaTacGia=" + MaTacGia + ", TenTacGia=" + TenTacGia + "]";
	}
}
