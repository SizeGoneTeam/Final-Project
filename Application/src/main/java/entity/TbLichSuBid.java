package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.math.BigInteger;


/**
 * The persistent class for the tbLichSuBid database table.
 * 
 */
@Entity
@Table(name="tbLichSuBid")
@NamedQuery(name="TbLichSuBid.findAll", query="SELECT t FROM TbLichSuBid t")
public class TbLichSuBid implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="MaBid")
	private int maBid;

	@Column(name="Bid")
	private Double bid;

	@Column(name="NgayTao")
	private Timestamp ngayTao;

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="MaTK")
    private TbAccount account;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="MaPhien")
    private TbPhienDauGia phienDauGia;
	
	

	public TbLichSuBid() {

    }
	
	
	
    public TbLichSuBid(Double bid, TbAccount account) {
        Date now = new Date();
        this.bid = bid;
        this.account = account;
        this.ngayTao = new Timestamp(now.getTime());
    }



    public int getMaBid() {
		return this.maBid;
	}

	public void setMaBid(int maBid) {
		this.maBid = maBid;
	}

	public Double getBid() {
		return this.bid;
	}

	public void setBid(Double bid) {
		this.bid = bid;
	}


	public Timestamp getNgayTao() {
		return this.ngayTao;
	}

	public void setNgayTao(Timestamp ngayTao) {
		this.ngayTao = ngayTao;
	}

    public TbAccount getAccount() {
        return account;
    }

    public void setAccount(TbAccount account) {
        this.account = account;
    }

    public TbPhienDauGia getPhienDauGia() {
        return phienDauGia;
    }

    public void setPhienDauGia(TbPhienDauGia phienDauGia) {
        this.phienDauGia = phienDauGia;
    }
	
	

}