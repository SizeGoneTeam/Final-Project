package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tbTheLoai database table.
 * 
 */
@Entity
@Table(name="tbTheLoai")
@NamedQuery(name="TbTheLoai.findAll", query="SELECT t FROM TbTheLoai t")
public class TbTheLoai implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MaTheLoai")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maTheLoai;

	@Column(name="TenTheLoai")
	private String tenTheLoai;

	//bi-directional many-to-many association to TbSach
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
	@JoinTable(
		name="tbThuocTheLoai"
		, joinColumns={
			@JoinColumn(name="MaTheLoai")
			}
		, inverseJoinColumns={
			@JoinColumn(name="MaSach")
			}
		)
	private List<TbSach> tbSaches;

	public TbTheLoai() {
	}

	public int getMaTheLoai() {
		return this.maTheLoai;
	}

	public void setMaTheLoai(int maTheLoai) {
		this.maTheLoai = maTheLoai;
	}

	public String getTenTheLoai() {
		return this.tenTheLoai;
	}

	public void setTenTheLoai(String tenTheLoai) {
		this.tenTheLoai = tenTheLoai;
	}

	public List<TbSach> getTbSaches() {
		return this.tbSaches;
	}

	public void setTbSaches(List<TbSach> tbSaches) {
		this.tbSaches = tbSaches;
	}
	

}