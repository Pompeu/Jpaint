
package jpaint.model.bean;

import java.util.ArrayList;

public class Figuras {
    /*esses atribultos vão dar tipo as figuras*/
    public final static int ELIPSE = 0;
    public final static int CIRCULO = 1;
    public final static int QUADRADO = 2;
    public final static int RETANGULO = 3;
    public final static int TRIANGULO = 4;
    
    private ArrayList<Figura> figs = new ArrayList<>();
    /*  metodos getters e setter que manipulão o array
        de figuras
    */
    public ArrayList<Figura> getFigs() {
        return figs;
    }

    public void setFigs(ArrayList<Figura> figs) {
        this.figs = figs;
    }

   
}
