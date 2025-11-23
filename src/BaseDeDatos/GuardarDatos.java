package BaseDeDatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;



public class GuardarDatos {
	public static boolean guardarClientes(String nombre, String telefono, String correo) {
		String datos = "INSERT INTO Clientes Values(?, ?, ?)";
		
		try (Connection con = Conectar.conexion();
				PreparedStatement ps = con.prepareStatement(datos)) {
			
			ps.setString(1, nombre);
			ps.setString(2, telefono);
			ps.setString(3, correo);
			
			
			ps.executeUpdate();
			return true;

		}
	
		
		catch (Exception e) {
            e.printStackTrace();
            System.out.println("Datos no ingresados");
            return false;
		}
}
	
	public static boolean guardarCita(int idBarber, int idCliente, String servicios, Date fecha, String hora) {
		String datos = "INSERT INTO Citas Values(?, ?, ?, ?, ?)";
		
		try (Connection con = Conectar.conexion();
				PreparedStatement ps = con.prepareStatement(datos)) {
			
			ps.setInt(1, idBarber);
			ps.setInt(2, idCliente);
			ps.setString(3, servicios);
			ps.setDate(4, fecha);
			ps.setString(5, hora);
			
			
			ps.executeUpdate();
			return true;

		}
	
		
		catch (Exception e) {
            e.printStackTrace();
            System.out.println("Datos no ingresados");
            return false;
		}
}
}
