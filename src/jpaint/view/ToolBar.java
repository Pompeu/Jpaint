package jpaint.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ToolBar extends JPanel {

    public final static int ELIPSE = 0;
    public final static int CIRCULO = 1;
    public final static int QUADRADO = 2;
    public final static int RETANGULO = 3;
    public final static int TRIANGULO = 4;
    private int ferramentaSelecionada = 0;
    private final JButton botoes[] = new JButton[5];
    private static final JButton btnElipse = new JButton("Elipse");
    private static final JButton btnCirculo = new JButton("Circulo");
    private static final JButton btnQuadrado = new JButton("Quadrado");
    private static final JButton btnRetangulo = new JButton("Retangulo");
    private static final JButton btnTriangulo = new JButton("triangulo");
    private static final JButton btnColorBorder = new JButton("Cor Borda");
    private static final JButton btnColorBackGround = new JButton("Cor Fundo");

    public ToolBar() {
        this.setLayout(new BoxLayout(this, WIDTH));
        this.add(btnElipse);
        this.add(btnCirculo);
        this.add(btnQuadrado);
        this.add(btnRetangulo);
        this.add(btnTriangulo);
        this.add(btnColorBorder);
        this.add(btnColorBackGround);
        this.setBackground(Color.gray);
        initBtnEvents();
    }

    /**
     * esse metodo manipula os eventos dos botões
     */
    private void initBtnEvents() {

        botoes[0] = btnElipse;
        botoes[1] = btnCirculo;
        botoes[2] = btnQuadrado;
        botoes[3] = btnRetangulo;
        botoes[4] = btnTriangulo;

        for (final JButton b : botoes) {
            b.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setFerramentaSelecionada(getIndexButtoes(b.getText()));
                }
            });
        }

        btnColorBorder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final ColorChoice colorBorder = new ColorChoice();
                colorBorder.setVisible(true);
                colorBorder.getBtnSelect().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        btnColorBorder.setBackground(colorBorder.getBtnSelect().getBackground());
                        colorBorder.dispose();
                    }
                });

            }
        });

        btnColorBackGround.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final ColorChoice colorBackGroud = new ColorChoice();
                colorBackGroud.setVisible(true);
                colorBackGroud.getBtnSelect().addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        btnColorBackGround.setBackground(colorBackGroud.getBtnSelect().getBackground());
                        colorBackGroud.dispose();
                    }
                });
            }
        });
    }

    public int getFerramentaSelecionada() {
        return ferramentaSelecionada;
    }

    public void setFerramentaSelecionada(int ferramentaSelecionada) {
        this.ferramentaSelecionada = ferramentaSelecionada;
    }

    /**
     * seta a cor de fundo do botões de desenho
     *
     * @param color
     */
    public static void setColorJButton(Color color) {

        btnColorBorder.setBackground(color);

    }

    public static void setColorJButtonBackGroud(Color color) {
        btnColorBackGround.setBackground(color);

    }

    public static JButton getBtnColorBorder() {
        return btnColorBorder;
    }

    public static JButton getBtnColorBackGround() {
        return btnColorBackGround;
    }

    /**
     * esse metodo recebe nome do botão e me restorna seu numero para uso da
     * ferramenta
     *
     * @param nome
     * @return Index
     */
    private int getIndexButtoes(String nome) {

        switch (nome) {
            case "Elipse":
                return ELIPSE;

            case "Circulo":
                return CIRCULO;

            case "Quadrado":
                return QUADRADO;

            case "Retangulo":
                return RETANGULO;

            case "triangulo":
                return TRIANGULO;

            default:

        }
        return ELIPSE;
    }
}
