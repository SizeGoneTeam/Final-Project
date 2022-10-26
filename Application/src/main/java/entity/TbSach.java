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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
    
    @OneToOne(mappedBy = "maSach")
    private TbPhienDauGia phienDauGia;
	
	//bi-directional many-to-one association to TbLichSuXem
	@OneToMany(mappedBy="tbSach")
	private List<TbLichSuXem> tbLichSuXems;

	

    //bi-directional many-to-many association to TbTheLoai
    @ManyToMany(mappedBy="tbSaches")
    
    private List<TbTheLoai> tbTheLoais;
    
    public TbSach() {
        this.anh = null;
        this.donGia = BigInteger.valueOf(0);
        this.moTa = null;
        this.tenSach = null;
        nguoiSoHuu = 2;
    }
    public TbSach(String anh, BigInteger donGia, String moTa, String tenSach) {
        this.anh = anh;
        this.donGia = donGia;
        this.moTa = moTa;
        this.tenSach = tenSach;
        nguoiSoHuu = 2;
    }
    public TbPhienDauGia getPhienDauGia() {
        return phienDauGia;
    }
    

    public void setPhienDauGia(TbPhienDauGia phienDauGia) {
        this.phienDauGia = phienDauGia;
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

	public List<TbLichSuXem> getTbLichSuXems() {
		return this.tbLichSuXems;
	}

	public void setTbLichSuXems(List<TbLichSuXem> tbLichSuXems) {
		this.tbLichSuXems = tbLichSuXems;
	}

	public TbLichSuXem addTbLichSuXem(TbLichSuXem tbLichSuXem) {
		getTbLichSuXems().add(tbLichSuXem);
		tbLichSuXem.setTbSach(this);

		return tbLichSuXem;
	}

	public TbLichSuXem removeTbLichSuXem(TbLichSuXem tbLichSuXem) {
		getTbLichSuXems().remove(tbLichSuXem);
		tbLichSuXem.setTbSach(null);

		return tbLichSuXem;
	}

    public List<TbTheLoai> getTbTheLoais() {
        return this.tbTheLoais;
    }

    public void setTbTheLoais(List<TbTheLoai> tbTheLoais) {
        this.tbTheLoais = tbTheLoais;
    }
    
    @Override
    public String toString() {
        return "TbSach [maSach=" + maSach + ", anh=" + anh + ", donGia=" + donGia + ", moTa=" + moTa + ", nguoiSoHuu="
                + nguoiSoHuu + ", tenSach=" + tenSach + ", phienDauGia=" + phienDauGia + ", tbLichSuXems="
                + tbLichSuXems + ", tbTheLoais=" + tbTheLoais + "]";
    }

}