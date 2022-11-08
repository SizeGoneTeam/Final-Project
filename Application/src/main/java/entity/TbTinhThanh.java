package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tbTinhThanh database table.
 * 
 */
@Entity
@Table(name="tbTinhThanh")
@NamedQuery(name="TbTinhThanh.findAll", query="SELECT t FROM TbTinhThanh t")
public class TbTinhThanh implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID")
	private int id;

	@Column(name="TinhThanh")
	private String tinhThanh;

	//bi-directional many-to-one association to TbDiaChiKH
	@OneToMany(mappedBy="tbTinhThanh")
	private List<TbDiaChiKH> tbDiaChiKhs;

	public TbTinhThanh() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTinhThanh() {
		return this.tinhThanh;
	}

	public void setTinhThanh(String tinhThanh) {
		this.tinhThanh = tinhThanh;
	}

	public List<TbDiaChiKH> getTbDiaChiKhs() {
		return this.tbDiaChiKhs;
	}

	public void setTbDiaChiKhs(List<TbDiaChiKH> tbDiaChiKhs) {
		this.tbDiaChiKhs = tbDiaChiKhs;
	}

	public TbDiaChiKH addTbDiaChiKh(TbDiaChiKH tbDiaChiKh) {
		getTbDiaChiKhs().add(tbDiaChiKh);
		tbDiaChiKh.setTbTinhThanh(this);

		return tbDiaChiKh;
	}

	public TbDiaChiKH removeTbDiaChiKh(TbDiaChiKH tbDiaChiKh) {
		getTbDiaChiKhs().remove(tbDiaChiKh);
		tbDiaChiKh.setTbTinhThanh(null);

		return tbDiaChiKh;
	}

}