package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.prefs.NodeChangeListener;
import BaseDeDatos.ConsultarDatos;
import BaseDeDatos.GuardarDatos;
import GUI.PantallaPrincipal;
import Dominio.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ChangeEvent;



public class PantallaAdmin {

    private JFrame frame;
    private JButton btConfirmar;
    private JLabel lbUsuario_1;
    private JLabel lbUsuario;
    private JRadioButton rbTarde;
    private JRadioButton rbTarde_1;
    private JRadioButton rbMañana;
    private JRadioButton rbMañana_1;
    private JRadioButton rbBarbero;
    private JRadioButton rbMontoCitas;
    private JRadioButton rbFechaCita;
    private JRadioButton rbRecepcionista;
    private JRadioButton rbBarberoFiltro;
    private JRadioButton rbUsuarioFiltro;
    private ButtonGroup turnos;
    private CardLayout cardLayout;
    private Panel panelBarbero;
    private Panel panelEditEmpleado;
    private Panel panelEditBarbero;
    private JPanel panelPrincipal;
    private Panel panelAggEmpleado;
    private JTable tablaCitas;
    private JTable tablaEmpleado;
    private JTable tablaPagos;
    private JTable tablaGestionE;
    private JScrollPane scrollGestionEmpleados;
    private JScrollPane scrollGestionBarberos;
    private JTextField tfCitas;
    private JTextField tfEmpleados;
    private JTextField tfNombre;
    private JTextField tfPagos;
    private JTextField tfUsuario;
    private JTextField tfCorreo;
    private JTextField tfHorario;
    private JTextField tfNombreEdit;
    private JTextField tfUsuarioEdit;
    private JTextField tfTelefonoEdit;
    private DefaultTableModel model;
    private JTextField tfTelefono;
    private JTextField tfCorreoEdit;
	private JTable tablaBarberos;
	private JTextField tfBuscarBarberos;
	private JTable tablaGestionBarbero;
	private JTextField tfNombreBarbero;
	private JTextField tfHorarioBarbero;
	private JTextField tfTelefonoBarbero;
	private JTextField tfCorreoBarbero;
	private JButton botonSeleccionado = null;
	private TableRowSorter<DefaultTableModel> sorter;
	private TableRowSorter<DefaultTableModel> sorter1;
	private TableRowSorter<DefaultTableModel> sorter2;
	private TableRowSorter<DefaultTableModel> sorter3;
	
	
	ArrayList<Barbero> barberos = ConsultarDatos.obtenerBarberos();
	ArrayList<Cliente> clientes = ConsultarDatos.obtenerClientes();
	
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


        EventQueue.invokeLater(() -> {
            try {
                PantallaAdmin window = new PantallaAdmin();
                window.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                window.frame.setVisible(true);
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public PantallaAdmin() {
        initialize();
        cargarUsuariosEnTabla();
        cargarBarberosEnTabla();
    }

	/**
	 * Initialize the contents of the frame.
	 */
    
	private void initialize() {
	
        frame = new JFrame();
        frame.setBounds(100, 100, 1422, 895);
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
        logoPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
     
        ImageIcon logo = new ImageIcon(getClass().getResource("/Imagenes/LogoTipografica.png"));
        Image imglogo = logo.getImage();
        Image sizelogo = imglogo.getScaledInstance(180, 140, Image.SCALE_SMOOTH);
        ImageIcon logoIcon = new ImageIcon(sizelogo);
        
//        
//        JLabel lbLogo = new JLabel(logoIcon);
//        logoPanel.add(lbLogo);
        JLabel title = new JLabel(logoIcon);
        title.setHorizontalTextPosition(SwingConstants.CENTER);
        title.setBounds(0, 100, 102, 25);
//        title.setFont(new Font("Segoe UI", Font.BOLD, 18));
//        title.setForeground(Paleta.textologin);
        logoPanel.add(title);

        sidebar.add(logoPanel);
//        sidebar.add(Box.createVerticalStrut(30));

        // ---------------- PANTALLAS CON CARDLAYOUT ----------------
        cardLayout = new CardLayout();
        panelPrincipal = new JPanel(cardLayout);

        // Pantalla EMPLEADOS
        JPanel pantallaEmpleados = new JPanel();
        pantallaEmpleados.setBackground(Paleta.fondo2);
        pantallaEmpleados.setLayout(null);
        pantallaEmpleados.setBackground(Paleta.fondoPrincipal);
        
        JLabel lblEmpleados = new JLabel("Usuarios ");
        lblEmpleados.setForeground(Paleta.textologin2);
        lblEmpleados.setFont(new Font("SansSerif", Font.BOLD, 27));
        lblEmpleados.setHorizontalAlignment(SwingConstants.LEFT);
        lblEmpleados.setBounds(81, 22, 322, 35);
        pantallaEmpleados.add(lblEmpleados);
        
        JPanel pantallaPrueba = new JPanel();
        pantallaPrueba.setBackground(Paleta.fondo2);
        pantallaPrueba.setBackground(Paleta.fondoPrincipal);
        pantallaPrueba.setLayout(null);
        JLabel lbPrueba = new JLabel("Bienvenido a nuestro programa");
        lbPrueba.setHorizontalAlignment(SwingConstants.CENTER);
        lbPrueba.setFont(new Font("Dialog", Font.BOLD, 35));
        lbPrueba.setBounds(289, 270, 541, 136);
        pantallaPrueba.add(lbPrueba);
        
        

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
        
        JPanel pantallaGestion = new JPanel();
        pantallaGestion.setBackground(Paleta.fondo2);
        pantallaGestion.setLayout(null);
       
        
        

        // Añadir pantallas
        JLabel lbBuscar = new JLabel("Buscar: ");
        lbBuscar.setForeground(Paleta.textologin2);
        lbBuscar.setFont(new Font("SansSerif", Font.BOLD, 16));
        lbBuscar.setBounds(81, 69, 80, 28);
        pantallaEmpleados.add(lbBuscar);
        
        
        tfEmpleados = new JTextField();
        tfEmpleados.getDocument().addDocumentListener(new DocumentListener() {
			public void insertUpdate(javax.swing.event.DocumentEvent e) {
				
				String text = tfEmpleados.getText();

					sorter.setRowFilter(javax.swing.RowFilter.regexFilter("(?i)" + text, 1));
					
				}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				String text = tfEmpleados.getText();
				sorter.setRowFilter(javax.swing.RowFilter.regexFilter("(?i)" + text, 1));
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				}
			
			
			});
		
        tfEmpleados.setOpaque(false);
        tfEmpleados.setForeground(Paleta.menu);
        tfEmpleados.setBackground(Paleta.fondo2);
        tfEmpleados.setFont(new Font("SansSerif", Font.PLAIN, 13));
        tfEmpleados.setBorder(new Borde(5, Paleta.menu));
        tfEmpleados.setColumns(10);
        tfEmpleados.setBounds(151, 69, 549, 28);
        pantallaEmpleados.add(tfEmpleados);
        
        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(83, 110, 947, 228);
        pantallaEmpleados.add(scrollPane_1);
        
        tablaEmpleado = new JTable();
        tablaEmpleado.setLocation(81, 0);
        tablaEmpleado.setShowGrid(true);
        tablaEmpleado.setGridColor(Paleta.fondoPrincipal);
        tablaEmpleado.setForeground(Paleta.fondoPrincipal);
        tablaEmpleado.setFillsViewportHeight(true);
        tablaEmpleado.setModel(new DefaultTableModel(
        	new Object[][] {
        		{null, null, null, null, null, null},
        	},
        	new String[] {
        		"ID", "Nombre", "Telefono", "Correo", "Usuario", "Contrase\u00F1a"
        	}
        ));
        
        
        tablaEmpleado.setFillsViewportHeight(true);
        tablaEmpleado.setBackground(Paleta.table);
        
        JTableHeader header = tablaEmpleado.getTableHeader();
        header.setOpaque(true);
        header.setBackground(Paleta.headers);
        tablaEmpleado.getTableHeader().setForeground(Paleta.textologin2);
        header.setFont(new Font("Segoe UI", Font.BOLD, 14));
        scrollPane_1.setViewportView(tablaEmpleado);
       
        
        
        ImageIcon agg = new ImageIcon(getClass().getResource("/Imagenes/botonAgregar.png"));
        Image img = agg.getImage();
        Image size = img.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        ImageIcon aggIcon = new ImageIcon(size);
        			
        
        JButton btnAgregarEmpleado = new JButton("Agregar ",aggIcon);
        btnAgregarEmpleado.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	
        		cardLayout.show(panelPrincipal, "AGREGAR");
        		rbRecepcionista.setSelected(true);
        		scrollGestionEmpleados.setVisible(true);
        		rbUsuarioFiltro.setSelected(true);
        		rbRecepcionista.setSelected(true);
        		lbUsuario.setEnabled(true);
        		tfUsuario.setEnabled(true);
        		btConfirmar.setEnabled(true);
        		panelBarbero.setVisible(false);
        		panelAggEmpleado.setBounds(41, 84, 449, 444);
        		btConfirmar.setBounds(31, 383, 387, 40);
				
			}
        });
        btnAgregarEmpleado.setHorizontalTextPosition(SwingConstants.RIGHT);
        btnAgregarEmpleado.setIconTextGap(3);
        btnAgregarEmpleado.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnAgregarEmpleado.setForeground(Paleta.textologin);
        btnAgregarEmpleado.setBackground(Paleta.textologin2);
        btnAgregarEmpleado.setBounds(723, 66, 145, 35);
        pantallaEmpleados.add(btnAgregarEmpleado);
        
