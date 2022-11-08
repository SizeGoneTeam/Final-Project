package entity;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;
import java.util.Set;


/**
 * The persistent class for the tbTacGia database table.
 * 
 */
@Entity
@Table(name="tbTacGia")
@NamedQuery(name="TbTacGia.findAll", query="SELECT t FROM TbTacGia t")
public class TbTacGia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="MaTacGia")
	private int maTacGia;

	@Column(name="TenTacGia")
	private String tenTacGia;

	//bi-directional many-to-one association to TbViet
    @ManyToMany(cascade = {CascadeType.MERGE})
    @JoinTable(
            name = "tbViet",
            joinColumns = @JoinColumn(name = "MaTacGia"),
            inverseJoinColumns = @JoinColumn(name ="MaSach")
            )
    private List<TbSach> tbSachs;

	public TbTacGia() {
	}

	public int getMaTacGia() {
		return this.maTacGia;
	}

	public void setMaTacGia(int maTacGia) {
		this.maTacGia = maTacGia;
	}

	public String getTenTacGia() {
		return this.tenTacGia;
	}

	public void setTenTacGia(String tenTacGia) {
		this.tenTacGia = tenTacGia;
	}

}