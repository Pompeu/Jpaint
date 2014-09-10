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
        btnElipse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setFerramentaSelecionada(0);
            }
        });
        btnCirculo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setFerramentaSelecionada(1);
            }
        });
        btnQuadrado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setFerramentaSelecionada(2);
            }
        });
        btnRetangulo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setFerramentaSelecionada(3);
            }
        });
        btnTriangulo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setFerramentaSelecionada(4);
            }
        });
        /*
         btnElipse.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
         setFerramentaSelecionada(0);
         }
         });
         btnCirculo.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
         setFerramentaSelecionada(1);
         }
         });
         btnQuadrado.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
         setFerramentaSelecionada(2);
         }
         });
         btnRetangulo.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
         setFerramentaSelecionada(3);
         }
         });
         btnTriangulo.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
         setFerramentaSelecionada(4);
         }
         });*/
        btnColorBorder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ColorChoice().setEnabled(true);

            }
        });

        btnColorBackGround.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ColorChoice().setEnabled(true);
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
        btnElipse.setBackground(color);
        btnCirculo.setBackground(color);
        btnRetangulo.setBackground(color);
        btnQuadrado.setBackground(color);
        btnTriangulo.setBackground(color);

    }

    /**
     * pegando a cor do botões
     *
     * @return
     */
    public static Color getColorButton() {
        return btnElipse.getBackground();
    }

    public static Color getColorButtonBackGround() {
        return btnElipse.getBackground();
    }

}
