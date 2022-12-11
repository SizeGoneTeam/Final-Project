package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the tbNhanXet database table.
 * 
 */
@Entity
@Table(name="tbNhanXet")
@NamedQuery(name="TbNhanXet.findAll", query="SELECT t FROM TbNhanXet t")
public class TbNhanXet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="MaDG")
	private int maDG;

	@Column(name="MaSach")
	private int maSach;

	@Column(name="MaTK")
	private int maTK;

	@Column(name="NgayDG")
	private Timestamp ngayDG;

	@Column(name="NhanXet")
	private String nhanXet;

	@Column(name="Sao")
	private int sao;
	
	@OneToOne(cascade = CascadeType.ALL )  
    @JoinColumn(name = "MaSach", insertable=false, updatable=false)
    private TbSach tbSach;
    
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="MaTK", insertable=false, updatable=false)
    private TbAccount account;

	public TbNhanXet() {
	}
	
	

	public TbNhanXet(int maSach, int maTK, String nhanXet, int sao) {
        super();
        this.maSach = maSach;
        this.maTK = maTK;
        this.nhanXet = nhanXet;
        this.sao = sao;
        Date now = new Date();
        Timestamp NowTime = new Timestamp(now.getTime());
        ngayDG = NowTime;
    }



    public int getMaDG() {
		return this.maDG;
	}

	public void setMaDG(int maDG) {
		this.maDG = maDG;
	}

	public int getMaSach() {
		return this.maSach;
	}

	public void setMaSach(int maSach) {
		this.maSach = maSach;
	}

	public int getMaTK() {
		return this.maTK;
	}

	public void setMaTK(int maTK) {
		this.maTK = maTK;
	}

	public Timestamp getNgayDG() {
		return this.ngayDG;
	}

	public void setNgayDG(Timestamp ngayDG) {
		this.ngayDG = ngayDG;
	}

	public String getNhanXet() {
		return this.nhanXet;
	}

	public void setNhanXet(String nhanXet) {
		this.nhanXet = nhanXet;
	}

	public int getSao() {
		return this.sao;
	}

	public void setSao(int sao) {
		this.sao = sao;
	}



    public TbSach getTbSach() {
        return tbSach;
    }



    public void setTbSach(TbSach tbSach) {
        this.tbSach = tbSach;
    }



    public TbAccount getAccount() {
        return account;
    }



    public void setAccount(TbAccount account) {
        this.account = account;
    }



    @Override
    public String toString() {
        return "TbNhanXet [maDG=" + maDG + ", maSach=" + maSach + ", maTK=" + maTK + ", ngayDG=" + ngayDG + ", nhanXet="
                + nhanXet + ", sao=" + sao + "]";
    }
	
    

}