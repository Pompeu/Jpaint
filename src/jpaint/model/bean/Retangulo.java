package jpaint.model.bean;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Retangulo extends Figura {


    public Retangulo(int x, int y, int largura, int altura, int tipo, Color colorBorda,
            Color colorInternal) {
        super(x, y, largura, altura, tipo, colorBorda,colorInternal);
    }

    @Override
    public void desenheMe(Graphics g) {
        
        g.setColor(getColorInternal());
        g.fillRect(getX(), getY(), getLargura(), getAltura());
        g.setColor(getColorBorda());
        ((Graphics2D) g).setStroke(new BasicStroke(BasicStroke.CAP_SQUARE, BasicStroke.JOIN_BEVEL, BasicStroke.JOIN_BEVEL));
        g.drawRect(getX(), getY(), getLargura(), getAltura());
        
    }
}
