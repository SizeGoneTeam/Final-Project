package entity;

public class Account {
	private int maTK;
	private String hoTen;
	private String phone;
	private String email;
	private int ngaySinh;
	private int thangSinh;
	private int namSinh;
	private String uName;
	private String pWord;
	private double tien;
	private float sao;
	
	public Account() {
        maTK = 0;
        hoTen = "";
        phone = "";
        email = "";
        ngaySinh = 0;
        thangSinh = 0;
        namSinh = 0;
        uName = "";
        pWord = "";
        tien = 0;
        sao = 0;
    }
	
    public Account(int maTK, String hoTen, String phone, String email, int ngaySinh, int thangSinh, int namSinh, String uName, String pWord, double tien,
            float sao) {
        super();
        this.maTK = maTK;
        this.hoTen = hoTen;
        this.phone = phone;
        this.email = email;
        this.ngaySinh = ngaySinh;
        this.thangSinh = thangSinh;
        this.namSinh = namSinh;
        this.uName = uName;
        this.pWord = pWord;
        this.tien = tien;
        this.sao = sao;
    }

    public int getMaTK() {
        return maTK;
    }

    public void setMaTK(int maTK) {
        this.maTK = maTK;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getpWord() {
        return pWord;
    }

    public void setpWord(String pWord) {
        this.pWord = pWord;
    }

    public double getTien() {
        return tien;
    }

    public void setTien(double tien) {
        this.tien = tien;
    }

    public float getSao() {
        return sao;
    }

    public void setSao(float sao) {
        this.sao = sao;
    }
    
    

    public int getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(int ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public int getThangSinh() {
        return thangSinh;
    }

    public void setThangSinh(int thangSinh) {
        this.thangSinh = thangSinh;
    }

    public int getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }

    @Override
    public String toString() {
        return "Account [maTK=" + maTK + ", hoTen=" + hoTen + ", phone=" + phone + ", email=" + email + ", uName="
                + uName + ", pWord=" + pWord + ", tien=" + tien + ", sao=" + sao + "]";
    }
    
}
