/*
 * classe DAO  para save
 */
package jpaint.model.bean.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jpaint.model.bean.Figura;
import jpaint.model.bean.Figuras;
import jpaint.model.bean.SaveModel;
import jpaint.model.connection.BancoDados;

/**
 *
 * @author pompeu
 */
public class SaveDAO {

    private static Connection con = null;
    private static PreparedStatement preparar;

    /**
     * Metodo que grava nome de save no banco
     *
     * @param nome
     * @return pkKey
     */
    public static int save(String nome) {

        String sql = ("INSERT INTO FIGURAS_SALVAS (PK_SAVE,SAVE_NAME) VALUES (?,?)");
        int pkKey = pegarProximaChave();
        con = BancoDados.getConnection();
        try {
            preparar = con.prepareStatement(sql);
            preparar.setInt(1, pkKey);
            preparar.setString(2, nome);
            preparar.execute();
            BancoDados.closeConnection();

        } catch (SQLException ex) {
            Logger.getLogger(SaveDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pkKey;
    }

    /**
     * Metodo pega o maior valor de chave inserido no banco e o retorna
     *
     * @return pkMaxKey
     */
    private static int pegarProximaChave() {
        String sql = ("SELECT MAX(PK_SAVE) FROM FIGURAS_SALVAS");
        int pkMaxKey = 0;
        con = BancoDados.getConnection();
        try {
            preparar = con.prepareStatement(sql);
            ResultSet rs = preparar.executeQuery();
            while (rs.next()) {
                pkMaxKey = rs.getInt("MAX");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SaveDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pkMaxKey + 1;
    }

    /**
     * Esse metodo seleciona um lista de figuras no banco atavez da view
     * Figuras_save que é um join entre Figura e Figuras usa o nome do Save como
     * filtro.
     *
     * @param nome
     * @return listaFigurasFiltradas
     */
    public static ArrayList<Figura> retreveSaveList(String nome) {
        ArrayList<Figura> listFigurasFiltradas = new ArrayList<>();

        String sql = "SELECT x,y,largura,altura,tipo,pk_figura,"
                + "r_b,g_b,b_b,r_i,g_i,b_i FROM FIGURAS_SAVE WHERE SAVE_NAME = ?";
        con = BancoDados.getConnection();
        try {
            preparar = con.prepareStatement(sql);
            preparar.setString(1, nome);
            ResultSet rs = preparar.executeQuery();

            while (rs.next()) {
                listFigurasFiltradas.add(FiguraDAO.toFigura(rs));
            }
            BancoDados.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(SaveDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listFigurasFiltradas;
    }

    /**
     * recupera uma lista de figuras salvas do banco de acordo com seu parametro
     *
     * @param fkKey
     * @return
     */
    public static Figuras retreveSaveListItens(int fkKey) {
        Figuras listFigurasFiltradas = new Figuras();
        String sql = "SELECT * FROM FIGURA WHERE FK_SAVE = ?";
        con = BancoDados.getConnection();
        try {
            preparar = con.prepareStatement(sql);
            preparar.setInt(1, fkKey);
            ResultSet rs = preparar.executeQuery();

            while (rs.next()) {
                listFigurasFiltradas.getFigs().add(FiguraDAO.toFigura(rs));
            }
            BancoDados.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(SaveDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listFigurasFiltradas;
    }
    /**
     * esse metodo recupera um chave primaria de um save
     * @param nome
     * @return pkKey
     */
    public static int recuperaPkKey(String nome) {
        SaveModel save = new SaveModel(-1, "");

        String sql = "SELECT * FROM FIGURAS_SALVAS WHERE SAVE_NAME = ?";
        con = BancoDados.getConnection();
        try {
            preparar = con.prepareStatement(sql);
            preparar.setString(1, nome);
            ResultSet rs = preparar.executeQuery();

            rs.next();
            save = new SaveModel(rs.getInt("PK_SAVE"), rs.getString("SAVE_NAME"));

            BancoDados.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(SaveDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return save.getPkSave();
    }

    /**
     * esse metodo retorna um lista com todos saves do banco
     *
     * @return namesSaved
     */
    public static List<SaveModel> retreveSaveName() {
        List<SaveModel> names = new ArrayList<>();
        String sql = "SELECT * FROM FIGURAS_SALVAS";
        con = BancoDados.getConnection();
        try {
            preparar = con.prepareStatement(sql);

            ResultSet rs = preparar.executeQuery();

            while (rs.next()) {
                SaveModel nome = new SaveModel(rs.getInt("PK_SAVE"), rs.getString("SAVE_NAME"));
                names.add(nome);
            }
            BancoDados.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(SaveDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return names;
    }
}
