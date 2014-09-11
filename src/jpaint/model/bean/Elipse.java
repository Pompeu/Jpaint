package jpaint.model.bean;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import javax.swing.border.StrokeBorder;

public class Elipse extends Figura {

    public Elipse(int x, int y, int largura, int altura, int tipo, Color colorBorda, Color colorInternal) {
        super(x, y, largura, altura, Figuras.ELIPSE, colorBorda, colorInternal);
    }

    /**
     * Metodo que tem como tarefa pegar o centro da figura elipse e retornalo
     *
     * @return centroElipse
     */
    public Point getCenter() {
        return new Point(getX() + getLargura() / 2, getY() + getAltura() / 2);
    }

    @Override
    public void desenheMe(Graphics g) {
        g.setColor(getColorInternal());
        g.fillOval(getX(), getY(), getLargura(), getAltura());
        g.setColor(getColorBorda());
        ((Graphics2D) g).setStroke(new BasicStroke(BasicStroke.CAP_SQUARE, BasicStroke.JOIN_BEVEL, BasicStroke.JOIN_BEVEL));
        g.drawOval(getX(), getY(), getLargura(), getAltura());

    }
}
