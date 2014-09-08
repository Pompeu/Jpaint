package jpaint.model.bean;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Date;

public abstract class Figura {

    private int pkfigura = -1;
    private int x;
    private int y;
    private int largura;
    private int altura;
    private int tipo;
    private Color colorBorda;
    private Color colorInternal;

    /**
     * construtor da classe abstrata figura que recebe todos seus argumentos
     * como parametro
     *
     * @param x
     * @param y
     * @param largura
     * @param altura
     * @param tipo
     */
    public Figura(int x, int y, int largura, int altura, int tipo, Color colorBorda, Color colorInternal) {
        setX(x);
        setY(y);
        setLargura(largura);
        setAltura(altura);
        setTipo(tipo);
        setColorBorda(colorBorda);
        setColorInternal(colorInternal);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        if (x >= 0) {
            this.x = x;
        } else {
            throw new RuntimeException("Valor inválido");
        }
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getLargura() {
        return largura;
    }

    /**
     * esse metodo trata corrige o problema da figura não ser desenhada
     * corretamente na view
     *
     * @param largura
     */
    public void setLargura(int largura) {
        if (largura < 0) {
            largura *= -1;
            x -= largura;
        }
        this.largura = largura;
    }

    public int getAltura() {
        return altura;
    }

    /**
     * esse metodo trata corrige o problema da figura não ser desenhada
     * corretamente na view
     *
     * @param altura
     */
    public void setAltura(int altura) {
        if (altura < 0) {
            altura *= -1;
            y -= altura;
        }
        this.altura = altura;
    }

    public void setTipo(int tipo) {
        if (tipo >= 0 && tipo <= 4) {
            this.tipo = tipo;
        } else {
            this.tipo = 0;
        }
    }

    public int getTipo() {
        return tipo;
    }

    public int getPkfigura() {
        return pkfigura;
    }

    public void setPkfigura(int pkfigura) {
        this.pkfigura = pkfigura;
    }

    public Color getColorBorda() {
        return colorBorda;
    }

    public void setColorBorda(Color colorBorda) {
        this.colorBorda = colorBorda;
    }

    public Color getColorInternal() {
        return colorInternal;
    }

    public void setColorInternal(Color colorInternal) {
        this.colorInternal = colorInternal;
    }

    /**
     * metodo de modelo padrão para todas classe filhas que pinta a borda dos
     * desenhos
     *
     * @param g
     */
    public abstract void desenheMe(Graphics g);

    /**
     * metodo usado para calcular altura de uma figura
     *
     * @param y0
     * @param y1
     * @return altura (y1 , y0)
     */
    public static int calcAltura(int y0, int y1) {
        return y1 - y0;
    }

    /**
     * metodo usado para calcular a largura de uma figura
     *
     * @param x0
     * @param x1
     * @return largura(x1 - x0)
     */
    public static int calcLargura(int x0, int x1) {
        return x1 - x0;
    }

    /**
     * metodos foi resecrito para que possa ser visualizado as cordenadas dos
     * pixeis da figura em tempo de execulção
     *
     * @return cordenadas da figura
     */
    @Override
    public String toString() {
        return "Figura{" + "pkfigura=" + pkfigura
                + ", x=" + x + ", y=" + y + ", largura="
                + largura + ", altura=" + altura + ", tipo="
                + tipo + ", colorBorda=" + colorBorda
                + ", colorInternal=" + colorInternal + '}';
    }

}
