/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpaint.view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JTable;
import jpaint.model.bean.Save;
import jpaint.model.bean.SaveDAO;
import jpaint.model.bean.SaveTableModel;

/**
 *
 * @author pompeu
 */
public class SaveTable extends JFrame {

    private JTable tblSave;
    private SaveTableModel tableModel;
    private List<Save> nomes;

    public SaveTable() {
        super("Lista de Saves");
        initComponetes();

    }

    private void initComponetes() {

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        getContentPane().add(getTblSave());

    }

    private JTable getTblSave() {
        if (tblSave == null) {
            tblSave = new JTable();
        }
        tblSave.setModel(getSaveTabelaModel());
        return tblSave;
    }

    private SaveTableModel getSaveTabelaModel() {
        if (tableModel == null) {
            tableModel = new SaveTableModel(criarSaves());
        }
        return tableModel;
    }

    public List<Save> criarSaves() {
        nomes = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Save save = new Save(i, "" + 1);
            nomes.add(save);
        }
        return nomes;
    }

}
