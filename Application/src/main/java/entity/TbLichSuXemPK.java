package entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the tbLichSuXem database table.
 * 
 */
@Embeddable
public class TbLichSuXemPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="MaTK", insertable=false, updatable=false)
	private int maTK;

	@Column(name="MaSach", insertable=false, updatable=false)
	private int maSach;

	public TbLichSuXemPK() {
	    
	}
    @Override
    public String toString() {
        return "TbLichSuXemPK [maTK=" + maTK + ", maSach=" + maSach + "]";
    }
    public TbLichSuXemPK(int maTK, int maSach) {
        // TODO Auto-generated constructor stub
        this.maTK= maTK;
        this.maSach = maSach;
             
    }
	public int getMaTK() {
		return this.maTK;
	}
	public void setMaTK(int maTK) {
		this.maTK = maTK;
	}
	public int getMaSach() {
		return this.maSach;
	}
	public void setMaSach(int maSach) {
		this.maSach = maSach;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TbLichSuXemPK)) {
			return false;
		}
		TbLichSuXemPK castOther = (TbLichSuXemPK)other;
		return 
			(this.maTK == castOther.maTK)
			&& (this.maSach == castOther.maSach);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.maTK;
		hash = hash * prime + this.maSach;
		
		return hash;
	}
}