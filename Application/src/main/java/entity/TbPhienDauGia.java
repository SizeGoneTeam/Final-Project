package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
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
	
    @Column(name="ThoiGian")
    private Integer thoiGian;
    
    @Column(name="GiaGiam")
    private BigInteger giaGiam;   
    
    @Column(name="ThoiGianGiam")
    private Integer thoiGianGiam;
    
    @Column(name="GiaThapNhat")
    private BigInteger giaThapNhat;  
    
    @Column(name="IsEnd")
    private int isEnd;  
	
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="MaTK")
	private TbAccount account;
	
	@OneToOne(cascade = CascadeType.ALL )  
	@JoinColumn(name = "MaSach")
	private TbSach maSach;

   @OneToMany(mappedBy = "phienDauGia", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private List<TbLichSuBid> bids;
	
	public TbAccount getAccount() {
        return account;
    }
	
    public TbPhienDauGia() {

    }	

    public TbPhienDauGia(BigInteger giaKhoiDiem, int loaiPhien,
            Timestamp ngayKetThuc, Timestamp ngayTao, Integer thoiGian, BigInteger giaGiam, BigInteger giaThapNhat, Integer thoiGianGiam) {
        this.giaKhoiDiem = giaKhoiDiem;
        this.loaiPhien = loaiPhien;
        this.ngayKetThuc = ngayKetThuc;
        this.ngayTao = ngayTao;
        this.thoiGian = thoiGian;
        this.giaGiam = giaGiam;
        this.giaThapNhat = giaThapNhat;
        this.thoiGianGiam = thoiGianGiam;
        this.giaChot = giaKhoiDiem;
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
	
	

    public Integer getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(Integer thoiGian) {
        this.thoiGian = thoiGian;
    }

    public BigInteger getGiaGiam() {
        return giaGiam;
    }

    public void setGiaGiam(BigInteger giaGiam) {
        this.giaGiam = giaGiam;
    }

    public Integer getThoiGianGiam() {
        return thoiGianGiam;
    }

    public void setThoiGianGiam(Integer thoiGianGiam) {
        this.thoiGianGiam = thoiGianGiam;
    }

    public BigInteger getGiaThapNhat() {
        return giaThapNhat;
    }

    public void setGiaThapNhat(BigInteger giaThapNhat) {
        this.giaThapNhat = giaThapNhat;
    }

    public int getIsEnd() {
        return isEnd;
    }

    public void setIsEnd(int isEnd) {
        this.isEnd = isEnd;
    }

    public void addBid(TbLichSuBid bid)
    {
        if (bids == null)
            bids = new ArrayList<>();
        bids.add(bid);
        bid.setPhienDauGia(this);;
    }
    
    public void removeBid(TbLichSuBid bid)
    {
        if (bids == null)
            return;
        bids.remove(bid);
        bid.setPhienDauGia(this);;
    }
    
    public List<TbLichSuBid> getBids() {
        return bids;
    }

    public void setBids(List<TbLichSuBid> bids) {
        this.bids = bids;
    }

    @Override
    public String toString() {
        return "TbPhienDauGia [maPhien=" + maPhien + ", giaChot=" + giaChot + ", giaKhoiDiem=" + giaKhoiDiem
                + ", loaiPhien=" + loaiPhien + ", ngayKetThuc=" + ngayKetThuc + ", ngayTao=" + ngayTao + ", thoiGian="
                + thoiGian + ", giaGiam=" + giaGiam + ", thoiGianGiam=" + thoiGianGiam + ", giaThapNhat=" + giaThapNhat
                + ", isEnd=" + isEnd + ", account=" + account + ", maSach=" + maSach + "]";
    }


	

}