package Dominio;

import java.sql.Date;

public class Cita {
	private int idCita;
	private Date fecha;
	private String hora;
	private String estado;
	
	
	public int getIdCita() {
		return idCita;
	}
	
	public void setIdCita(int idCita) {
		this.idCita = idCita;
	}
	
	public Date getFecha() {
		return fecha;
	}
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public String getHora() {
		return hora;
	}
	
	public void setHora(String hora) {
		this.hora = hora;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
	public void agendarCita() {
		
	}
	
	public void cancelarCita() {
		
	}
	
	public void actualizarEstado() {
		
	}
}
