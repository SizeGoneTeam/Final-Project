package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the tbGiaoDich database table.
 * 
 */
@Entity
@Table(name="tbGiaoDich")
@NamedQuery(name="TbGiaoDich.findAll", query="SELECT t FROM TbGiaoDich t")
public class TbGiaoDich implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MaGD")
	private int maGD;

	@Column(name="LoaiGD")
	private int loaiGD;

	@Column(name="NgayTao")
	private Timestamp ngayTao;

	@Column(name="NguoiGui")
	private int nguoiGui;

	@Column(name="NguoiNhan")
	private int nguoiNhan;

	@Column(name="TienGD")
	private double tienGD;

	@Column(name="TienHoaHong")
	private double tienHoaHong;

	public TbGiaoDich() {
	}

	public int getMaGD() {
		return this.maGD;
	}

	public void setMaGD(int maGD) {
		this.maGD = maGD;
	}

	public int getLoaiGD() {
		return this.loaiGD;
	}

	public void setLoaiGD(int loaiGD) {
		this.loaiGD = loaiGD;
	}

	public Timestamp getNgayTao() {
		return this.ngayTao;
	}

	public void setNgayTao(Timestamp ngayTao) {
		this.ngayTao = ngayTao;
	}

	public int getNguoiGui() {
		return this.nguoiGui;
	}

	public void setNguoiGui(int nguoiGui) {
		this.nguoiGui = nguoiGui;
	}

	public int getNguoiNhan() {
		return this.nguoiNhan;
	}

	public void setNguoiNhan(int nguoiNhan) {
		this.nguoiNhan = nguoiNhan;
	}

	public double getTienGD() {
		return this.tienGD;
	}

	public void setTienGD(double tienGD) {
		this.tienGD = tienGD;
	}

	public double getTienHoaHong() {
		return this.tienHoaHong;
	}

	public int month() {
        return getNgayTao().getMonth();
    }
	public int year() {
	    return getNgayTao().getYear();
	}
	public void setTienHoaHong(double tienHoaHong) {
		this.tienHoaHong = tienHoaHong;
	}

}