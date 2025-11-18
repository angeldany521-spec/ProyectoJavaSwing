package Dominio;

public class Admin extends UsuarioBase implements Usuario{
	private int nivelAcceso;
	
	
	public void setNivelAcceso(int nivelAcceso) {
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
