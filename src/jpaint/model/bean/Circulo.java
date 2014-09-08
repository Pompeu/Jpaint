package jpaint.model.bean;

import java.awt.Color;
import java.awt.Point;

public class Circulo extends Elipse {

    public Circulo(int x, int y, int diametro,int tipo, Color colorBorda, Color colorInternal) {
        super(x, y, diametro, diametro, Figuras.CIRCULO, colorBorda,colorInternal);
    }

    /**
     * Metodo que tem como tarefa pegar o centro da figura Circulo e retornalo
     *
     * @return centroCirculo
     */
    @Override
    public Point getCenter() {
        int c = getLargura() / 2;
        return new Point(getX() + c, getY() + c);
    }
}