        ImageIcon elim = new ImageIcon(getClass().getResource("/Imagenes/botonBorrar.png"));
      
        Image img1 = elim.getImage();
        Image size1 = img1.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        ImageIcon elimIcon = new ImageIcon(size1);
        
        JButton btEliminarEmpleado = new JButton("Eliminar",elimIcon);
        
        btEliminarEmpleado.addActionListener(e -> eliminarEmpleado());
        btEliminarEmpleado.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btEliminarEmpleado.setForeground(Paleta.textologin);
        btEliminarEmpleado.setBackground(Paleta.fondoBoton2);
        btEliminarEmpleado.setBounds(891, 66, 139, 35);
        pantallaEmpleados.add(btEliminarEmpleado);
        
        
        JScrollPane scrollPane_1_2 = new JScrollPane();
        scrollPane_1_2.setBounds(81, 470, 947, 182);
        pantallaEmpleados.add(scrollPane_1_2);
        
        tablaBarberos = new JTable();
        JTableHeader header5 = tablaBarberos.getTableHeader();
        tablaBarberos.getTableHeader().setBackground(Paleta.headers);
        tablaBarberos.getTableHeader().setForeground(Paleta.textologin2);
        header5.setFont(new Font("Segoe UI", Font.BOLD, 14));
        tablaBarberos.setModel(new DefaultTableModel(
        	new Object[][] {
        		{null, null, null, null, null},
        	},
        	new String[] {
        		"ID", "Nombre", "Telefono", "Correo", "Turno"
        	}
        ));

        tablaBarberos.setShowGrid(true);
        tablaBarberos.setGridColor(new Color(242, 240, 235));
        tablaBarberos.setForeground(new Color(242, 240, 235));
        tablaBarberos.setFillsViewportHeight(true);
        tablaBarberos.setBackground(new Color(31, 41, 55));
        scrollPane_1_2.setViewportView(tablaBarberos);
        
        JLabel lbBarberos = new JLabel("Barberos");
        lbBarberos.setHorizontalAlignment(SwingConstants.LEFT);
        lbBarberos.setForeground(new Color(96, 165, 250));
        lbBarberos.setFont(new Font("SansSerif", Font.BOLD, 27));
        lbBarberos.setBounds(81, 387, 145, 35);
        pantallaEmpleados.add(lbBarberos);
        
        JLabel lbBuscar_1 = new JLabel("Buscar: ");
        lbBuscar_1.setForeground(new Color(96, 165, 250));
        lbBuscar_1.setFont(new Font("SansSerif", Font.BOLD, 16));
        lbBuscar_1.setBounds(81, 430, 80, 28);
        pantallaEmpleados.add(lbBuscar_1);
        
        tfBuscarBarberos = new JTextField();
        tfBuscarBarberos.getDocument().addDocumentListener(new DocumentListener() {
			public void insertUpdate(javax.swing.event.DocumentEvent e) {
				
				String text = tfBuscarBarberos.getText();
					sorter1.setRowFilter(javax.swing.RowFilter.regexFilter("(?i)" + text, 1));
					
				}

			@Override
			public void removeUpdate(DocumentEvent e) {
				String text = tfBuscarBarberos.getText();
				sorter1.setRowFilter(javax.swing.RowFilter.regexFilter("(?i)" + text, 1));
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				}
			
			
			});
        tfBuscarBarberos.setOpaque(false);
        tfBuscarBarberos.setForeground(new Color(31, 41, 55));
        tfBuscarBarberos.setFont(new Font("SansSerif", Font.PLAIN, 13));
        tfBuscarBarberos.setColumns(10);
        tfBuscarBarberos.setBorder(new Borde(5, Paleta.menu));
        tfBuscarBarberos.setBackground(new Color(242, 240, 235));
        tfBuscarBarberos.setBounds(151, 430, 549, 28);
        pantallaEmpleados.add(tfBuscarBarberos);
        
        JButton btnAgregarEmpleado_1 = new JButton("Agregar ", aggIcon);
        btnAgregarEmpleado_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		cardLayout.show(panelPrincipal, "AGREGAR");
        		scrollGestionEmpleados.setVisible(false);
        		rbBarbero.setSelected(true);
                		
                		tfUsuario.setText("");
                		lbUsuario.setEnabled(false);
                		tfUsuario.setEnabled(false);
                		panelAggEmpleado.setBounds(41, 84, 449,580);
                		panelAggEmpleado.add(panelBarbero);
                		panelBarbero.setBounds(0, 370, 449, 154);
                		btConfirmar.setBounds(31, 515, 387, 40);
                		panelBarbero.setVisible(true);
                
