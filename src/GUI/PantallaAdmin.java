package GUI;

import javax.swing.*;
import java.awt.*;

public class PantallaAdmin {

    private JFrame frame;
    private CardLayout cardLayout;
    private JPanel panelPrincipal;

    public static void main(String[] args) {
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
        frame.setBounds(100, 100, 900, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        // ---------------- SIDEBAR ----------------
        JPanel sidebar = new JPanel();
        sidebar.setBackground(new Color(245, 247, 250));
        sidebar.setPreferredSize(new Dimension(250, 600));
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));

        // Logo
        JPanel logoPanel = new JPanel();
        logoPanel.setBackground(new Color(245, 247, 250));
        logoPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));

        JLabel title = new JLabel("barberPiece");
        title.setFont(new Font("Segoe UI", Font.BOLD, 16));
        logoPanel.add(title);

        sidebar.add(logoPanel);
        sidebar.add(Box.createRigidArea(new Dimension(0, 20)));

        // ---------------- PANTALLAS CON CARDLAYOUT ----------------
        cardLayout = new CardLayout();
        panelPrincipal = new JPanel(cardLayout);

        // Pantalla inicio
        JPanel pantallaInicio = new JPanel();
        pantallaInicio.add(new JLabel("Pantalla de inicio"));

        // Pantalla agregar
        JPanel pantallaAgregar = new JPanel();
        pantallaAgregar.add(new JLabel("Pantalla para agregar cosas"));

        // Añadir pantallas
        panelPrincipal.add(pantallaInicio, "INICIO");
        panelPrincipal.add(pantallaAgregar, "AGREGAR");

        // ---------------- BOTONES DEL SIDEBAR ----------------
        sidebar.add(createMenuButton("Gestion Barberos", () -> {
            cardLayout.show(panelPrincipal, "INICIO");
        }));

        sidebar.add(createMenuButton("Historial de Pagos", () -> {
            cardLayout.show(panelPrincipal, "AGREGAR");
        }));

        sidebar.add(Box.createVerticalGlue());

        // Añadir todo al frame
        frame.add(sidebar, BorderLayout.WEST);
        frame.add(panelPrincipal, BorderLayout.CENTER);
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
