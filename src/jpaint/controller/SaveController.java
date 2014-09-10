/*
 * Classe pra controlar o save
 * salvar figuras no banco de dados
 * 
 */
package jpaint.controller;

import jpaint.model.bean.Figura;
import jpaint.model.bean.FiguraDAO;
import jpaint.model.bean.Figuras;
import jpaint.model.bean.SaveDAO;

/**
 *
 * @author pompeu
 */
public class SaveController {
    /**
     * metodo que sava novas figuras no banco de acordo com  nome do save
     * @param figs
     * @param nome 
     */
    public void savarFigurasNome(Figuras figs, String nome) {
        int fkkey = SaveDAO.save(nome);
        for (Figura f : figs.getFigs()) {
            FiguraDAO.create(f, fkkey);
        }
    }
    
}