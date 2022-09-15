package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import context.DBContext;
import entity.Product;

public class dao {
	Connection conn=null;
	PreparedStatement ps =null;
	ResultSet rs = null;
	
	public List<Product> getALLProduct(){
		List<Product> list = new ArrayList<>();
		String query ="select * from tbSach";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	public static void main(String[] args) {
		dao Dao =new dao();
		List<Product> list = Dao.getALLProduct();
		for(Product o : list) {
			System.out.println(o);
		}
	}
}
