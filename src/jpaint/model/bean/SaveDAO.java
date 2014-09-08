/*
 * classe DAO  para save
 */
package jpaint.model.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jpaint.model.connection.BancoDados;
import oracle.jrockit.jfr.tools.ConCatRepository;

/**
 *
 * @author pompeu
 */
public class SaveDAO {

    private static Connection con = null;
    private static PreparedStatement preparar;

    /**
     * Metodo que grava nome de saves no banco
     *
     * @param nome
     */
    public static void save(String nome) {

        String sql = ("INSERT INTO FIGURAS_SALVAS (PK_SAVE,SAVE_NAME) VALUES (?,?)");

        con = BancoDados.getConnection();
        try {
            preparar = con.prepareStatement(sql);
            preparar.setInt(1, pegarProximaChave());
            preparar.setString(2, nome);
            preparar.execute();

            BancoDados.closeConnection();

        } catch (SQLException ex) {
            Logger.getLogger(SaveDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Metodo pega o maior valor de chave inserido no banco e o retorna
     *
     * @return pkMaxKey
     */
    public static int pegarProximaChave() {
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
}
