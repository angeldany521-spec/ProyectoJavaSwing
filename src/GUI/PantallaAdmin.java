package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;

import BaseDeDatos.ConsultarDatos;
import BaseDeDatos.GuardarDatos;
import Dominio.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;



public class PantallaAdmin {

    private JFrame frame;
    private JButton btConfirmar;
    private JLabel lbUsuario_1;
    private ButtonGroup turnos;
    private ButtonGroup turnos2;
    private ButtonGroup roles1;
    private CardLayout cardLayout;
    private Panel panelBarbero;
    private Panel panelEditEmpleado;
    private JPanel panelPrincipal;
    private JTable tablaCitas;
    private JTable tablaEmpleado;
    private JTable tablaPagos;
    private JTable tablaGestionE;
    private JTextField tfCitas;
    private JTextField tfHorarioEdit;
    private JTextField tfEmpleados;
    private JTextField tfNombre;
    private JTextField tfPagos;
    private JTextField tfUsuario;
    private JTextField tfCorreo;
    private JTextField tfHorario;
    private JTextField tfNombreEdit;
    private JTextField tfUsuarioEdit;
    private JTextField tfTelefonoEdit;
    private JTextField tfTelefono;
    private JTextField tfCorreoEdit;

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
                window.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
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
        frame.setBounds(100, 100, 1380, 900);
        frame.setTitle("BarberPiece - Panel Administrador");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setLayout(new BorderLayout());
        
        if (frame.isActive()) {
        	cargarUsuariosEnTabla();
        	
        }
        

