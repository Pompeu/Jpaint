package jpaint.model.bean;

import java.awt.Color;
import java.awt.Graphics;

public class Retangulo extends Figura {


    public Retangulo(int x, int y, int largura, int altura, int tipo, Color colorBorda,
            Color colorInternal) {
        super(x, y, largura, altura, tipo, colorBorda,colorInternal);
    }

    @Override
    public void desenheMe(Graphics g) {
        g.setColor(getColorBorda());
        g.fillRect(getX(), getY(), getLargura(), getAltura());
        g.drawRect(getX(), getY(), getLargura(), getAltura());
        
    }
}
