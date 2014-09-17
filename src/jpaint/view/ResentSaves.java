/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpaint.view;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JMenuItem;
import jpaint.model.bean.SaveModel;
import jpaint.model.bean.DAO.SaveDAO;

/**
 *
 * @author pompeu
 */
public class ResentSaves extends JMenuItem {

    private final Set<JMenuItem> savesRecetes = new HashSet<>();
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

    public Set<JMenuItem> getSavesRecetes() {
        return savesRecetes;
    }

    /**
     * esse metodo faz com a lista de nomes dos saves venham para o submenu
     *
     */
    public void addNomesJMenu() {
        List<SaveModel> saveList = SaveDAO.retreveSaveName();
        for (SaveModel s : saveList) {
            savesRecetes.add(new JMenuItem(s.getSaveName()));
        }

    }

}
