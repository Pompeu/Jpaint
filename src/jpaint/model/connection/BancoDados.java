
package jpaint.model.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BancoDados {

    private static Connection con;
    /**
     * esse metodo faz conecção com banco de dados
     * usado atribultos staticos para URL,User e PassWd
     * @return 
     */
    public static Connection getConnection() {
        if (con != null) {
            return con;
        }
        try {
            con = DriverManager.getConnection(ConnetionData.URL, ConnetionData.USER, ConnetionData.PASSWD);
        } catch (SQLException ex) {
            Logger.getLogger(BancoDados.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
    /**
     * esse metodo desliga a conecçao com banco de dados.
     */
    public static void closeConnection() {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(BancoDados.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        con = null;
    }
}
