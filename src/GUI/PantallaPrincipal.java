
package GUI;
import GUI.PantallaAdmin.*;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.lang.foreign.AddressLayout;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ForkJoinPool;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import BaseDeDatos.ConsultarDatos;
import BaseDeDatos.GuardarDatos;
import Dominio.Barbero;
import Dominio.Cliente;
import Dominio.Servicio;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.List;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;



public class PantallaPrincipal {

	private JFrame frame;
	private JTextField campoBuscar;
	private JTable tableCitas;
	private JTextField buscarHistorialPagos;
	private JTable tableHistorialPagos;
	private JTextField campoNombreCliente;
	private JTextField campoTelefonoCliente;
	private JTextField campoCorreoCliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		try {

		for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {

		if ("Nimbus".equals(info.getName())) {

		UIManager.setLookAndFeel(info.getClassName());

		break;

		}

		}

		} catch (Exception e) {

		// Si Nimbus no está disponible, puedes establecer otro Look and Feel.

		try {

		UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());

		} catch (Exception ex) {

		// Manejo de excepción

		}

}
        

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
		frame.setBounds(100, 100, 1182, 737);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout());
		frame.getContentPane().setBackground(Paleta.fondo2);
		
		
		ArrayList<Barbero> barberos = ConsultarDatos.obtenerBarberos();
		ArrayList<Cliente> clientes = ConsultarDatos.obtenerClientes();
		
		
		Servicio[] servicios = {new Servicio(0, "Cerquillo", 100),
								new Servicio(1, "Corte regular", 300),
								new Servicio(2, "Corte Moderno", 500),
								new Servicio(3, "Tintado de pelo", 400),
								new Servicio(4, "Trenzado sin diseño", 500),
								new Servicio(5, "Depilacion de cejas", 150),
								new Servicio(6, "Barba", 150),
								new Servicio(7, "Facial", 100)};
		
		
		
		
		
        JPanel menu = new JPanel();
        menu.setPreferredSize(new Dimension(150, 0));
        menu.setBackground(Paleta.menu);
        menu.setOpaque(true);
        menu.setLayout(null);
        
        
        
        JButton crearCitas = new JButton("Crear Cita");
        crearCitas.setFont(new Font("SansSerif", Font.BOLD, 15));
        crearCitas.setBorder(null);
        crearCitas.setBounds(0, 143, 150, 46);
        crearCitas.setForeground(Paleta.textologin);
        crearCitas.setContentAreaFilled(true);
        crearCitas.setFocusPainted(false);
        crearCitas.setBorderPainted(false);
        crearCitas.setOpaque(false);
        crearCitas.setBackground(Paleta.fondoBoton2);
        
        JButton historialPagos = new JButton("Historial de Pagos");
        historialPagos.setFont(new Font("SansSerif", Font.BOLD, 15));
        historialPagos.setBorder(null);
        historialPagos.setBounds(0, 188, 150, 46);
        historialPagos.setForeground(Paleta.textologin);
        historialPagos.setContentAreaFilled(true);
        historialPagos.setFocusPainted(false);
        historialPagos.setBorderPainted(false);
        historialPagos.setOpaque(false);
        historialPagos.setBackground(Paleta.fondoBoton2);
        
        JButton citas = new JButton("Citas");
        citas.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        citas.setFont(new Font("SansSerif", Font.BOLD, 15));
        citas.setBorder(null);
        citas.setBounds(0, 97, 150, 46);
        citas.setForeground(Paleta.textologin);
        citas.setContentAreaFilled(true);
        citas.setFocusPainted(false);
        citas.setBorderPainted(false);
        citas.setOpaque(false);
        citas.setBackground(Paleta.fondoBoton2);
        
        menu.add(citas);
        menu.add(crearCitas);
        menu.add(historialPagos);
 
        
        frame.getContentPane().add(menu, BorderLayout.WEST);
        
        JButton btnCerrarSesion = new JButton("Cerrar Sesion");
        btnCerrarSesion.setOpaque(false);
        btnCerrarSesion.setForeground(Paleta.textologin);
        btnCerrarSesion.setFont(new Font("SansSerif", Font.BOLD, 15));
        btnCerrarSesion.setFocusPainted(false);
        btnCerrarSesion.setContentAreaFilled(true);
        btnCerrarSesion.setBorderPainted(false);
        btnCerrarSesion.setBorder(null);
        btnCerrarSesion.setBackground(Paleta.fondoBoton2);
        btnCerrarSesion.setBounds(0, 432, 150, 46);
        menu.add(btnCerrarSesion);
        
        JLabel lblbarber = new JLabel("BarberPiece\r\n");
        lblbarber.setFont(new Font("Tahoma", Font.BOLD, 21));
        lblbarber.setForeground(Paleta.textologin);;
        lblbarber.setBounds(10, 10, 130, 35);
        menu.add(lblbarber);
        
        JButton aggCliente = new JButton("Agregar Cliente");
        aggCliente.setOpaque(false);
        aggCliente.setForeground(new Color(242, 240, 235));
        aggCliente.setFont(new Font("SansSerif", Font.BOLD, 15));
        aggCliente.setFocusPainted(false);
        aggCliente.setContentAreaFilled(true);
        aggCliente.setBorderPainted(false);
        aggCliente.setBorder(null);
        aggCliente.setBackground(new Color(200, 50, 42));
        aggCliente.setBounds(0, 233, 150, 46);
        menu.add(aggCliente);
        
        CardLayout card = new CardLayout();
        JPanel panel = new JPanel();  
        panel.setBackground(Paleta.fondo2);
        panel.setLayout(card);
        panel.setOpaque(true);
        
        frame.getContentPane().add(panel);
        
        PanelGestionCitas Inicio = new PanelGestionCitas();
        Inicio.setPreferredSize(new Dimension(1400, 700));
        Inicio.setForeground(new Color(0, 0, 0));
        Inicio.setBackground(Paleta.fondo2);
        Inicio.setOpaque(true);
        panel.add(Inicio, "cita");
        Inicio.setLayout(null);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setOpaque(false);
        scrollPane.setBorder(null);
        scrollPane.setBounds(12, 72, 1001, 480);
        
       
        Inicio.add(scrollPane);
        
        String[] columnasCitas = {"Cliente", "Barber", "Fecha", "Servicio", "Precio"};
        
        		
        
        DefaultTableModel modeloCitas = new DefaultTableModel(columnasCitas, 0);
        modeloCitas.addRow(new String[]{"Cliente", "Barbero", "Fecha", "Servicio", "Precio"});
        modeloCitas.addRow(new String[]{"Cliente", "Barbero", "Fecha", "Servicio", "Precio"});
        modeloCitas.addRow(new String[]{"Cliente", "Barbero", "Fecha", "Servicio", "Precio"});
        modeloCitas.addRow(new String[]{"Cliente", "Barbero", "Fecha", "Servicio", "Precio"});
        
        
        
        tableCitas = new JTable(modeloCitas);
        tableCitas.setRowHeight(20);
        tableCitas.setSize(new Dimension(0, 5));
        tableCitas.getTableHeader().setBackground(Paleta.headers);
        tableCitas.getTableHeader().setForeground(Paleta.textologin2);
        tableCitas.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 13));
        tableCitas.setShowGrid(true);
        tableCitas.setGridColor(Paleta.fondoPrincipal);
        tableCitas.setForeground(Paleta.fondoPrincipal);
        tableCitas.setFillsViewportHeight(true);
        tableCitas.setBackground(Paleta.table);
        tableCitas.setFont(new Font("SansSerif", Font.PLAIN, 13));
        scrollPane.setViewportView(tableCitas);
        
        panelAgregarCliente panelAgregarCliente = new panelAgregarCliente();
        panel.add(panelAgregarCliente, "agregarcliente");
        panelAgregarCliente.setLayout(null);
        
        Panel panelDatosCliente = new Panel(15, 2, Paleta.borde);
        panelDatosCliente.setBounds(260, 120, 501, 442);
        panelDatosCliente.setBackground(Paleta.menu);
        panelAgregarCliente.add(panelDatosCliente);
        panelDatosCliente.setLayout(null);
        
        JLabel lblInformacionDeLa_1 = new JLabel("Informacon del cliente");
        lblInformacionDeLa_1.setBounds(12, 12, 211, 21);
        panelDatosCliente.add(lblInformacionDeLa_1);
        lblInformacionDeLa_1.setForeground(new Color(96, 165, 250));
        lblInformacionDeLa_1.setFont(new Font("SansSerif", Font.BOLD, 18));
        
        campoNombreCliente = new JTextField();
        campoNombreCliente.setBounds(12, 76, 477, 35);
        panelDatosCliente.add(campoNombreCliente);
        campoNombreCliente.setForeground(new Color(242, 240, 235));
        campoNombreCliente.setFont(new Font("SansSerif", Font.PLAIN, 14));
        campoNombreCliente.setColumns(10);
        campoNombreCliente.setBorder(new Borde(8, Paleta.fondoPrincipal));
        campoNombreCliente.setBackground(new Color(31, 41, 55));
        
        JLabel lblNewLabel_1_2 = new JLabel("Nombre");
        lblNewLabel_1_2.setBounds(12, 52, 65, 16);
        panelDatosCliente.add(lblNewLabel_1_2);
        lblNewLabel_1_2.setForeground(new Color(242, 240, 235));
        lblNewLabel_1_2.setFont(new Font("SansSerif", Font.BOLD, 14));
        
        campoTelefonoCliente = new JTextField();
        campoTelefonoCliente.setBounds(12, 172, 477, 35);
        panelDatosCliente.add(campoTelefonoCliente);
        campoTelefonoCliente.setForeground(new Color(242, 240, 235));
        campoTelefonoCliente.setFont(new Font("SansSerif", Font.PLAIN, 14));
        campoTelefonoCliente.setColumns(10);
        campoTelefonoCliente.setBorder(new Borde(8, Paleta.fondoPrincipal));
        campoTelefonoCliente.setBackground(new Color(31, 41, 55));
        
        JLabel lblNewLabel_1_1_2 = new JLabel("Telefono");
        lblNewLabel_1_1_2.setBounds(12, 148, 65, 16);
        panelDatosCliente.add(lblNewLabel_1_1_2);
        lblNewLabel_1_1_2.setForeground(new Color(242, 240, 235));
        lblNewLabel_1_1_2.setFont(new Font("SansSerif", Font.BOLD, 14));
        
        campoCorreoCliente = new JTextField();
        campoCorreoCliente.setBounds(12, 268, 477, 35);
        panelDatosCliente.add(campoCorreoCliente);
        campoCorreoCliente.setForeground(new Color(242, 240, 235));
        campoCorreoCliente.setFont(new Font("SansSerif", Font.PLAIN, 14));
        campoCorreoCliente.setColumns(10);
        campoCorreoCliente.setBorder(new Borde(8, Paleta.fondoPrincipal));
        campoCorreoCliente.setBackground(new Color(31, 41, 55));
        
        JLabel lblNewLabel_1_1_1_1 = new JLabel("Correo");
        lblNewLabel_1_1_1_1.setBounds(12, 244, 65, 16);
        panelDatosCliente.add(lblNewLabel_1_1_1_1);
        lblNewLabel_1_1_1_1.setForeground(new Color(242, 240, 235));
        lblNewLabel_1_1_1_1.setFont(new Font("SansSerif", Font.BOLD, 14));
        
        ImageIcon agg = new ImageIcon(getClass().getResource("/Imagenes/botonAgregar.png"));
        Image img = agg.getImage();
        Image size = img.getScaledInstance(18, 18, Image.SCALE_SMOOTH);
        ImageIcon aggIcon = new ImageIcon(size);
        
        JButton agregarCliente = new JButton("Agregar", aggIcon);
        agregarCliente.setBounds(55, 350, 391, 41);
        panelDatosCliente.add(agregarCliente);
        agregarCliente.setForeground(new Color(242, 240, 235));
        agregarCliente.setFont(new Font("SansSerif", Font.BOLD, 16));
        agregarCliente.setFocusPainted(false);
        agregarCliente.setContentAreaFilled(true);
        agregarCliente.setBorderPainted(false);
        agregarCliente.setBorder(null);
        agregarCliente.setBackground(new Color(96, 165, 250));
        
        
        JLabel lblAgregarCliente = new JLabel("Agregar Cliente");
        lblAgregarCliente.setForeground(new Color(96, 165, 250));
        lblAgregarCliente.setFont(new Font("SansSerif", Font.BOLD, 27));
        lblAgregarCliente.setBackground(new Color(242, 240, 235));
        lblAgregarCliente.setBounds(12, 12, 210, 35);
        panelAgregarCliente.add(lblAgregarCliente);
        
        JPanel panelSuperior = new JPanel();
        panelSuperior.setBounds(12, 12, 1001, 51);
        panelSuperior.setBackground(Paleta.fondoPrincipal);
        Inicio.add(panelSuperior);
        panelSuperior.setLayout(null);
        
        JLabel lblCitas = new JLabel("Citas");
        lblCitas.setBounds(12, 8, 66, 35);
        panelSuperior.add(lblCitas);
        lblCitas.setFont(new Font("SansSerif", Font.BOLD, 27));
        lblCitas.setForeground(Paleta.textologin2);
        lblCitas.setBackground(Paleta.fondo2);
        
        ImageIcon elim = new ImageIcon(getClass().getResource("/Imagenes/botonBorrar.png"));
        Image img1 = elim.getImage();
        Image size1 = img1.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon elimIcon = new ImageIcon(size1);
        
        JButton eliminarCita = new JButton("Eliminar Cita", elimIcon);
        eliminarCita.setBounds(789, 5, 200, 40);
        eliminarCita.setOpaque(false);
        eliminarCita.setBorder(null);
        panelSuperior.add(eliminarCita);
        eliminarCita.setPreferredSize(new Dimension(200, 40));
        eliminarCita.setFont(new Font("SansSerif", Font.BOLD, 16));
        
        eliminarCita.setBackground(Paleta.fondoBoton2);
        eliminarCita.setForeground(Paleta.textologin);
        panelSuperior.add(eliminarCita);
        
        campoBuscar = new JTextField();
        campoBuscar.setBounds(229, 5, 461, 40);
        panelSuperior.add(campoBuscar);
        campoBuscar.setPreferredSize(new Dimension(100, 40));
        campoBuscar.setOpaque(false);
        campoBuscar.setBackground(Paleta.fondo2);
        campoBuscar.setForeground(Paleta.menu);
        campoBuscar.setFont(new Font("SansSerif", Font.PLAIN, 14));
        campoBuscar.setBorder(new Borde(10, Paleta.menu));
        campoBuscar.setColumns(40);
        
        
        
        PanelGestionPagos verHistorialPagos = new PanelGestionPagos();
        verHistorialPagos.setBackground(Paleta.fondoPrincipal);
        panel.add(verHistorialPagos, "historialPagos");
        verHistorialPagos.setOpaque(true);
        
        JPanel panelSuperior_1 = new JPanel();
        panelSuperior_1.setBackground(Paleta.fondoPrincipal);
        panelSuperior_1.setBounds(0, 10, 1023, 57);
        verHistorialPagos.add(panelSuperior_1);
        panelSuperior_1.setLayout(null);
        
        JLabel lblHistorialPagos = new JLabel("Historial De Pagos");
        lblHistorialPagos.setBounds(9, 10, 241, 37);
        lblHistorialPagos.setForeground(new Color(70, 150, 230));
        lblHistorialPagos.setFont(new Font("SansSerif", Font.BOLD, 27));
        lblHistorialPagos.setBackground(new Color(240, 235, 220));
        panelSuperior_1.add(lblHistorialPagos);
        
        
        buscarHistorialPagos = new JTextField();
        buscarHistorialPagos.setPreferredSize(new Dimension(100, 30));
        buscarHistorialPagos.setBounds(621, 8, 392, 41);
        buscarHistorialPagos.setOpaque(false);
        buscarHistorialPagos.setFont(new Font("SansSerif", Font.PLAIN, 14));
        buscarHistorialPagos.setForeground(Paleta.menu);
        buscarHistorialPagos.setColumns(30);
        buscarHistorialPagos.setBorder(new Borde(10, Paleta.menu));
        buscarHistorialPagos.setBackground(Paleta.fondoPrincipal);
        panelSuperior_1.add(buscarHistorialPagos);
        
        JPanel panelFiltro = new JPanel();
        panelFiltro.setBounds(334, 3, 196, 51);
        panelSuperior_1.add(panelFiltro);
        panelFiltro.setPreferredSize(new Dimension(100, 19));
        panelFiltro.setBackground(Paleta.fondoPrincipal);
        panelFiltro.setLayout(null);
        
        JLabel lblFiltro = new JLabel("Filtrar por");
        lblFiltro.setBounds(61, 7, 74, 19);
        lblFiltro.setForeground(Paleta.textologin2);
        lblFiltro.setFont(new Font("SansSerif", Font.BOLD, 15));
        panelFiltro.add(lblFiltro);
        
        ButtonGroup filtros = new ButtonGroup();
        JRadioButton filtroMetodo = new JRadioButton("Metodo de pago");
        filtroMetodo.setFont(new Font("SansSerif", Font.PLAIN, 13));
        filtroMetodo.setForeground(Paleta.panel);
        filtroMetodo.setOpaque(false);
        filtroMetodo.setBounds(69, 27, 117, 21);
        panelFiltro.add(filtroMetodo);
        
        JRadioButton filtroFecha = new JRadioButton("Fecha");
        filtroFecha.setFont(new Font("SansSerif", Font.PLAIN, 13));
        filtroFecha.setForeground(Paleta.panel);
        filtroFecha.setOpaque(false);
        filtroFecha.setBounds(4, 27, 61, 21);
        panelFiltro.add(filtroFecha);
        
        filtros.add(filtroMetodo);
        filtros.add(filtroFecha);
        
        
        
        
        
        
        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setOpaque(false);
        scrollPane_1.setBorder(null);
        scrollPane_1.setBounds(10, 71, 1004, 480);
        verHistorialPagos.add(scrollPane_1);
        
        String[] columnasPagos = {"Cliente", "Monto", "Metodo de pago", "Fecha de pago"};
        
        DefaultTableModel modeloPagos = new DefaultTableModel(columnasPagos, 0);
        modeloPagos.addRow(new String[] {"Cliente", "Monto", "Metodo de pago", "Fecha de pago"});
        modeloPagos.addRow(new String[] {"Cliente", "Monto", "Metodo de pago", "Fecha de pago"});
        modeloPagos.addRow(new String[] {"Cliente", "Monto", "Metodo de pago", "Fecha de pago"});
        modeloPagos.addRow(new String[] {"Cliente", "Monto", "Metodo de pago", "Fecha de pago"});
     
        tableHistorialPagos = new JTable(modeloPagos);
        tableHistorialPagos.setRowHeight(20);
        tableHistorialPagos.setSize(new Dimension(0, 5));
        tableHistorialPagos.getTableHeader().setBackground(Paleta.headers);
        tableHistorialPagos.getTableHeader().setForeground(Paleta.textologin2);
        tableHistorialPagos.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 13));
        tableHistorialPagos.setShowGrid(true);
        tableHistorialPagos.setGridColor(Paleta.fondoPrincipal);
        tableHistorialPagos.setForeground(Paleta.fondoPrincipal);
        tableHistorialPagos.setFillsViewportHeight(true);
        tableHistorialPagos.setBackground(Paleta.table);
        tableHistorialPagos.setFont(new Font("SansSerif", Font.PLAIN, 13));
        scrollPane_1.setViewportView(tableHistorialPagos);
        
        
        
        
        
        CrearCita crearCita = new CrearCita();
        panel.add(crearCita, "crearcitas");
        crearCita.setOpaque(true);
        crearCita.setBackground(Paleta.fondoPrincipal);
        crearCita.setLayout(null);
       
        
     
        
        
        JLabel lblHistorialPagos_1 = new JLabel("Agregar Cita");
        lblHistorialPagos_1.setForeground(new Color(70, 150, 230));
        lblHistorialPagos_1.setFont(new Font("SansSerif", Font.BOLD, 27));
        lblHistorialPagos_1.setBackground(new Color(240, 235, 220));
        lblHistorialPagos_1.setBounds(15, 10, 241, 35);
        crearCita.add(lblHistorialPagos_1);
        
        Panel panelFecha = new Panel(20,1, Paleta.textologin2);
        panelFecha.setBounds(15, 50, 376, 128);
        panelFecha.setBackground(Paleta.menu);
        crearCita.add(panelFecha);
        panelFecha.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Fecha");
        lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        lblNewLabel.setForeground(Paleta.textologin2);
        lblNewLabel.setBounds(12, 12, 165, 21);
        panelFecha.add(lblNewLabel);
        
        Panel panelBarberos = new Panel(20,1, Paleta.textologin2);
        panelBarberos.setLayout(null);
        panelBarberos.setBackground(Paleta.menu);
        panelBarberos.setBounds(15, 204, 995, 380);
        crearCita.add(panelBarberos);
        
        JLabel lblNewLabel_1_2_2 = new JLabel("Barbero");
        lblNewLabel_1_2_2.setForeground(new Color(242, 240, 235));
        lblNewLabel_1_2_2.setFont(new Font("SansSerif", Font.BOLD, 14));
        lblNewLabel_1_2_2.setBounds(12, 45, 76, 16);
        panelBarberos.add(lblNewLabel_1_2_2);
        
        JComboBox barberoscombo = new JComboBox();
        barberoscombo.setBounds(12, 73, 442, 34);
        barberoscombo.setBackground(Paleta.menu);
        barberoscombo.setFont(new Font("SansSerif", Font.PLAIN, 14)); 
        barberoscombo.setForeground(Paleta.fondoPrincipal);
        
        barberoscombo.setOpaque(false);
        
        panelBarberos.add(barberoscombo);
        
        
        
        for (int i=0; i<barberos.size(); i++) {
        	barberoscombo.addItem(barberos.get(i).getNombre());
        }
        
        JLabel lblSeleccionarBarbero = new JLabel("Seleccionar Barbero y Servicios");
        lblSeleccionarBarbero.setForeground(new Color(96, 165, 250));
        lblSeleccionarBarbero.setFont(new Font("SansSerif", Font.BOLD, 18));
        lblSeleccionarBarbero.setBounds(12, 12, 283, 21);
        panelBarberos.add(lblSeleccionarBarbero);
        
        
        
        
        JLabel lblNewLabel_1_2_2_1_1_1_1 = new JLabel("Cliente");
        lblNewLabel_1_2_2_1_1_1_1.setForeground(new Color(242, 240, 235));
        lblNewLabel_1_2_2_1_1_1_1.setFont(new Font("SansSerif", Font.BOLD, 14));
        lblNewLabel_1_2_2_1_1_1_1.setBounds(474, 45, 70, 16);
        panelBarberos.add(lblNewLabel_1_2_2_1_1_1_1);
        
        JComboBox comboClientes = new JComboBox();
        comboClientes.setOpaque(false);
        comboClientes.setForeground(new Color(242, 240, 235));
        comboClientes.setFont(new Font("SansSerif", Font.PLAIN, 14));
        comboClientes.setBackground(new Color(31, 41, 55));
        comboClientes.setBounds(474, 73, 442, 34);
        panelBarberos.add(comboClientes);
        
        
        for (int i=0; i<clientes.size(); i++) {
        	comboClientes.addItem(clientes.get(i).getNombre());
        }
        
        JPanel panelServicios = new JPanel();
        panelServicios.setBounds(12, 171, 904, 93);
        panelBarberos.add(panelServicios);
        panelServicios.setBackground(new Color(31, 41, 55));
        panelServicios.setLayout(new GridLayout(2, 3, 25, 40));
        
        JCheckBox service1 = new JCheckBox("New check box");
        panelServicios.add(service1);
        
        JCheckBox service2 = new JCheckBox("New check box");
        panelServicios.add(service2);
        
        JCheckBox service3 = new JCheckBox("New check box");
        panelServicios.add(service3);
        
        JCheckBox service4 = new JCheckBox("New check box");
        panelServicios.add(service4);
        
        JCheckBox service5 = new JCheckBox("New check box");
        panelServicios.add(service5);
        
        JCheckBox service6 = new JCheckBox("New check box");
        panelServicios.add(service6);
        
        JCheckBox service7 = new JCheckBox("New check box");
        panelServicios.add(service7);
        
        JCheckBox service8 = new JCheckBox("New check box");
        panelServicios.add(service8);
        
        JLabel lblSeleccionarCliente = new JLabel("Seleccionar Cliente");
        lblSeleccionarCliente.setForeground(new Color(96, 165, 250));
        lblSeleccionarCliente.setFont(new Font("SansSerif", Font.BOLD, 18));
        lblSeleccionarCliente.setBounds(473, 16, 283, 21);
        panelBarberos.add(lblSeleccionarCliente);
        
        JLabel lblSeleccionarServicios = new JLabel("Seleccionar Servicios");
        lblSeleccionarServicios.setForeground(new Color(96, 165, 250));
        lblSeleccionarServicios.setFont(new Font("SansSerif", Font.BOLD, 18));
        lblSeleccionarServicios.setBounds(12, 138, 283, 21);
        panelBarberos.add(lblSeleccionarServicios);
        
        
        JButton confirmarCita = new JButton("Confirmar Cita");
        confirmarCita.setBounds(178, 307, 638, 41);
        panelBarberos.add(confirmarCita);
        confirmarCita.setOpaque(false);
        confirmarCita.setForeground(new Color(242, 240, 235));
        confirmarCita.setFont(new Font("SansSerif", Font.BOLD, 16));
        confirmarCita.setFocusPainted(false);
        confirmarCita.setContentAreaFilled(true);
        confirmarCita.setBorderPainted(false);
        confirmarCita.setBorder(null);
        confirmarCita.setBackground(Paleta.textologin2);
        
        confirmarCita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selected = barberoscombo.getSelectedIndex();
				int idbarber = barberos.get(selected).getId();
				
				
						
			
				
				for (JButton select : barberos.get(selected).getBotones()) {
					if (select.getBackground() == Paleta.fondoBoton) {
						select.setEnabled(false);
					}
				}
		
		
