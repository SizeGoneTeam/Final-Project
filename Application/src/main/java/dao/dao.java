package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import context.DBContext;
import entity.Account;
import entity.BidHistory;
import entity.Product;
import entity.TacGia;

public class dao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public List<Product> getALLProduct() {
		List<Product> list = new ArrayList<>();
		String query = "select * from tbSach";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5),rs.getString(6)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	public Account login(String user, String pass) {

		String query = "select * from tbAccount\r\n" + "where TK = ? and MK = ?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, user);
			ps.setString(2, pass);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new Account(rs.getInt(1),rs.getString(6), rs.getString(2), rs.getInt(3));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public Account checkAccountExitst(String user) {

		String query = "select * from tbAccount\r\n" + "where TK = ?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, user);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new Account(rs.getInt(1),rs.getString(6), rs.getString(2), rs.getInt(3));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public Product getProductbyID(String id) {
		String query = "select * from tbSach \n"
				+ "where MaSach = ?";
		
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public void register(String user, String pass) {

		String query = "insert into tbAccount(TK,MK) values (?,?)";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);

			ps.setString(1, user);
			ps.setString(2, pass);

			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public List<Product> getLatestProduct() {
		List<Product> list = new ArrayList<>();
		String query = "select * from tbSach inner join (select MaSach from tbChiTietHD\r\n"
				+ "order by MaHD desc\r\n"
				+ "limit 4) chitiet on tbSach.MaSach = chitiet.MaSach";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5),rs.getString(6)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	
	public List<Product> getTopSeller() {
		List<Product> list = new ArrayList<>();
		String query = "select * from tbSach inner join (select MaSach from tbChiTietHD\r\n"
				+ "group by MaSach\r\n"
				+ "order by sum(SoLuong) desc\r\n"
				+ "limit 4) chitiet on tbSach.MaSach = chitiet.MaSach";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5),rs.getString(6)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	
	public List<Product> getTopRated() {
		List<Product> list = new ArrayList<>();
		String query = "select * from tbSach inner join (select MaSach from tbRated\r\n"
				+ "group by MaSach\r\n"
				+ "order by avg(Rated) desc\r\n"
				+ "limit 4) rate on tbSach.MaSach = rate.MaSach";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5),rs.getString(6)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	
	public void deleteProduct(String id) {
		String query = "delete from tbSach where MaSach = ? ";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void updateProduct(String maSach, String tenSach, String anh, int price, int soLuong, String moTa ) {

		String query = "update tbSach set TenSach = ?, Anh = ?, DonGia = ?, SoLuong =?, MoTa=?"
				+ " Where MaSach=?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, tenSach);
			ps.setString(2, anh);
			ps.setInt(3, price);
			ps.setInt(4, soLuong);
			ps.setString(5, moTa);
			ps.setString(6, maSach);

			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void addProduct(String tenSach, String anh, int price, int soLuong, String moTa ) {

		String query = "insert into tbSach(TenSach,Anh,DonGia,SoLuong,MoTa)\r\n"
				+ "values (?,?,?,?,?)";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, tenSach);
			ps.setString(2, anh);
			ps.setInt(3, price);
			ps.setInt(4, soLuong);
			ps.setString(5, moTa);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public List<TacGia> getALLTacGia() {
		List<TacGia> list = new ArrayList<>();
		String query = "select * from tbTacGia";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new TacGia(rs.getInt(1), rs.getString(2)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	
	public void bidProduct(String maSach, int price) {

		String query = "update tbSach set DonGia = ?"
				+ " Where MaSach=?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, price);
			ps.setString(2, maSach);

			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void addBidHistory(String maKH, String maSach, int price) {

		String query = "insert into tbLichSuBid(MaKH,MaSach,Bid)\r\n"
				+ "values (?,?,?)";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, maKH);
			ps.setString(2, maSach);
			ps.setInt(3, price);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public List<BidHistory> getTopBid(int maSach) {
		List<BidHistory> list = new ArrayList<>();
		String query = "select MaBid,TK,Bid,bid.MaSach,NgayTao from tbAccount inner join (select * from tbLichSuBid\r\n"
				+ "where MaSach =?  order by MaBid desc limit 5) bid on tbAccount.MaKH = bid.MaKH";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, maSach);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new BidHistory(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	public static void main(String[] args) {
		dao Dao = new dao();
		List<BidHistory> list = Dao.getTopBid(5);
		for (BidHistory bidHistory : list) {
			System.out.println(bidHistory);
		}
	}
}
