package Dominio;

public class Servicio {
	private int idServicio;
	private String nombre;
	private double precio;
	private int duracion;
	
	public Servicio(int idServicio, String nombre, double precio, int duracion) {
		this.idServicio = idServicio;
		this.nombre = nombre;
		this.precio = precio;
		this.duracion = duracion;
	}
	
	public int getIdServicio() {
		return idServicio;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public double getPrecio() {
		return precio;
	}
	

	
	public int getDuracion() {
		return duracion;
	}
	
	
	
	public void agregarServicio() {
		
	}
	
	public void editarServicio() {
		
	}
	
	public void consultarPrecio() {
		
	}
	
}
