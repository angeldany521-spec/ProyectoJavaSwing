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

        // --------------------------
        // SOMBRA menos difuminada
        // --------------------------
        for (int i = shadowSize; i > 0; i--) {
            int alpha = (int) (80 * (i / (float) shadowSize)); // sombra más fuerte (antes era 20)

            g2.setColor(new Color(
                    shadowColor.getRed(),
                    shadowColor.getGreen(),
                    shadowColor.getBlue(),
                    alpha
            ));

            g2.fillRoundRect(
                    i, 
                    i,
                    width - (i * 2),
                    height - (i * 2),
                    radius,
                    radius
            );
        }

        // --------------------------
        // PANEL principal
        // --------------------------
        g2.setColor(getBackground());
        g2.fillRoundRect(
                shadowSize,
                shadowSize,
                width - shadowSize * 2,
                height - shadowSize * 2,
                radius,
                radius
        );
    }
}