package jpaint.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Set;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import jpaint.controller.SaveController;
import jpaint.model.bean.DAO.SaveDAO;
import jpaint.model.bean.Figura;

public class TelaPrincipal extends JFrame {

    private Canvas c;
    private final SaveController saveController = new SaveController();
    private String saveName;
    private int fkKey, tamanhoListRecuperada;
    private final Set<JMenuItem> novosItens = ResentSaves.getInstace().getSavesRecetes();
    private final JMenuBar jmbBarra = new JMenuBar();//barra de menus
    private final JMenu jmArquivo = new JMenu("Aquivo"); //Cabeçario do jMenu
    private final JMenuItem jmiSalvar = new JMenuItem("Salvar Atual", 0);//intens do menu Jmenu
    private final JMenuItem jmiSalvarNovo = new JMenuItem("Salvar Novo", 0);
    private final JMenuItem jmiCarregar = new JMenu("Carregar Recentes");
    private final JMenuItem jmiLimpar = new JMenuItem("Limpar", 0);
    private final JMenuItem jmiSair = new JMenuItem("Sair", 0);

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
        atulizarSavesRecentes(); //carregando o menu de intens recentes
        jmArquivo.setMnemonic('A');//subilnha a letra do menu alt+A fica como atalho
        jmiSair.setMnemonic('S');
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
                List<Figura> listnewFigs = c.getFigs().getFigs().subList(tamanhoListRecuperada,
                        c.getFigs().getFigs().size());
                if (listnewFigs.isEmpty()) {
                    JOptionPane.showMessageDialog(rootPane, "Desenhe Novas Figuras");
                } else {
                    saveController.savarNovasFiguras(listnewFigs, fkKey);
                }
            }

        });
        /**
         * savar uma nova figura no banco!!
         */
        jmiSalvarNovo.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e
                    ) {
                        if (c.getFigs().getFigs().isEmpty()) {
                            JOptionPane.showMessageDialog(rootPane, "Sem Figuras");
                        } else {
                            final SaveView save = new SaveView();
                            /**
                             * Cria um action para botão salvar que grava a
                             * lista de figuras no banco com nome do Save
                             */
                            save.getBtnSave().addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    saveName = save.getTfName().getText();
                                    saveController.savarFigurasNome(c.getFigs(), saveName);
                                    ResentSaves.getInstace().getSavesRecetes().add(
                                            new JMenuItem(saveName));
                                    atulizarSavesRecentes();
                                    save.dispose();
                                }
                            });
                        }
                    }
                }
        );
        jmiLimpar.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e
                    ) {
                        c.getFigs().getFigs().clear();
                        c.repaint();
                    }
                }
        );
        jmiSair.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e
                    ) {
                        System.exit(0);
                    }
                }
        );

    }

    private void atulizarSavesRecentes() {
        for (JMenuItem jmenuIten : novosItens) {
            jmiCarregar.add(jmenuIten);
            jmenuIten.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    fkKey = SaveDAO.recuperaPkKey(jmenuIten.getText());
                    c.setFigs(SaveDAO.retreveSaveListItens(fkKey));
                    c.repaint();
                    /**
                     * pegando nome e tamanho da lista de save
                     */
                    saveName = jmenuIten.getText();
                    tamanhoListRecuperada = SaveDAO.retreveSaveListItens(fkKey).getFigs().size();
                    TelaPrincipal.this.setTitle("jPaint 1.0 " + saveName + " save");
                }
            });
        }

    }
}
