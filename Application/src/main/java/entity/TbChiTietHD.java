package entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tbChiTietHD database table.
 * 
 */
@Entity
@Table(name="tbChiTietHD")
@NamedQuery(name="TbChiTietHD.findAll", query="SELECT t FROM TbChiTietHD t")
public class TbChiTietHD implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name="MaCT") 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maCT;

	@Column(name="GiaVC")
	private double giaVC;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "MaGD")
    private TbGiaoDich giaoDich;
    
	//bi-directional many-to-one association to TbHoaDon
	@ManyToOne()
	@JoinColumn(name="MaHD")
	private TbHoaDon tbHoaDon;
	
	@OneToOne()  
	@JoinColumn(name = "MaSach")
	private TbSach maSach;
	public TbChiTietHD() {
	}
	
	

	public TbChiTietHD(TbHoaDon hoaDon,double giaVC, TbGiaoDich giaoDich, TbSach maSach) {
	    this.tbHoaDon = hoaDon;
        this.giaVC = giaVC;
        this.giaoDich = giaoDich;
        this.maSach = maSach;
    }

	public double getGiaVC() {
		return this.giaVC;
	}

	public void setGiaVC(double giaVC) {
		this.giaVC = giaVC;
	}


	public TbSach getMaSach() {
        return maSach;
    }

    public void setMaSach(TbSach maSach) {
        this.maSach = maSach;
    }

    public TbHoaDon getTbHoaDon() {
		return this.tbHoaDon;
	}

	public void setTbHoaDon(TbHoaDon tbHoaDon) {
		this.tbHoaDon = tbHoaDon;
	}



    public int getMaCT() {
        return maCT;
    }



    public void setMaCT(int maCT) {
        this.maCT = maCT;
    }



    public TbGiaoDich getGiaoDich() {
        return giaoDich;
    }



    public void setGiaoDich(TbGiaoDich giaoDich) {
        this.giaoDich = giaoDich;
    }
    
    

	
}