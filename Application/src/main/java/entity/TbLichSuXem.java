package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the tbLichSuXem database table.
 * 
 */
@Entity
@Table(name="tbLichSuXem")
@NamedQuery(name="TbLichSuXem.findAll", query="SELECT t FROM TbLichSuXem t")
public class TbLichSuXem implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private TbLichSuXemPK id;

    @Column(name="NgayXem")
	private Timestamp ngayXem;

	//bi-directional many-to-one association to TbSach
	@ManyToOne
	@JoinColumn(name="MaSach", insertable=false, updatable=false)
	private TbSach tbSach;

	public TbLichSuXem() {
	    
	}
    public TbLichSuXem(TbLichSuXemPK id, Timestamp ngayXem ) {
        super();
        this.id = id;
        this.ngayXem = ngayXem;
    }
    
	public TbLichSuXemPK getId() {
		return this.id;
	}

	public void setId(TbLichSuXemPK id) {
		this.id = id;
	}

	public Timestamp getNgayXem() {
		return this.ngayXem;
	}

	public void setNgayXem(Timestamp ngayXem) {
		this.ngayXem = ngayXem;
	}

	public TbSach getTbSach() {
		return this.tbSach;
	}

	public void setTbSach(TbSach tbSach) {
		this.tbSach = tbSach;
	}
    @Override
    public String toString() {
        return "TbLichSuXem [id=" + id + ", ngayXem=" + ngayXem + ", tbSach=" + tbSach + "]";
    }

}