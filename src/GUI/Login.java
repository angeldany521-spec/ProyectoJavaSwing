package GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import com.formdev.flatlaf.FlatLightLaf;


import BaseDeDatos.ConsultarDatos;
import Dominio.UsuarioRegular;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JPasswordField;



public class Login extends JFrame{

	private JFrame ventanaLogin;
	private JTextField campo_user;
	private JPasswordField campoContra;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.ventanaLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ventanaLogin = new JFrame();
		ventanaLogin.setResizable(false);
		ventanaLogin.getContentPane().setBackground(Paleta.fondoPrincipal);
		ventanaLogin.setBounds(460, 120, 520, 602);
		ventanaLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventanaLogin.getContentPane().setLayout(null);
		
		ArrayList<UsuarioRegular> usuarios = ConsultarDatos.obtenerUsuarios();
		
		
		ImageIcon logo = new ImageIcon(getClass().getResource("/Imagenes/LogoBarberia-1-02.png"));
		Image img = logo.getImage().getScaledInstance(220, 180, Image.SCALE_SMOOTH);
		
		
		JLabel lbllogo = new JLabel(new ImageIcon(img));
		lbllogo.setText("");
		lbllogo.setBounds(114, 10, 277, 171);
		ventanaLogin.getContentPane().add(lbllogo);
		
		
		Panel panel = new Panel(15, 2, Paleta.borde);                          
		
		panel.setBackground(Paleta.menu);
		panel.setPreferredSize(new Dimension(300, 200));
		panel.setBounds(58, 190, 389, 339);
		

		ventanaLogin.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblIniciarSesion = new JLabel("Iniciar Sesion");
		lblIniciarSesion.setFont(new Font("SansSerif", Font.BOLD, 23));
		lblIniciarSesion.setBounds(20, 25, 158, 41);
		lblIniciarSesion.setForeground(Paleta.textologin);
		panel.add(lblIniciarSesion);
		
		JLabel lbl2 = new JLabel("Ingresa tus datos para acceder al sistema\r\n");
		lbl2.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lbl2.setForeground(Paleta.textologin2);
		lbl2.setBounds(20, 70, 266, 19);
		panel.add(lbl2);
		
		campo_user = new JTextField();
		campo_user.setFont(new Font("Tahoma", Font.PLAIN, 14));
		campo_user.setBounds(20, 136, 345, 41);
		campo_user.setBorder(new Borde(10, Paleta.bordeCampos));
		campo_user.setOpaque(false);
		campo_user.setForeground(Paleta.textologin2);
		campo_user.setCaretColor(Paleta.textologin2);
		panel.add(campo_user);
		campo_user.setColumns(10);
		
		JLabel lbluser = new JLabel("Usuario");
		lbluser.setFont(new Font("SansSerif", Font.BOLD, 14));
		lbluser.setBounds(20, 110, 54, 16);
		lbluser.setForeground(Paleta.textologin);
		panel.add(lbluser);
		
		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblContrasea.setBounds(20, 189, 87, 16);
		lblContrasea.setForeground(Paleta.textologin);
		panel.add(lblContrasea);
		
		JButton botonIniciarSesion = new JButton("Iniciar Sesion");
		botonIniciarSesion.setFont(new Font("SansSerif", Font.BOLD, 18));
		botonIniciarSesion.setBounds(20, 278, 345, 35);
		botonIniciarSesion.setBackground(Paleta.fondoBoton);
		botonIniciarSesion.setForeground(Paleta.textologin);
		
		panel.add(botonIniciarSesion);
		
		campoContra = new JPasswordField();
		campoContra.setFont(new Font("Tahoma", Font.PLAIN, 14));
		campoContra.setBounds(20, 217, 345, 41);
		campoContra.setBorder(new Borde(10, Paleta.bordeCampos));
		campoContra.setForeground(Paleta.textologin2);
		campoContra.setCaretColor(Paleta.textologin2);
		campoContra.setOpaque(false);
		panel.add(campoContra);
		
		JLabel lblerror = new JLabel("El usuario o Contraseña son incorrectos, por favor vuelva a intentarlo");
		lblerror.setVisible(false);
		lblerror.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblerror.setForeground(Paleta.fondoBoton);
		lblerror.setBounds(22, 531, 462, 24);
		ventanaLogin.getContentPane().add(lblerror);
		
		botonIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = campo_user.getText();
				String contra = campoContra.getText();
				
				if (user.equals("administrador") &&
					contra.equals("admin")) {
					ventanaLogin.dispose();
					PantallaAdmin.main(null);
				}
				
				
				for (int i=0; i<usuarios.size(); i++) {
		        	if (usuarios.get(i).getUser().equals(user) &&
		        		usuarios.get(i).getContraseña().equals(contra)) {
		        		PantallaPrincipal.main(null);
		        		ventanaLogin.dispose();	
		        	}
		        	
	        	else {lblerror.setVisible(true);}
		        	
				}
			}
			
			
			
		});
	}
	


}