                		rbBarberoFiltro.setSelected(true);
        	
        	}
        });
        btnAgregarEmpleado_1.setIconTextGap(3);
        btnAgregarEmpleado_1.setHorizontalTextPosition(SwingConstants.RIGHT);
        btnAgregarEmpleado_1.setForeground(new Color(242, 240, 235));
        btnAgregarEmpleado_1.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnAgregarEmpleado_1.setBackground(new Color(96, 165, 250));
        btnAgregarEmpleado_1.setBounds(723, 423, 145, 35);
        pantallaEmpleados.add(btnAgregarEmpleado_1);
        
        JButton btEliminarEmpleado_1 = new JButton("Eliminar", elimIcon);
        btEliminarEmpleado_1.addActionListener(e -> eliminarBarbero());
        btEliminarEmpleado_1.setForeground(new Color(242, 240, 235));
        btEliminarEmpleado_1.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btEliminarEmpleado_1.setBackground(Paleta.fondoBoton2);
        btEliminarEmpleado_1.setBounds(891, 423, 139, 35);
        pantallaEmpleados.add(btEliminarEmpleado_1);
       
        
        JLabel lblAgregarEmpleado = new JLabel("Gestion Empleados");
        lblAgregarEmpleado.setForeground(Paleta.textologin2);
        lblAgregarEmpleado.setHorizontalAlignment(SwingConstants.LEFT);
        lblAgregarEmpleado.setFont(new Font("SansSerif", Font.BOLD, 27));
        lblAgregarEmpleado.setBounds(41, 39, 305, 35);
        pantallaGestion.add(lblAgregarEmpleado);
        
        panelAggEmpleado = new Panel(15, 0, Paleta.borde);
        panelAggEmpleado.setBackground(Paleta.menu);
        panelAggEmpleado.setBounds(41, 84, 449, 444);
        pantallaGestion.add(panelAggEmpleado);
        panelAggEmpleado.setLayout(null);
        
        JLabel lbNombre = new JLabel("Nombre:");
        lbNombre.setForeground(Paleta.fondoPrincipal);
        lbNombre.setFont(new Font("Dialog", Font.BOLD, 14));
        lbNombre.setHorizontalAlignment(SwingConstants.LEFT);
        lbNombre.setBounds(31, 59, 77, 16);
        panelAggEmpleado.add(lbNombre);
        
        tfNombre = new JTextField();
        tfNombre.setOpaque(false);
        tfNombre.setForeground(Paleta.fondoPrincipal);
        tfNombre.setBackground(Paleta.menu);
        tfNombre.setFont(new Font("SansSerif", Font.PLAIN, 13));
        tfNombre.setBorder(new Borde(5, Paleta.fondoPrincipal));
        tfNombre.setBounds(31, 85, 387, 29);
        tfNombre.setColumns(10);
        panelAggEmpleado.add(tfNombre);
        
        lbUsuario = new JLabel("Usuario:");
        lbUsuario.setForeground(Paleta.fondoPrincipal);
        lbUsuario.setHorizontalAlignment(SwingConstants.LEFT);
        lbUsuario.setFont(new Font("Dialog", Font.BOLD, 14));
        lbUsuario.setForeground(Paleta.fondoPrincipal);
        lbUsuario.setBounds(31, 124, 77, 16);
        panelAggEmpleado.add(lbUsuario);
        
        tfUsuario = new JTextField();
        tfUsuario.setOpaque(false);
        tfUsuario.setForeground(Paleta.fondoPrincipal);
        tfUsuario.setBackground(Paleta.menu);
        tfUsuario.setFont(new Font("SansSerif", Font.PLAIN, 13));
        tfUsuario.setBorder(new Borde(5, Paleta.fondoPrincipal));
        tfUsuario.setColumns(10);
        tfUsuario.setBounds(31, 150, 387, 29);
        panelAggEmpleado.add(tfUsuario);
        
        JLabel lbRol = new JLabel("Rol:");
        lbRol.setForeground(Paleta.fondoPrincipal);
        lbRol.setHorizontalAlignment(SwingConstants.LEFT);
        lbRol.setFont(new Font("Dialog", Font.BOLD, 14));
        lbRol.setBounds(31, 189, 67, 16);
        panelAggEmpleado.add(lbRol);
        
        rbBarbero = new JRadioButton("Barbero");
        rbBarbero.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		tfUsuario.setText("");
        		lbUsuario.setEnabled(false);
        		tfUsuario.setEnabled(false);
        		panelAggEmpleado.setBounds(41, 84, 449,580);
        		panelAggEmpleado.add(panelBarbero);
        		panelBarbero.setBounds(0, 370, 449, 154);
        		btConfirmar.setBounds(31, 515, 387, 40);
        		panelBarbero.setVisible(true);
        		
        	}
        });
        rbBarbero.setForeground(Paleta.textologin);
        rbBarbero.setBounds(31, 215, 88, 24);
        panelAggEmpleado.add(rbBarbero);
        
        rbRecepcionista = new JRadioButton("Recepcionista");
        rbRecepcionista.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		lbUsuario.setEnabled(true);
        		tfUsuario.setEnabled(true);
        		btConfirmar.setEnabled(true);
        		panelBarbero.setVisible(false);
        		panelAggEmpleado.setBounds(41, 84, 449, 444);
        		btConfirmar.setBounds(31, 383, 387, 40);
        	}
        });
        rbRecepcionista.setForeground(Paleta.textologin);
        rbRecepcionista.setBounds(136, 215, 106, 24);
        panelAggEmpleado.add(rbRecepcionista);
        
        ButtonGroup roles = new ButtonGroup();
        roles.add(rbRecepcionista);        
        roles.add(rbBarbero);
        
        JLabel lbCorreo = new JLabel("Correo");
        lbCorreo.setForeground(Paleta.fondoPrincipal);
        lbCorreo.setHorizontalAlignment(SwingConstants.LEFT);
        lbCorreo.setFont(new Font("Dialog", Font.BOLD, 14));
        lbCorreo.setBounds(31, 249, 77, 16);
        panelAggEmpleado.add(lbCorreo);
        
        tfCorreo = new JTextField();
        tfCorreo.setOpaque(false);
        tfCorreo.setForeground(Paleta.fondoPrincipal);
        tfCorreo.setBackground(Paleta.menu);
        tfCorreo.setFont(new Font("SansSerif", Font.PLAIN, 13));
        tfCorreo.setBorder(new Borde(5, Paleta.fondoPrincipal));
        tfCorreo.setColumns(10);
        tfCorreo.setBounds(31, 275, 387, 29);
        panelAggEmpleado.add(tfCorreo);
        
        
        btConfirmar = new JButton("Confirmar");
        btConfirmar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		String nombre = tfNombre.getText();
        		String usuario = tfUsuario.getText();
        		String telefono = tfTelefono.getText();
        		String correo = tfCorreo.getText();
        		String contraseña = usuario + 123;
        		String rol = "";
        		String turno = "";
        		
        		
        		if(rbMañana.isSelected()) {
        			turno = "Mañana";
        		}else if (rbTarde.isSelected()) {
					turno = "Tarde";
				}
        		
        		
        		if (rbBarbero.isSelected()) {
					rol = "Barbero";
					usuario = "No hablilitado";
					contraseña = "No hablilitado";
					
				} else if (rbRecepcionista.isSelected()) {
					rol = "Recepcionista";
				}
	        	
        		if(rol.isEmpty()) {
        			JOptionPane.showMessageDialog(frame, "Por favor, complete todos los campos requeridos.", "Error", JOptionPane.ERROR_MESSAGE);
        			
        		}
        		
        		if (rol.equals("Barbero")) {
	        		if (nombre.isEmpty() || telefono.isEmpty() || correo.isEmpty() ||turno.isEmpty()) {
	        			JOptionPane.showMessageDialog(frame, "Por favor, complete todos los campos requeridos.", "Error", JOptionPane.ERROR_MESSAGE);
	        		} else {
							if (GuardarDatos.guardarBarberos(nombre, telefono, correo, turno)) {
								JOptionPane.showMessageDialog(null, "Barbero guardado");
			        	        cargarBarberosEnTabla();
			        	    } else {
			        	        JOptionPane.showMessageDialog(null, "Error al guardar");
			        	    }
					}
				
	        	} else if (rol.equals("Recepcionista")) {
						if (nombre.isEmpty() || usuario.isEmpty() || telefono.isEmpty() || correo.isEmpty()) {
		        			JOptionPane.showMessageDialog(frame, "Por favor, complete todos los campos requeridos.", "Error", JOptionPane.ERROR_MESSAGE);
		        		} else {
			        			if (GuardarDatos.guardarUsuarios(nombre, telefono, correo, usuario, contraseña)) {
			            	        JOptionPane.showMessageDialog(null, "Empleado guardado");
			            	        cargarUsuariosEnTabla();
			            	    } else {
			            	        JOptionPane.showMessageDialog(null, "Error al guardar");
			            	    }
		        			
		        		}
        		}
        		
        		tfNombre.setText("");
        		tfUsuario.setText("");
        		tfCorreo.setText("");
        		tfTelefono.setText("");
        		tfUsuario.setEnabled(true);
        		lbUsuario.setEnabled(true);
        		roles.clearSelection();
        		panelBarbero.setVisible(false);
        		panelAggEmpleado.setBounds(41, 84, 449, 444);
        		btConfirmar.setBounds(31, 383, 387, 40);
        	}
        });
        btConfirmar.setBackground(Paleta.textologin2);
        btConfirmar.setForeground(Paleta.fondoPrincipal);
        btConfirmar.setBounds(31, 383, 387, 40);
        panelAggEmpleado.add(btConfirmar);
        
        JLabel lblAgregarEmpleado_1 = new JLabel("Agregar Empleado");
        lblAgregarEmpleado_1.setHorizontalAlignment(SwingConstants.LEFT);
        lblAgregarEmpleado_1.setForeground(new Color(96, 165, 250));
        lblAgregarEmpleado_1.setFont(new Font("SansSerif", Font.BOLD, 20));
        lblAgregarEmpleado_1.setBounds(25, 12, 246, 35);
        panelAggEmpleado.add(lblAgregarEmpleado_1);
        
        JLabel lbTelefono_2 = new JLabel("Telefono: ");
        lbTelefono_2.setHorizontalAlignment(SwingConstants.LEFT);
        lbTelefono_2.setForeground(new Color(242, 240, 235));
        lbTelefono_2.setFont(new Font("Dialog", Font.BOLD, 14));
        lbTelefono_2.setBounds(31, 316, 77, 16);
        panelAggEmpleado.add(lbTelefono_2);
        
        tfTelefono = new JTextField();
        tfTelefono.setOpaque(false);
        tfTelefono.setForeground(new Color(242, 240, 235));
        tfTelefono.setFont(new Font("SansSerif", Font.PLAIN, 13));
        tfTelefono.setColumns(10);
        tfTelefono.setBorder(new Borde(5, Paleta.fondoPrincipal));
        tfTelefono.setBackground(new Color(31, 41, 55));
        tfTelefono.setBounds(31, 342, 387, 29);
        panelAggEmpleado.add(tfTelefono);
        
        
        panelBarbero = new Panel(15, 0, Paleta.borde);
        panelBarbero.setVisible(false);
        panelBarbero.setLayout(null);
        panelBarbero.setBorder(new Borde(10,Paleta.menu));
        panelBarbero.setBackground(new Color(31, 41, 55));
        panelBarbero.setBounds(41, 540, 449, 154);
        pantallaGestion.add(panelBarbero);
        
        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	
        		
        		roles.clearSelection();
        		turnos.clearSelection();
        		lbUsuario.setEnabled(true);
        		tfUsuario.setEnabled(true);
        		tfHorario.setText("");
        		panelBarbero.setVisible(false);
        		panelAggEmpleado.setBounds(41, 84, 449, 444);
        		btConfirmar.setBounds(31, 383, 387, 40);
        	}
        });
        btnCancelar.setForeground(Paleta.textologin2);
        btnCancelar.setBackground(Paleta.fondoPrincipal);
        btnCancelar.setBounds(31, 102, 387, 40);
        panelBarbero.add(btnCancelar);
        
        JLabel lblTurno = new JLabel("Turno");
        lblTurno.setHorizontalAlignment(SwingConstants.LEFT);
        lblTurno.setForeground(new Color(242, 240, 235));
        lblTurno.setFont(new Font("Dialog", Font.BOLD, 14));
        lblTurno.setBounds(31, 26, 77, 16);
        panelBarbero.add(lblTurno);
        
        JLabel lblHorario = new JLabel("Horario");
        lblHorario.setHorizontalAlignment(SwingConstants.LEFT);
        lblHorario.setForeground(new Color(242, 240, 235));
        lblHorario.setFont(new Font("Dialog", Font.BOLD, 14));
        lblHorario.setBounds(225, 24, 77, 16);
        panelBarbero.add(lblHorario);
        
        tfHorario = new JTextField();
        tfHorario.setEditable(false);
        tfHorario.setOpaque(false);
        tfHorario.setForeground(Paleta.textologin);
        tfHorario.setFont(new Font("Segoe UI", Font.BOLD, 14));
        tfHorario.setColumns(10);
        tfHorario.setBorder(new Borde(5, Color.WHITE));
        tfHorario.setBackground(new Color(31, 41, 55));
        tfHorario.setBounds(225, 47, 196, 29);
        panelBarbero.add(tfHorario);
        
        rbMañana = new JRadioButton("Mañana");
        rbMañana.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		tfHorario.setText("");
        		tfHorario.setText("9:00AM - 1:00PM");
        	
        	}
        });
        rbMañana.setForeground(new Color(242, 240, 235));
        rbMañana.setBounds(31, 50, 88, 24);
        panelBarbero.add(rbMañana);
        
        rbTarde = new JRadioButton("Tarde");
        rbTarde.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		tfHorario.setText("");
        		tfHorario.setText("1:00PM - 6:00PM");
        	}
        });
        rbTarde.setForeground(new Color(242, 240, 235));
        rbTarde.setBounds(123, 50, 88, 24);
        panelBarbero.add(rbTarde);
        
        turnos = new ButtonGroup();
        turnos.add(rbTarde);
        turnos.add(rbMañana);
        
        scrollGestionEmpleados = new JScrollPane();
        scrollGestionEmpleados.setBounds(526, 84, 558, 378);
        pantallaGestion.add(scrollGestionEmpleados);
        tablaGestionE = new JTable();
        tablaGestionE.setModel(new DefaultTableModel(
        	new Object[][] {
        		{null, null, null, null, null, null},
        	},
        	new String[] {
        		"ID", "Nombre", "Telefono", "Correo", "Usuario", "Contrase\u00F1a"
        	}
        ));
        tablaGestionE.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                llenarCamposEditar();
            }
        });
        tablaGestionE.setShowGrid(true);
        tablaGestionE.setGridColor(Paleta.fondoPrincipal);
        tablaGestionE.setForeground(Paleta.fondoPrincipal);
        
        model = (DefaultTableModel) tablaGestionE.getModel();
   
        tablaGestionE.setFillsViewportHeight(true);
        tablaGestionE.setBackground(Paleta.table);
        JTableHeader header1 = tablaGestionE.getTableHeader();
        header1.setOpaque(true);
        header1.setBackground(Paleta.headers);
        tablaGestionE.getTableHeader().setForeground(Paleta.textologin2);
        header1.setFont(new Font("Segoe UI", Font.BOLD, 14));
        scrollGestionEmpleados.setViewportView(tablaGestionE);
       
        
        ImageIcon edit = new ImageIcon(getClass().getResource("/Imagenes/botonEditar.png"));
        Image img2 = edit.getImage();
        Image size3 = img2.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
       
        ImageIcon editIcon = new ImageIcon(size3);
        
        
        JButton btEditar = new JButton("Editar", editIcon);
        btEditar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	
        	if(rbUsuarioFiltro.isSelected()) {	
        		if (tablaGestionE.getSelectedRow() == -1) {
        			JOptionPane.showMessageDialog(frame, "Por favor, seleccione un usuario para editar.", "Error", JOptionPane.ERROR_MESSAGE);
        		} else {
        			panelEditEmpleado.setVisible(true);
        			
        		}
        	}else if (rbBarberoFiltro.isSelected()) {
				if (tablaGestionBarbero.getSelectedRow() == -1) {
        		JOptionPane.showMessageDialog(frame, "Por favor, seleccione un barbero para editar.", "Error", JOptionPane.ERROR_MESSAGE);
        		} else {
        			panelEditBarbero.setVisible(true);
        			
        		}
			}
        		
        		
			}
        });
        btEditar.setIconTextGap(6);
        btEditar.setHorizontalTextPosition(SwingConstants.RIGHT);
        btEditar.setForeground(new Color(242, 240, 235));
        btEditar.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btEditar.setBackground(Paleta.menu);
        btEditar.setBounds(526, 39, 145, 35);
        pantallaGestion.add(btEditar);
        
        panelEditEmpleado = new Panel(15, 0, new Color(120, 120, 120, 80));
        panelEditEmpleado.setVisible(false);
        panelEditEmpleado.setLayout(null);
        panelEditEmpleado.setBackground(new Color(31, 41, 55));
        panelEditEmpleado.setBounds(526, 480, 558, 184);
        pantallaGestion.add(panelEditEmpleado);
        
        JLabel lbNombre_1 = new JLabel("Nombre:");
        lbNombre_1.setHorizontalAlignment(SwingConstants.LEFT);
        lbNombre_1.setForeground(new Color(242, 240, 235));
        lbNombre_1.setFont(new Font("Dialog", Font.BOLD, 14));
        lbNombre_1.setBounds(31, 12, 77, 16);
        panelEditEmpleado.add(lbNombre_1);
        
        tfNombreEdit = new JTextField();
        tfNombreEdit.setOpaque(false);
        tfNombreEdit.setForeground(new Color(242, 240, 235));
        tfNombreEdit.setFont(new Font("SansSerif", Font.PLAIN, 13));
        tfNombreEdit.setColumns(10);
        tfNombreEdit.setBorder(new Borde(5, Paleta.fondoPrincipal));
        tfNombreEdit.setBackground(new Color(31, 41, 55));
        tfNombreEdit.setBounds(31, 38, 245, 29);
        panelEditEmpleado.add(tfNombreEdit);
        
        lbUsuario_1 = new JLabel("Usuario:");
        lbUsuario_1.setHorizontalAlignment(SwingConstants.LEFT);
        lbUsuario_1.setForeground(new Color(242, 240, 235));
        lbUsuario_1.setFont(new Font("Dialog", Font.BOLD, 14));
        lbUsuario_1.setBounds(301, 12, 77, 16);
        panelEditEmpleado.add(lbUsuario_1);
        
        tfUsuarioEdit = new JTextField();
        tfUsuarioEdit.setOpaque(false);
        tfUsuarioEdit.setForeground(new Color(242, 240, 235));
        tfUsuarioEdit.setFont(new Font("SansSerif", Font.PLAIN, 13));
        tfUsuarioEdit.setColumns(10);
        tfUsuarioEdit.setBorder(new Borde(5, Paleta.fondoPrincipal));
        tfUsuarioEdit.setBackground(new Color(31, 41, 55));
        tfUsuarioEdit.setBounds(301, 38, 245, 29);
        panelEditEmpleado.add(tfUsuarioEdit);
        
