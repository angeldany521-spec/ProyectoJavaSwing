package Dominio;

import java.sql.Date;

public class Pago {
	private int idPago;
	private int monto;
	private String metodoPago;
	private Date fechaPago;
	private String nombreCliente;
	
	public Pago(int idPago, String nombreCliente, int monto, String metodoPago,Date fechaPago) {
		this.idPago = idPago;
		this.monto = monto;
		this.nombreCliente = nombreCliente;
		this.metodoPago = metodoPago;
		this.fechaPago = fechaPago;
	}
	
	public int getIdPago() {
		return idPago;
	}
	
	
	public int getMonto() {
		return monto;
	}
	
	
	public String getMetodoPago() {
		return metodoPago;
	}
	
	
	public Date getFechaPago() {
		return fechaPago;
	}
	
	public String getnombreCliente() {
		return nombreCliente;
	}
	
	public void registrarPago() {
		
	}
	
	public void consultarPago() {
		
	}
}
