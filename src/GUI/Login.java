package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;



public class Login {

	private JFrame ventanaLogin;
	private JTextField campo_user;
	private JPasswordField campoContra;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

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
		ventanaLogin.getContentPane().setBackground(Paleta.fondoPrincipal);
		ventanaLogin.setBounds(100, 100, 519, 578);
		ventanaLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventanaLogin.getContentPane().setLayout(null);
		
		Panel panel = new Panel(15, 2, Paleta.borde);                          

		panel.setBackground(Color.WHITE);
		panel.setPreferredSize(new Dimension(300, 200));
		panel.setBounds(58, 150, 389, 339);
		
		
		
		
		
		
		
		ventanaLogin.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblIniciarSesion = new JLabel("Iniciar Sesion");
		lblIniciarSesion.setFont(new Font("SansSerif", Font.BOLD, 25));
		lblIniciarSesion.setBounds(20, 25, 158, 41);
		panel.add(lblIniciarSesion);
		
		JLabel lbl2 = new JLabel("Ingresa tus datos para acceder al sistema\r\n");
		lbl2.setFont(new Font("SansSerif", Font.BOLD, 13));
		lbl2.setForeground(Paleta.textologin);
		lbl2.setBounds(20, 70, 266, 19);
		panel.add(lbl2);
		
		campo_user = new JTextField();
		campo_user.setBounds(20, 129, 345, 41);
		campo_user.setBorder(new Borde(10, Paleta.bordeCampos));
		panel.add(campo_user);
		campo_user.setColumns(10);
		
		JLabel lbluser = new JLabel("Usuario");
		lbluser.setFont(new Font("SansSerif", Font.BOLD, 14));
		lbluser.setBounds(20, 110, 54, 16);
		panel.add(lbluser);
		
		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblContrasea.setBounds(20, 180, 87, 16);
		panel.add(lblContrasea);
		
		JButton botonIniciarSesion = new JButton("Iniciar Sesion");
		botonIniciarSesion.setFont(new Font("SansSerif", Font.BOLD, 18));
		botonIniciarSesion.setBounds(20, 273, 345, 33);
		botonIniciarSesion.setBorder(new Borde(5, Paleta.bordeCampos));
		botonIniciarSesion.setBackground(Paleta.fondoBoton);
		
		panel.add(botonIniciarSesion);
		
		campoContra = new JPasswordField();
		campoContra.setBounds(20, 206, 345, 41);
		campoContra.setBorder(new Borde(10, Paleta.bordeCampos));
		panel.add(campoContra);
		
		
	}
}