//        roles1 = new ButtonGroup();
        
        JLabel lbTelefono_1 = new JLabel("Telefono: ");
        lbTelefono_1.setHorizontalAlignment(SwingConstants.LEFT);
        lbTelefono_1.setForeground(new Color(242, 240, 235));
        lbTelefono_1.setFont(new Font("Dialog", Font.BOLD, 14));
        lbTelefono_1.setBounds(301, 77, 77, 16);
        panelEditEmpleado.add(lbTelefono_1);
        
        tfTelefonoEdit = new JTextField();
        tfTelefonoEdit.setOpaque(false);
        tfTelefonoEdit.setForeground(new Color(242, 240, 235));
        tfTelefonoEdit.setFont(new Font("SansSerif", Font.PLAIN, 13));
        tfTelefonoEdit.setColumns(10);
        tfTelefonoEdit.setBorder(new Borde(5, Paleta.fondoPrincipal));
        tfTelefonoEdit.setBackground(new Color(31, 41, 55));
        tfTelefonoEdit.setBounds(301, 103, 245, 29);
        panelEditEmpleado.add(tfTelefonoEdit);
        
        JButton btnCancelar_1 = new JButton("Cancelar");
        btnCancelar_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	
        		panelEditEmpleado.setVisible(false);
        		tablaGestionE.clearSelection();
        		
        	}
        });
        btnCancelar_1.setForeground(new Color(96, 165, 250));
        btnCancelar_1.setBackground(new Color(242, 240, 235));
        btnCancelar_1.setBounds(338, 146, 98, 26);
        panelEditEmpleado.add(btnCancelar_1);
        
        JButton btnEditar = new JButton("Editar");
        btnEditar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		int fila = tablaGestionE.getSelectedRow();
        		if(fila == -1 ) {
        			JOptionPane.showMessageDialog(null, "Selecciona un usuario");
        			return;
        		}
        		
        		if (tfNombreEdit.getText().isEmpty() || tfUsuarioEdit.getText().isEmpty() || tfTelefonoEdit.getText().isEmpty() || tfCorreoEdit.getText().isEmpty()) {
        			JOptionPane.showMessageDialog(frame, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
        		}else { 
	        		int id = (int)tablaGestionE.getValueAt(fila, 0);
	        		String contraseña = tablaGestionE.getValueAt(fila,5).toString();
	        		
	        		
	        		UsuarioRegular u = new UsuarioRegular(
	        		        id,
	        		        tfNombreEdit.getText(),
	        		        tfTelefonoEdit.getText(),
	        		        tfCorreoEdit.getText(),
	        		        tfUsuarioEdit.getText(),
	        		        contraseña
	        		);
	        		
	        		if(GuardarDatos.actualizarUsuarios(u)) {
	        			JOptionPane.showMessageDialog(null, "Usuario actualizado");
	        	        cargarUsuariosEnTabla();
	        	        
	        	        tfUsuarioEdit.setText(""); 
	        	        tfNombreEdit.setText("");
	        	        tfUsuarioEdit.setText("");
	        	        tfTelefonoEdit.setText("");
		    			panelEditEmpleado.setVisible(false);
						tablaGestionE.clearSelection();	
	        	        
	        		}else {
	        	        JOptionPane.showMessageDialog(null, "Error al actualizar");
	        	    }
        		
        		}
		    			
						
			}
        	
        });
        btnEditar.setForeground(new Color(242, 240, 235));
        btnEditar.setBackground(new Color(96, 165, 250));
        btnEditar.setBounds(448, 146, 98, 26);
        panelEditEmpleado.add(btnEditar);
        
        JLabel lbCorreo_1 = new JLabel("Correo:");
        lbCorreo_1.setHorizontalAlignment(SwingConstants.LEFT);
        lbCorreo_1.setForeground(new Color(242, 240, 235));
        lbCorreo_1.setFont(new Font("Dialog", Font.BOLD, 14));
        lbCorreo_1.setBounds(31, 79, 77, 16);
        panelEditEmpleado.add(lbCorreo_1);
        
        tfCorreoEdit = new JTextField();
        tfCorreoEdit.setOpaque(false);
        tfCorreoEdit.setForeground(new Color(242, 240, 235));
        tfCorreoEdit.setFont(new Font("SansSerif", Font.PLAIN, 13));
        tfCorreoEdit.setColumns(10);
        tfCorreoEdit.setBorder(new Borde(5, Paleta.fondoPrincipal));
        tfCorreoEdit.setBackground(new Color(31, 41, 55));
        tfCorreoEdit.setBounds(31, 105, 245, 29);
        panelEditEmpleado.add(tfCorreoEdit);
        
        rbUsuarioFiltro = new JRadioButton("Usuario");
        rbUsuarioFiltro.setSelected(true);
        rbUsuarioFiltro.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		panelEditBarbero.setVisible(false);
        		scrollGestionEmpleados.setVisible(true);
        		
        	}
        });
        rbUsuarioFiltro.setForeground(new Color(200, 50, 42));
        rbUsuarioFiltro.setBounds(694, 42, 97, 28);
        pantallaGestion.add(rbUsuarioFiltro);
        
        rbBarberoFiltro = new JRadioButton("Barbero");
        rbBarberoFiltro.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	panelEditEmpleado.setVisible(false);	
        	scrollGestionEmpleados.setVisible(false);
        	
        	}
        });
        rbBarberoFiltro.setForeground(new Color(200, 50, 42));
        rbBarberoFiltro.setBounds(795, 42, 81, 28);
        pantallaGestion.add(rbBarberoFiltro);
        
        ButtonGroup filtroEdit = new ButtonGroup();
        filtroEdit.add(rbBarberoFiltro);
        filtroEdit.add(rbUsuarioFiltro);
        
        panelPrincipal.add(pantallaPrueba,"PRUEBA");
        panelPrincipal.add(pantallaEmpleados, "EMPLEADOS");
        
        scrollGestionBarberos = new JScrollPane();
        scrollGestionBarberos.setBounds(526, 84, 558, 378);
        pantallaGestion.add(scrollGestionBarberos);
        
        tablaGestionBarbero = new JTable();
        JTableHeader header4 = tablaGestionBarbero.getTableHeader();
        tablaGestionBarbero.getTableHeader().setBackground(Paleta.headers);
        tablaGestionBarbero.getTableHeader().setForeground(Paleta.textologin2);
        header4.setFont(new Font("Segoe UI", Font.BOLD, 14));
        tablaGestionBarbero.setModel(new DefaultTableModel(
        	new Object[][] {
        		{null, null, null, null, null},
        	},
        	new String[] {
        		"ID", "Nombre", "Telefono", "Correo", "Turno"
        	}
        ));
        
        tablaGestionBarbero.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                llenarCamposEditar();
            }
        });
        tablaGestionBarbero.setShowGrid(true);
        tablaGestionBarbero.setGridColor(new Color(242, 240, 235));
        tablaGestionBarbero.setForeground(new Color(242, 240, 235));
        tablaGestionBarbero.setFillsViewportHeight(true);
        tablaGestionBarbero.setBackground(new Color(31, 41, 55));
        scrollGestionBarberos.setViewportView(tablaGestionBarbero);
        
        panelEditBarbero = new Panel(15, 0, new Color(120, 120, 120, 80));
        panelEditBarbero.setVisible(false);
        panelEditBarbero.setLayout(null);
        panelEditBarbero.setBackground(new Color(31, 41, 55));
        panelEditBarbero.setBounds(526, 480, 558, 184);
        pantallaGestion.add(panelEditBarbero);
        
        JLabel lbNombre_1_1 = new JLabel("Nombre:");
        lbNombre_1_1.setHorizontalAlignment(SwingConstants.LEFT);
        lbNombre_1_1.setForeground(new Color(242, 240, 235));
        lbNombre_1_1.setFont(new Font("Dialog", Font.BOLD, 14));
        lbNombre_1_1.setBounds(31, 12, 77, 16);
        panelEditBarbero.add(lbNombre_1_1);
        
        tfNombreBarbero = new JTextField();
        tfNombreBarbero.setOpaque(false);
        tfNombreBarbero.setForeground(new Color(242, 240, 235));
        tfNombreBarbero.setFont(new Font("SansSerif", Font.PLAIN, 13));
        tfNombreBarbero.setColumns(10);
        tfNombreBarbero.setBorder(new Borde(5, Paleta.fondoPrincipal));
        tfNombreBarbero.setBackground(new Color(31, 41, 55));
        tfNombreBarbero.setBounds(31, 38, 245, 29);
        panelEditBarbero.add(tfNombreBarbero);
        
        JLabel lbUsuario_1_1 = new JLabel("Turno:");
        lbUsuario_1_1.setHorizontalAlignment(SwingConstants.LEFT);
        lbUsuario_1_1.setForeground(new Color(242, 240, 235));
        lbUsuario_1_1.setFont(new Font("Dialog", Font.BOLD, 14));
        lbUsuario_1_1.setBounds(301, 12, 77, 16);
        panelEditBarbero.add(lbUsuario_1_1);
        
        tfHorarioBarbero = new JTextField();
        tfHorarioBarbero.setEditable(false);
        tfHorarioBarbero.setOpaque(false);
        tfHorarioBarbero.setForeground(new Color(242, 240, 235));
        tfHorarioBarbero.setFont(new Font("Segoe UI", Font.BOLD, 14));
        tfHorarioBarbero.setColumns(10);
        tfHorarioBarbero.setBorder(new Borde(5, Paleta.fondoPrincipal));
        tfHorarioBarbero.setBackground(new Color(31, 41, 55));
        tfHorarioBarbero.setBounds(373, 38, 173, 29);
        panelEditBarbero.add(tfHorarioBarbero);
        
        JLabel lbTelefono_1_1 = new JLabel("Telefono: ");
        lbTelefono_1_1.setHorizontalAlignment(SwingConstants.LEFT);
        lbTelefono_1_1.setForeground(new Color(242, 240, 235));
        lbTelefono_1_1.setFont(new Font("Dialog", Font.BOLD, 14));
        lbTelefono_1_1.setBounds(301, 77, 77, 16);
        panelEditBarbero.add(lbTelefono_1_1);
        
        tfTelefonoBarbero = new JTextField();
        tfTelefonoBarbero.setOpaque(false);
        tfTelefonoBarbero.setForeground(new Color(242, 240, 235));
        tfTelefonoBarbero.setFont(new Font("SansSerif", Font.PLAIN, 13));
        tfTelefonoBarbero.setColumns(10);
        tfTelefonoBarbero.setBorder(new Borde(5, Paleta.fondoPrincipal));
        tfTelefonoBarbero.setBackground(new Color(31, 41, 55));
        tfTelefonoBarbero.setBounds(301, 103, 245, 29);
        panelEditBarbero.add(tfTelefonoBarbero);
        
        JButton btnCancelar_1_1 = new JButton("Cancelar");
        btnCancelar_1_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		panelEditBarbero.setVisible(false);
        		tablaGestionBarbero.clearSelection();
        	}
        });
        btnCancelar_1_1.setForeground(new Color(96, 165, 250));
        btnCancelar_1_1.setBackground(new Color(242, 240, 235));
        btnCancelar_1_1.setBounds(338, 146, 98, 26);
        panelEditBarbero.add(btnCancelar_1_1);
        
        JButton btnEditar_1 = new JButton("Editar");
        btnEditar_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		int fila = tablaGestionBarbero.getSelectedRow();
        		if(fila == -1 ) {
        			JOptionPane.showMessageDialog(null, "Selecciona un barbero");
        			return;
        		}
        		
        		if (tfNombreBarbero.getText().isEmpty() || tfTelefonoBarbero.getText().isEmpty() || tfHorarioBarbero.getText().isEmpty() || tfCorreoBarbero.getText().isEmpty()) {
        			JOptionPane.showMessageDialog(frame, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
        		}else { 
	        		int id = (int)tablaGestionBarbero.getValueAt(fila, 0);
	        		
	        		String turno = "";
	        		if(rbMañana_1.isSelected()) {
	        			turno = "Mañana";
	        		}else if (rbTarde_1.isSelected()) {
	        			turno = "Tarde";
					}
	        		
	        		Barbero b = new Barbero(
	        		        id,
	        		        tfNombreBarbero.getText(),
	        		        tfTelefonoBarbero.getText(),
	        		        tfCorreoBarbero.getText(),
	        		        turno
	        		);
	        		
	        		if(GuardarDatos.actualizarBarbero(b)) {
	        			JOptionPane.showMessageDialog(null, "Barbero actualizado");
	        	        cargarBarberosEnTabla();
	        	        
	        	        
		    			panelEditBarbero.setVisible(false);
						tablaGestionBarbero.clearSelection();	
	        	        
	        		}else {
	        	        JOptionPane.showMessageDialog(null, "Error al actualizar");
	        	    }
        		
        		}
		    			
						
			}
        	
        });
        btnEditar_1.setForeground(new Color(242, 240, 235));
        btnEditar_1.setBackground(new Color(96, 165, 250));
        btnEditar_1.setBounds(448, 146, 98, 26);
        panelEditBarbero.add(btnEditar_1);
        
        JLabel lbCorreo_1_1 = new JLabel("Correo:");
        lbCorreo_1_1.setHorizontalAlignment(SwingConstants.LEFT);
        lbCorreo_1_1.setForeground(new Color(242, 240, 235));
        lbCorreo_1_1.setFont(new Font("Dialog", Font.BOLD, 14));
        lbCorreo_1_1.setBounds(31, 79, 77, 16);
        panelEditBarbero.add(lbCorreo_1_1);
        
        tfCorreoBarbero = new JTextField();
        tfCorreoBarbero.setOpaque(false);
        tfCorreoBarbero.setForeground(new Color(242, 240, 235));
        tfCorreoBarbero.setFont(new Font("SansSerif", Font.PLAIN, 13));
        tfCorreoBarbero.setColumns(10);
        tfCorreoBarbero.setBorder(new Borde(5, Paleta.fondoPrincipal));
        tfCorreoBarbero.setBackground(new Color(31, 41, 55));
        tfCorreoBarbero.setBounds(31, 105, 245, 29);
        panelEditBarbero.add(tfCorreoBarbero);
        
        JLabel lbUsuario_1_1_1 = new JLabel("Horario:");
        lbUsuario_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
        lbUsuario_1_1_1.setForeground(new Color(242, 240, 235));
        lbUsuario_1_1_1.setFont(new Font("Dialog", Font.BOLD, 14));
        lbUsuario_1_1_1.setBounds(301, 44, 77, 16);
        panelEditBarbero.add(lbUsuario_1_1_1);
        
        rbTarde_1 = new JRadioButton("Tarde");
        rbTarde_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	tfHorarioBarbero.setText("1:00PM - 6:00PM");
        	
        	}
        });
        rbTarde_1.setForeground(new Color(242, 240, 235));
        rbTarde_1.setBounds(458, 8, 88, 24);
        panelEditBarbero.add(rbTarde_1);
        
        rbMañana_1 = new JRadioButton("Mañana");
        rbMañana_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	
        		tfHorarioBarbero.setText("9:00AM - 1:00PM");
        	}
        });
        rbMañana_1.setForeground(new Color(242, 240, 235));
        rbMañana_1.setBounds(366, 8, 88, 24);
        panelEditBarbero.add(rbMañana_1);
        
        ButtonGroup turno2 = new ButtonGroup();
        turno2.add(rbTarde_1);
        turno2.add(rbMañana_1);
        
        panelPrincipal.add(pantallaGestion,"AGREGAR");
        panelPrincipal.add(pantallaCitas, "CITAS");
        panelPrincipal.add(pantallaPagos, "PAGOS");
        
        JLabel lbBuscar3 = new JLabel("Buscar: ");
        lbBuscar3.setForeground(Paleta.textologin2);
        lbBuscar3.setFont(new Font("SansSerif", Font.BOLD, 16));
        lbBuscar3.setBounds(72, 70, 81, 28);
        pantallaPagos.add(lbBuscar3);
        
        JRadioButton rbMetodoPago = new JRadioButton("Metodos de Pago");
        rbMetodoPago.setForeground(Paleta.fondoBoton2);
        rbMetodoPago.setBounds(896, 75, 123, 23);
        pantallaPagos.add(rbMetodoPago);
        
        JRadioButton rbFecha = new JRadioButton("Fecha");
        rbFecha.setForeground(Paleta.fondoBoton2);
        rbFecha.setBounds(823, 75, 81, 23);
        pantallaPagos.add(rbFecha);
        
        ButtonGroup filtros = new ButtonGroup();
        filtros.add(rbFecha);
        filtros.add(rbMetodoPago);
        
        
        tfPagos = new JTextField();
		tfPagos.getDocument().addDocumentListener(new DocumentListener() {
			public void insertUpdate(javax.swing.event.DocumentEvent e) {
				String text = tfPagos.getText();
				if (rbMetodoPago.isSelected()) {
					sorter3.setRowFilter(javax.swing.RowFilter.regexFilter("(?i)" + text, 3));
				} else if (rbFecha.isSelected()) {
					sorter3.setRowFilter(javax.swing.RowFilter.regexFilter("(?i)" + text, 4));
				} else {
					sorter3.setRowFilter(null);
				}
			}
			public void removeUpdate(javax.swing.event.DocumentEvent e) {
				String text = tfPagos.getText();
				if (rbMetodoPago.isSelected()) {
					sorter3.setRowFilter(javax.swing.RowFilter.regexFilter("(?i)" + text, 3));
				} else if (rbFecha.isSelected()) {
					sorter3.setRowFilter(javax.swing.RowFilter.regexFilter("(?i)" + text, 4));
				} else {
					sorter3.setRowFilter(null);
				}
			}
			public void changedUpdate(javax.swing.event.DocumentEvent e) {
				
			}
		});
        tfPagos.setOpaque(false);
        tfPagos.setForeground(Paleta.menu);
        tfPagos.setBackground(Paleta.fondo2);
        tfPagos.setFont(new Font("SansSerif", Font.PLAIN, 13));
        tfPagos.setBorder(new Borde(5, Paleta.menu));
        tfPagos.setColumns(10);
        tfPagos.setBounds(140, 72, 577, 28);
        pantallaPagos.add(tfPagos);
        
        JScrollPane scrollPane_2 = new JScrollPane();
        scrollPane_2.setBounds(72, 110, 947, 540);
        pantallaPagos.add(scrollPane_2);
        
        tablaPagos = new JTable(cargartablaPagos());
        DefaultTableModel modeloPagos = (DefaultTableModel) tablaPagos.getModel();
        sorter3 = new TableRowSorter<DefaultTableModel>(modeloPagos);
        tablaPagos.setRowSorter(sorter3);
        tablaPagos.setBackground(Paleta.headers);
        tablaPagos.setShowGrid(true);
        tablaPagos.setGridColor(Paleta.fondoPrincipal);
        tablaPagos.setForeground(Paleta.fondoPrincipal);
        tablaPagos.setFillsViewportHeight(true);
        tablaPagos.setBackground(Paleta.menu);
        JTableHeader header2 = tablaPagos.getTableHeader();
        tablaPagos.getTableHeader().setBackground(Paleta.headers);
        tablaPagos.getTableHeader().setForeground(Paleta.textologin2);
        header2.setFont(new Font("Segoe UI", Font.BOLD, 14));
        scrollPane_2.setViewportView(tablaPagos);
        
        JLabel lblNewLabel_1 = new JLabel("Filtrar por: ");
        lblNewLabel_1.setForeground(Paleta.textologin2);
        lblNewLabel_1.setFont(new Font("SansSerif", Font.BOLD, 16));
        lblNewLabel_1.setBounds(725, 78, 98, 16);
        pantallaPagos.add(lblNewLabel_1);
        
        
        JLabel lbBuscar2 = new JLabel("Buscar: ");
        lbBuscar2.setForeground(Paleta.textologin2);
        lbBuscar2.setFont(new Font("SansSerif", Font.BOLD, 16));
        lbBuscar2.setBounds(71, 70, 69, 28);
        pantallaCitas.add(lbBuscar2);
        
        tfCitas = new JTextField();
        tfCitas.getDocument().addDocumentListener(new DocumentListener() {
			public void insertUpdate(javax.swing.event.DocumentEvent e) {
				String text = tfCitas.getText();
				
				if (rbFechaCita.isSelected()) {
					sorter2.setRowFilter(javax.swing.RowFilter.regexFilter("(?i)" + text, 3));
				} else if (rbMontoCitas.isSelected()) {
					sorter2.setRowFilter(javax.swing.RowFilter.regexFilter("(?i)" + text, 6));
				} else {
					sorter2.setRowFilter(null);
				}
			}
			public void removeUpdate(javax.swing.event.DocumentEvent e) {
				String text = tfCitas.getText();
				if (rbFechaCita.isSelected()) {
					sorter2.setRowFilter(javax.swing.RowFilter.regexFilter("(?i)" + text, 3));
				} else if (rbMontoCitas.isSelected()) {
					sorter2.setRowFilter(javax.swing.RowFilter.regexFilter("(?i)" + text, 6));
				} else {
					sorter2.setRowFilter(null);
				}
			}
			public void changedUpdate(javax.swing.event.DocumentEvent e) {
				
			}
		});
        tfCitas.setOpaque(false);
        tfCitas.setForeground(Paleta.menu);
        tfCitas.setBackground(Paleta.fondo2);
        tfCitas.setFont(new Font("SansSerif", Font.PLAIN, 13));
        tfCitas.setBorder(new Borde(5, Paleta.menu));
        tfCitas.setBounds(142, 70, 647, 28);
        pantallaCitas.add(tfCitas);
        tfCitas.setColumns(10);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(72, 110, 947, 540);
        pantallaCitas.add(scrollPane);
        
        tablaCitas = new JTable();
        tablaCitas.setModel(ConsultarDatos.cargar_citas());
        DefaultTableModel modeloCitas = (DefaultTableModel) tablaCitas.getModel();
        sorter2 = new TableRowSorter<DefaultTableModel>(modeloCitas);
		tablaCitas.setRowSorter(sorter2);
        tablaCitas.setShowGrid(true);
        tablaCitas.setForeground(Paleta.textologin);
        tablaCitas.setGridColor(Paleta.fondoPrincipal);
        tablaCitas.setFillsViewportHeight(true);
        tablaCitas.setBackground(Paleta.menu);
        
        JTableHeader header3 = tablaCitas.getTableHeader();
        tablaCitas.getTableHeader().setBackground(Paleta.headers);
        tablaCitas.getTableHeader().setForeground(Paleta.textologin2);
        header3.setFont(new Font("Segoe UI", Font.BOLD, 14));
        scrollPane.setViewportView(tablaCitas);
        
        rbFechaCita = new JRadioButton("Fecha");
        rbFechaCita.setForeground(Paleta.fondoBoton2);
        rbFechaCita.setBounds(877, 70, 69, 28);
        pantallaCitas.add(rbFechaCita);
        
        rbMontoCitas = new JRadioButton("Monto");
        rbMontoCitas.setForeground(Paleta.fondoBoton2);
        rbMontoCitas.setBounds(947, 70, 69, 28);
        pantallaCitas.add(rbMontoCitas);
        
        ButtonGroup filtroCitas = new ButtonGroup();
        filtroCitas.add(rbFechaCita);
        filtroCitas.add(rbMontoCitas);
        
        JLabel lblNewLabel = new JLabel("Filtrar por: ");
        lblNewLabel.setForeground(Paleta.textologin2);
        lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        lblNewLabel.setBounds(795, 70, 90, 28);
        pantallaCitas.add(lblNewLabel);
        

        // ---------------- BOTONES DEL SIDEBAR ----------------
