package Dominio;

import java.sql.Date;

public class Cita {
	private int idCita;
	private Date fecha;
	private String hora;
	private String estado;
	
	public Cita(int idCita,Date fecha,String hora,String estado) {
		this.idCita = idCita;
		this.fecha = fecha;
		this.hora = hora;
		this.estado = estado;
	}
	
	
	public int getIdCita() {
		return idCita;
	}
	
	public Date getFecha() {
		return fecha;
	}
	
	public String getHora() {
		return hora;
	}
	
	
	
	public String getEstado() {
		return estado;
	}
	
	
	
	
	
	public void agendarCita() {
		
	}
	
	public void cancelarCita() {
		
	}
	
	public void actualizarEstado() {
		
	}
}
