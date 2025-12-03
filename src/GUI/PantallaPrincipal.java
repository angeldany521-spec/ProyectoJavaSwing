
package GUI;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.invoke.StringConcatFactory;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.management.modelmbean.ModelMBeanOperationInfo;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import javax.swing.UIManager;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import com.toedter.calendar.JDateChooser;

import BaseDeDatos.ConsultarDatos;
import BaseDeDatos.GuardarDatos;
import Dominio.Barbero;
import Dominio.Cliente;
import Dominio.Pago;
import Dominio.Servicio;


import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JSeparator;

import javax.swing.SwingConstants;



public class PantallaPrincipal {

	private JFrame frame;
	private JTextField campoBuscarCitas;
	private JTable tableCitas;
	private JTextField buscarHistorialPagos;
	private JTable tableHistorialPagos;
	private JTextField campoNombreCliente;
	private JTextField campoTelefonoCliente;
	private JTextField campoCorreoCliente;
	private JTable tableClientes;
	private JTextField campoBuscarClientes;
	private TableRowSorter<DefaultTableModel> sorterBuscarCitas;
	private TableRowSorter<DefaultTableModel> sorterPagos;
	private TableRowSorter<DefaultTableModel> sorterClientes;
	

	public static void main(String[] args) {

		try {

		for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {

		if ("Nimbus".equals(info.getName())) {

		UIManager.setLookAndFeel(info.getClassName());

		break;

		}

		}

		} catch (Exception e) {


		try {

		UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());

		} catch (Exception ex) {


		}

}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaPrincipal window = new PantallaPrincipal();
					window.frame.setVisible(true);
					window.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PantallaPrincipal() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1182, 737);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout());
		frame.getContentPane().setBackground(Paleta.fondo2);
		
		ArrayList<Barbero> barberos = ConsultarDatos.obtenerBarberos();
		ArrayList<Cliente> clientes = ConsultarDatos.obtenerClientes();
		
		Servicio[] listservicios = {new Servicio(0, "Cerquillo", 100),
								new Servicio(1, "Corte regular", 300),
								new Servicio(2, "Corte Moderno", 500),
								new Servicio(3, "Tintado de pelo", 400),
								new Servicio(4, "Trenzado sin diseño", 500),
								new Servicio(5, "Depilacion de cejas", 150),
								new Servicio(6, "Barba", 150),
								new Servicio(7, "Facial", 100)};
		
        JPanel menu = new JPanel();
        menu.setPreferredSize(new Dimension(250, 0));
        menu.setBackground(Paleta.menu);
        menu.setOpaque(true);
        menu.setLayout(null);
        
        JButton btnPanelCrearCita = new JButton("Crear Cita");
        btnPanelCrearCita.setFont(new Font("SansSerif", Font.BOLD, 15));
        btnPanelCrearCita.setBorder(null);
        btnPanelCrearCita.setBounds(0, 206, 250, 46);
        btnPanelCrearCita.setForeground(Paleta.textologin);
        btnPanelCrearCita.setContentAreaFilled(true);
        btnPanelCrearCita.setFocusPainted(false);
        btnPanelCrearCita.setBorderPainted(false);
        btnPanelCrearCita.setOpaque(false);
        btnPanelCrearCita.setBackground(Paleta.fondoBoton2);
        
        JButton btnPanelPagos = new JButton("Historial de Pagos");
        btnPanelPagos.setFont(new Font("SansSerif", Font.BOLD, 15));
        btnPanelPagos.setBorder(null);
        btnPanelPagos.setBounds(0, 251, 250, 46);
        btnPanelPagos.setForeground(Paleta.textologin);
        btnPanelPagos.setContentAreaFilled(true);
        btnPanelPagos.setFocusPainted(false);
        btnPanelPagos.setBorderPainted(false);
        btnPanelPagos.setOpaque(false);
        btnPanelPagos.setBackground(Paleta.fondoBoton2);
        
        JButton btnPanelCitas = new JButton("Citas");
        
        btnPanelCitas.setFont(new Font("SansSerif", Font.BOLD, 15));
        btnPanelCitas.setBorder(null);
        btnPanelCitas.setBounds(0, 160, 250, 46);
        btnPanelCitas.setForeground(Paleta.textologin);
        btnPanelCitas.setContentAreaFilled(true);
        btnPanelCitas.setFocusPainted(false);
        btnPanelCitas.setBorderPainted(false);
        btnPanelCitas.setOpaque(false);
        btnPanelCitas.setBackground(Paleta.fondoBoton2);
        
        menu.add(btnPanelCitas);
        menu.add(btnPanelCrearCita);
        menu.add(btnPanelPagos);
 
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
        btnCerrarSesion.setBounds(0, 560, 250, 46);
        menu.add(btnCerrarSesion);
        
        JLabel lblbarber = new JLabel("BarberPiece\r\n");
        lblbarber.setFont(new Font("Tahoma", Font.BOLD, 21));
        lblbarber.setForeground(Paleta.textologin);;
        lblbarber.setBounds(10, 10, 130, 35);
        menu.add(lblbarber);
        
        JButton btnPanelGestionClientes = new JButton("Gestionar Clientes");
        btnPanelGestionClientes.setOpaque(false);
        btnPanelGestionClientes.setForeground(new Color(242, 240, 235));
        btnPanelGestionClientes.setFont(new Font("SansSerif", Font.BOLD, 15));
        btnPanelGestionClientes.setFocusPainted(false);
        btnPanelGestionClientes.setContentAreaFilled(true);
        btnPanelGestionClientes.setBorderPainted(false);
        btnPanelGestionClientes.setBorder(null);
        btnPanelGestionClientes.setBackground(new Color(200, 50, 42));
        btnPanelGestionClientes.setBounds(0, 296, 250, 46);
        menu.add(btnPanelGestionClientes);
        
        CardLayout card = new CardLayout();
        JPanel panel = new JPanel();  
        panel.setBackground(Paleta.fondo2);
        panel.setLayout(card);
        panel.setOpaque(true);
        
        frame.getContentPane().add(panel);
        
        PanelGestionCitas panelPrincipal = new PanelGestionCitas();
        panelPrincipal.setForeground(new Color(0, 0, 0));
        panelPrincipal.setBackground(Paleta.fondo2);
        panelPrincipal.setOpaque(true);
        panel.add(panelPrincipal, "cita");
        panelPrincipal.setLayout(null);
        
        panelAgregarCliente panelAgregarCliente = new panelAgregarCliente();
        panelAgregarCliente.setBackground(Paleta.fondoPrincipal);
        panel.add(panelAgregarCliente, "agregarcliente");
        panelAgregarCliente.setLayout(null);
        
        Panel panelDatosCliente = new Panel(15, 7, Paleta.textologin2);
        panelDatosCliente.setBounds(12, 142, 452, 558);
        panelDatosCliente.setBackground(Paleta.menu);
        panelAgregarCliente.add(panelDatosCliente);
        panelDatosCliente.setLayout(null);
        
        JLabel lblInformacionDeLa_1 = new JLabel("Agregar Cliente");
        lblInformacionDeLa_1.setBounds(16, 16, 167, 26);
        panelDatosCliente.add(lblInformacionDeLa_1);
        lblInformacionDeLa_1.setForeground(new Color(96, 165, 250));
        lblInformacionDeLa_1.setFont(new Font("SansSerif", Font.BOLD, 20));
        
        campoNombreCliente = new JTextField();
        campoNombreCliente.setBounds(16, 93, 420, 35);
        panelDatosCliente.add(campoNombreCliente);
        campoNombreCliente.setForeground(new Color(242, 240, 235));
        campoNombreCliente.setFont(new Font("SansSerif", Font.PLAIN, 14));
        campoNombreCliente.setColumns(10);
        campoNombreCliente.setBorder(new Borde(8, Paleta.fondoPrincipal));
        campoNombreCliente.setBackground(new Color(31, 41, 55));
        
        JLabel lblNombre = new JLabel("Nombre");
        lblNombre.setBounds(16, 69, 65, 16);
        panelDatosCliente.add(lblNombre);
        lblNombre.setForeground(new Color(242, 240, 235));
        lblNombre.setFont(new Font("SansSerif", Font.BOLD, 14));
        
        campoTelefonoCliente = new JTextField();
        campoTelefonoCliente.setBounds(16, 212, 420, 35);
        panelDatosCliente.add(campoTelefonoCliente);
        campoTelefonoCliente.setForeground(new Color(242, 240, 235));
        campoTelefonoCliente.setFont(new Font("SansSerif", Font.PLAIN, 14));
        campoTelefonoCliente.setColumns(10);
        campoTelefonoCliente.setBorder(new Borde(8, Paleta.fondoPrincipal));
        campoTelefonoCliente.setBackground(new Color(31, 41, 55));
        
        JLabel lblTelefono = new JLabel("Telefono");
        lblTelefono.setBounds(16, 187, 65, 16);
        panelDatosCliente.add(lblTelefono);
        lblTelefono.setForeground(new Color(242, 240, 235));
        lblTelefono.setFont(new Font("SansSerif", Font.BOLD, 14));
        
        campoCorreoCliente = new JTextField();
        campoCorreoCliente.setBounds(16, 337, 420, 35);
        panelDatosCliente.add(campoCorreoCliente);
        campoCorreoCliente.setForeground(new Color(242, 240, 235));
        campoCorreoCliente.setFont(new Font("SansSerif", Font.PLAIN, 14));
        campoCorreoCliente.setColumns(10);
        campoCorreoCliente.setBorder(new Borde(8, Paleta.fondoPrincipal));
        campoCorreoCliente.setBackground(new Color(31, 41, 55));
        
        JLabel lblCorreo = new JLabel("Correo");
        lblCorreo.setBounds(16, 312, 65, 16);
        panelDatosCliente.add(lblCorreo);
        lblCorreo.setForeground(new Color(242, 240, 235));
        lblCorreo.setFont(new Font("SansSerif", Font.BOLD, 14));
        
        ImageIcon agg = new ImageIcon(getClass().getResource("/Imagenes/botonAgregar.png"));
        Image img = agg.getImage();
        Image size = img.getScaledInstance(13, 13, Image.SCALE_SMOOTH);
        ImageIcon aggIcon = new ImageIcon(size);
        
        JButton agregarCliente = new JButton("Agregar", aggIcon);
        agregarCliente.setBounds(246, 440, 173, 41);
        panelDatosCliente.add(agregarCliente);
        agregarCliente.setForeground(new Color(242, 240, 235));
        agregarCliente.setFont(new Font("SansSerif", Font.BOLD, 18));
        agregarCliente.setFocusPainted(false);
        agregarCliente.setContentAreaFilled(true);
        agregarCliente.setBorderPainted(false);
        agregarCliente.setBorder(null);
        agregarCliente.setBackground(new Color(96, 165, 250));
        
        JButton cancelarCliente = new JButton("Cancelar", null);
        cancelarCliente.setForeground(Paleta.textologin2);
        cancelarCliente.setFont(new Font("SansSerif", Font.BOLD, 18));
        cancelarCliente.setFocusPainted(false);
        cancelarCliente.setContentAreaFilled(true);
        cancelarCliente.setBorderPainted(false);
        cancelarCliente.setBorder(null);
        cancelarCliente.setBackground(Paleta.fondoPrincipal);
        cancelarCliente.setBounds(31, 440, 173, 41);
        panelDatosCliente.add(cancelarCliente);
        
        
        JLabel lblAgregarCliente = new JLabel("Gestionar Clientes");
        lblAgregarCliente.setForeground(new Color(96, 165, 250));
        lblAgregarCliente.setFont(new Font("SansSerif", Font.BOLD, 27));
        lblAgregarCliente.setBackground(new Color(242, 240, 235));
        lblAgregarCliente.setBounds(12, 12, 238, 35);
        panelAgregarCliente.add(lblAgregarCliente);
        
        JPanel panelClientes = new Panel(20, 7, Paleta.textologin2);
        panelClientes.setBounds(476, 142, 802, 558);
        panelClientes.setBackground(Paleta.menu);
        panelAgregarCliente.add(panelClientes);
        panelClientes.setLayout(null);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(16, 101, 770, 434);
        panelClientes.add(scrollPane);

        tableClientes = new JTable();
        tableClientes.setSize(new Dimension(0, 5));
        tableClientes.getTableHeader().setReorderingAllowed(false);
        tableClientes.setShowGrid(true);
        tableClientes.setRowHeight(21);
        tableClientes.getTableHeader().setBackground(Paleta.headers);
        tableClientes.getTableHeader().setForeground(Paleta.textologin2);
        tableClientes.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 15));
        tableClientes.setGridColor(Paleta.fondoPrincipal);
        tableClientes.setForeground(new Color(242, 240, 235));
        tableClientes.setFont(new Font("SansSerif", Font.PLAIN, 14));
        tableClientes.setFillsViewportHeight(true);
        tableClientes.setBackground(new Color(31, 41, 55));
        tableClientes.setOpaque(true);
        scrollPane.setViewportView(tableClientes);
        
        DefaultTableModel modeloClientes = cargartablaClientes();
        tableClientes.setModel(modeloClientes);
        sorterClientes = new TableRowSorter<DefaultTableModel>(modeloClientes);
        tableClientes.setRowSorter(sorterClientes);
       
        
        
        
        
        ImageIcon elim = new ImageIcon(getClass().getResource("/Imagenes/botonBorrar.png"));
        Image img1 = elim.getImage();
        Image size1 = img1.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon elimIcon = new ImageIcon(size1);
        
        JLabel lblClientes = new JLabel("Clientes");
        lblClientes.setForeground(new Color(96, 165, 250));
        lblClientes.setFont(new Font("SansSerif", Font.BOLD, 20));
        lblClientes.setBounds(16, 16, 94, 21);
        panelClientes.add(lblClientes);
        
        JButton eliminarCliente = new JButton("Eliminar Cliente", elimIcon);
        eliminarCliente.setBounds(586, 47, 200, 40);
        panelClientes.add(eliminarCliente);
        eliminarCliente.setPreferredSize(new Dimension(200, 40));
        eliminarCliente.setOpaque(false);
        eliminarCliente.setForeground(new Color(242, 240, 235));
        eliminarCliente.setFont(new Font("SansSerif", Font.BOLD, 16));
        eliminarCliente.setBorder(null);
        eliminarCliente.setBackground(new Color(200, 50, 42));
        
        JPanel panelFiltro_2 = new JPanel();
        panelFiltro_2.setLayout(null);
        panelFiltro_2.setPreferredSize(new Dimension(100, 19));
        panelFiltro_2.setBackground(new Color(31, 41, 55));
        panelFiltro_2.setBounds(370, 42, 155, 51);
        panelClientes.add(panelFiltro_2);
        
        JLabel lblFiltro_2 = new JLabel("Filtrar por");
        lblFiltro_2.setForeground(new Color(96, 165, 250));
        lblFiltro_2.setFont(new Font("SansSerif", Font.BOLD, 18));
        lblFiltro_2.setBounds(30, 6, 95, 19);
        panelFiltro_2.add(lblFiltro_2);
        
        JRadioButton filtroNombre = new JRadioButton("Nombre");
        filtroNombre.setOpaque(false);
        filtroNombre.setForeground(new Color(242, 240, 235));
        filtroNombre.setFont(new Font("SansSerif", Font.PLAIN, 15));
        filtroNombre.setBounds(70, 27, 84, 21);
        panelFiltro_2.add(filtroNombre);
        
        JRadioButton filtroID = new JRadioButton("ID");
        filtroID.setOpaque(false);
        filtroID.setForeground(new Color(242, 240, 235));
        filtroID.setFont(new Font("SansSerif", Font.PLAIN, 15));
        filtroID.setBounds(10, 27, 41, 21);
        panelFiltro_2.add(filtroID);
        
        ButtonGroup filtrosClientes = new ButtonGroup();
        filtrosClientes.add(filtroNombre);
        filtrosClientes.add(filtroID);
        
        campoBuscarClientes = new JTextField();
        campoBuscarClientes.setPreferredSize(new Dimension(100, 40));
        panelClientes.add(campoBuscarClientes);
        campoBuscarClientes.setForeground(new Color(242, 240, 235));
        campoBuscarClientes.setFont(new Font("SansSerif", Font.PLAIN, 14));
        campoBuscarClientes.setOpaque(false);
        campoBuscarClientes.setColumns(40);
        campoBuscarClientes.setBorder(new Borde(10, Paleta.fondoPrincipal));
        campoBuscarClientes.setBackground(new Color(31, 41, 55));
        campoBuscarClientes.setBounds(16, 49, 290, 40);
        
        JLabel lblCitas = new JLabel("Citas");
        lblCitas.setBounds(12, 26, 66, 35);
        panelPrincipal.add(lblCitas);
        lblCitas.setFont(new Font("SansSerif", Font.BOLD, 27));
        lblCitas.setForeground(Paleta.textologin2);
        lblCitas.setBackground(Paleta.fondo2);
        
        JPanel panelCitas = new Panel(20, 7, Paleta.textologin2);
        panelCitas.setBounds(12, 78, 1252, 694);
        panelCitas.setBackground(Paleta.menu);
        panelPrincipal.add(panelCitas);
        panelCitas.setLayout(null);
        
        JScrollPane scrollPaneCitas = new JScrollPane();
        scrollPaneCitas.setBounds(12, 106, 1228, 576);
        panelCitas.add(scrollPaneCitas);
        scrollPaneCitas.setOpaque(false);
        scrollPaneCitas.setBorder(null);
        
       
        
        tableCitas = new JTable();
        
        tableCitas.getTableHeader().setReorderingAllowed(false);
        tableCitas.setRowHeight(21);
        tableCitas.setSize(new Dimension(0, 5));
        tableCitas.getTableHeader().setBackground(Paleta.headers);
        tableCitas.getTableHeader().setForeground(Paleta.textologin2);
        tableCitas.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 15));
        tableCitas.setShowGrid(true);
        tableCitas.setGridColor(Paleta.fondoPrincipal);
        tableCitas.setForeground(Paleta.fondoPrincipal);
        tableCitas.setFillsViewportHeight(true);
        tableCitas.setBackground(Paleta.table);
        tableCitas.setFont(new Font("SansSerif", Font.PLAIN, 14));
        scrollPaneCitas.setViewportView(tableCitas);
        
        DefaultTableModel modeloCitas = ConsultarDatos.cargar_citas();
        tableCitas.setModel(modeloCitas);
        sorterBuscarCitas = new TableRowSorter<DefaultTableModel>(modeloCitas);
        tableCitas.setRowSorter(sorterBuscarCitas);
        
        JPanel panelControlCitas = new Panel(20,7,Paleta.textologin2);
        panelControlCitas.setBounds(12, 25, 1228, 69);
        panelCitas.add(panelControlCitas);
        panelControlCitas.setBackground(Paleta.menu);
        panelControlCitas.setLayout(null);
        
        campoBuscarCitas = new JTextField();
        campoBuscarCitas.setBounds(12, 17, 461, 40);
        panelControlCitas.add(campoBuscarCitas);
        campoBuscarCitas.setPreferredSize(new Dimension(100, 40));
        campoBuscarCitas.setOpaque(false);
        campoBuscarCitas.setBackground(Paleta.menu);
        campoBuscarCitas.setForeground(Paleta.fondoPrincipal);
        campoBuscarCitas.setFont(new Font("SansSerif", Font.PLAIN, 14));
        campoBuscarCitas.setBorder(new Borde(10, Paleta.fondoPrincipal));
        campoBuscarCitas.setColumns(40);
        
        JButton eliminarCita = new JButton("Eliminar Cita", elimIcon);
        eliminarCita.setBounds(964, 15, 252, 40);
        panelControlCitas.add(eliminarCita);
        eliminarCita.setOpaque(false);
        eliminarCita.setBorder(null);
        eliminarCita.setPreferredSize(new Dimension(200, 40));
        eliminarCita.setFont(new Font("SansSerif", Font.BOLD, 16));
        
        eliminarCita.setBackground(Paleta.fondoBoton2);
        eliminarCita.setForeground(Paleta.textologin);
        
        JPanel panelFiltro_1 = new JPanel();
        panelFiltro_1.setLayout(null);
        panelFiltro_1.setPreferredSize(new Dimension(100, 19));
        panelFiltro_1.setBackground(new Color(31, 41, 55));
        panelFiltro_1.setBounds(575, 12, 293, 51);
        panelControlCitas.add(panelFiltro_1);
        
        JLabel lblFiltro_1 = new JLabel("Filtrar por");
        lblFiltro_1.setForeground(new Color(96, 165, 250));
        lblFiltro_1.setFont(new Font("SansSerif", Font.BOLD, 18));
        lblFiltro_1.setBounds(99, 8, 95, 19);
        panelFiltro_1.add(lblFiltro_1);
        
        JRadioButton filtroBarberoCitas = new JRadioButton("Barbero");
        filtroBarberoCitas.setOpaque(false);
        filtroBarberoCitas.setForeground(new Color(242, 240, 235));
        filtroBarberoCitas.setFont(new Font("SansSerif", Font.PLAIN, 15));
        filtroBarberoCitas.setBounds(111, 27, 79, 21);
        panelFiltro_1.add(filtroBarberoCitas);
        
        JRadioButton filtroFechaCitas = new JRadioButton("Fecha");
        filtroFechaCitas.setOpaque(false);
        filtroFechaCitas.setForeground(new Color(242, 240, 235));
        filtroFechaCitas.setFont(new Font("SansSerif", Font.PLAIN, 15));
        filtroFechaCitas.setBounds(18, 27, 73, 21);
        panelFiltro_1.add(filtroFechaCitas);
        
        JRadioButton filtroClientesCitas = new JRadioButton("Cliente");
        filtroClientesCitas.setOpaque(false);
        filtroClientesCitas.setForeground(new Color(242, 240, 235));
        filtroClientesCitas.setFont(new Font("SansSerif", Font.PLAIN, 15));
        filtroClientesCitas.setBounds(210, 27, 79, 21);
        panelFiltro_1.add(filtroClientesCitas);
        
        PanelGestionPagos verHistorialPagos = new PanelGestionPagos();
        verHistorialPagos.setPreferredSize(new Dimension(2000, 2000));
        verHistorialPagos.setBackground(Paleta.fondoPrincipal);
        panel.add(verHistorialPagos, "historialPagos");
        verHistorialPagos.setOpaque(true);
        table_widhts();
        
        ButtonGroup filtros = new ButtonGroup();

        JPanel panelPagos = new Panel(20, 7, Paleta.textologin2);
        panelPagos.setBackground(Paleta.menu);
        panelPagos.setBounds(102, 93, 1057, 660);
        verHistorialPagos.add(panelPagos);
        panelPagos.setLayout(null);
        
        JScrollPane scrollPanePagos = new JScrollPane();
        scrollPanePagos.setBounds(12, 110, 1033, 538);
        panelPagos.add(scrollPanePagos);
        scrollPanePagos.setOpaque(false);
        scrollPanePagos.setBorder(null);
        
       tableHistorialPagos = new JTable();
       tableHistorialPagos.setRowHeight(21);
       tableHistorialPagos.getTableHeader().setReorderingAllowed(false);
       tableHistorialPagos.setSize(new Dimension(0, 5));
       tableHistorialPagos.getTableHeader().setBackground(Paleta.headers);
       tableHistorialPagos.getTableHeader().setForeground(Paleta.textologin2);
       tableHistorialPagos.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 15));
       tableHistorialPagos.setShowGrid(true);
       tableHistorialPagos.setGridColor(Paleta.fondoPrincipal);
       tableHistorialPagos.setForeground(Paleta.fondoPrincipal);
       tableHistorialPagos.setFillsViewportHeight(true);
       tableHistorialPagos.setBackground(Paleta.table);
       tableHistorialPagos.setFont(new Font("SansSerif", Font.PLAIN, 14));
       scrollPanePagos.setViewportView(tableHistorialPagos);
       
       DefaultTableModel modeloPagos = cargartablaPagos();
       tableHistorialPagos.setModel(modeloPagos);
       sorterPagos = new TableRowSorter<DefaultTableModel>(modeloPagos);
       tableHistorialPagos.setRowSorter(sorterPagos);
       
       JPanel panelControlPagos = new Panel(20, 7, Paleta.textologin2);
       panelControlPagos.setBounds(12, 20, 1033, 67);
       panelPagos.add(panelControlPagos);
       panelControlPagos.setBackground(Paleta.menu);
       panelControlPagos.setLayout(null);
       
       JPanel panelFiltro = new JPanel();
       panelFiltro.setBounds(152, 8, 267, 51);
       panelControlPagos.add(panelFiltro);
       panelFiltro.setPreferredSize(new Dimension(100, 19));
       panelFiltro.setBackground(Paleta.menu);
       panelFiltro.setLayout(null);
       
       JLabel lblFiltro = new JLabel("Filtrar por");
       lblFiltro.setBounds(78, 8, 95, 19);
       lblFiltro.setForeground(Paleta.textologin2);
       lblFiltro.setFont(new Font("SansSerif", Font.BOLD, 18));
       panelFiltro.add(lblFiltro);
       JRadioButton filtroMetodo = new JRadioButton("Metodo de pago");
       filtroMetodo.setFont(new Font("SansSerif", Font.PLAIN, 15));
       filtroMetodo.setForeground(Paleta.fondoPrincipal);
       filtroMetodo.setOpaque(false);
       filtroMetodo.setBounds(115, 27, 142, 21);
       panelFiltro.add(filtroMetodo);
       
       JRadioButton filtroFecha = new JRadioButton("Fecha");
       filtroFecha.setFont(new Font("SansSerif", Font.PLAIN, 15));
       filtroFecha.setForeground(Paleta.fondoPrincipal);
       filtroFecha.setOpaque(false);
       filtroFecha.setBounds(18, 27, 73, 21);
       panelFiltro.add(filtroFecha);
       
       filtros.add(filtroMetodo);
       filtros.add(filtroFecha);
       
       
       buscarHistorialPagos = new JTextField();
       buscarHistorialPagos.setBounds(521, 13, 392, 41);
       buscarHistorialPagos.setPreferredSize(new Dimension(100, 30));
       buscarHistorialPagos.setOpaque(false);
       buscarHistorialPagos.setFont(new Font("SansSerif", Font.PLAIN, 14));
       buscarHistorialPagos.setForeground(Paleta.textologin);
       buscarHistorialPagos.setColumns(30);
       buscarHistorialPagos.setBorder(new Borde(10, Paleta.textologin));
       buscarHistorialPagos.setBackground(Paleta.menu);
       panelControlPagos.add(buscarHistorialPagos);
       
       JLabel lblHistorialPagos = new JLabel("Historial De Pagos");
       lblHistorialPagos.setBounds(9, 30, 241, 37);
       verHistorialPagos.add(lblHistorialPagos);
       lblHistorialPagos.setForeground(new Color(70, 150, 230));
       lblHistorialPagos.setFont(new Font("SansSerif", Font.BOLD, 27));
       lblHistorialPagos.setBackground(new Color(240, 235, 220));
        
        CrearCita PanelcrearCita = new CrearCita();
        panel.add(PanelcrearCita, "crearcitas");
        PanelcrearCita.setOpaque(true);
        PanelcrearCita.setBackground(Paleta.fondoPrincipal);
        PanelcrearCita.setLayout(null);

        JLabel lblHistorialPagos_1 = new JLabel("Agregar Cita");
        lblHistorialPagos_1.setForeground(new Color(70, 150, 230));
        lblHistorialPagos_1.setFont(new Font("SansSerif", Font.BOLD, 27));
        lblHistorialPagos_1.setBackground(new Color(240, 235, 220));
        lblHistorialPagos_1.setBounds(33, 22, 241, 35);
        PanelcrearCita.add(lblHistorialPagos_1);
        
        Panel panelFecha = new Panel(20,7, Paleta.textologin2);
        panelFecha.setBounds(31, 69, 375, 160);
        panelFecha.setBackground(Paleta.menu);
        PanelcrearCita.add(panelFecha);
        panelFecha.setLayout(null);
        
        JLabel lblLabel = new JLabel("Fecha");
        lblLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        lblLabel.setForeground(Paleta.textologin2);
        lblLabel.setBounds(20, 20, 165, 21);
        panelFecha.add(lblLabel);
        
        Panel panelBarberos = new Panel(25,7, Paleta.textologin2);
        panelBarberos.setLayout(null);
        panelBarberos.setBackground(Paleta.menu);
        panelBarberos.setBounds(31, 265, 1228, 490);
        PanelcrearCita.add(panelBarberos);
        
        JLabel lblBarbero = new JLabel("Barbero");
        lblBarbero.setForeground(new Color(242, 240, 235));
        lblBarbero.setFont(new Font("SansSerif", Font.BOLD, 14));
        lblBarbero.setBounds(20, 59, 76, 16);
        panelBarberos.add(lblBarbero);
        
        JComboBox<String> barberoscombo = new JComboBox<>();
        barberoscombo.setBounds(20, 87, 440, 34);
        barberoscombo.setBackground(Paleta.menu);
        barberoscombo.setFont(new Font("SansSerif", Font.PLAIN, 14)); 
        barberoscombo.setForeground(Paleta.fondoPrincipal);
        barberoscombo.setOpaque(false);
        panelBarberos.add(barberoscombo);

        for (int i=0; i<barberos.size(); i++) {
        	barberoscombo.addItem(barberos.get(i).getNombre());
        }
        
        JLabel lblSeleccionarBarberos = new JLabel("Seleccionar Barbero");
        lblSeleccionarBarberos.setForeground(new Color(96, 165, 250));
        lblSeleccionarBarberos.setFont(new Font("SansSerif", Font.BOLD, 18));
        lblSeleccionarBarberos.setBounds(20, 26, 283, 21);
        panelBarberos.add(lblSeleccionarBarberos);
 
        JLabel lblCliente = new JLabel("Cliente");
        lblCliente.setForeground(new Color(242, 240, 235));
        lblCliente.setFont(new Font("SansSerif", Font.BOLD, 14));
        lblCliente.setBounds(20, 237, 70, 16);
        panelBarberos.add(lblCliente);
      
        JComboBox<String> comboClientes = new JComboBox<String>(cargarcombobox());
        comboClientes.setOpaque(false);
        comboClientes.setForeground(new Color(242, 240, 235));
        comboClientes.setFont(new Font("SansSerif", Font.PLAIN, 14));
        comboClientes.setBackground(new Color(31, 41, 55));
        comboClientes.setBounds(20, 265, 440, 34);
        panelBarberos.add(comboClientes);
        
        JPanel panelServicios = new JPanel();
        panelServicios.setBounds(529, 75, 486, 263);
        panelServicios.setBackground(Paleta.fondoPrincipal);
        panelBarberos.add(panelServicios);
        
        panelServicios.setBackground(new Color(31, 41, 55));
        panelServicios.setLayout(new GridLayout(4, 2, 50, 15));
        
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
        lblSeleccionarCliente.setBounds(20, 204, 283, 21);
        panelBarberos.add(lblSeleccionarCliente);
        
        JLabel lblSeleccionarServicios = new JLabel("Seleccionar Servicios");
        lblSeleccionarServicios.setForeground(new Color(96, 165, 250));
        lblSeleccionarServicios.setFont(new Font("SansSerif", Font.BOLD, 18));
        lblSeleccionarServicios.setBounds(632, 26, 205, 21);
        panelBarberos.add(lblSeleccionarServicios);
        
        
        JButton confirmarCita = new JButton("Confirmar");
        confirmarCita.setBounds(529, 400, 440, 41);
        panelBarberos.add(confirmarCita);
        confirmarCita.setOpaque(false);
        confirmarCita.setForeground(new Color(242, 240, 235));
        confirmarCita.setFont(new Font("SansSerif", Font.BOLD, 18));
        confirmarCita.setFocusPainted(false);
        confirmarCita.setContentAreaFilled(true);
        confirmarCita.setBorderPainted(false);
        confirmarCita.setBorder(null);
        confirmarCita.setBackground(Paleta.textologin2);
        
        JButton cancelar = new JButton("Cancelar");
        cancelar.setOpaque(false);
        cancelar.setForeground(Paleta.textologin2);
        cancelar.setFont(new Font("SansSerif", Font.BOLD, 18));
        cancelar.setFocusPainted(false);
        cancelar.setContentAreaFilled(true);
        cancelar.setBorderPainted(false);
        cancelar.setBorder(null);
        cancelar.setBackground(Paleta.fondoPrincipal);
        cancelar.setBounds(20, 400, 440, 41);
        panelBarberos.add(cancelar);
        
        JSeparator separator = new JSeparator();
        separator.setForeground(Color.RED);
        separator.setBounds(12, 360, 1207, 2);
        separator.setBackground(Paleta.fondoBoton);
        separator.setOpaque(false);
        panelBarberos.add(separator);
        
        JLabel lblMonto = new JLabel("Monto");
        lblMonto.setVerticalAlignment(SwingConstants.TOP);
        lblMonto.setForeground(new Color(96, 165, 250));
        lblMonto.setFont(new Font("SansSerif", Font.BOLD, 18));
        lblMonto.setBounds(1110, 26, 109, 22);
        panelBarberos.add(lblMonto);
        
        JLabel lblMonto_1 = new JLabel(""+0);
        lblMonto_1.setVerticalAlignment(SwingConstants.TOP);
        lblMonto_1.setForeground(Paleta.fondoPrincipal);
        lblMonto_1.setFont(new Font("SansSerif", Font.BOLD, 18));
        lblMonto_1.setBounds(1132, 54, 45, 22);
        panelBarberos.add(lblMonto_1);
        
        JLabel lblMetodoDePago = new JLabel("Metodo de pago");
        lblMetodoDePago.setVerticalAlignment(SwingConstants.TOP);
        lblMetodoDePago.setForeground(new Color(96, 165, 250));
        lblMetodoDePago.setFont(new Font("SansSerif", Font.BOLD, 18));
        lblMetodoDePago.setBounds(1064, 206, 141, 22);
        panelBarberos.add(lblMetodoDePago);
        
        JRadioButton metodoTransferencia = new JRadioButton("Transferencia");
        metodoTransferencia.setBounds(1074, 238, 121, 24);
        metodoTransferencia.setForeground(Paleta.textologin);
        metodoTransferencia.setFont(new Font("SansSerif", Font.PLAIN, 15));
        panelBarberos.add(metodoTransferencia);
        
        JRadioButton metodoEfectivo = new JRadioButton("Efectivo");
        metodoEfectivo.setBounds(1074, 275, 121, 24);
        metodoEfectivo.setForeground(Paleta.textologin);
        metodoEfectivo.setFont(new Font("SansSerif", Font.PLAIN, 15));
        panelBarberos.add(metodoEfectivo);
        
        ButtonGroup metodos = new ButtonGroup();
        metodos.add(metodoEfectivo);
        metodos.add(metodoTransferencia);
        
        Panel panelHorarios_1 = new Panel(20,7, Paleta.textologin2);
        panelHorarios_1.setLayout(null);
        panelHorarios_1.setBackground(Paleta.menu);
        panelHorarios_1.setBounds(455, 69, 804, 160);
        PanelcrearCita.add(panelHorarios_1);
        
        JLabel lblHorariosDisponibles = new JLabel("Horarios disponibles del barbero");
        lblHorariosDisponibles.setForeground(new Color(96, 165, 250));
        lblHorariosDisponibles.setFont(new Font("SansSerif", Font.BOLD, 18));
        lblHorariosDisponibles.setBounds(20, 20, 292, 21);
        panelHorarios_1.add(lblHorariosDisponibles);
        
        JPanel panelHorarios = new JPanel();
        panelHorarios.setBounds(20, 45, 761, 97);
        panelHorarios.setBackground(Paleta.menu);
        panelHorarios_1.add(panelHorarios);
        panelHorarios.setLayout(new GridLayout(0, 4, 10, 10));
        
        ButtonGroup filtrosCitas = new ButtonGroup();
        filtrosCitas.add(filtroBarberoCitas);
        filtrosCitas.add(filtroFechaCitas);
        filtrosCitas.add(filtroClientesCitas);
        JCheckBox[] servicescheck = {service1, service2, service3, service4, service5, service6, service7, service8};
        
        for (int i=0; i<8; i++) {
        	servicescheck[i].setText(listservicios[i].getNombre());
        	servicescheck[i].setBackground(Paleta.menu);
        	servicescheck[i].setForeground(Paleta.textologin);
        	servicescheck[i].setFont(new Font("SansSerif", Font.PLAIN, 14));
        	servicescheck[i].setOpaque(true);
        	
        } 
        
        JDateChooser fecha = new JDateChooser();
        fecha.setBounds(20, 50, 335, 30);
        fecha.setBackground(Paleta.menu);
        fecha.setForeground(Paleta.textologin2);
        ((JTextField) fecha.getDateEditor().getUiComponent()).setEditable(false);
        panelFecha.add(fecha);
            
       barberoscombo.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			int selected = barberoscombo.getSelectedIndex();
			
			if (barberos.get(selected).getId() != 0) {
			for (int i=0; i<barberos.size(); i++) {
	        	 panelHorarios.add(barberos.get(selected).getBotones()[i]);
	        	 
			}
				
			
			panelHorarios.removeAll();     
		    panelHorarios.revalidate();   
		    panelHorarios.repaint();      

		    for (JButton bu : barberos.get(selected).getBotones()) {
		        
		        panelHorarios.add(bu);   
		    }

		    panelHorarios.revalidate();
		    panelHorarios.repaint();
			}
			
			else {panelHorarios.removeAll();
			panelHorarios.revalidate();   
		    panelHorarios.repaint();  }
			
		}
		
	});
    
       btnPanelGestionClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPanelGestionClientes.setBackground(Paleta.active);
				btnPanelCrearCita.setBackground(Paleta.fondoBoton2);
				btnPanelPagos.setBackground(Paleta.fondoBoton2);
				btnPanelCitas.setBackground(Paleta.fondoBoton2);
				card.show(panel, "agregarcliente");
				
				
			}
		});
        
        btnPanelCitas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPanelCitas.setBackground(Paleta.active);
				btnPanelCrearCita.setBackground(Paleta.fondoBoton2);
				btnPanelPagos.setBackground(Paleta.fondoBoton2);
				btnPanelGestionClientes.setBackground(Paleta.fondoBoton2);
				card.show(panel, "cita");
				
				
			}
		});
        
        
        btnPanelCrearCita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPanelCrearCita.setBackground(Paleta.active);
				btnPanelCitas.setBackground(Paleta.fondoBoton2);
				btnPanelPagos.setBackground(Paleta.fondoBoton2);
				btnPanelGestionClientes.setBackground(Paleta.fondoBoton2);
				card.show(panel, "crearcitas");
			}
		});
        
        btnPanelPagos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPanelPagos.setBackground(Paleta.active);
				btnPanelCrearCita.setBackground(Paleta.fondoBoton2);
				btnPanelCitas.setBackground(Paleta.fondoBoton2);
				btnPanelGestionClientes.setBackground(Paleta.fondoBoton2);
				card.show(panel, "historialPagos");
			}
		});
        
        
        btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Login.main(null);
			}
		});
        
        agregarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = campoNombreCliente.getText();	
				String telefono = campoTelefonoCliente.getText();	
				String correo = campoCorreoCliente.getText();	
				
				campoNombreCliente.setText("");
				campoTelefonoCliente.setText("");
				campoCorreoCliente.setText("");
				
				if (!nombre.equals("") &&
					!telefono.equals("") &&
					!correo.equals("")) {
				GuardarDatos.guardarClientes(nombre, telefono, correo);
				confirmaciones("Cliente agregado exitosamente!");
				
				comboClientes.setModel(cargarcombobox());
				
				DefaultTableModel modelo = cargartablaClientes();
                tableClientes.setModel(modelo);
                sorterClientes.setModel(modelo);
				}
				
				else {errores("Rellena todos los campos para continuar", "Campos Vacios");}
			}	
		});
        
        eliminarCita.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                int row = tableCitas.getSelectedRow();

                if (row == -1) {
                    errores("Debes seleccionar una fila a eliminar", "Error");
                    return;
                }

                int rowModel = tableCitas.convertRowIndexToModel(row);

                int IDcita = Integer.parseInt(
                    tableCitas.getModel().getValueAt(rowModel, 0).toString()
                );

                GuardarDatos.eliminarDato("Citas", "Cita", IDcita);

                DefaultTableModel modelo = ConsultarDatos.cargar_citas();
                tableCitas.setModel(modelo);
                sorterBuscarCitas.setModel(modelo); 

                table_widhts();
                confirmaciones("Cita eliminada exitosamente!");
            }
        });
        
        eliminarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = tableClientes.getSelectedRow();
				
				if (row == -1) {errores("Debes seleccionar una fila a eliminar", "Error");
				return;
				}
				
				int rowModel = tableClientes.convertRowIndexToModel(row);
				
				int IDCliente = Integer.parseInt(
	                    tableClientes.getModel().getValueAt(rowModel, 0).toString()
	                );


				GuardarDatos.eliminarDato("Clientes", "Cliente", IDCliente);
				DefaultTableModel modelo = cargartablaClientes();
				tableClientes.setModel(modelo);
				sorterClientes.setModel(modelo);
				
				DefaultTableModel modeloc = ConsultarDatos.cargar_citas();
                tableCitas.setModel(modeloc);
                sorterBuscarCitas.setModel(modeloc); 
                table_widhts();
                
				
				comboClientes.setModel(cargarcombobox());
				confirmaciones("Cliente eliminado exitosamente!");
				
			}	
		});
        
       
        
        cancelarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				campoNombreCliente.setText("");
				campoTelefonoCliente.setText("");
				campoCorreoCliente.setText("");		
			}	
		});
        
        for (JCheckBox s : servicescheck) {
        	s.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ArrayList<String> servicioSelected = new ArrayList<String>();
        		int mont = 0;
        		
        		 
        		
        		for (int i = 0; i < servicescheck.length; i++) {
        			
        			if (servicescheck[2].isSelected()) {servicescheck[1].setEnabled(false);}
        			else {servicescheck[1].setEnabled(true);}
        			
        			if (servicescheck[1].isSelected()) {servicescheck[2].setEnabled(false);}
        			else {servicescheck[2].setEnabled(true);}
        			
        			
        			if (servicescheck[i].isSelected()) {
        				servicioSelected.add(servicescheck[i].getText()); 
        				mont += listservicios[i].getPrecio();
        			}
        		}
        		
        		lblMonto_1.setText("" + mont);
			}
		});
     }
        
        confirmarCita.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                ArrayList<String> servicioSelected = new ArrayList<String>();
                int selectedCliente = comboClientes.getSelectedIndex();
                int selectedBarbero = barberoscombo.getSelectedIndex();
                
                int cuenta = 0;
                int idbarber = barberos.get(selectedBarbero).getId();
                int idcliente = clientes.get(selectedCliente).getId();
                
                String nombre = clientes.get(selectedCliente).getNombre();
                String servicios = null;
                String hora = null; 
                String metodo = null;
                
                
                java.sql.Date date = null;
                java.sql.Date hoy = java.sql.Date.valueOf(LocalDate.now());
                
                if (fecha.getDate() != null) {
                    date = new java.sql.Date(fecha.getDate().getTime());
                } else {
                    errores("Debes seleccionar una fecha para confirmar", "Selecciona una fecha");
                }

                for (JButton horarioselect : barberos.get(selectedBarbero).getBotones()) {
                    if (horarioselect.getBackground() == Paleta.fondoBoton) {
                        hora = horarioselect.getText();
                    }
                }
                

                for (int i = 0; i < servicescheck.length; i++) {
                    if (servicescheck[i].isSelected()) {
                        servicioSelected.add(servicescheck[i].getText()); 
                        cuenta += listservicios[i].getPrecio();
                    }
                }
                
                if (metodoEfectivo.isSelected())  {metodo = metodoEfectivo.getText();}
                else if (metodoTransferencia.isSelected())  {metodo = metodoTransferencia.getText();}
                

                servicios = (servicioSelected.isEmpty()) ? null : servicios.join(", ", servicioSelected);

                
                if (ConsultarDatos.horaOcupada(idbarber, date, hora)) {
                    errores("Esa fecha y hora ya está ocupada para ese barbero.", "Horario no disponible");
                    return; 
                }
                
                

                if (hora != null &&
                    servicios != null &&
                    cuenta > 0 &&
                    idbarber > 0 &&
                    idcliente > 0 && 
                	metodo != null) {

                    GuardarDatos.guardarCita(idbarber, idcliente, servicios, date, hora, cuenta);
                    GuardarDatos.guardarPago(idcliente, nombre, cuenta, metodo, hoy);
                    
                    DefaultTableModel modelo = ConsultarDatos.cargar_citas();
                    tableCitas.setModel(modelo);
                    sorterBuscarCitas.setModel(modelo); 
                    
                    DefaultTableModel modelopago = cargartablaPagos();
                    tableHistorialPagos.setModel(modelopago);
                    sorterPagos.setModel(modelopago);
                    

                   
                    table_widhts();
                    
                    confirmaciones("Cita agendada exitosamente!");
                    lblMonto_1.setText("" + 0);
                    hora = null;
                    servicios = null;
                    cuenta = 0;
                    metodos.clearSelection();
                    comboClientes.setSelectedIndex(0); 
                    barberoscombo.setSelectedIndex(0);
                    
                    ((JTextField) fecha.getDateEditor().getUiComponent()).setText("");
                    for (int i = 0; i < servicescheck.length; i++) {
                            servicescheck[i].setSelected(false);
                            barberos.get(selectedBarbero).getBotones()[i].setBackground(Paleta.menu);
                    }   
                } 
                else {errores("Debes rellenar todos los campos para confirmar", "Campos vacíos");}
                    
            }
        });
        
        cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				java.sql.Date date = new java.sql.Date(fecha.getDate().getTime());
				int selectedBarbero = barberoscombo.getSelectedIndex();
				
				for (JButton horarioselect : barberos.get(selectedBarbero).getBotones()) {
                    horarioselect.setBackground(Paleta.menu);
                        
                    }
				
				for (JCheckBox servicio : servicescheck) {
					servicio.setSelected(false);
				}
        
                comboClientes.setSelectedIndex(0); 
                barberoscombo.setSelectedIndex(0); 
                metodoEfectivo.setSelected(false);
                metodoTransferencia.setSelected(false);
                ((JTextField) fecha.getDateEditor().getUiComponent()).setText("");
						
			}
		});
        
        campoBuscarClientes.getDocument().addDocumentListener(new DocumentListener() {
			public void insertUpdate(javax.swing.event.DocumentEvent e) {
				String text = campoBuscarClientes.getText();
				
				if (filtroID.isSelected()) {
					sorterClientes.setRowFilter(javax.swing.RowFilter.regexFilter("(?i)" + text, 0));
				} 
				
				else if (filtroNombre.isSelected()) {
					sorterClientes.setRowFilter(javax.swing.RowFilter.regexFilter("(?i)" + text, 1));
				} 
				
				else {
					sorterClientes.setRowFilter(null);
				}
				
			}
			public void removeUpdate(javax.swing.event.DocumentEvent e) {
				String text = campoBuscarClientes.getText();
				if (filtroID.isSelected()) {
					sorterClientes.setRowFilter(javax.swing.RowFilter.regexFilter("(?i)" + text, 0));
				} 
				
				else if (filtroNombre.isSelected()) {
					sorterClientes.setRowFilter(javax.swing.RowFilter.regexFilter("(?i)" + text, 1));
				} 
				
				else {
					sorterClientes.setRowFilter(null);
				}
			}
			public void changedUpdate(javax.swing.event.DocumentEvent e) {
				
			}
		});
        
        campoBuscarCitas.getDocument().addDocumentListener(new DocumentListener() {
			public void insertUpdate(javax.swing.event.DocumentEvent e) {
				String text = campoBuscarCitas.getText();
				
				if (filtroClientesCitas.isSelected()) {
					sorterBuscarCitas.setRowFilter(javax.swing.RowFilter.regexFilter("(?i)" + text, 1));
				} 
				
				else if (filtroBarberoCitas.isSelected()) {
					sorterBuscarCitas.setRowFilter(javax.swing.RowFilter.regexFilter("(?i)" + text, 2));
				} 
				else if  (filtroFechaCitas.isSelected()) {
					sorterBuscarCitas.setRowFilter(javax.swing.RowFilter.regexFilter("(?i)" + text, 3));
				}
				
				else {
					sorterBuscarCitas.setRowFilter(null);
				}
				
			}
			public void removeUpdate(javax.swing.event.DocumentEvent e) {
				String text = campoBuscarCitas.getText();
				if (filtroClientesCitas.isSelected()) {
					sorterBuscarCitas.setRowFilter(javax.swing.RowFilter.regexFilter("(?i)" + text, 1));
				} 
				
				else if (filtroBarberoCitas.isSelected()) {
					sorterBuscarCitas.setRowFilter(javax.swing.RowFilter.regexFilter("(?i)" + text, 2));
				} 
				else if  (filtroFechaCitas.isSelected()) {
					sorterBuscarCitas.setRowFilter(javax.swing.RowFilter.regexFilter("(?i)" + text, 3));
				}
				
				else {
					sorterBuscarCitas.setRowFilter(null);
				}
			}
			public void changedUpdate(javax.swing.event.DocumentEvent e) {
				
			}
		});
        
        buscarHistorialPagos.getDocument().addDocumentListener(new DocumentListener() {
			public void insertUpdate(javax.swing.event.DocumentEvent e) {
				String text = buscarHistorialPagos.getText();
				
				if (filtroMetodo.isSelected()) {
					sorterPagos.setRowFilter(javax.swing.RowFilter.regexFilter("(?i)" + text, 3));
				} 
				
				else if (filtroFecha.isSelected()) {
					sorterPagos.setRowFilter(javax.swing.RowFilter.regexFilter("(?i)" + text, 4));
				} 
				
				else {
					sorterPagos.setRowFilter(null);
				}
				
			}
			public void removeUpdate(javax.swing.event.DocumentEvent e) {
				String text = buscarHistorialPagos.getText();
				if (filtroMetodo.isSelected()) {
					sorterPagos.setRowFilter(javax.swing.RowFilter.regexFilter("(?i)" + text, 3));
				} 
				
				else if (filtroFecha.isSelected()) {
					sorterPagos.setRowFilter(javax.swing.RowFilter.regexFilter("(?i)" + text, 4));
				} 
				
				else {
					sorterPagos.setRowFilter(null);
				}
			}
			public void changedUpdate(javax.swing.event.DocumentEvent e) {
				
			}
		});
        
        
           
	}
	

	public void table_widhts() {
		tableCitas.getColumnModel().getColumn(0).setPreferredWidth(1);
        tableCitas.getColumnModel().getColumn(1).setPreferredWidth(10);
        tableCitas.getColumnModel().getColumn(2).setPreferredWidth(30);
        tableCitas.getColumnModel().getColumn(3).setPreferredWidth(10);
        tableCitas.getColumnModel().getColumn(4).setPreferredWidth(5);
        tableCitas.getColumnModel().getColumn(5).setPreferredWidth(400);
        tableCitas.getColumnModel().getColumn(6).setPreferredWidth(1);
	}
	
	public void table_widhts_clientes() {
		tableClientes.getColumnModel().getColumn(0).setPreferredWidth(5);
        tableClientes.getColumnModel().getColumn(1).setPreferredWidth(5);
        tableClientes.getColumnModel().getColumn(2).setPreferredWidth(5);
        tableClientes.getColumnModel().getColumn(3).setPreferredWidth(200);
	}
	
	
	public void errores(String tema, String error) {
		JOptionPane.showMessageDialog(null, tema, error, JOptionPane.ERROR_MESSAGE);
	}
	
	
	public void confirmaciones(String confirmacion) {
		JOptionPane.showMessageDialog(null, confirmacion);
	}
	
	
	public static DefaultComboBoxModel<String> cargarcombobox() {
	    DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();

	    for (Cliente c : ConsultarDatos.obtenerClientes()) {
	        model.addElement(c.getNombre());
	    }
	    return model;
	}
	
	
	public static DefaultTableModel cargartablaClientes() {
		String [] columnas = {"ID", "Nombre", "Telefono", "Correo"};
		DefaultTableModel model = new DefaultTableModel(null, columnas) {
		    
		    public boolean isCellEditable(int row, int column) {
		        return false; 
		    }
		};

	    for (Cliente c : ConsultarDatos.obtenerClientes()) {
	    	Object row [] = {c.getId(), c.getNombre(), c.getTelefono(), c.getCorreo()};
	    	if (c.getId() > 0) {model.addRow(row);}
	    }
	    return model;
	}
	
	
	public static DefaultTableModel cargartablaPagos() {
		String [] columnas = {"ID", "Cliente", "Monto", "MetodoDePago", "Fecha"};
		DefaultTableModel model = new DefaultTableModel(null, columnas) {
		    
		    public boolean isCellEditable(int row, int column) {
		        return false; 
		    }
		};
		
		for (Pago p : ConsultarDatos.obtenerPagos()) {
			Object row [] = {p.getIdPago(), p.getnombreCliente(), p.getMonto(), p.getMetodoPago(), p.getFechaPago()};
			model.addRow(row);	
		}	
		
		return model;
	}
}