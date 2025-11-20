package BaseDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conectar {

	    private static final String URL = "jdbc:sqlserver://MANU:1433;databaseName=BarberPiece;encrypt=false;trustServerCertificate=true";
	    

	    public static Connection conexion(String USER, String PASSWORD) {
	        try {
	            // Conexión
	            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
	            return con;
	        } catch (SQLException e) {
	       
	            return null;
	        }
	    }
}
