package jpaint.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JPanel;
import jpaint.model.bean.Circulo;
import jpaint.model.bean.Elipse;
import jpaint.model.bean.Figura;
import jpaint.model.bean.Figuras;
import jpaint.model.bean.Quadrado;
import jpaint.model.bean.Retangulo;
import jpaint.model.bean.Triangulo;

public class Canvas extends JPanel {

    private ToolBar t;
    private Figuras figs = new Figuras();
    private Point m = new Point();
    private boolean rastro = false;
    private int x = 0, y = 0;
    private int ferramentaSelecionada = 0;

    public Canvas(ToolBar t) {
        setToolBar(t);
        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
                m.setLocation(e.getX(), e.getY());
                repaint();
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                m.setLocation(e.getX(), e.getY());
                repaint();
            }
        });

        this.addMouseListener(
                new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {
                        x = e.getX();
                        y = e.getY();
                        rastro = true;
                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {
                        switch (getToolBar().getFerramentaSelecionada()) {
                            case ToolBar.CIRCULO:
                                figs.getFigs().add(new Circulo(x,
                                                y,
                                                Figura.calcLargura(x, e.getX()), ToolBar.CIRCULO,
                                                ToolBar.getColorButton(), ToolBar.getColorButtonBackGround()));
                                break;
                            case ToolBar.ELIPSE:
                                figs.getFigs().add(new Elipse(x,
                                                y,
                                                Figura.calcLargura(x, e.getX()),
                                                Figura.calcAltura(y, e.getY()), ToolBar.ELIPSE,
                                                ToolBar.getColorButton(), ToolBar.getColorButtonBackGround()));
                                break;
                            case ToolBar.QUADRADO:
                                figs.getFigs().add(new Quadrado(x,
                                                y,
                                                Figura.calcAltura(y, e.getY()), ToolBar.QUADRADO,
                                                ToolBar.getColorButton(), ToolBar.getColorButtonBackGround()));
                                break;
                            case ToolBar.RETANGULO:
                                figs.getFigs().add(new Retangulo(x,
                                                y,
                                                Figura.calcLargura(x, e.getX()),
                                                Figura.calcAltura(y, e.getY()), ToolBar.RETANGULO,
                                                ToolBar.getColorButton(), ToolBar.getColorButtonBackGround()));
                                break;
                            case ToolBar.TRIANGULO:
                                figs.getFigs().add(new Triangulo(x,
                                                y,
                                                Figura.calcLargura(x, e.getX()),
                                                Figura.calcAltura(y, e.getY()),
                                                ToolBar.TRIANGULO, ToolBar.getColorButton(), ToolBar.getColorButtonBackGround()));
                                break;
                            default:
                                throw new AssertionError();
                        }
                        rastro = false;
                        repaint();
                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                    }
                });
        this.setBackground(Color.WHITE);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);//por esse super?
        g.drawString(m.getX() + ";" + m.getY(),
                Toolkit.getDefaultToolkit().getScreenSize().width - 80,
                Toolkit.getDefaultToolkit().getScreenSize().height - 40);

        if (rastro) {
            g.drawRect(x, y, Figura.calcLargura(x,
                    (int) m.getX()),
                    Figura.calcAltura(y, (int) m.getY()));
            
        }

        for (Figura f : figs.getFigs()) {
            f.desenheMe(g);
        }
    }

    public int getFerramentaSelecionada() {
        return ferramentaSelecionada;
    }

    public void setFerramentaSelecionada(int ferramentaSelecionada) {
        this.ferramentaSelecionada = ferramentaSelecionada;
    }

    public ToolBar getToolBar() {
        return t;
    }

    public void setToolBar(ToolBar t) {
        this.t = t;
    }

    public Figuras getFigs() {
        return figs;
    }

    public void setFigs(Figuras figs) {
        this.figs = figs;
    }

}
