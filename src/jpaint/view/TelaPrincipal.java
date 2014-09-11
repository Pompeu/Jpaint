package jpaint.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import jpaint.controller.SaveController;
import jpaint.model.bean.Save;
import jpaint.model.bean.SaveDAO;

public class TelaPrincipal extends JFrame {

    private Canvas c;
    private final SaveController saveController = new SaveController();
    private String name;
    private int fkKey;

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

        JMenuItem jmiSalvar = new JMenuItem("Salvar Atual", 0);//intens do menu Jmenu
        JMenuItem jmiSalvarNovo = new JMenuItem("Salvar Novo", 0);
        JMenuItem jmiCarregar = new JMenu("Carregar Recentes");
        JMenuItem jmiLimpar = new JMenuItem("Limpar", 0);
        JMenuItem jmiSair = new JMenuItem("Sair", 0);
        jmiSair.setMnemonic('S');

        JMenuItem subJMenuPrimeiroItem = new JMenuItem("Carregar");
        jmiCarregar.add(subJMenuPrimeiroItem);

        
  
        
        jmArquivo.add(jmiSalvar);
        jmArquivo.add(jmiSalvarNovo);
        jmArquivo.add(jmiCarregar);
        jmArquivo.add(jmiLimpar);
        jmArquivo.add(jmiSair);

        jmbBarra.add(jmArquivo);

        this.setJMenuBar(jmbBarra);
        subJMenuPrimeiroItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final RecuperarSaves recuperarSaves = new RecuperarSaves();

                recuperarSaves.getBtnCerragar().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        name = recuperarSaves.getTfNameSave().getText();
                        fkKey = SaveDAO.recuperaPkKey(name);
                        c.setFigs(SaveDAO.retreveSaveListItens(fkKey));
                        c.repaint();
                        recuperarSaves.getJ().dispose();
                    }
                });
            }
        });

        jmiSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(rootPane, "Não Esta Implementado");
            }
        });
        /**
         * savar uma nova figura no banco!!
         */
        jmiSalvarNovo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (c.getFigs().getFigs().isEmpty()) {
                    JOptionPane.showMessageDialog(rootPane, "Sem Figuras");
                } else {
                    final SaveView save = new SaveView();
                    /**
                     * Cria um action para botão salvar que grava a lista de
                     * figuras no banco com nome do Save
                     */
                    save.getBtnSave().addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            name = save.getTfName().getText();
                            saveController.savarFigurasNome(c.getFigs(), name);
                            save.dispose();
                        }
                    });
                }
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
