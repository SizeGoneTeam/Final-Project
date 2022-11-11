package entity;

import java.io.Serializable;
import javax.persistence.*;

import java.math.BigInteger;
import java.util.ArrayList;
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

    @Column(name="TinhTrang")
    private String tinhTrang;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="NguoiSoHuu")
    private TbAccount nguoiSoHuu;

	@Column(name="TenSach")
	private String tenSach;
    
    @OneToOne(mappedBy = "maSach", cascade = CascadeType.ALL)
    private TbPhienDauGia phienDauGia;
    
	//bi-directional many-to-one association to TbLichSuXem
	@OneToMany(mappedBy="tbSach")
	private List<TbLichSuXem> tbLichSuXems;

	//bi-directional many-to-one association to TbYeuThich
    @OneToMany(mappedBy="tbSach")
    private List<TbYeuThich> TbYeuThichs;
	

    //bi-directional many-to-many association to TbTheLoai
    @ManyToMany(cascade = {CascadeType.MERGE})
    @JoinTable(
            name = "tbThuocTheLoai",
            joinColumns = @JoinColumn(name = "MaSach"),
            inverseJoinColumns = @JoinColumn(name ="MaTheLoai")
            )
    private List<TbTheLoai> tbTheLoais;
    
    @ManyToMany(cascade = {CascadeType.MERGE})
    @JoinTable(
            name = "tbViet",
            joinColumns = @JoinColumn(name = "MaSach"),
            inverseJoinColumns = @JoinColumn(name ="MaTacGia")
            )
    private List<TbTacGia> tbTacGias;
    
    @OneToMany(mappedBy = "tbSach")
    private List<TbGioHang> gioHang;
    
    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    public TbSach() {
        this.anh = null;
        this.donGia = BigInteger.valueOf(0);
        this.moTa = null;
        this.tenSach = null;
    }
    public TbSach(String anh, BigInteger donGia, String moTa, String tenSach, String tinhTrang) {
        this.anh = anh;
        this.donGia = donGia;
        this.moTa = moTa;
        this.tenSach = tenSach;
        this.tinhTrang = tinhTrang;
        
    }
    public String getTinhTrang() {
        return tinhTrang;
    }
    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
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

	public List<TbYeuThich> getTbYeuThichs() {
        return TbYeuThichs;
    }
    public void setTbYeuThichs(List<TbYeuThich> tbYeuThichs) {
        TbYeuThichs = tbYeuThichs;
    }
    public void setMoTa(String moTa) {
		this.moTa = moTa;
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
    
    public void addTheLoai(TbTheLoai theloai)
    {
        if(tbTheLoais == null)
        {
            tbTheLoais = new ArrayList<>();
        }
        tbTheLoais.add(theloai);
    }

    public void addTacGia(TbTacGia tacgia)
    {
        if(tbTacGias == null)
        {
            tbTacGias = new ArrayList<>();
        }
        tbTacGias.add(tacgia);
    }

    
    public List<TbTacGia> getTbTacGias() {
        return tbTacGias;
    }
    public void setTbTacGias(List<TbTacGia> tbTacGias) {
        this.tbTacGias = tbTacGias;
    }
    
    
    
    public TbAccount getNguoiSoHuu() {
        return nguoiSoHuu;
    }
    public void setNguoiSoHuu(TbAccount nguoiSoHuu) {
        this.nguoiSoHuu = nguoiSoHuu;
    }
    
    
    
   
    public List<TbGioHang> getGioHang() {
        return gioHang;
    }
    public void setGioHang(List<TbGioHang> gioHang) {
        this.gioHang = gioHang;
    }
    @Override
    public String toString() {
        return "TbSach [maSach=" + maSach + ", anh=" + anh + ", donGia=" + donGia + ", moTa=" + moTa + ", tenSach=" + tenSach + ", tbTheLoais=" + tbTheLoais + "]";
    }

}