        // ---------------- SIDEBAR ----------------
        JPanel sidebar = new JPanel();
        sidebar.setBackground(Paleta.menu);
        sidebar.setPreferredSize(new Dimension(250, 600));
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        

        
        JPanel logoPanel = new JPanel();
        logoPanel.setBackground(Paleta.menu);
        logoPanel.setPreferredSize(new Dimension(250, 70));
        logoPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));
     
        
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
        
        
        JLabel lblEmpleados = new JLabel("Usuarios / Empleados");
        lblEmpleados.setForeground(Paleta.textologin2);
        lblEmpleados.setFont(new Font("SansSerif", Font.BOLD, 27));
        lblEmpleados.setHorizontalAlignment(SwingConstants.LEFT);
        lblEmpleados.setBounds(81, 22, 322, 35);
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
        tfEmpleados.setOpaque(false);
        tfEmpleados.setForeground(Paleta.menu);
        tfEmpleados.setBackground(Paleta.fondo2);
        tfEmpleados.setFont(new Font("SansSerif", Font.PLAIN, 13));
        tfEmpleados.setBorder(new Borde(10, Paleta.menu));
        tfEmpleados.setColumns(10);
        tfEmpleados.setBounds(151, 69, 549, 28);
        pantallaEmpleados.add(tfEmpleados);
        
        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(83, 110, 947, 540);
        pantallaEmpleados.add(scrollPane_1);
        
        tablaEmpleado = new JTable();
        tablaEmpleado.setShowGrid(true);
        tablaEmpleado.setGridColor(Paleta.fondoPrincipal);
        tablaEmpleado.setForeground(Paleta.fondoPrincipal);
        tablaEmpleado.setFillsViewportHeight(true);
        tablaEmpleado.setModel(new DefaultTableModel(
            new Object[][] {},
            new String[] {
            		"ID", "Nombre", "Telefono", "Correo", "Usuario", "Contraseña"
            }
        ));
        
        DefaultTableModel model = (DefaultTableModel) tablaEmpleado.getModel();
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
        panelPrincipal.add(pantallaEmpleados, "EMPLEADOS");
        panelPrincipal.add(pantallaGestion,"AGREGAR");
        
        JLabel lblAgregarEmpleado = new JLabel("Gestion Empleados");
        lblAgregarEmpleado.setForeground(Paleta.textologin2);
        lblAgregarEmpleado.setHorizontalAlignment(SwingConstants.LEFT);
        lblAgregarEmpleado.setFont(new Font("SansSerif", Font.BOLD, 27));
        lblAgregarEmpleado.setBounds(41, 39, 305, 35);
        pantallaGestion.add(lblAgregarEmpleado);
        
        Panel panelAggEmpleado = new Panel(15, 0, Paleta.borde);
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
        
        JLabel lbUsuario = new JLabel("Usuario:");
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
        
        JRadioButton rbBarbero = new JRadioButton("Barbero");
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
        
        JRadioButton rbRecepcionista = new JRadioButton("Recepcionista");
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
        		String rol = "";
        		
        		
        		
        		if (rbBarbero.isSelected()) {
					rol = "Barbero";
				} else if (rbRecepcionista.isSelected()) {
					rol = "Recepcionista";
				}
        		
        		if (rol.equals("Barbero")) {
	        		if (nombre.isEmpty() || telefono.isEmpty()) {
	        			JOptionPane.showMessageDialog(frame, "Por favor, complete todos los campos requeridos.", "Error", JOptionPane.ERROR_MESSAGE);
	        		} else {
	        			DefaultTableModel model = (DefaultTableModel) tablaGestionE.getModel();
//						model.addRow(new Object[]{model.getRowCount() + 1, nombre, "Inecesario", rol, telefono});
							if (GuardarDatos.guardarUsuarios(model.getRowCount() + 1,nombre, telefono, correo, "Inecesario", usuario+"123")) {
			        	        JOptionPane.showMessageDialog(null, "Empleado guardado");
			        	        cargarUsuariosEnTabla();
			        	    } else {
			        	        JOptionPane.showMessageDialog(null, "Error al guardar");
			        	        cargarUsuariosEnTabla();
			        	    }
						
							tfNombre.setText("");
							tfUsuario.setText("");
							tfUsuario.setEnabled(true);
							lbUsuario.setEnabled(true);
							tfCorreo.setText("");
							roles.clearSelection();
							panelBarbero.setVisible(false);
					}
				
	        	} else if (rol.equals("Recepcionista")) {
						if (nombre.isEmpty() || usuario.isEmpty() || telefono.isEmpty() || usuario.isEmpty()) {
		        			JOptionPane.showMessageDialog(frame, "Por favor, complete todos los campos requeridos.", "Error", JOptionPane.ERROR_MESSAGE);
		        		} else {
		        			DefaultTableModel model = (DefaultTableModel) tablaGestionE.getModel();
//		        			model.addRow(new Object[]{model.getRowCount() + 1, nombre, usuario, rol, telefono});
			        			if (GuardarDatos.guardarUsuarios(model.getRowCount() + 1,nombre, telefono, correo, usuario, usuario+ "123")) {
			            	        JOptionPane.showMessageDialog(null, "Empleado guardado");
			            	        cargarUsuariosEnTabla();
			            	    } else {
			            	        JOptionPane.showMessageDialog(null, "Error al guardar");
			            	    }
		        			
		        		}
        		}
				
        		
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
        
        JRadioButton rbMañana = new JRadioButton("Mañana");
        rbMañana.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		tfHorario.setText("");
        		tfHorario.setText("9:00AM - 1:00PM");
        	
        	}
        });
        rbMañana.setForeground(new Color(242, 240, 235));
        rbMañana.setBounds(31, 50, 88, 24);
        panelBarbero.add(rbMañana);
        
        JRadioButton rbTarde = new JRadioButton("Tarde");
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
        
        JScrollPane scrollPane_1_1 = new JScrollPane();
        scrollPane_1_1.setBounds(526, 84, 558, 378);
        pantallaGestion.add(scrollPane_1_1);
        tablaGestionE = new JTable();
        tablaGestionE.setModel(new DefaultTableModel(
        	new Object[][] {
        	},
        	new String[] {
        		"ID", "Nombre", "Telefono", "Correo", "Usuario", "Contrase\u00F1a"
        	}
        ));
        tablaGestionE.getColumnModel().getColumn(0).setPreferredWidth(35);
        tablaGestionE.getColumnModel().getColumn(3).setPreferredWidth(100);
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
        scrollPane_1_1.setViewportView(tablaGestionE);
       
        
        ImageIcon edit = new ImageIcon(getClass().getResource("/Imagenes/botonEditar.png"));
        Image img2 = edit.getImage();
        Image size3 = img2.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
       
        ImageIcon editIcon = new ImageIcon(size3);
        
        
        JButton btEditar = new JButton("Editar", editIcon);
        btEditar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	
        		if (tablaGestionE.getSelectedRow() == -1) {
        		JOptionPane.showMessageDialog(frame, "Por favor, seleccione un empleado para editar.", "Error", JOptionPane.ERROR_MESSAGE);
        		} else {
        			panelEditEmpleado.setVisible(true);
        			
        		}
        		
        		
			}
        });
        btEditar.setIconTextGap(6);
        btEditar.setHorizontalTextPosition(SwingConstants.RIGHT);
        btEditar.setForeground(new Color(242, 240, 235));
        btEditar.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btEditar.setBackground(Paleta.menu);
        btEditar.setBounds(939, 39, 145, 35);
        pantallaGestion.add(btEditar);
        
        panelEditEmpleado = new Panel(15, 0, new Color(120, 120, 120, 80));
        panelEditEmpleado.setVisible(false);
        panelEditEmpleado.setLayout(null);
        panelEditEmpleado.setBackground(new Color(31, 41, 55));
        panelEditEmpleado.setBounds(526, 489, 558, 184);
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
        	
        		turnos2.clearSelection();
        		roles1.clearSelection();
        		panelEditEmpleado.setVisible(false);
        		
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
        		}else {
        	        JOptionPane.showMessageDialog(null, "Error al actualizar");
        	    }
        		
        		
	        		if (tfNombreEdit.getText().isEmpty() || tfUsuarioEdit.getText().isEmpty() || tfTelefonoEdit.getText().isEmpty()) {
						JOptionPane.showMessageDialog(frame, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
					} else {
						 DefaultTableModel model = (DefaultTableModel) tablaGestionE.getModel();
						 int selectedRow = tablaGestionE.getSelectedRow();
						 model.setValueAt(tfNombreEdit.getText(), selectedRow, 1);
						 model.setValueAt(tfUsuarioEdit.getText(), selectedRow, 2);
						 model.setValueAt(tfTelefonoEdit.getText(), selectedRow, 4);
						 
						 panelEditEmpleado.setVisible(false);
						
						
		    			lbUsuario_1.setText("Usuario:");
		        		tfHorarioEdit.setVisible(false);
		        		tfUsuarioEdit.setVisible(true);
						tfUsuarioEdit.setText(""); 
						tfNombreEdit.setText("");
						tfUsuarioEdit.setText("");
						tfTelefonoEdit.setText("");
						tablaGestionE.clearSelection();
						
					}
        		
					
					if (tfNombreEdit.getText().isEmpty() || tfTelefonoEdit.getText().isEmpty()) {
						JOptionPane.showMessageDialog(frame, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
					} else {
						 DefaultTableModel model = (DefaultTableModel) tablaGestionE.getModel();
						 int selectedRow = tablaGestionE.getSelectedRow();
						 model.setValueAt(tfNombreEdit.getText(), selectedRow, 1);
						 model.setValueAt("Inecesario", selectedRow, 2);
						 model.setValueAt(tfTelefonoEdit.getText(), selectedRow, 4);
						 
						
		    			lbUsuario_1.setText("Usuario:");
		        		tfHorarioEdit.setVisible(false);
		        		tfUsuarioEdit.setVisible(true);
						tfUsuarioEdit.setText("");
						tfNombreEdit.setText("");
						tfUsuarioEdit.setText("");
						tfTelefonoEdit.setText("");
						panelEditEmpleado.setVisible(false);
						tablaGestionE.clearSelection();
						
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
        
//        turnos2 = new ButtonGroup();
        
        panelPrincipal.add(pantallaCitas, "CITAS");
        panelPrincipal.add(pantallaPagos, "PAGOS");
        
        JLabel lbBuscar3 = new JLabel("Buscar: ");
        lbBuscar3.setForeground(Paleta.textologin2);
        lbBuscar3.setFont(new Font("SansSerif", Font.BOLD, 16));
        lbBuscar3.setBounds(72, 70, 81, 28);
        pantallaPagos.add(lbBuscar3);
        
        tfPagos = new JTextField();
        tfPagos.setOpaque(false);
        tfPagos.setForeground(Paleta.menu);
        tfPagos.setBackground(Paleta.fondo2);
        tfPagos.setFont(new Font("SansSerif", Font.PLAIN, 13));
        tfPagos.setBorder(new Borde(5, Paleta.menu));
        tfPagos.setColumns(10);
        tfPagos.setBounds(140, 72, 598, 28);
        pantallaPagos.add(tfPagos);
        
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
        
        JScrollPane scrollPane_2 = new JScrollPane();
        scrollPane_2.setBounds(72, 110, 947, 540);
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
        tablaPagos.setShowGrid(true);
        tablaPagos.setGridColor(Paleta.fondoPrincipal);
        tablaPagos.setFillsViewportHeight(true);
        tablaPagos.setBackground(Paleta.menu);
        
        JTableHeader header2 = tablaPagos.getTableHeader();
        tablaPagos.getTableHeader().setBackground(Paleta.headers);
        tablaPagos.getTableHeader().setForeground(Paleta.textologin2);
        
        header2.setFont(new Font("Segoe UI", Font.BOLD, 14));
        scrollPane_2.setViewportView(tablaPagos);
        
        JLabel lblNewLabel_1 = new JLabel("Filtrar por: ");
        lblNewLabel_1.setFont(new Font("SansSerif", Font.BOLD, 12));
        lblNewLabel_1.setBounds(756, 78, 69, 16);
        pantallaPagos.add(lblNewLabel_1);
        
        
        JLabel lbBuscar2 = new JLabel("Buscar: ");
        lbBuscar2.setForeground(Paleta.textologin2);
        lbBuscar2.setFont(new Font("SansSerif", Font.BOLD, 16));
        lbBuscar2.setBounds(76, 65, 69, 28);
        pantallaCitas.add(lbBuscar2);
        
        tfCitas = new JTextField();
        tfCitas.setOpaque(false);
        tfCitas.setForeground(Paleta.menu);
        tfCitas.setBackground(Paleta.fondo2);
        tfCitas.setFont(new Font("SansSerif", Font.PLAIN, 13));
        tfCitas.setBorder(new Borde(10, Paleta.menu));
        tfCitas.setBounds(147, 65, 592, 28);
        pantallaCitas.add(tfCitas);
        tfCitas.setColumns(10);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(72, 110, 947, 540);
        pantallaCitas.add(scrollPane);
        
        tablaCitas = new JTable();
        tablaCitas.setModel(new DefaultTableModel(
        	new Object[][] {
        		{null, null, null, null},
        	},
        	new String[] {
        		"Id", "Cliente", "Fecha", "Hora"
        	}
        ));
        tablaCitas.getColumnModel().getColumn(0).setPreferredWidth(25);
        tablaCitas.getColumnModel().getColumn(1).setPreferredWidth(133);
        tablaCitas.getColumnModel().getColumn(2).setPreferredWidth(202);
        tablaCitas.setShowGrid(true);
        tablaCitas.setGridColor(Paleta.fondoPrincipal);
        tablaCitas.setFillsViewportHeight(true);
        tablaCitas.setBackground(Paleta.menu);
        
        JTableHeader header3 = tablaCitas.getTableHeader();
        tablaCitas.getTableHeader().setBackground(Paleta.headers);
        tablaCitas.getTableHeader().setForeground(Paleta.textologin2);
        header3.setFont(new Font("Segoe UI", Font.BOLD, 14));
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
        sidebar.add(createMenuButton("Empleados", () -> {
            cardLayout.show(panelPrincipal, "EMPLEADOS");
            cargarUsuariosEnTabla();
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
	}
	
	private void cargarUsuariosEnTabla() {
	    String[] columnas = {"ID", "Nombre", "Telefono", "Correo", "Usuario", "Contraseña"};

	    DefaultTableModel modelo = new DefaultTableModel(null, columnas);

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
	    }
	    String[] columnas1 = {"ID", "Nombre", "Telefono", "Correo", "Usuario", "Contraseña"};
	    
	    DefaultTableModel modelo1 = new DefaultTableModel(null, columnas);
	    
	    for (UsuarioRegular u : lista) {
	    	Object[] fila = {
	    			u.getId(),
	    			u.getNombre(),
	    			u.getTelefono(),
	    			u.getCorreo(),
	    			u.getUser(),
	    			u.getContraseña()
	    	};
	    	modelo1.addRow(fila);
	    }

	    
	    
	    tablaGestionE.setModel(modelo);
	    tablaEmpleado.setModel(modelo1);
	}
	
	public void eliminarEmpleado() {
		int fila = tablaEmpleado.getSelectedRow();
		
		if(fila == -1) {
			JOptionPane.showMessageDialog(null, "Selecciona un empleado para eliminar.");
			return;
		}
	
		int id = Integer.parseInt(tablaEmpleado.getValueAt(fila, 0).toString());
		
//		int id = Integer.parseInt(tablaEmpleado.getValueAt(fila, 0).toString());
		
		int confirmacion = JOptionPane.showConfirmDialog(null, "¿Deseas eliminar este empleado?",
	            "Confirmación",
	            JOptionPane.YES_NO_OPTION);
		
		
		if(confirmacion == JOptionPane.YES_OPTION) {
			if(GuardarDatos.eliminarUsuarios(id)) {
				JOptionPane.showMessageDialog(null, "Empleado eliminado correctamente.");
				cargarUsuariosEnTabla();
			}else {
				 JOptionPane.showMessageDialog(null, "ERROR al eliminar.","Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		cargarUsuariosEnTabla();
		
	}
	
	
}