package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the tbGioHang database table.
 * 
 */
@Entity
@Table(name="tbGioHang")
@NamedQuery(name="TbGioHang.findAll", query="SELECT t FROM TbGioHang t")
public class TbGioHang implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private GioHangPK gioHangPK;
	
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name = "MaSach", insertable=false, updatable=false)
	private TbSach tbSach;
	
	@OneToOne
    @JoinColumn(name = "MaTK", insertable=false, updatable=false)
    private TbAccount tbAccount;

	@Column(name="NgayThem")
	private Timestamp ngayThem;

	@Column(name="TrangThaiThanhToan")
	private int trangThaiThanhToan;

	public TbGioHang() {
	    Date now = new Date();
        Timestamp NowTime = new Timestamp(now.getTime());
        ngayThem = NowTime;
        trangThaiThanhToan =0;
	}
	
	public TbGioHang(GioHangPK gioHangPK) {
	    Date now = new Date();
        Timestamp NowTime = new Timestamp(now.getTime());
        ngayThem = NowTime;
	    this.gioHangPK = gioHangPK;
	    trangThaiThanhToan =0;
    }


	public GioHangPK getGioHangPK() {
        return gioHangPK;
    }


    public void setGioHangPK(GioHangPK gioHangPK) {
        this.gioHangPK = gioHangPK;
    }


    public Timestamp getNgayThem() {
		return this.ngayThem;
	}

	public void setNgayThem(Timestamp ngayThem) {
		this.ngayThem = ngayThem;
	}

	public int getTrangThaiThanhToan() {
		return this.trangThaiThanhToan;
	}

	public void setTrangThaiThanhToan(int trangThaiThanhToan) {
		this.trangThaiThanhToan = trangThaiThanhToan;
	}


    public TbSach getMaSach() {
        return tbSach;
    }


    public void setMaSach(TbSach tbSach) {
        this.tbSach = tbSach;
    }


    public TbAccount getMaTK() {
        return tbAccount;
    }


    public void setMaTK(TbAccount tbAccount) {
        this.tbAccount = tbAccount;
    }
	

}