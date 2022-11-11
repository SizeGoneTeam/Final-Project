package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class GioHangPK implements Serializable {
    
    @Column(name="MaTK", insertable=false, updatable=false)
    private int maTK;

    @Column(name="MaSach", insertable=false, updatable=false)
    private int maSach;
    
    public GioHangPK() {
        
    }

    public GioHangPK(int maTK, int maSach) {
        this.maTK = maTK;
        this.maSach = maSach;
    }

    public int getMaTK() {
        return maTK;
    }

    public void setMaTK(int maTK) {
        this.maTK = maTK;
    }

    public int getMaSach() {
        return maSach;
    }

    public void setMaSach(int maSach) {
        this.maSach = maSach;
    }
    
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GioHangPK)) {
            return false;
        }
        GioHangPK castOther = (GioHangPK)other;
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
