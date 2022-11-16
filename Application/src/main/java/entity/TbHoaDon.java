package entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;
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
	@Column(name="MaHD") 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maHD;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="MaTK")
    private TbAccount account;
    
    @Column(name="NgayTao")
    private Timestamp NgayTao;

	//bi-directional many-to-one association to TbChiTietHD
	@OneToMany(mappedBy="tbHoaDon", cascade = CascadeType.ALL)
	private List<TbChiTietHD> tbChiTietHds;

	public TbHoaDon() {
	}
	
	

	public TbHoaDon(TbAccount account) {
	    Date now = new Date();
        this.account = account;
        NgayTao = new Timestamp(now.getTime());
    }



    public int getMaHD() {
		return this.maHD;
	}

	public void setMaHD(int maHD) {
		this.maHD = maHD;
	}

    public TbAccount getAccount() {
        return account;
    }

    public void setAccount(TbAccount account) {
        this.account = account;
    }


	public List<TbChiTietHD> getTbChiTietHds() {
		return this.tbChiTietHds;
	}

	public void setTbChiTietHds(List<TbChiTietHD> tbChiTietHds) {
		this.tbChiTietHds = tbChiTietHds;
	}

	public void addTbChiTietHd(TbChiTietHD tbChiTietHd) {
	    if(tbChiTietHds == null)
        {
	        tbChiTietHds = new ArrayList<>();
        }

		tbChiTietHds.add(tbChiTietHd);
	}

	public TbChiTietHD removeTbChiTietHd(TbChiTietHD tbChiTietHd) {
		getTbChiTietHds().remove(tbChiTietHd);
		tbChiTietHd.setTbHoaDon(null);

		return tbChiTietHd;
	}

}