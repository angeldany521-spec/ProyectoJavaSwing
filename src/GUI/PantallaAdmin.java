package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class PantallaAdmin {

    private JFrame frame;
    private CardLayout cardLayout;
    private JPanel panelPrincipal;
    private JTextField tfCitas;
    private JTable tablaCitas;
    private JTextField tfEmpleados;
    private JTable tablaEmpleado;
    private JTextField tfPagos;
    private JTable tablaPagos;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;

    public static void main(String[] args) {

//    	try {
//            UIManager.setLookAndFeel(new FlatLightLaf());
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
    	

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


        EventQueue.invokeLater(() -> {
            try {
                PantallaAdmin window = new PantallaAdmin();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public PantallaAdmin() {
        initialize();
    }



	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
	
        frame = new JFrame();
        frame.setBounds(100, 100, 1300, 900);
        frame.setTitle("BarberPiece - Panel Administrador");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setLayout(new BorderLayout());

        // ---------------- SIDEBAR ----------------
        JPanel sidebar = new JPanel();
        sidebar.setBackground(Paleta.menu);
        sidebar.setPreferredSize(new Dimension(250, 600));
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        

        
        JPanel logoPanel = new JPanel();
    
        logoPanel.setBackground(Paleta.menu);
        logoPanel.setPreferredSize(new Dimension(250, 70));
        logoPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));
        
        JPanel cerrarPanel = new JPanel();
        

        
        JLabel title = new JLabel("BarberPiece");
        title.setBounds(10, 11, 102, 25);
        title.setFont(new Font("Segoe UI", Font.BOLD, 18));
        title.setForeground(Paleta.textologin);
        logoPanel.add(title);

        sidebar.add(logoPanel);
        sidebar.add(Box.createVerticalStrut(30));

        // ---------------- PANTALLAS CON CARDLAYOUT ----------------
        cardLayout = new CardLayout();
        panelPrincipal = new JPanel(cardLayout);

        // Pantalla EMPLEADOS
        JPanel pantallaEmpleados = new JPanel();
        pantallaEmpleados.setBackground(Paleta.fondo2);
        pantallaEmpleados.setLayout(null);
        pantallaEmpleados.setBackground(Paleta.fondoPrincipal);
        
        
        JLabel lblEmpleados = new JLabel("Empleados");
        lblEmpleados.setForeground(Paleta.textologin2);
        lblEmpleados.setFont(new Font("SansSerif", Font.BOLD, 27));
        lblEmpleados.setHorizontalAlignment(SwingConstants.CENTER);
        lblEmpleados.setBounds(432, 23, 170, 35);
        pantallaEmpleados.add(lblEmpleados);

        // Pantalla Citas
        JPanel pantallaCitas = new JPanel();
        pantallaCitas.setBackground(Paleta.fondo2);
        pantallaCitas.setLayout(null);
        JLabel label = new JLabel("Historial de Citas");
        label.setFont(new Font("SansSerif", Font.BOLD, 27));
        label.setForeground(Paleta.textologin2);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBounds(384, 5, 245, 49);
        pantallaCitas.add(label);
        
        
        JPanel pantallaPagos = new JPanel();
        pantallaPagos.setBackground(Paleta.fondo2);
        pantallaPagos.setLayout(null);
        JLabel lbPagos = new JLabel("Historial de Pagos");
        lbPagos.setForeground(Paleta.textologin2);
        lbPagos.setBounds(386, 5, 241, 49);
        lbPagos.setFont(new Font("SansSerif", Font.BOLD, 27));
        lbPagos.setHorizontalAlignment(SwingConstants.CENTER);
        pantallaPagos.add(lbPagos);
        
        JPanel pantallaAgregar = new JPanel();
        pantallaAgregar.setBackground(Paleta.fondo2);
        pantallaAgregar.setLayout(null);
        JLabel lbAgregar = new JLabel("Agregar Empleado");
        lbAgregar.setForeground(Paleta.textologin2);
        lbAgregar.setBounds(386, 5, 241, 49);
        lbAgregar.setFont(new Font("SansSerif", Font.BOLD, 27));
        lbAgregar.setHorizontalAlignment(SwingConstants.CENTER);
        pantallaPagos.add(lbAgregar);
       
        
        

        // Añadir pantallas
        
        JLabel lbBuscar = new JLabel("Buscar: ");
        lbBuscar.setForeground(Paleta.textologin2);
        lbBuscar.setFont(new Font("SansSerif", Font.BOLD, 16));
        lbBuscar.setBounds(71, 70, 80, 28);
        pantallaEmpleados.add(lbBuscar);
        
        tfEmpleados = new JTextField();
        tfEmpleados.setColumns(10);
        tfEmpleados.setBounds(141, 70, 513, 28);
        pantallaEmpleados.add(tfEmpleados);
        
        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(72, 110, 889, 303);
        pantallaEmpleados.add(scrollPane_1);
        
        tablaEmpleado = new JTable();
        tablaEmpleado.setModel(new DefaultTableModel(
            new Object[][] {},
            new String[] {
                "Id", "Nombre", "Usuario", "Rol", "Telefono", "Estado"
            }
        ));
        tablaEmpleado.setOpaque(true);
        tablaEmpleado.setBackground(Color.BLACK);
        
        JTableHeader header = tablaEmpleado.getTableHeader();
        header.setOpaque(true);
        header.setBackground(Paleta.headers);
        tablaEmpleado.getTableHeader().setBackground(Color.BLACK);
        tablaEmpleado.getTableHeader().setForeground(Paleta.textologin2);
        
        header.setFont(new Font("Segoe UI", Font.BOLD, 14));
        
        scrollPane_1.setViewportView(tablaEmpleado);
        
        JScrollPane scrollPane_a = new JScrollPane();
        scrollPane_a.setBounds(72, 110, 889, 60);
        pantallaAgregar.add(scrollPane_a);
        
        JTable tablaAgregar = new JTable();
        tablaAgregar.setModel(new DefaultTableModel(
            new Object[][] {},
            new String[] {
                "Id", "Nombre", "Usuario", "Rol", "Telefono", "Estado"
            }
        ));
        
        scrollPane_a.setViewportView(tablaAgregar);
        
        ImageIcon agg = new ImageIcon(getClass().getResource("/Imagenes/botonAgregar.png"));
        
        Image img = agg.getImage();
        Image size = img.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        ImageIcon aggIcon = new ImageIcon(size);
        			
        
        JButton btnAgregarEmpleado = new JButton("Agregar ",aggIcon);
        
        btnAgregarEmpleado.setHorizontalTextPosition(SwingConstants.RIGHT);
        btnAgregarEmpleado.setIconTextGap(3);
        btnAgregarEmpleado.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnAgregarEmpleado.setForeground(Paleta.textologin);
        btnAgregarEmpleado.setBackground(Paleta.fondoBoton2);
        btnAgregarEmpleado.setBounds(664, 67, 145, 35);
        pantallaEmpleados.add(btnAgregarEmpleado);
        
        ImageIcon elim = new ImageIcon(getClass().getResource("/Imagenes/botonBorrar.png"));
      
        Image img1 = elim.getImage();
        Image size1 = img1.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        ImageIcon elimIcon = new ImageIcon(size1);
        
        JButton btEliminarEmpleado = new JButton("Eliminar",elimIcon);
        btEliminarEmpleado.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btEliminarEmpleado.setForeground(Paleta.textologin);
        btEliminarEmpleado.setBackground(Paleta.fondoBoton2);
        btEliminarEmpleado.setBounds(821, 67, 139, 35);
        pantallaEmpleados.add(btEliminarEmpleado);
        panelPrincipal.add(pantallaEmpleados, "EMPLEADOS");
        panelPrincipal.add(pantallaAgregar,"AGREGAR");
        
        JLabel lblAgregarEmpleado = new JLabel("Agregar Empleado");
        lblAgregarEmpleado.setHorizontalAlignment(SwingConstants.CENTER);
        lblAgregarEmpleado.setForeground(new Color(70, 150, 230));
        lblAgregarEmpleado.setFont(new Font("SansSerif", Font.BOLD, 27));
        lblAgregarEmpleado.setBounds(394, 31, 246, 35);
        pantallaAgregar.add(lblAgregarEmpleado);
        
        JPanel panel = new JPanel();
        panel.setBounds(292, 182, 449, 495);
        pantallaAgregar.add(panel);
        panel.setLayout(null);
        
        JLabel lblNewLabel_2 = new JLabel("Nombre:");
        lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 14));
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_2.setBounds(49, 45, 77, 16);
        panel.add(lblNewLabel_2);
        
        textField = new JTextField();
        textField.setBounds(122, 39, 275, 29);
        panel.add(textField);
        textField.setColumns(10);
        
        JLabel lblNewLabel_2_1 = new JLabel("Usuario:");
        lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_2_1.setFont(new Font("Dialog", Font.BOLD, 14));
        lblNewLabel_2_1.setBounds(49, 113, 77, 16);
        panel.add(lblNewLabel_2_1);
        
        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(122, 107, 275, 29);
        panel.add(textField_1);
        
        JLabel lblNewLabel_2_1_1 = new JLabel("Rol:");
        lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_2_1_1.setFont(new Font("Dialog", Font.BOLD, 14));
        lblNewLabel_2_1_1.setBounds(49, 172, 67, 16);
        panel.add(lblNewLabel_2_1_1);
        
        JRadioButton rdbtnNewRadioButton = new JRadioButton("Regular");
        rdbtnNewRadioButton.setBounds(122, 169, 88, 24);
        panel.add(rdbtnNewRadioButton);
        
        JRadioButton rdbtnBarbero = new JRadioButton("Admin");
        rdbtnBarbero.setBounds(222, 169, 88, 24);
        panel.add(rdbtnBarbero);
        
        JLabel lblNewLabel_2_1_2 = new JLabel("Telefono: ");
        lblNewLabel_2_1_2.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_2_1_2.setFont(new Font("Dialog", Font.BOLD, 14));
        lblNewLabel_2_1_2.setBounds(49, 222, 77, 16);
        panel.add(lblNewLabel_2_1_2);
        
        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(122, 216, 275, 29);
        panel.add(textField_2);
        panelPrincipal.add(pantallaCitas, "CITAS");
        panelPrincipal.add(pantallaPagos, "PAGOS");
        
        JLabel lbBuscar3 = new JLabel("Buscar: ");
        lbBuscar3.setForeground(Paleta.textologin2);
        lbBuscar3.setFont(new Font("SansSerif", Font.BOLD, 16));
        lbBuscar3.setBounds(91, 72, 81, 28);
        pantallaPagos.add(lbBuscar3);
        
        tfPagos = new JTextField();
        tfPagos.setColumns(10);
        tfPagos.setBounds(161, 72, 501, 28);
        pantallaPagos.add(tfPagos);
        
        JRadioButton rbMetodoPago = new JRadioButton("Metodos de Pago");
        rbMetodoPago.setForeground(Paleta.fondoBoton2);
        rbMetodoPago.setBounds(819, 75, 123, 23);
        pantallaPagos.add(rbMetodoPago);
        
        JRadioButton rbFecha = new JRadioButton("Fecha");
        rbFecha.setForeground(Paleta.fondoBoton2);
        rbFecha.setBounds(742, 75, 73, 23);
        pantallaPagos.add(rbFecha);
        
        ButtonGroup filtros = new ButtonGroup();
        filtros.add(rbFecha);
        filtros.add(rbMetodoPago);
        
        JScrollPane scrollPane_2 = new JScrollPane();
        scrollPane_2.setBounds(91, 122, 851, 517);
        pantallaPagos.add(scrollPane_2);
        
        tablaPagos = new JTable();
        tablaPagos.setModel(new DefaultTableModel(
        	new Object[][] {
        	},
        	new String[] {
        		"Id", "Monto", "Metodo de Pago", "Fecha"
        	}
        ));
        tablaPagos.getColumnModel().getColumn(2).setPreferredWidth(118);
        tablaPagos.setBackground(Paleta.headers);
        
        JTableHeader header2 = tablaPagos.getTableHeader();
        tablaPagos.getTableHeader().setBackground(Paleta.headers);
        tablaPagos.getTableHeader().setForeground(Paleta.textologin2);
        
        header2.setFont(new Font("Segoe UI", Font.BOLD, 14));
        scrollPane_2.setViewportView(tablaPagos);
        
        JLabel lblNewLabel_1 = new JLabel("Filtrar por: ");
        lblNewLabel_1.setFont(new Font("SansSerif", Font.BOLD, 12));
        lblNewLabel_1.setBounds(680, 78, 69, 16);
        pantallaPagos.add(lblNewLabel_1);
        
        
        JLabel lbBuscar2 = new JLabel("Buscar: ");
        lbBuscar2.setForeground(Paleta.textologin2);
        lbBuscar2.setFont(new Font("SansSerif", Font.BOLD, 16));
        lbBuscar2.setBounds(76, 65, 69, 28);
        pantallaCitas.add(lbBuscar2);
        
        tfCitas = new JTextField();
        tfCitas.setBounds(147, 65, 592, 28);
        pantallaCitas.add(tfCitas);
        tfCitas.setColumns(10);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(76, 119, 881, 554);
        pantallaCitas.add(scrollPane);
        
        tablaCitas = new JTable();
        tablaCitas.setModel(new DefaultTableModel(
        	new Object[][] {
        	},
        	new String[] {
        		"Fecha", "Hora", "Estado"
        	}
        ));
        
        JTableHeader header3 = tablaCitas.getTableHeader();
        tablaCitas.getTableHeader().setBackground(Paleta.headers);
        tablaCitas.getTableHeader().setForeground(Paleta.textologin2);
        header3.setFont(new Font("Segoe UI", Font.BOLD, 14));
        tablaCitas.getColumnModel().getColumn(0).setPreferredWidth(202);
        scrollPane.setViewportView(tablaCitas);
        
        JRadioButton rbFechaC = new JRadioButton("Fecha");
        rbFechaC.setForeground(Paleta.fondoBoton);
        rbFechaC.setBounds(827, 70, 69, 23);
        pantallaCitas.add(rbFechaC);
        
        JRadioButton rbHoraC = new JRadioButton("Hora");
        rbHoraC.setForeground(Paleta.fondoBoton2);
        rbHoraC.setBounds(900, 70, 57, 23);
        pantallaCitas.add(rbHoraC);
        
        ButtonGroup filtroCitas = new ButtonGroup();
        filtroCitas.add(rbFechaC);
        filtroCitas.add(rbHoraC);
        
        JLabel lblNewLabel = new JLabel("Filtrar por: ");
        lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 12));
        lblNewLabel.setBounds(758, 73, 69, 16);
        pantallaCitas.add(lblNewLabel);

        // ---------------- BOTONES DEL SIDEBAR ----------------
        sidebar.add(createMenuButton("Gestion Empleados", () -> {
            cardLayout.show(panelPrincipal, "EMPLEADOS");
        }));
        sidebar.add(createMenuButton("Agregar Empleado", () -> {
        	cardLayout.show(panelPrincipal, "AGREGAR");
        }));

       
        sidebar.add(createMenuButton("Historial de Citas", () -> {
        	cardLayout.show(panelPrincipal, "CITAS");
        }));
         sidebar.add(createMenuButton("Historial de Pagos", () -> {
        	cardLayout.show(panelPrincipal, "PAGOS");
        }));
        
         
        sidebar.add(Box.createVerticalStrut(310));
        sidebar.add(createMenuButton("Cerrar Sesión", () -> {
			frame.dispose();
			
		}));
        
        
