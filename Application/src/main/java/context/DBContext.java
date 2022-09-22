package context;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBContext {
	public Connection getConnection() throws Exception {
		String url = "jdbc:mysql://"+ serverName +":" +portNumber+"/ "+dbName;
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection(url, UserID, password);
		
	}
	private final String serverName ="sql6.freesqldatabase.com";
	private final String dbName = "sql6521250";
	private final String portNumber ="3306";
	private final String UserID = "sql6521250";
	private final String password ="HTetLcEFIR";
	public static void main(String[] args) {
		try {
			System.out.println(new DBContext().getConnection());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
