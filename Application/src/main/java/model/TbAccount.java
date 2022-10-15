package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tbAccount database table.
 * 
 */
@Entity
@Table(name="tbAccount")
@NamedQuery(name="TbAccount.findAll", query="SELECT t FROM TbAccount t")
public class TbAccount implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MaTK")
	private int maTK;

	@Column(name="Email")
	private String email;

	@Column(name="HoTen")
	private String hoTen;

	@Column(name="NamSinh")
	private int namSinh;

	@Column(name="NgaySinh")
	private int ngaySinh;

	@Column(name="Phone")
	private String phone;

	private String PWord;

	@Column(name="Sao")
	private float sao;

	@Column(name="ThangSinh")
	private int thangSinh;

	@Column(name="Tien")
	private double tien;

	private String UName;

	public TbAccount() {
	}
	



    public TbAccount(String uName,String pWord) {
        super();
        PWord = pWord;
        UName = uName;
    }




    public int getMaTK() {
		return this.maTK;
	}

	public void setMaTK(int maTK) {
		this.maTK = maTK;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHoTen() {
		return this.hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public int getNamSinh() {
		return this.namSinh;
	}

	public void setNamSinh(int namSinh) {
		this.namSinh = namSinh;
	}

	public int getNgaySinh() {
		return this.ngaySinh;
	}

	public void setNgaySinh(int ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPWord() {
		return this.PWord;
	}

	public void setPWord(String PWord) {
		this.PWord = PWord;
	}

	public float getSao() {
		return this.sao;
	}

	public void setSao(float sao) {
		this.sao = sao;
	}

	public int getThangSinh() {
		return this.thangSinh;
	}

	public void setThangSinh(int thangSinh) {
		this.thangSinh = thangSinh;
	}

	public double getTien() {
		return this.tien;
	}

	public void setTien(double tien) {
		this.tien = tien;
	}

	public String getUName() {
		return this.UName;
	}

	public void setUName(String UName) {
		this.UName = UName;
	}


    @Override
    public String toString() {
        return "TbAccount [maTK=" + maTK + ", email=" + email + ", hoTen=" + hoTen + ", namSinh=" + namSinh
                + ", ngaySinh=" + ngaySinh + ", phone=" + phone + ", PWord=" + PWord + ", sao=" + sao + ", thangSinh="
                + thangSinh + ", tien=" + tien + ", UName=" + UName + "]";
    }
	

}