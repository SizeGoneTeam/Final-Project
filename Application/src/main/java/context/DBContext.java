package context;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBContext {
	public Connection getConnection() throws Exception {
		String url = "jdbc:mysql://"+ serverName +":" +portNumber+"/ "+dbName;
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection(url, UserID, password);
		
	}
	private final String serverName ="database-2.cuhigonpnglj.ap-southeast-1.rds.amazonaws.com";
	private final String dbName = "dbbook";
	private final String portNumber ="3306";
	private final String UserID = "admin";
	private final String password ="Enter0123";
	public static void main(String[] args) {
		try {
			System.out.println(new DBContext().getConnection());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
