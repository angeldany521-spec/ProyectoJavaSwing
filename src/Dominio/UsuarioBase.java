package Dominio;

public abstract class UsuarioBase extends Persona{

	private String user;
	private String contraseña;
	private String rol;
	
	public UsuarioBase(int id, String nombre, String telefono, String correo,String user,String contraseña,String rol) {
		super(id, nombre, telefono, correo);
		this.user = user;
		this.contraseña = contraseña;
		this.rol = rol;
	}
	
	
	public String getUser() {
		return user;
	}
	
	
	public String getContraseña() {
		return contraseña;
	}
	
	
	public String getRol() {
		return rol;
	}
	
}
