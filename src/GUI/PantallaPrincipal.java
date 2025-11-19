package GUI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



import java.awt.SystemColor;
import java.awt.MultipleGradientPaint.ColorSpaceType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;

public class PantallaPrincipal {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaPrincipal window = new PantallaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PantallaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 850, 602);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout());
		frame.getContentPane().setBackground(Paleta.fondo2);
		JPanel panelPrincipal;
	    CardLayout card;

        JPanel menu = new JPanel();
        menu.setPreferredSize(new Dimension(150, 0));
        menu.setBackground(Paleta.menu);
        menu.setOpaque(true);
        menu.setLayout(null);
        
        
        
        JButton crearCitas = new JButton("Crear Cita");
        crearCitas.setFont(new Font("SansSerif", Font.PLAIN, 15));
        crearCitas.setBorder(null);
        crearCitas.setBounds(0, 166, 150, 46);
        crearCitas.setForeground(Paleta.textologin2);
        crearCitas.setContentAreaFilled(true);
        crearCitas.setFocusPainted(false);
        crearCitas.setBorderPainted(false);
        crearCitas.setOpaque(true);
        crearCitas.setBackground(Paleta.menu);
        
        JButton historialPagos = new JButton("Historial de Pagos");
        historialPagos.setFont(new Font("SansSerif", Font.PLAIN, 15));
        historialPagos.setBorder(null);
        historialPagos.setBounds(0, 211, 150, 46);
        historialPagos.setForeground(Paleta.textologin2);
        historialPagos.setContentAreaFilled(true);
        historialPagos.setFocusPainted(false);
        historialPagos.setBorderPainted(false);
        historialPagos.setOpaque(true);
        historialPagos.setBackground(Paleta.menu);
        
        JButton citas = new JButton("Citas");
        citas.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        citas.setFont(new Font("SansSerif", Font.PLAIN, 15));
        citas.setBorder(null);
        citas.setBounds(0, 121, 150, 46);
        citas.setForeground(Paleta.textologin2);
        citas.setContentAreaFilled(true);
        citas.setFocusPainted(false);
        citas.setBorderPainted(false);
        citas.setOpaque(true);
        citas.setBackground(Paleta.menu);
        
        menu.add(citas);
        menu.add(crearCitas);
        menu.add(historialPagos);
        
   
        
      

        frame.getContentPane().add(menu, BorderLayout.WEST);
        
        JButton btnCerrarSesion = new JButton("Cerrar Sesion");
        btnCerrarSesion.setOpaque(true);
        btnCerrarSesion.setForeground(Paleta.textologin2);
        btnCerrarSesion.setFont(new Font("SansSerif", Font.PLAIN, 15));
        btnCerrarSesion.setFocusPainted(false);
        btnCerrarSesion.setContentAreaFilled(true);
        btnCerrarSesion.setBorderPainted(false);
        btnCerrarSesion.setBorder(null);
        btnCerrarSesion.setBackground(Paleta.menu);
        btnCerrarSesion.setBounds(0, 464, 150, 46);
        menu.add(btnCerrarSesion);
        
        

        

        

        
    
        
    

    
	        
       
        
        citas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				citas.setBackground(Color.gray);
				crearCitas.setBackground(Paleta.menu);
				historialPagos.setBackground(Paleta.menu);
			}
		});
        
        crearCitas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crearCitas.setBackground(Color.gray);
				citas.setBackground(Paleta.menu);
				historialPagos.setBackground(Paleta.menu);
			}
		});
        
        historialPagos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				historialPagos.setBackground(Color.gray);
				crearCitas.setBackground(Paleta.menu);
				citas.setBackground(Paleta.menu);
			}
		});
        
        
        
        
        
        
        
        
    }
	
}


