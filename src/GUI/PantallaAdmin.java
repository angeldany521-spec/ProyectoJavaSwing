package GUI;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import com.formdev.flatlaf.FlatLightLaf;



public class PantallaAdmin {

    private JFrame frame;
    private CardLayout cardLayout;
    private JPanel panelPrincipal;
    private JTextField textField;
    private JTable table;
    private JTextField textField_1;
    private JTable table_1;
    private JTextField textField_2;
    private JTable table_2;

    public static void main(String[] args) {
    	try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
            ex.printStackTrace();
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
        sidebar.setBackground(new Color(0,0,0,230));
        sidebar.setPreferredSize(new Dimension(250, 600));
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));

        
        JPanel logoPanel = new JPanel();
        logoPanel.setForeground(new Color(0,0,0,215));
        logoPanel.setBackground(new Color(26, 26, 26));
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
        pantallaEmpleados.setLayout(null);
        pantallaEmpleados.setBackground(Paleta.fondoPrincipal);
        
        
        JLabel lblEmpleados = new JLabel("Empleados");
        lblEmpleados.setFont(new Font("SansSerif", Font.BOLD, 27));
        lblEmpleados.setHorizontalAlignment(SwingConstants.CENTER);
        lblEmpleados.setBounds(432, 23, 170, 35);
        pantallaEmpleados.add(lblEmpleados);

        // Pantalla agregar
        JPanel pantallaCitas = new JPanel();
        pantallaCitas.setLayout(null);
        JLabel label = new JLabel("Historial de Citas");
        label.setFont(new Font("SansSerif", Font.BOLD, 27));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBounds(384, 5, 245, 49);
        pantallaCitas.add(label);
        
        
        JPanel pantallaPagos = new JPanel();
        pantallaPagos.setLayout(null);
        JLabel lbPagos = new JLabel("Historial de Pagos");
        lbPagos.setBounds(386, 5, 241, 49);
        lbPagos.setFont(new Font("SansSerif", Font.BOLD, 27));
        lbPagos.setHorizontalAlignment(SwingConstants.CENTER);
        pantallaPagos.add(lbPagos);
       
        
        

        // Añadir pantallas
        panelPrincipal.add(pantallaEmpleados, "EMPLEADOS");
        
        JLabel lbBuscar = new JLabel("Buscar: ");
        lbBuscar.setForeground(Paleta.textologin2);
        lbBuscar.setFont(new Font("SansSerif", Font.BOLD, 16));
        lbBuscar.setBounds(71, 70, 80, 28);
        pantallaEmpleados.add(lbBuscar);
        
        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(141, 70, 513, 28);
        pantallaEmpleados.add(textField_1);
        
        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(72, 110, 889, 547);
        pantallaEmpleados.add(scrollPane_1);
        
        table_1 = new JTable();
        table_1.setModel(new DefaultTableModel(
            new Object[][] {},
            new String[] {
                "Id", "Nombre", "Usuario", "Rol", "Telefono", "Estado"
            }
        ));

        
        JTableHeader header = table_1.getTableHeader();
        table_1.getTableHeader().setBackground(Paleta.headers);
        table_1.getTableHeader().setForeground(Paleta.textologin2);
        
        header.setFont(new Font("Segoe UI", Font.BOLD, 14));
        
        scrollPane_1.setViewportView(table_1);
        
        JButton btnAgregarEmpleado = new JButton("Agregar Empleado");
        btnAgregarEmpleado.setForeground(Paleta.textologin);
        btnAgregarEmpleado.setBackground(Paleta.fondoBoton2);
        btnAgregarEmpleado.setBounds(670, 70, 139, 26);
        pantallaEmpleados.add(btnAgregarEmpleado);
        
        JButton btEliminarEmpleado = new JButton("Eliminar Empleado");
        btEliminarEmpleado.setForeground(Paleta.textologin);
        btEliminarEmpleado.setBackground(Paleta.fondoBoton2);
        btEliminarEmpleado.setBounds(821, 70, 139, 26);
        pantallaEmpleados.add(btEliminarEmpleado);
        panelPrincipal.add(pantallaCitas, "CITAS");
        panelPrincipal.add(pantallaPagos, "PAGOS");
        
        JLabel lbBuscar3 = new JLabel("Buscar: ");
        lbBuscar3.setForeground(Paleta.textologin2);
        lbBuscar3.setFont(new Font("SansSerif", Font.BOLD, 16));
        lbBuscar3.setBounds(91, 72, 81, 28);
        pantallaPagos.add(lbBuscar3);
        
        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(161, 72, 572, 28);
        pantallaPagos.add(textField_2);
        
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
        
        table_2 = new JTable();
        table_2.setModel(new DefaultTableModel(
        	new Object[][] {
        	},
        	new String[] {
        		"Id", "Monto", "Metodo de Pago", "Fecha"
        	}
        ));
        table_2.getColumnModel().getColumn(2).setPreferredWidth(118);
        
        JTableHeader header2 = table_2.getTableHeader();
        table_2.getTableHeader().setBackground(Paleta.headers);
        table_2.getTableHeader().setForeground(Paleta.textologin2);
        
        header2.setFont(new Font("Segoe UI", Font.BOLD, 14));
        scrollPane_2.setViewportView(table_2);
        
        
        JLabel lbBuscar2 = new JLabel("Buscar: ");
        lbBuscar2.setForeground(Paleta.textologin2);
        lbBuscar2.setFont(new Font("SansSerif", Font.BOLD, 16));
        lbBuscar2.setBounds(76, 65, 69, 28);
        pantallaCitas.add(lbBuscar2);
        
        textField = new JTextField();
        textField.setBounds(147, 65, 592, 28);
        pantallaCitas.add(textField);
        textField.setColumns(10);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(76, 119, 881, 554);
        pantallaCitas.add(scrollPane);
        
        table = new JTable();
        table.setModel(new DefaultTableModel(
        	new Object[][] {
        	},
        	new String[] {
        		"Fecha", "Hora", "Estado"
        	}
        ));
        
        JTableHeader header3 = table.getTableHeader();
        table.getTableHeader().setBackground(Paleta.headers);
        table.getTableHeader().setForeground(Paleta.textologin2);
        header3.setFont(new Font("Segoe UI", Font.BOLD, 14));
        table.getColumnModel().getColumn(0).setPreferredWidth(202);
        scrollPane.setViewportView(table);
        
        JRadioButton rbFechaC = new JRadioButton("Fecha");
        rbFechaC.setForeground(Paleta.fondoBoton);
        rbFechaC.setBounds(747, 68, 69, 23);
        pantallaCitas.add(rbFechaC);
        
        JRadioButton rbHoraC = new JRadioButton("Hora");
        rbHoraC.setForeground(Paleta.fondoBoton2);
        rbHoraC.setBounds(818, 68, 57, 23);
        pantallaCitas.add(rbHoraC);
        
        ButtonGroup filtroCitas = new ButtonGroup();
        filtroCitas.add(rbFechaC);
        filtroCitas.add(rbHoraC);

        // ---------------- BOTONES DEL SIDEBAR ----------------
        sidebar.add(createMenuButton("Gestion Empleados", () -> {
            cardLayout.show(panelPrincipal, "EMPLEADOS");
        }));

       
        sidebar.add(createMenuButton("Historial de Citas", () -> {
        	cardLayout.show(panelPrincipal, "CITAS");
        }));
         sidebar.add(createMenuButton("Historial de Pagos", () -> {
        	cardLayout.show(panelPrincipal, "PAGOS");
        }));
        
         
        sidebar.add(Box.createVerticalStrut(410));
        sidebar.add(createMenuButton("Cerrar Sesión", () -> {
			frame.dispose();
			
		}));
        
