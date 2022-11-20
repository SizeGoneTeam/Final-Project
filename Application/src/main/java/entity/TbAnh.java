package entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tbAnh database table.
 * 
 */
@Entity
@Table(name="tbAnh")
@NamedQuery(name="TbAnh.findAll", query="SELECT t FROM TbAnh t")
public class TbAnh implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="MaAnh")
	private int maAnh;

	@Column(name="Anh")
	private String anh;

	@ManyToOne
	@JoinColumn(name="MaSach")
	private TbSach sach;

	public TbAnh() {
	}
	


    public TbAnh(String anh, TbSach sach) {
        super();
        this.anh = anh;
        this.sach = sach;
    }



    public int getMaAnh() {
		return this.maAnh;
	}

	public void setMaAnh(int maAnh) {
		this.maAnh = maAnh;
	}

	public String getAnh() {
		return this.anh;
	}

	public void setAnh(String anh) {
		this.anh = anh;
	}

    public TbSach getSach() {
        return sach;
    }

    public void setSach(TbSach sach) {
        this.sach = sach;
    }

    @Override
    public String toString() {
        return "TbAnh [maAnh=" + maAnh + ", anh=" + anh + "]";
    }


}