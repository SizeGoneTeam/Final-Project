package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.math.BigInteger;


/**
 * The persistent class for the tbPhienDauGia database table.
 * 
 */
@Entity
@Table(name="tbPhienDauGia")
@NamedQuery(name="TbPhienDauGia.findAll", query="SELECT t FROM TbPhienDauGia t")
public class TbPhienDauGia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="MaPhien")
	private int maPhien;

	@Column(name="GiaChot")
	private BigInteger giaChot;

	@Column(name="GiaKhoiDiem")
	private BigInteger giaKhoiDiem;

	@Column(name="LoaiPhien")
	private int loaiPhien;

	@Column(name="NgayKetThuc")
	private Timestamp ngayKetThuc;

	@Column(name="NgayTao")
	private Timestamp ngayTao;
	
	@ManyToOne
	@JoinColumn(name="MaTK")
	private TbAccount account;
	
	@OneToOne(cascade = CascadeType.ALL )  
	@JoinColumn(name = "MaSach")
	private TbSach maSach;

	public TbAccount getAccount() {
        return account;
    }
	
    public TbPhienDauGia() {
        this.giaChot = null;
        this.giaKhoiDiem = null;
        this.loaiPhien = 0;
        this.ngayKetThuc = null;
        this.ngayTao = null;
    }	

    public TbPhienDauGia(BigInteger giaChot, BigInteger giaKhoiDiem, int loaiPhien,
            Timestamp ngayKetThuc, Timestamp ngayTao) {
        this.giaChot = giaChot;
        this.giaKhoiDiem = giaKhoiDiem;
        this.loaiPhien = loaiPhien;
        this.ngayKetThuc = ngayKetThuc;
        this.ngayTao = ngayTao;
    }



    public void setAccount(TbAccount account) {
        this.account = account;
    }

    
	public int getMaPhien() {
		return this.maPhien;
	}

	public void setMaPhien(int maPhien) {
		this.maPhien = maPhien;
	}

	public BigInteger getGiaChot() {
		return this.giaChot;
	}

	public void setGiaChot(BigInteger giaChot) {
		this.giaChot = giaChot;
	}

	public BigInteger getGiaKhoiDiem() {
		return this.giaKhoiDiem;
	}

	public void setGiaKhoiDiem(BigInteger giaKhoiDiem) {
		this.giaKhoiDiem = giaKhoiDiem;
	}

	public int getLoaiPhien() {
		return this.loaiPhien;
	}

	public void setLoaiPhien(int loaiPhien) {
		this.loaiPhien = loaiPhien;
	}

	
	public TbSach getMaSach() {
        return maSach;
    }

    public void setMaSach(TbSach maSach) {
        this.maSach = maSach;
    }

    public Timestamp getNgayKetThuc() {
		return this.ngayKetThuc;
	}

	public void setNgayKetThuc(Timestamp ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}

	public Timestamp getNgayTao() {
		return this.ngayTao;
	}

	public void setNgayTao(Timestamp ngayTao) {
		this.ngayTao = ngayTao;
	}

    @Override
    public String toString() {
        return "TbPhienDauGia [maPhien=" + maPhien + ", giaChot=" + giaChot + ", giaKhoiDiem=" + giaKhoiDiem
                + ", loaiPhien=" + loaiPhien + ", maSach=" + maSach + ", ngayKetThuc=" + ngayKetThuc
                + ", ngayTao=" + ngayTao + "]";
    }
	

}