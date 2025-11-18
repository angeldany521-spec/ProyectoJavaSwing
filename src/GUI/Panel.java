package GUI;

import java.awt.*;

import javax.swing.JPanel;
import javax.swing.border.Border;

public class Panel extends JPanel {

    private int radius;
    private int shadowSize;
    private Color shadowColor;

    public Panel(int radius, int shadowSize, Color shadowColor) {
        this.radius = radius;
        this.shadowSize = shadowSize;
        this.shadowColor = shadowColor;
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = getWidth();
        int height = getHeight();

        // --- Sombra ---
        g2.setColor(shadowColor);
        g2.fillRoundRect(
                shadowSize,               // mover un poco la sombra
                shadowSize,
                width - shadowSize * 2,
                height - shadowSize * 2,
                radius,
                radius
        );

        // --- Fondo del panel ---
        g2.setColor(getBackground());
        g2.fillRoundRect(
                0,
                0,
                width - shadowSize * 2,
                height - shadowSize * 2,
                radius,
                radius
        );
    }
}