//        sidebar.add(createMenuButton("Prueba", () -> {
//        	cardLayout.show(panelPrincipal, "PRUEBA");
//        }));
        
        sidebar.add(createMenuButton("Empleados", () -> {
            cardLayout.show(panelPrincipal, "EMPLEADOS");
            cargarUsuariosEnTabla();
            cargarBarberosEnTabla();
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
        
         
        sidebar.add(Box.createVerticalStrut(230));
        sidebar.add(createMenuButton("Cerrar Sesión", () -> {
			frame.dispose();
			Login.main(null);
			
		}));
        

        sidebar.add(Box.createVerticalStrut(400));

        frame.getContentPane().add(sidebar, BorderLayout.WEST);
        frame.getContentPane().add(panelPrincipal, BorderLayout.CENTER);
        
        
    }
	
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

	    Color colorNormal = Paleta.fondoBoton2;
	    Color colorHover = Paleta.active;
	    Color colorSeleccionado = Paleta.active; 

	    // HOVER
	    btn.addMouseListener(new java.awt.event.MouseAdapter() {
	        @Override
	        public void mouseEntered(java.awt.event.MouseEvent evt) {
	            if (btn != botonSeleccionado) {
	                btn.setBackground(colorHover);
	            }
	        }

	        @Override
	        public void mouseExited(java.awt.event.MouseEvent evt) {
	            if (btn != botonSeleccionado) {
	                btn.setBackground(colorNormal);
	            }
	        }
	    });

	    btn.addActionListener(e -> {

	        if (botonSeleccionado != null) {
	            botonSeleccionado.setBackground(colorNormal);
	        }

	        botonSeleccionado = btn;
	        btn.setBackground(colorSeleccionado);

	        action.run();
	    });

	    return btn;
	}

	private void llenarCamposEditar() {
	    int selectedRow = tablaGestionE.getSelectedRow();
	    
	    if (selectedRow != -1) {
	        String nombre = (String) tablaGestionE.getValueAt(selectedRow, 1);
	        String usuario = (String) tablaGestionE.getValueAt(selectedRow, 4);
	        String correo = (String) tablaGestionE.getValueAt(selectedRow, 3);
	        String telefono = (String) tablaGestionE.getValueAt(selectedRow, 2);

	        tfNombreEdit.setText(nombre);
	        tfCorreoEdit.setText(correo);
	        tfUsuarioEdit.setText(usuario);
	        tfTelefonoEdit.setText(telefono);
	    }
	     
	    
	    int fila = tablaGestionBarbero.getSelectedRow();
	     
	    if(fila != -1) {   
	        
	        String nombre1 = (String) tablaGestionBarbero.getValueAt(fila, 1);
	        String correo1 = (String) tablaGestionBarbero.getValueAt(fila, 3);
	        String telefono1 = (String) tablaGestionBarbero.getValueAt(fila, 2);
	        String turno = (String) tablaGestionBarbero.getValueAt(fila, 4);
	        String horario1 =""; 
	        if(turno.equals("Mañana")) {
	        	rbMañana_1.setSelected(true);
	        	horario1 = "9:00AM - 1:00PM";
	        }else if(turno.equals("Tarde")) {
	        	rbTarde_1.setSelected(true);
	        	horario1 = "1:00PM - 6:00PM";
	        }
	        
	        tfNombreBarbero.setText(nombre1);
	        tfCorreoBarbero.setText(correo1);
	        tfTelefonoBarbero.setText(telefono1);
	        tfHorarioBarbero.setText(horario1);
	     }
	        
	    
	}
	
	private void cargarUsuariosEnTabla() {
	    String[] columnas = {"ID", "Nombre", "Telefono", "Correo", "Usuario", "Contraseña"};

	    DefaultTableModel modelo = new DefaultTableModel(null, columnas);
	    DefaultTableModel modelo1 = new DefaultTableModel(null, columnas);

	    ArrayList<UsuarioRegular> lista = ConsultarDatos.obtenerUsuarios();

	    for (UsuarioRegular u : lista) {
	        Object[] fila = {
	            u.getId(),
	            u.getNombre(),
	            u.getTelefono(),
	            u.getCorreo(),
	            u.getUser(),
	            u.getContraseña()
	        };
	        modelo.addRow(fila);
	        modelo1.addRow(fila);
	    }

	    tablaGestionE.setModel(modelo);
	    tablaGestionE.getColumnModel().getColumn(0).setPreferredWidth(25);
	    tablaGestionE.getColumnModel().getColumn(1).setPreferredWidth(100);
	    tablaGestionE.getColumnModel().getColumn(2).setPreferredWidth(100);
        tablaGestionE.getColumnModel().getColumn(3).setPreferredWidth(150);
        tablaGestionE.getColumnModel().getColumn(5).setPreferredWidth(90);
	    tablaEmpleado.setModel(modelo1);
	    tablaEmpleado.getColumnModel().getColumn(0).setPreferredWidth(25);
        tablaEmpleado.getColumnModel().getColumn(3).setPreferredWidth(312);
	    
	    sorter = new TableRowSorter<DefaultTableModel>(modelo1);
		tablaEmpleado.setRowSorter(sorter);
		
	}
	
	private void cargarBarberosEnTabla() {
		String[] columnas = {"ID", "Nombre", "Telefono", "Correo", "Turno"};
		
		DefaultTableModel modelo = new DefaultTableModel(null, columnas);
		DefaultTableModel modelo1 = new DefaultTableModel(null, columnas);
		
		ArrayList<Barbero> barberos = ConsultarDatos.obtenerBarberos();
		
		for (Barbero u : barberos) {
			Object[] fila = {
					u.getId(),
					u.getNombre(),
					u.getTelefono(),
					u.getCorreo(),
					u.getTurno()
			};
			modelo.addRow(fila);
			modelo1.addRow(fila);
		}
		if(modelo.getRowCount()>0) {
			modelo.removeRow(0);
			modelo1.removeRow(0);
		}
		tablaBarberos.setModel(modelo);
		tablaBarberos.getColumnModel().getColumn(0).setPreferredWidth(60);
        tablaBarberos.getColumnModel().getColumn(2).setPreferredWidth(289);
        tablaBarberos.getColumnModel().getColumn(3).setPreferredWidth(313);
		tablaBarberos.getColumnModel().getColumn(1).setPreferredWidth(218);		
		tablaGestionBarbero.setModel(modelo1);
		tablaGestionBarbero.getColumnModel().getColumn(0).setPreferredWidth(25);
        tablaGestionBarbero.getColumnModel().getColumn(2).setPreferredWidth(90);
        tablaGestionBarbero.getColumnModel().getColumn(3).setPreferredWidth(190);
        tablaGestionBarbero.getColumnModel().getColumn(4).setPreferredWidth(60);
		sorter1 = new TableRowSorter<DefaultTableModel>(modelo);
		tablaBarberos.setRowSorter(sorter1);
		
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
	public void eliminarEmpleado() {
		int fila = tablaEmpleado.getSelectedRow();
		
		if(fila == -1) {
			JOptionPane.showMessageDialog(null, "Selecciona un empleado para eliminar.");
			return;
		}
	
		int id = Integer.parseInt(tablaEmpleado.getValueAt(fila, 0).toString());
		int confirmacion = JOptionPane.showConfirmDialog(null, "¿Deseas eliminar este empleado?",
	            "Confirmación",
	            JOptionPane.YES_NO_OPTION);
		
		if(confirmacion == JOptionPane.YES_OPTION) {
			GuardarDatos.eliminarDato("Usuarios", "Usuario", id); 
			JOptionPane.showMessageDialog(null, "Empleado eliminado correctamente.");
				cargarUsuariosEnTabla();
			}else {
				 JOptionPane.showMessageDialog(null, "ERROR al eliminar.","Error", JOptionPane.ERROR_MESSAGE);
			}

	}
	public void cargarCitasEnTabla() {
		
		tablaCitas.setRowSorter(null);
	    tablaCitas.clearSelection();
	    tablaCitas.setModel(new DefaultTableModel());
		
		DefaultTableModel model = ConsultarDatos.cargar_citas();
	    tablaCitas.setModel(model);
	    
	    tablaCitas.setAutoCreateColumnsFromModel(true);
	    tablaCitas.setModel(model);

	    if (tablaCitas.getColumnCount() > 0) {
	        tablaCitas.getColumnModel().getColumn(0).setPreferredWidth(60);
	        tablaCitas.getColumnModel().getColumn(1).setPreferredWidth(150);
	        tablaCitas.getColumnModel().getColumn(2).setPreferredWidth(150);
	        tablaCitas.getColumnModel().getColumn(3).setPreferredWidth(100);
	        tablaCitas.getColumnModel().getColumn(4).setPreferredWidth(100);
	        tablaCitas.getColumnModel().getColumn(5).setPreferredWidth(200);
	        tablaCitas.getColumnModel().getColumn(6).setPreferredWidth(100);
	    }
	    
	    tablaCitas.revalidate();
	    tablaCitas.repaint();
	}

	public void eliminarBarbero() {
		int filaBarbero = tablaBarberos.getSelectedRow();
		
		if(filaBarbero == -1) {
			JOptionPane.showMessageDialog(null, "Selecciona un barbero para eliminar.");
			return;
		}
		
		int idB = Integer.parseInt(tablaBarberos.getValueAt(filaBarbero, 0).toString());
		int confirmacion1 = JOptionPane.showConfirmDialog(null, "¿Deseas eliminar este barbero?",
				"Confirmación",
				JOptionPane.YES_NO_OPTION);
		
		if(confirmacion1 == JOptionPane.YES_OPTION) {
			GuardarDatos.eliminarDato("Barberos", "Barbero", idB); 
			JOptionPane.showMessageDialog(null, "Barbero eliminado correctamente.");
			cargarBarberosEnTabla();
			cargarCitasEnTabla();
		}else {
			JOptionPane.showMessageDialog(null, "ERROR al eliminar.","Error", JOptionPane.ERROR_MESSAGE);
		}

        
	}
	
}