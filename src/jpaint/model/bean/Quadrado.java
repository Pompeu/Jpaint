package jpaint.model.bean;

import java.awt.Color;

public class Quadrado extends Retangulo {

    public Quadrado(int x, int y, int lado,int tipo, Color colorBorda,
            Color colorInternal) {
        super(x, y, lado, lado, tipo, colorBorda,colorInternal);
    }

    /**
     * metodo que seta altura e largarua == pois o quadrado usa o metodo draw do
     * retangulo
     *
     * @param lado
     */
    public void setLado(int lado) {
        setLargura(lado);
        setAltura(lado);
    }
}
