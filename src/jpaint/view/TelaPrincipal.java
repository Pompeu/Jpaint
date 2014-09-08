package jpaint.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import jpaint.controller.SaveController;
import jpaint.model.bean.FiguraDAO;
import jpaint.model.bean.FigurasDAO;

public class TelaPrincipal extends JFrame {

    Canvas c;
    SaveController save = new SaveController();

    /**
     * contrutor da tela principal
     */
    public TelaPrincipal() {
        super("jPaint 1.0");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLayout(new BorderLayout());
        initMenu();
        this.add(c, BorderLayout.CENTER);
        this.add(c.getToolBar(), BorderLayout.WEST);
    }

    /**
     * metodos de carregar os menus
     */
    private void initMenu() {
        c = new Canvas(new ToolBar());
        JMenuBar jmbBarra = new JMenuBar();//barra de menus
        JMenu jmArquivo = new JMenu("Aquivo"); //Cabeçario do jMenu
        jmArquivo.setMnemonic('A');//subilnha a letra do menu alt+A fica como atalho

        JMenuItem jmiSalvar = new JMenuItem("Salvar", 0);//intens do menu Jmenu
        JMenuItem jmiSalvarNovo = new JMenuItem("Salvar Novo", 0);

        JMenuItem jmiCarregar = new JMenu("Carregar");

        JMenuItem jmiLimpar = new JMenuItem("Limpar", 0);
        JMenuItem jmiSair = new JMenuItem("Sair", 0);
        jmiSair.setMnemonic('S');

        JMenuItem recuperarCirculos = new JMenuItem("Carregar Circlos");
        JMenuItem recuperarElipses = new JMenuItem("Carregar Elipses");
        JMenuItem recuperarRetangulos = new JMenuItem("Carregar Retangulos");
        JMenuItem recuperarQuadrados = new JMenuItem("Carregar Quadrados");
        JMenuItem recuperarTriangulos = new JMenuItem("Carregar Triangulos");

        jmiCarregar.add(recuperarCirculos);
        jmiCarregar.add(recuperarElipses);
        jmiCarregar.add(recuperarRetangulos);
        jmiCarregar.add(recuperarQuadrados);
        jmiCarregar.add(recuperarTriangulos);

        jmArquivo.add(jmiSalvar);
        jmArquivo.add(jmiSalvarNovo);
        jmArquivo.add(jmiCarregar);
        jmArquivo.add(jmiLimpar);
        jmArquivo.add(jmiSair);

        jmbBarra.add(jmArquivo);

        this.setJMenuBar(jmbBarra);

        jmiSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //FigurasDAO.create(c.getFigs());//passando todo array pra lista  
                save.savarFigurasNome(c.getFigs(), "Jose");
            }
        });

        jmiLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c.getFigs().getFigs().clear();
                c.repaint();
            }
        });
        jmiSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

}
