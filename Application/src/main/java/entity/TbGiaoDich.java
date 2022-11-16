package entity;

import java.io.Serializable;
import javax.persistence.*;

import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the tbGiaoDich database table.
 * 
 */
@Entity
@Table(name="tbGiaoDich")
@NamedQuery(name="TbGiaoDich.findAll", query="SELECT t FROM TbGiaoDich t")
public class TbGiaoDich implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="MaGD")
	private int maGD;

	@Column(name="LoaiGD")
	private int loaiGD;

	@Column(name="NgayTao")
	private Timestamp ngayTao;

	@Column(name="NguoiGui")
	private int nguoiGui;

	@Column(name="NguoiNhan")
	private int nguoiNhan;

	@Column(name="TienGD")
	private double tienGD;

	@Column(name="TienHoaHong")
	private double tienHoaHong;
	
	@OneToOne(mappedBy = "giaoDich")
    private TbChiTietHD chiTietHD;

	public TbGiaoDich() {
	}

	
	public TbGiaoDich(int loaiGD, int nguoiGui, int nguoiNhan, double tienGD) {
        super();
        Date now = new Date();
        this.loaiGD = loaiGD;
        this.ngayTao = new Timestamp(now.getTime());
        this.nguoiGui = nguoiGui;
        this.nguoiNhan = nguoiNhan;
        this.tienGD = tienGD;
        this.tienHoaHong = tienGD*20/100;
    }


    public int getMaGD() {
		return this.maGD;
	}

	public void setMaGD(int maGD) {
		this.maGD = maGD;
	}

	public int getLoaiGD() {
		return this.loaiGD;
	}

	public void setLoaiGD(int loaiGD) {
		this.loaiGD = loaiGD;
	}

	public Timestamp getNgayTao() {
		return this.ngayTao;
	}

	public void setNgayTao(Timestamp ngayTao) {
		this.ngayTao = ngayTao;
	}

	public int getNguoiGui() {
		return this.nguoiGui;
	}

	public void setNguoiGui(int nguoiGui) {
		this.nguoiGui = nguoiGui;
	}

	public int getNguoiNhan() {
		return this.nguoiNhan;
	}

	public void setNguoiNhan(int nguoiNhan) {
		this.nguoiNhan = nguoiNhan;
	}

	public double getTienGD() {
		return this.tienGD;
	}

	public void setTienGD(double tienGD) {
		this.tienGD = tienGD;
	}

	public double getTienHoaHong() {
		return this.tienHoaHong;
	}

	public void setTienHoaHong(double tienHoaHong) {
		this.tienHoaHong = tienHoaHong;
	}



    public TbChiTietHD getChiTietHD() {
        return chiTietHD;
    }


    public void setChiTietHD(TbChiTietHD chiTietHD) {
        this.chiTietHD = chiTietHD;
    }


    @Override
    public String toString() {
        return "TbGiaoDich [maGD=" + maGD + ", loaiGD=" + loaiGD + ", ngayTao=" + ngayTao + ", nguoiGui=" + nguoiGui
                + ", nguoiNhan=" + nguoiNhan + ", tienGD=" + tienGD + ", tienHoaHong=" + tienHoaHong + "]";
    }

    
	
}