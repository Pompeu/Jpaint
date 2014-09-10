/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpaint.model.bean;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author pompeu
 */
public class SaveTableModel extends AbstractTableModel {

    private List<Save> linhas;
    private final String[] colunas = new String[]{"SaveName"};
    private static final int SAVENAME = 0;

    public SaveTableModel() {
        linhas = new ArrayList<Save>();
    }

    public SaveTableModel(List<Save> linhas) {
        this.linhas = new ArrayList<Save>(linhas);
    }

    @Override
    public int getRowCount() {
        return linhas.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case SAVENAME:
                return String.class;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Save save = linhas.get(rowIndex);
        switch (columnIndex) {
            case SAVENAME:
                return String.class;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    public Save getSaveName(int indiceLinha) {
        return linhas.get(indiceLinha);
    }

    public void addSaveName(Save save) {
        linhas.add(save);
        int ultimoIten = getRowCount() - 1;

        fireTableRowsInserted(ultimoIten, ultimoIten);

    }

    public void removerSave(int indiceLinha) {
        linhas.remove(indiceLinha);
        fireTableRowsInserted(indiceLinha, indiceLinha);
    }

    public void addListaSaves(List<Save> saves) {
        int indice = getRowCount();
        linhas.addAll(saves);

        fireTableRowsInserted(indice, indice + saves.size());
    }

    public void limpar() {
        linhas.clear();
        fireTableDataChanged();
    }
}