//        Component verticalGlue = Box.createVerticalGlue();
//        sidebar.add(verticalGlue);
        sidebar.add(Box.createVerticalStrut(500));

        // Añadir todo al frame
        frame.getContentPane().add(sidebar, BorderLayout.WEST);
        frame.getContentPane().add(panelPrincipal, BorderLayout.CENTER);
    }

    // ---- Método para crear botones con acción ----
    private JPanel createMenuButton(String text, Runnable action) {

        JPanel button = new JPanel();
        button.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));
        button.setMaximumSize(new Dimension(250, 45));
        button.setBackground(Paleta.fondoBoton2);

        JLabel label = new JLabel(text);
        label.setFont(new Font("Segoe UI", Font.BOLD, 15));
        label.setForeground(Paleta.textologin);
        label.setOpaque(true);
        label.setBackground(Paleta.fondoBoton2);

        button.add(label);

        button.addMouseListener(new java.awt.event.MouseAdapter() {

//            @Override
//            public void mouseEntered(java.awt.event.MouseEvent evt) {
//                button.setBackground(Paleta.active);
//                label.setBackground(Paleta.active);
//            }
//
//            @Override
//            public void mouseExited(java.awt.event.MouseEvent evt) {
//              
//            }

            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                action.run();
            }
        });

        return button;
    }
}
