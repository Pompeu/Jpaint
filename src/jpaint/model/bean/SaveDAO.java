/*
 * classe DAO  para save
 */
package jpaint.model.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    public static Set retreveSaveName() {
        Set nomes = new HashSet<String>();
        String sql = "SELECT SAVE_NAME FROM FIGURAS_SAVE";
        con = BancoDados.getConnection();
        try {
            preparar = con.prepareStatement(sql);

            ResultSet rs = preparar.executeQuery();

            while (rs.next()) {
                nomes.add(rs.getString("SAVE_NAME"));

            }
            BancoDados.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(SaveDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nomes;
    }
}
