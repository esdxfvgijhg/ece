package Data;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectToDataBase {
	public Connection Open_ConnectDB() {
		String connectionURL = "jdbc:mysql://127.0.0.1:3306/";
		String NomDB = "Gestionnaire";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "aghiles";
		String password = "aghilesDJ35B";
		Connection connection = null;
		try {
			Class.forName(driver).newInstance();
			connection = DriverManager.getConnection(connectionURL + NomDB, userName, password);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return connection;
	}

	public void Close_ConnectDB(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
				//System.out.println("Out");
			} catch (Exception ex) {
			}
		}
	}
}
