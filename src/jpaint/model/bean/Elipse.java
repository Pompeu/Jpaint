package jpaint.model.bean;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

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
        
        g.setColor(getColorBorda());
        g.fillOval(getX(), getY(), getLargura(), getAltura());
        
        g.setColor(getColorInternal());        
        g.drawOval(getX(), getY(), getLargura(), getAltura());

    }
}