//				GuardarDatos.guardarClientes(nombre, telefono, correo);
		}
		});
        
        Panel paneldatos = new Panel(20,1, Paleta.textologin2);
        paneldatos.setLayout(null);
        paneldatos.setBackground(Paleta.menu);
        paneldatos.setBounds(419, 50, 591, 128);
        crearCita.add(paneldatos);
        
        JLabel lblHorariosDisponiblesDel = new JLabel("Horarios disponibles del barbero");
        lblHorariosDisponiblesDel.setForeground(new Color(96, 165, 250));
        lblHorariosDisponiblesDel.setFont(new Font("SansSerif", Font.BOLD, 18));
        lblHorariosDisponiblesDel.setBounds(12, 12, 292, 21);
        paneldatos.add(lblHorariosDisponiblesDel);
        
        JPanel panelHorarios = new JPanel();
        panelHorarios.setBounds(12, 40, 567, 76);
        panelHorarios.setBackground(Paleta.menu);
        paneldatos.add(panelHorarios);
        panelHorarios.setLayout(new GridLayout(0, 4, 10, 10));
        
        
        JCheckBox[] servicescheck = {service1, service2, service3, service4, service5, service6, service7, service8};
        
        for (int i=0; i<8; i++) {
        	servicescheck[i].setText(servicios[i].getNombre());
        	servicescheck[i].setBackground(Paleta.menu);
        	servicescheck[i].setForeground(Paleta.textologin);
        	servicescheck[i].setFont(new Font("SansSerif", Font.PLAIN, 14));
        	servicescheck[i].setOpaque(true);
        	
        } 
        
        
        
        
   
        JDateChooser fecha = new JDateChooser();
        fecha.setBounds(12, 40, 352, 30);
        fecha.setBackground(Paleta.menu);
        fecha.setForeground(Paleta.textologin2);
        panelFecha.add(fecha);
        
        
        
        
       
     
        
       
            
       barberoscombo.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			int selected = barberoscombo.getSelectedIndex();
			
			if (barberos.get(selected).getId() != 0) {
			for (int i=0; i<barberos.size(); i++) {
	        	 panelHorarios.add(barberos.get(selected).getBotones()[i]);
	        	 System.out.println(barberos.get(selected).getId());
			}
				
			
			panelHorarios.removeAll();    // Quita todos los botones previos
		    panelHorarios.revalidate();   // Recalcula layout
		    panelHorarios.repaint();      // Redibuja

		    for (JButton bu : barberos.get(selected).getBotones()) {
		        
		        panelHorarios.add(bu);   
		    }

		    panelHorarios.revalidate();
		    panelHorarios.repaint();
			}
			
		}
		
	});

        
       aggCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aggCliente.setBackground(Paleta.active);
				crearCitas.setBackground(Paleta.fondoBoton2);
				historialPagos.setBackground(Paleta.fondoBoton2);
				citas.setBackground(Paleta.fondoBoton2);
				card.show(panel, "agregarcliente");
				
				
			}
		});
        
        citas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				citas.setBackground(Paleta.active);
				crearCitas.setBackground(Paleta.fondoBoton2);
				historialPagos.setBackground(Paleta.fondoBoton2);
				aggCliente.setBackground(Paleta.fondoBoton2);
				card.show(panel, "cita");
				
				
			}
		});
        
        
        crearCitas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crearCitas.setBackground(Paleta.active);
				citas.setBackground(Paleta.fondoBoton2);
				historialPagos.setBackground(Paleta.fondoBoton2);
				aggCliente.setBackground(Paleta.fondoBoton2);
				card.show(panel, "crearcitas");
			}
		});
        
        historialPagos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				historialPagos.setBackground(Paleta.active);
				crearCitas.setBackground(Paleta.fondoBoton2);
				citas.setBackground(Paleta.fondoBoton2);
				aggCliente.setBackground(Paleta.fondoBoton2);
				card.show(panel, "historialPagos");
			}
		});
        
        
        btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
        
        

        
        fecha.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				
			}
		});
        
        agregarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = campoNombreCliente.getText();	
				String telefono = campoTelefonoCliente.getText();	
				String correo = campoCorreoCliente.getText();	
				
				GuardarDatos.guardarClientes(nombre, telefono, correo);
				ConsultarDatos.refrescarcombos(comboClientes, "Clientes");
				
				campoNombreCliente.setText("");
				campoTelefonoCliente.setText("");
				campoCorreoCliente.setText("");
			}	
		});
        
        confirmarCita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}	
		});
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
}


