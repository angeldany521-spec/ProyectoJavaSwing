package Dominio;

import java.sql.Date;

public class Pago {
	private int idPago;
	private double monto;
	private String metodoPago;
	private Date fechaPago;
	
	public Pago(int idPago,double monto,String metodoPago,Date fechaPago) {
		this.fechaPago = fechaPago;
		this.monto = monto;
		this.metodoPago = metodoPago;
		this.fechaPago = fechaPago;
	}
	
	public int getIdPago() {
		return idPago;
	}
	
	
	public double getMonto() {
		return monto;
	}
	
	
	public String getMetodoPago() {
		return metodoPago;
	}
	
	
	public Date getFechaPago() {
		return fechaPago;
	}
	
	
	public void registrarPago() {
		
	}
	
	public void consultarPago() {
		
	}
}
