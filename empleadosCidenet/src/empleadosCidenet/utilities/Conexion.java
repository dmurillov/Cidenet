package empleadosCidenet.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	private static String url = "jdbc:mysql://localhost:3306/dbcidenet?serverTimezone=GMT-5";
	private static String user = "root";
	private static String password = "root";

	public Connection getConnection() {
		Connection con = null;

		try {
			con = DriverManager.getConnection(url, user, password);
			System.out.println("conectado");
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("out");
		}
		return con;

	}

}
