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
     * metodo que sava novas figuras no banco de acordo com nome do save
     *
     * @param figs
     * @param nome
     */
    public void savarFigurasNome(Figuras figs, String nome) {
        int fkkey = SaveDAO.save(nome);
        for (Figura f : figs.getFigs()) {
            FiguraDAO.create(f, fkkey);
        }
    }

    /**
     * esse metodo recebe um nome e recupera uma lista de figuras
     *
     * @param nome
     * @return figs
     */
    public Figuras recuperarFigurasNome(String nome) {
        int fkKey = SaveDAO.recuperaPkKey(nome);
        Figuras figs = SaveDAO.retreveSaveListItens(fkKey);
        return figs;
    }
    /**
     * esse metodo ainda não esta completo
     * @param figs
     * @param fkKey 
     */
    public void savarNovasFiguras(Figuras figs, int fkKey) {
        for (Figura f : figs.getFigs()) {
            FiguraDAO.create(f, fkKey);
        }
    }
}
