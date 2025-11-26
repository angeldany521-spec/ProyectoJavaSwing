package BaseDeDatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import Dominio.UsuarioRegular;



public class GuardarDatos {
	
	
	public static boolean guardarUsuarios( int id ,String nombre, String telefono, String correo,String usuario,String contraseña) {
		String datos = "INSERT INTO Usuarios (Nombre, Telefono, Correo, Usuario, Contraseña) VALUES (?, ?, ?, ?, ?)";
		
		try (Connection con = Conectar.conexion();
				PreparedStatement ps = con.prepareStatement(datos)) {
			
			ps.setString(1, nombre);
			ps.setString(2, telefono);
			ps.setString(3, correo);
			ps.setString(4, usuario);
			ps.setString(5, contraseña);
			
			
			ps.executeUpdate();
			return true;
			
		}
		
		
		catch (Exception e) {
			e.printStackTrace();
//			JOptionPane.showMessageDialog(null, "Datos no ingresados", "Error", JOptionPane.ERROR_MESSAGE);
			System.out.println("Datos no ingresados");
			return false;
		}
	}
	
	public static boolean actualizarUsuarios(UsuarioRegular u) {
		String datos = "UPDATE Usuarios SET Nombre=?, Telefono=?, Correo=?, Usuario=?, Contraseña=? WHERE IDUsuario=?";
		
		try (Connection con = Conectar.conexion();
				PreparedStatement ps = con.prepareStatement(datos)) {
			
			ps.setString(1, u.getNombre());
			ps.setString(2, u.getTelefono());
			ps.setString(3, u.getCorreo());
			ps.setString(4, u.getUser());
			ps.setString(5, u.getContraseña());
			ps.setInt(6,u.getId());
			
			int filas = ps.executeUpdate();
			return filas > 0;
			
		}catch (Exception e) {
			e.printStackTrace();
//			JOptionPane.showMessageDialog(null, "Datos no ingresados", "Error", JOptionPane.ERROR_MESSAGE);
			System.out.println("Datos no ingresados");
			return false;
		}
	}
	
	public static void eliminarDato(String tabla, String campo, int id) {
		String datos = "DELETE FROM " + tabla + " WHERE ID"+campo+ " = ?";
		
		try (Connection con = Conectar.conexion();
				PreparedStatement ps = con.prepareStatement(datos)) {
			
			
			ps.setInt(1,id);
			ps.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
//			JOptionPane.showMessageDialog(null, "Datos no ingresados", "Error", JOptionPane.ERROR_MESSAGE);
			System.out.println("Datos no ingresados");
			
		}
	}
	
	
	
	
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
	
	public static boolean guardarCita(int idBarber, int idCliente, String servicios, Date fecha, String hora, int monto) {
		String datos = "INSERT INTO Citas Values(?, ?, ?, ?, ?, ?)";
		
		try (Connection con = Conectar.conexion();
				PreparedStatement ps = con.prepareStatement(datos)) {
			
			ps.setInt(1, idBarber);
			ps.setInt(2, idCliente);
			ps.setString(3, servicios);
			ps.setDate(4, fecha);
			ps.setString(5, hora);
			ps.setInt(6, monto);
			
			
			ps.executeUpdate();
			return true;

		}
	
		
		catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR");
            return false;
		}
}
}
