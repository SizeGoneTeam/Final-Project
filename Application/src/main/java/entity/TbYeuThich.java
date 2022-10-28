package entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.*;


/**
 * The persistent class for the tbYeuThich database table.
 * 
 */
@Entity
@Table(name="tbYeuThich")
@NamedQuery(name="TbYeuThich.findAll", query="SELECT t FROM TbYeuThich t")
public class TbYeuThich implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private TbYeuThichPK id;

	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="MaSach", insertable=false, updatable=false)
	private TbSach tbSach;
	public TbYeuThich() {
	}
	
    public TbYeuThich(TbYeuThichPK id) {
        super();
        this.id = id;
    }

	public TbYeuThichPK getId() {
		return this.id;
	}

	public void setId(TbYeuThichPK id) {
		this.id = id;
	}
    public TbSach getTbSach() {
        return this.tbSach;
    }

    @Override
    public String toString() {
        return "TbYeuThich [id=" + id + ", tbSach=" + tbSach + "]";
    }
	
}