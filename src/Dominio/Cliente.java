package Dominio;

public class Cliente extends Persona {
	private int puntosFidelidad;
	
	public Cliente(int id, String nombre, String telefono, String correo,int puntosFidelidad) {
		super(id, nombre, telefono, correo);
		this.puntosFidelidad = puntosFidelidad;
	}
	
	public int getPuntosFidelidad() {
		return puntosFidelidad;
	}
	
	public void setPuntosFidelidad(int puntosFidelidad) {
		this.puntosFidelidad = puntosFidelidad;
	}
}
