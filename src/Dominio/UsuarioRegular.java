package Dominio;


public class UsuarioRegular extends UsuarioBase implements Usuario{

	public UsuarioRegular(int id, String nombre, String telefono, String correo,String user, String contraseña, String rol) {
		super(id, nombre, telefono, correo,user,contraseña,rol);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void registrar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizarDatos() {
		// TODO Auto-generated method stub
		
	}

}
