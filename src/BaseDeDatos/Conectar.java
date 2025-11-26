package BaseDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class Conectar {
//		private static final String URL = "jdbc:sqlserver://MANU:1433;databaseName=BarberPiece;encrypt=false;trustServerCertificate=true";
	    private static final String URL = "jdbc:sqlserver://Angel:1433;databaseName=BarberPiece;encrypt=false;trustServerCertificate=true";
	    private static final String USER = "administrador";
	    private static final String PASSWORD = "admin";
	    

	    public static Connection conexion() {
	        try {
	        	System.out.println("bueno");
	            // Conexión
	            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
	            return con;
	        } catch (SQLException e) {
	        	System.out.println("Malo");
	            return null;
	        }
	    }
}
