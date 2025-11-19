package GUI;

import java.awt.*;
import javax.swing.border.Border;

public class Borde implements Border {

    private int radius;
    private Color color;

    public Borde(int radius, Color color) {
        this.radius = radius;
        this.color = color;
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(this.radius + 1, this.radius + 1, this.radius + 2, this.radius);
    }

    @Override
    public boolean isBorderOpaque() {
        return true;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.setColor(color); // color del borde
        g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
    }
}

