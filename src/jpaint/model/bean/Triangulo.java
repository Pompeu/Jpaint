package jpaint.model.bean;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;

public class Triangulo extends Figura {

    public Triangulo(int x, int y, int largura, int altura,int tipo, Color colorBorda,
            Color colorInternal) {
        super(x, y, largura, altura, tipo , colorBorda,colorInternal);
    }

    /**
     * Metodos que desenha um triangulo tela usando a classe Polygon atravez
     * dela é 3 pontos que são delimistados na tela.
     *
     * @param g
     */
    @Override
    public void desenheMe(Graphics g) {
        
        Polygon p = new Polygon();
        p.addPoint(getX(), getY() + getAltura());
        p.addPoint(getX() + getLargura(), getY() + getAltura());
        p.addPoint(getX() + getLargura() / 2, getY());
        g.setColor(getColorInternal());
        g.fillPolygon(p);
        g.setColor(getColorBorda());
        ((Graphics2D) g).setStroke(new BasicStroke(BasicStroke.CAP_SQUARE, BasicStroke.JOIN_BEVEL, BasicStroke.JOIN_BEVEL));
        g.drawPolygon(p);
        
    }

}
