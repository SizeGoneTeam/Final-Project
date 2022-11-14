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

	@EmbeddedId
	private TbChiTietHDPK id;

	@Column(name="GiaVC")
	private double giaVC;



	//bi-directional many-to-one association to TbHoaDon
	@ManyToOne
	@JoinColumn(name="MaHD",insertable=false, updatable=false)
	private TbHoaDon tbHoaDon;
	@OneToOne(cascade = CascadeType.ALL )  
	@JoinColumn(name = "MaSach")
	private TbSach maSach;
	public TbChiTietHD() {
	}

	public TbChiTietHDPK getId() {
		return this.id;
	}

	public void setId(TbChiTietHDPK id) {
		this.id = id;
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

}