
package GUI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatLightLaf;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;




public class PantallaPrincipal {

	private JFrame frame;
	private JTextField campoBuscar;
	private JTable tableCitas;
	private JTextField buscarHistorialPagos;
	private JTable tableHistorialPagos;

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
		frame.setBounds(100, 100, 1190, 602);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout());
		frame.getContentPane().setBackground(Paleta.fondo2);
		
	    

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
        
        String[] columnasCitas = {"Cliente", "Barber", "Fecha", "Servicio", "Duracion", "Precio"};
        
        		
        
        DefaultTableModel modeloCitas = new DefaultTableModel(columnasCitas, 0);
        modeloCitas.addRow(new String[]{"Cliente", "Barbero", "Fecha", "Servicio", "Duracion", "Precio"});
        modeloCitas.addRow(new String[]{"Cliente", "Barbero", "Fecha", "Servicio", "Duracion", "Precio"});
        modeloCitas.addRow(new String[]{"Cliente", "Barbero", "Fecha", "Servicio", "Duracion", "Precio"});
        modeloCitas.addRow(new String[]{"Cliente", "Barbero", "Fecha", "Servicio", "Duracion", "Precio"});
        
        
        
        tableCitas = new JTable(modeloCitas);
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
        
        tableCitas.putClientProperty(
                FlatClientProperties.STYLE,
                "showHorizontalLines:true; "
                + // separadores de filas
                "showVerticalLines:true; "
                + // con líneas verticales
                "rowHeight:28; "
                + // altura agradable
                "intercellSpacing:0,1; "
                + // grosor de 1px entre filas
                "selectionBackground:#E6F0FF; "
                +
                "selectionForeground:#0A1F44; "
        );
        
        JPanel panelSuperior = new JPanel();
        panelSuperior.setBounds(-185, 10, 1407, 51);
        panelSuperior.setBackground(Paleta.fondoPrincipal);
        Inicio.add(panelSuperior);
        panelSuperior.setLayout(new FlowLayout(FlowLayout.CENTER, 150, 5));
        
        JLabel lblCitas = new JLabel("Citas");
        panelSuperior.add(lblCitas);
        lblCitas.setFont(new Font("SansSerif", Font.BOLD, 27));
        lblCitas.setForeground(Paleta.textologin2);
        lblCitas.setBackground(Paleta.fondo2);
        
        campoBuscar = new JTextField();
        panelSuperior.add(campoBuscar);
        campoBuscar.setOpaque(false);
        campoBuscar.setForeground(Paleta.menu);
        campoBuscar.setBackground(Paleta.fondo2);
        campoBuscar.setFont(new Font("SansSerif", Font.PLAIN, 13));
        campoBuscar.setBorder(new Borde(10, Paleta.menu));
        campoBuscar.setColumns(40);
        
        ImageIcon elim = new ImageIcon(getClass().getResource("/Imagenes/botonBorrar.png"));
        Image img1 = elim.getImage();
        Image size1 = img1.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon elimIcon = new ImageIcon(size1);
        
        JButton eliminarCita = new JButton("Eliminar Cita", elimIcon);
        eliminarCita.setOpaque(false);
        eliminarCita.setBorder(null);
        panelSuperior.add(eliminarCita);
        eliminarCita.setPreferredSize(new Dimension(200, 40));
        eliminarCita.setFont(new Font("SansSerif", Font.BOLD, 15));
        
        eliminarCita.setBackground(Paleta.fondoBoton2);
        eliminarCita.setForeground(Paleta.textologin);
        
        
        PanelGestionPagos verHistorialPagos = new PanelGestionPagos();
        verHistorialPagos.setBackground(Paleta.fondoPrincipal);
        panel.add(verHistorialPagos, "historialPagos");
        verHistorialPagos.setOpaque(true);
        
        JPanel panelSuperior_1 = new JPanel();
        panelSuperior_1.setBackground(Paleta.fondoPrincipal);
        panelSuperior_1.setBounds(0, 10, 1023, 51);
        verHistorialPagos.add(panelSuperior_1);
        panelSuperior_1.setLayout(null);
        
        JLabel lblHistorialPagos = new JLabel("Historial De Pagos");
        lblHistorialPagos.setBounds(9, 8, 241, 35);
        lblHistorialPagos.setForeground(new Color(70, 150, 230));
        lblHistorialPagos.setFont(new Font("SansSerif", Font.BOLD, 27));
        lblHistorialPagos.setBackground(new Color(240, 235, 220));
        panelSuperior_1.add(lblHistorialPagos);
        
        
        buscarHistorialPagos = new JTextField();
        buscarHistorialPagos.setBounds(621, 5, 392, 41);
        buscarHistorialPagos.setOpaque(false);
        buscarHistorialPagos.setForeground(new Color(0, 0, 0, 215));
        buscarHistorialPagos.setFont(new Font("SansSerif", Font.PLAIN, 13));
        buscarHistorialPagos.setColumns(50);
        buscarHistorialPagos.setBorder(new Borde(10, Paleta.menu));
        buscarHistorialPagos.setBackground(Paleta.fondoPrincipal);
        panelSuperior_1.add(buscarHistorialPagos);
        
        JPanel panelFiltro = new JPanel();
        panelFiltro.setBounds(334, 0, 196, 51);
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
        tableHistorialPagos.getTableHeader().setBackground(Paleta.headers);
        tableHistorialPagos.getTableHeader().setForeground(Paleta.textologin2);
        tableHistorialPagos.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 13));
        tableHistorialPagos.setGridColor(Color.black);
        tableHistorialPagos.setShowGrid(true);
        
        tableHistorialPagos.setForeground(Paleta.menu);
        tableHistorialPagos.setFillsViewportHeight(true);
        tableHistorialPagos.setBackground(Paleta.table);
        tableHistorialPagos.setFont(new Font("SansSerif", Font.PLAIN, 13));
        scrollPane_1.setViewportView(tableHistorialPagos);
        
        
        
        
        
        CrearCita crearCita = new CrearCita();
        panel.add(crearCita, "crearcitas");
        crearCita.setOpaque(true);
        crearCita.setBackground(Paleta.fondoPrincipal);
        crearCita.setLayout(null);
        
        
        
        

       

        // Cambiar fuente
        

        // Crear DatePicker con la configuración
        
        
        
        
        JLabel lblHistorialPagos_1 = new JLabel("Agregar Cita");
        lblHistorialPagos_1.setForeground(new Color(70, 150, 230));
        lblHistorialPagos_1.setFont(new Font("SansSerif", Font.BOLD, 27));
        lblHistorialPagos_1.setBackground(new Color(240, 235, 220));
        lblHistorialPagos_1.setBounds(10, 10, 241, 35);
        crearCita.add(lblHistorialPagos_1);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBounds(10, 55, 386, 283);
        panel_1.setBackground(Paleta.prueba);
        crearCita.add(panel_1);
        panel_1.setLayout(null);
        
        
        
       

        
        
        
        
        
       
        
        citas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				citas.setBackground(Paleta.active);
				crearCitas.setBackground(Paleta.fondoBoton2);
				historialPagos.setBackground(Paleta.fondoBoton2);
				card.show(panel, "cita");
				
				
			}
		});
        
        
        crearCitas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crearCitas.setBackground(Paleta.active);
				citas.setBackground(Paleta.fondoBoton2);
				historialPagos.setBackground(Paleta.fondoBoton2);
				card.show(panel, "crearcitas");
			}
		});
        
        historialPagos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				historialPagos.setBackground(Paleta.active);
				crearCitas.setBackground(Paleta.fondoBoton2);
				citas.setBackground(Paleta.fondoBoton2);
				card.show(panel, "historialPagos");
			}
		});
        
        
        btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
        
        
        
        
        
    }
}


