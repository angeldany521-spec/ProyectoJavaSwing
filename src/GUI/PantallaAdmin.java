package GUI;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;

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
    		
			  for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
			  
			  if ("Windows".equals(info.getName())) {
			  
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

    private void initialize() {

        frame = new JFrame();
        frame.setBounds(100, 100, 1280, 900);
        frame.setTitle("BarberPiece - Panel Administrador");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setLayout(new BorderLayout());

        // ---------------- SIDEBAR ----------------
        JPanel sidebar = new JPanel();
        sidebar.setBackground(Paleta.panel);
        sidebar.setPreferredSize(new Dimension(250, 600));
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));

        // Logo
        JPanel logoPanel = new JPanel();
        logoPanel.setBackground(new Color(245, 247, 250));
        logoPanel.setPreferredSize(new Dimension(250, 70));
        logoPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));

        
        JLabel title = new JLabel("BarberPiece");
        title.setBounds(10, 11, 102, 25);
        title.setFont(new Font("Segoe UI", Font.BOLD, 18));
        logoPanel.add(title);

        sidebar.add(logoPanel);

        // ---------------- PANTALLAS CON CARDLAYOUT ----------------
        cardLayout = new CardLayout();
        panelPrincipal = new JPanel(cardLayout);

        // Pantalla EMPLEADOS
        JPanel pantallaEmpleados = new JPanel();
        pantallaEmpleados.setLayout(null);
        JLabel lblEmpleados = new JLabel("Empleados");
        lblEmpleados.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblEmpleados.setHorizontalAlignment(SwingConstants.CENTER);
        lblEmpleados.setBounds(422, 5, 170, 35);
        pantallaEmpleados.add(lblEmpleados);

        // Pantalla agregar
        JPanel pantallaCitas = new JPanel();
        pantallaCitas.setLayout(null);
        JLabel label = new JLabel("Historial de Citas");
        label.setFont(new Font("Tahoma", Font.PLAIN, 18));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBounds(427, 5, 160, 49);
        pantallaCitas.add(label);
        
        
        JPanel pantallaPagos = new JPanel();
        pantallaPagos.setLayout(null);
        JLabel lbPagos = new JLabel("Historial de Pagos");
        lbPagos.setBounds(427, 5, 160, 49);
        lbPagos.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lbPagos.setHorizontalAlignment(SwingConstants.CENTER);
        pantallaPagos.add(lbPagos);
       
        
        

        // Añadir pantallas
        panelPrincipal.add(pantallaEmpleados, "EMPLEADOS");
        
        JLabel lblNewLabel_1 = new JLabel("Buscar: ");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_1.setBounds(71, 76, 57, 28);
        pantallaEmpleados.add(lblNewLabel_1);
        
        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(138, 76, 804, 28);
        pantallaEmpleados.add(textField_1);
        
        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(71, 131, 871, 547);
        pantallaEmpleados.add(scrollPane_1);
        
        table_1 = new JTable();
        table_1.setModel(new DefaultTableModel(
        	new Object[][] {
        	},
        	new String[] {
        		"Id", "Nombre", "Usuario", "Rol", "Telefono", "Estado"
        	}
        ));
        scrollPane_1.setViewportView(table_1);
        panelPrincipal.add(pantallaCitas, "CITAS");
        panelPrincipal.add(pantallaPagos, "PAGOS");
        
        JLabel lblNewLabel_2 = new JLabel("Buscar: ");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_2.setBounds(50, 70, 57, 28);
        pantallaPagos.add(lblNewLabel_2);
        
        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(117, 70, 572, 28);
        pantallaPagos.add(textField_2);
        
        JRadioButton rbMetodoPago = new JRadioButton("Metodos de Pago");
        rbMetodoPago.setBounds(778, 73, 135, 23);
        pantallaPagos.add(rbMetodoPago);
        
        JRadioButton rbFecha = new JRadioButton("Fecha");
        rbFecha.setBounds(695, 73, 81, 23);
        pantallaPagos.add(rbFecha);
        
        ButtonGroup filtros = new ButtonGroup();
        filtros.add(rbFecha);
        filtros.add(rbMetodoPago);
        
        JScrollPane scrollPane_2 = new JScrollPane();
        scrollPane_2.setBounds(50, 122, 851, 517);
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
        scrollPane_2.setViewportView(table_2);
        
        JLabel lblNewLabel = new JLabel("Buscar: ");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel.setBounds(65, 65, 57, 28);
        pantallaCitas.add(lblNewLabel);
        
        textField = new JTextField();
        textField.setBounds(132, 65, 592, 28);
        pantallaCitas.add(textField);
        textField.setColumns(10);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(66, 119, 881, 554);
        pantallaCitas.add(scrollPane);
        
        table = new JTable();
        table.setModel(new DefaultTableModel(
        	new Object[][] {
        	},
        	new String[] {
        		"Fecha", "Hora", "Estado"
        	}
        ));
        table.getColumnModel().getColumn(0).setPreferredWidth(202);
        scrollPane.setViewportView(table);
        
        JRadioButton rdFechaC = new JRadioButton("Fecha");
        rdFechaC.setBounds(747, 68, 69, 23);
        pantallaCitas.add(rdFechaC);
        
        JRadioButton rdHoraC = new JRadioButton("Hora");
        rdHoraC.setBounds(818, 68, 57, 23);
        pantallaCitas.add(rdHoraC);
        
        ButtonGroup filtroCitas = new ButtonGroup();
        filtroCitas.add(rdFechaC);
        filtroCitas.add(rdHoraC);

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
        button.setBackground(new Color(245, 247, 250));

        JLabel label = new JLabel(text);
        label.setFont(new Font("Segoe UI", Font.PLAIN, 15));

        button.add(label);

        // Hover
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(229, 232, 236));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(245, 247, 250));
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                action.run();
            }
        });

        return button;
    }
}
