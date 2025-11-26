package Dominio;

import java.awt.Button;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ForkJoinPool;

import javax.swing.JButton;



import GUI.Paleta;


public class Barbero extends Persona{

	private boolean disponible;
	private String[] horario;
	private String turno; 
	private JButton[] botones = new JButton[8];
	
	public Barbero(int id, String nombre, String telefono, String correo, String turno) {
		super(id, nombre, telefono, correo);
		this.turno = turno;
		
		
		this.horario = (turno.equals("Mañana")) 
				? new String[] {"9:00AM","9:30AM", "10:00AM", "10:30AM", "11:00AM", "11:30AM", "12:00AM", "1:00PM" } 
				: new String[]  {"2:00PM", "2:30PM", "3:00PM", "3:30PM", "4:00PM", "4:30PM", "5:00PM", "6:00PM"};
		
		for (int i = 0; i < botones.length; i++) {
		    botones[i] = new JButton(mostrarHorarios()[i]);
		    botones[i].setFont(new Font("Sansserif", Font.BOLD, 15));
        	botones[i].setBackground(Paleta.menu);
        	botones[i].setForeground(Paleta.fondoPrincipal);
        	botones[i].setOpaque(false);
    

             

        	}
        	
        for (JButton b : botones) {
        		b.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						for (JButton bu : botones) {
							bu.setBackground(Paleta.menu);
						}
						b.setBackground(Paleta.fondoBoton);
					
					}
				
				});
        	}
		}
	
	

	
	public JButton[] getBotones(){
		return botones;
	}
	
	
	public String getTurno() {
		return turno;
	}
	
	public String[] mostrarHorarios() {
		return horario;
	}
	
	

	public void asignarCita() {
		
	}
	
	
	
}
