package entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the tbChiTietHD database table.
 * 
 */
@Embeddable
public class TbChiTietHDPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="MaCT")
	private int maCT;

	@Column(name="MaHD", insertable=false, updatable=false)
	private int maHD;

	public TbChiTietHDPK() {
	}
	public int getMaCT() {
		return this.maCT;
	}
	public void setMaCT(int maCT) {
		this.maCT = maCT;
	}
	public int getMaHD() {
		return this.maHD;
	}
	public void setMaHD(int maHD) {
		this.maHD = maHD;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TbChiTietHDPK)) {
			return false;
		}
		TbChiTietHDPK castOther = (TbChiTietHDPK)other;
		return 
			(this.maCT == castOther.maCT)
			&& (this.maHD == castOther.maHD);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.maCT;
		hash = hash * prime + this.maHD;
		
		return hash;
	}
}