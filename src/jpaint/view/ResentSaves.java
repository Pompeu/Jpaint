/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpaint.view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JMenuItem;
import jpaint.model.bean.Save;
import jpaint.model.bean.SaveDAO;

/**
 *
 * @author pompeu
 */
public class ResentSaves extends JMenuItem {

    private final List<JMenuItem> savesRecetes = new ArrayList<>();
    private String[] nomes;
    public static ResentSaves rSave = null;

    private ResentSaves() {
        addNomesJMenu();
    }

    public static ResentSaves getInstace() {
        if (rSave == null) {
            rSave = new ResentSaves();
        }
        return rSave;
    }

    public List<JMenuItem> getSavesRecetes() {
        return savesRecetes;
    }

    public String[] getNomes() {
        return nomes;
    }

    public void setNomes(String[] nomes) {
        this.nomes = nomes;
    }

    /**
     * esse metodo faz com a lista de nomes dos saves venham para o submenu
     *
     */
    private void addNomesJMenu() {

        List<Save> saveList = SaveDAO.retreveSaveName();
        for (Save s : saveList) {
            savesRecetes.add(new JMenuItem(s.getSaveName()));
        }

    }

}
