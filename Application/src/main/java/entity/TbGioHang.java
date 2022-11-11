package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the tbGioHang database table.
 * 
 */
@Entity
@Table(name="tbGioHang")
@NamedQuery(name="TbGioHang.findAll", query="SELECT t FROM TbGioHang t")
public class TbGioHang implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MaSach")
	private int maSach;

	@Column(name="NgayThem")
	private Timestamp ngayThem;

	@Column(name="TrangThaiThanhToan")
	private byte trangThaiThanhToan;

	//bi-directional many-to-one association to TbAccountNew
	@ManyToOne
	@JoinColumn(name="MaTK")
	private TbAccount tbAccount;

	//bi-directional one-to-one association to TbSachNew
	@OneToOne
	@JoinColumn(name="MaSach")
	private TbSach tbSach;

	public TbGioHang() {
	}

	public int getMaSach() {
		return this.maSach;
	}

	public void setMaSach(int maSach) {
		this.maSach = maSach;
	}

	public Timestamp getNgayThem() {
		return this.ngayThem;
	}

	public void setNgayThem(Timestamp ngayThem) {
		this.ngayThem = ngayThem;
	}

	public byte getTrangThaiThanhToan() {
		return this.trangThaiThanhToan;
	}

	public void setTrangThaiThanhToan(byte trangThaiThanhToan) {
		this.trangThaiThanhToan = trangThaiThanhToan;
	}

	public TbAccount getTbAccount() {
		return this.tbAccount;
	}

	public void setTbAccount(TbAccount tbAccount) {
		this.tbAccount = tbAccount;
	}

	public TbSach getTbSach() {
		return this.tbSach;
	}

	public void setTbSach(TbSach tbSach) {
		this.tbSach = tbSach;
	}

}