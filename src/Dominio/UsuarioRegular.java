package Dominio;

import java.util.ArrayList;

public class UsuarioRegular extends UsuarioBase implements Usuario{
	

	public UsuarioRegular(int id, String nombre, String telefono, String correo,String user, String contraseña) {
		super(id, nombre, telefono, correo,user,contraseña);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void registrar() {
		
	}

	@Override
	public void actualizarDatos() {
		// TODO Auto-generated method stub
		
	}

}
