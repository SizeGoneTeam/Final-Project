package entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the tbYeuThich database table.
 * 
 */
@Embeddable
public class TbYeuThichPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="MaTK", insertable=false, updatable=false)
	private int maTK;

	@Column(name="MaSach", insertable=false, updatable=false)
	private int maSach;

	public TbYeuThichPK() {
	}
	
    public TbYeuThichPK(int maTK, int maSach) {
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
		if (!(other instanceof TbYeuThichPK)) {
			return false;
		}
		TbYeuThichPK castOther = (TbYeuThichPK)other;
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

    @Override
    public String toString() {
        return "TbYeuThichPK [maTK=" + maTK + ", maSach=" + maSach + "]";
    }
	
}