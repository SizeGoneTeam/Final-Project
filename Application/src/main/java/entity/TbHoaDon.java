package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tbHoaDon database table.
 * 
 */
@Entity
@Table(name="tbHoaDon")
@NamedQuery(name="TbHoaDon.findAll", query="SELECT t FROM TbHoaDon t")
public class TbHoaDon implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MaHD", insertable=false, updatable=false)
	private int maHD;

	@Column(name="MaGD")
	private int maGD;

	@Column(name="MaTK")
	private int maTK;

	@Column(name="TienHD")
	private double tienHD;

	@Column(name="TienSach")
	private double tienSach;

	@Column(name="TienVC")
	private double tienVC;

	//bi-directional many-to-one association to TbChiTietHD
	@OneToMany(mappedBy="tbHoaDon")
	private List<TbChiTietHD> tbChiTietHds;

	public TbHoaDon() {
	}

	public int getMaHD() {
		return this.maHD;
	}

	public void setMaHD(int maHD) {
		this.maHD = maHD;
	}

	public int getMaGD() {
		return this.maGD;
	}

	public void setMaGD(int maGD) {
		this.maGD = maGD;
	}

	public int getMaTK() {
		return this.maTK;
	}

	public void setMaTK(int maTK) {
		this.maTK = maTK;
	}

	public double getTienHD() {
		return this.tienHD;
	}

	public void setTienHD(double tienHD) {
		this.tienHD = tienHD;
	}

	public double getTienSach() {
		return this.tienSach;
	}

	public void setTienSach(double tienSach) {
		this.tienSach = tienSach;
	}

	public double getTienVC() {
		return this.tienVC;
	}

	public void setTienVC(double tienVC) {
		this.tienVC = tienVC;
	}

	public List<TbChiTietHD> getTbChiTietHds() {
		return this.tbChiTietHds;
	}

	public void setTbChiTietHds(List<TbChiTietHD> tbChiTietHds) {
		this.tbChiTietHds = tbChiTietHds;
	}

	public TbChiTietHD addTbChiTietHd(TbChiTietHD tbChiTietHd) {
		getTbChiTietHds().add(tbChiTietHd);
		tbChiTietHd.setTbHoaDon(this);

		return tbChiTietHd;
	}

	public TbChiTietHD removeTbChiTietHd(TbChiTietHD tbChiTietHd) {
		getTbChiTietHds().remove(tbChiTietHd);
		tbChiTietHd.setTbHoaDon(null);

		return tbChiTietHd;
	}

}