package BaseDeDatos;

import java.lang.invoke.StringConcatFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;


import Dominio.Barbero;
import Dominio.Cliente;
import Dominio.Usuario;
import Dominio.UsuarioRegular;




public class ConsultarDatos {
	
	
	public static ArrayList<Barbero> obtenerBarberos() {
		ArrayList<Barbero> listaBarberos = new ArrayList<Barbero>();
		String horal;
		
		String sql = "SELECT * FROM Barberos";
	
	try {
        Connection con = Conectar.conexion();
        

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        
        listaBarberos.add(new Barbero(0, "", null, null, ""));
        while (rs.next()) {
           Barbero b = new Barbero(
        		   rs.getInt("IDBarbero"),
        		   rs.getString("Nombre"),
        		   rs.getString("Telefono"),
                   rs.getString("Correo"),
                   rs.getString("Turno")
        		   );
           listaBarberos.add(b);
           
        }
        
       con.close();  
	}
	
	catch (Exception e) {e.printStackTrace();}
	return listaBarberos;

	
}  
	public static DefaultTableModel cargar_citas() {
		String [] columns = {"Cliente", "Barbero", "Fecha", "Servicio", "Precio"};
		DefaultTableModel modelo = new DefaultTableModel(null, columns);
		String sql = "SELECT * FROM vw_citas";
	
	try {
        Connection con = Conectar.conexion();
        

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        
        while (rs.next()) {
            Object fila [] = new Object[columns.length];
            
            fila[0] = rs.getString("Cliente");
            fila[1] = rs.getString("Barbero");
            fila[2] = rs.getDate("Fecha");
            fila[3] = rs.getString("Servicios");
            fila[4] = rs.getInt("monto");
            
            modelo.addRow(fila);
        }
       con.close();  
	}
	
	catch (Exception e) {e.printStackTrace();}

	return modelo;
}
	
	public static void refrescarcombos(JComboBox<String> combo, String tabla) {
	    DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<>();

	    try {
	        Connection conn = Conectar.conexion();
	        PreparedStatement ps = conn.prepareStatement("SELECT nombre FROM "+ tabla);
	        ResultSet rs = ps.executeQuery();

	        while (rs.next()) {
	        	
	        	modelo.addElement(rs.getString("nombre"));
	        }

	        combo.setModel(modelo);
	        conn.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	public static ArrayList<Cliente> obtenerClientes() {
		ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
		
		
		listaClientes.add(new Cliente(0, "", null, null));
		String sql = "SELECT * FROM Clientes";
	
	try {
        Connection con = Conectar.conexion();
        

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        
        while (rs.next()) {
           Cliente c = new Cliente(
        		   rs.getInt("IDCliente"),
        		   rs.getString("Nombre"),
        		   rs.getString("Telefono"),
                   rs.getString("Correo"));
           listaClientes.add(c);
           
        }
        
       con.close();  
	}
	
	catch (Exception e) {e.printStackTrace();}
	return listaClientes;

	
} 
	
	
	public static ArrayList<UsuarioRegular> obtenerUsuarios() {
		ArrayList<UsuarioRegular> listaUsuarios = new ArrayList<UsuarioRegular>();
		
		
		String sql = "SELECT * FROM Usuarios";
	
	try {
        Connection con = Conectar.conexion();
        

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        
        while (rs.next()) {
        	UsuarioRegular u = new UsuarioRegular(
        		   rs.getInt("IDUsuario"),
        		   rs.getString("Nombre"),
        		   rs.getString("Telefono"),
                   rs.getString("Correo"),
                   rs.getString("Usuario"),
                   rs.getString("Contraseña"));
           listaUsuarios.add(u);
           
        }
        
       con.close();  
	}
	
	catch (Exception e) {e.printStackTrace();}
	return listaUsuarios;	
} 
	
	
	
	}