//        Component verticalGlue = Box.createVerticalGlue();
//        sidebar.add(verticalGlue);
        sidebar.add(Box.createVerticalStrut(400));

        // Añadir todo al frame
        frame.getContentPane().add(sidebar, BorderLayout.WEST);
        frame.getContentPane().add(panelPrincipal, BorderLayout.CENTER);
        
        
    }

    // ---- Método para crear botones con acción ----
	private JButton createMenuButton(String text, Runnable action) {

	    JButton btn = new JButton(text);
	   
	    btn.setFont(new Font("Segoe UI", Font.BOLD, 15));
	    btn.setForeground(Paleta.textologin);
	    btn.setBackground(Paleta.fondoBoton2);

	    btn.setFocusPainted(false);
	    btn.setBorderPainted(false);
	    btn.setHorizontalAlignment(SwingConstants.LEFT);
	    btn.setPreferredSize(new Dimension(750, 105));
	    btn.setMinimumSize(new Dimension(Integer.MAX_VALUE, 55));
	    btn.setMaximumSize(new Dimension(Integer.MAX_VALUE, 45));

	  
	    btn.addActionListener(e -> action.run());
	    
	    btn.addMouseListener(new java.awt.event.MouseAdapter() {
	        @Override
	        public void mouseEntered(java.awt.event.MouseEvent evt) {
	            btn.setBackground(Paleta.active);
	        }

	        @Override
	        public void mouseExited(java.awt.event.MouseEvent evt) {
	            btn.setBackground(Paleta.fondoBoton2);
	            
	        }
	          
	    	
	    });

	    return btn;
	}
}
