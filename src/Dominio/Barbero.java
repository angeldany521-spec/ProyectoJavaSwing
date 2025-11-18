package Dominio;

public class Barbero extends Persona{
	private String especialidad;
	private boolean disponible;
	
	public Barbero(int id, String nombre, String telefono, String correo,String especialidad,boolean disponible) {
		super(id, nombre, telefono, correo);
		this.especialidad = especialidad;
		this.disponible = disponible;
	}
	
	
	public String getEspecialidad() {
		return especialidad;
	}
	
	
	public boolean getDisponible() {
		return disponible;
	}
	

	public void asignarCita() {
		
	}
	
	public void actualizarDisponibilidad() {
		
	}
	
	public void mostrarHorarios() {
		
	}
}
