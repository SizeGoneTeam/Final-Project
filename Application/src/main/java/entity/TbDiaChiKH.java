package entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tbDiaChiKH database table.
 * 
 */
@Entity
@Table(name="tbDiaChiKH")
@NamedQuery(name="TbDiaChiKH.findAll", query="SELECT t FROM TbDiaChiKH t")
public class TbDiaChiKH implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID")
	private int id;

	@Column(name="DiaChi")
	private String diaChi;

	@Column(name="HoVaTen")
	private String hoVaTen;

	@Column(name="SDT")
	private String sdt;

	@Column(name="TenPhuong")
	private String tenPhuong;

	@Column(name="TenQuan")
	private String tenQuan;
	
	//bi-directional many-to-one association to TbAccountNew
	@ManyToOne
	@JoinColumn(name="MaTK")
	private TbAccount tbAccount;

	//bi-directional many-to-one association to TbTinhThanh
	@ManyToOne
	@JoinColumn(name="IDTinh")
	private TbTinhThanh tbTinhThanh;
	
    @Column(name="MacDinh")
    private int macDinh;

	public TbDiaChiKH() {
	    this.macDinh = 1;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDiaChi() {
		return this.diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getHoVaTen() {
		return this.hoVaTen;
	}

	public void setHoVaTen(String hoVaTen) {
		this.hoVaTen = hoVaTen;
	}

	public String getSdt() {
		return this.sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getTenPhuong() {
		return this.tenPhuong;
	}

	public void setTenPhuong(String tenPhuong) {
		this.tenPhuong = tenPhuong;
	}

	public String getTenQuan() {
		return this.tenQuan;
	}

	public void setTenQuan(String tenQuan) {
		this.tenQuan = tenQuan;
	}

	public TbAccount getTbAccount() {
		return this.tbAccount;
	}

	public void setTbAccount(TbAccount tbAccount) {
		this.tbAccount = tbAccount;
	}

	public TbTinhThanh getTbTinhThanh() {
		return this.tbTinhThanh;
	}

	public void setTbTinhThanh(TbTinhThanh tbTinhThanh) {
		this.tbTinhThanh = tbTinhThanh;
	}

    public int getMacDinh() {
        return macDinh;
    }

    public void setMacDinh(int macDinh) {
        this.macDinh = macDinh;
    }
		

}