package Dominio;

public class Admin extends UsuarioBase implements Usuario{
	private int nivelAcceso;
	
	
	public Admin(int id, String nombre, String telefono, String correo,String user,String contraseña,String rol,int nivelAcceso) {
		super(id, nombre, telefono, correo, user, contraseña, rol);
		this.nivelAcceso = nivelAcceso;
	}
	
	
	public int getNivelAcceso() {
		return nivelAcceso;
	}
	
	@Override
	public void registrar() {
		
	}

	@Override
	public void actualizarDatos() {
		
	}

}
