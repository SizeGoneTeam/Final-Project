package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;


/**
 * The persistent class for the tbSach database table.
 * 
 */
@Entity
@Table(name="tbSach")
@NamedQuery(name="TbSach.findAll", query="SELECT t FROM TbSach t")
public class TbSach implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MaSach")
	private int maSach;

	@Column(name="Anh")
	private String anh;

	@Column(name="DonGia")
	private BigInteger donGia;

	@Lob
	@Column(name="MoTa")
	private String moTa;

	@Column(name="NguoiSoHuu")
	private int nguoiSoHuu;

	@Column(name="TenSach")
	private String tenSach;

    //bi-directional many-to-many association to TbTheLoai
    @ManyToMany(mappedBy="tbSaches")
    
    private List<TbTheLoai> tbTheLoais;

	public TbSach() {
	}

	public int getMaSach() {
		return this.maSach;
	}

	public void setMaSach(int maSach) {
		this.maSach = maSach;
	}

	public String getAnh() {
		return this.anh;
	}

	public void setAnh(String anh) {
		this.anh = anh;
	}

	public BigInteger getDonGia() {
		return this.donGia;
	}

	public void setDonGia(BigInteger donGia) {
		this.donGia = donGia;
	}

	public String getMoTa() {
		return this.moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public int getNguoiSoHuu() {
		return this.nguoiSoHuu;
	}

	public void setNguoiSoHuu(int nguoiSoHuu) {
		this.nguoiSoHuu = nguoiSoHuu;
	}

	public String getTenSach() {
		return this.tenSach;
	}

	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}

    public List<TbTheLoai> getTbTheLoais() {
        return this.tbTheLoais;
    }

    public void setTbTheLoais(List<TbTheLoai> tbTheLoais) {
        this.tbTheLoais = tbTheLoais;
    }

}