/**
 * essa classe é basedado no padrão DAO que por sua vez faz a persistencia no
 * banco de dados
 *
 */
package jpaint.model.bean;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import jpaint.model.connection.BancoDados;

/**
 *
 * @author IFGoiano
 */
public class FiguraDAO {
    /*  atribiltos potegidos da classe FiguraDAO
     que tem obojetivo serem reutilizados internamente
     em toda classe dentos dos metodos de persistencia
     */

    protected static PreparedStatement preparar;
    protected static Connection con = null;

    /**
     * metodo que persiste uma figura no banco de dados
     *
     * @param f
     * @param fkKey
     * @return pkFigura
     */
    public static int create(Figura f, int fkKey) {
        if (f.getPkfigura() != -1) {
            return -1;
        }

        try {
            String sql = ("INSERT INTO FIGURA(x, y, largura, altura,"
                    + "tipo,"
                    + "color_border,"
                    + "color_internal,"
                    + "fk_save)"
                    + " values(?,?,?,?,?,?,?,?)");
            con = BancoDados.getConnection();
            /**/
            preparar = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            preparar.setInt(1, f.getX());
            preparar.setInt(2, f.getY());
            preparar.setInt(3, f.getLargura());
            preparar.setInt(4, f.getAltura());
            preparar.setInt(5, f.getTipo());
            preparar.setInt(6, f.getColorBorda().getRGB());
            preparar.setInt(7, f.getColorInternal().getRGB());
            preparar.setInt(8, fkKey);
            preparar.execute();
            /* pega a chave */
            ResultSet rs = preparar.getGeneratedKeys();
            rs.next();
            int pk = rs.getInt(1);
            BancoDados.closeConnection();
            return pk;
        } catch (SQLException ex) {
            Logger.getLogger(FiguraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    /*
     * metodo usado pela classe FiguraDao para organizar a recuperação de figura
     * do banco de dados, usando atribultos final Static e um switch case para
     * isso e ele é usado internemnto por outro metodos;
     * casa figura possue cor de bora de fundo
     * sao usadas rgb para recuperar a cor que foi salva no banco
     * @param pkFigura
     * @param rs
     * @return figura (com sua chave primarioa)
     * @throws SQLException
     */
    public static Figura toFigura(ResultSet rs) throws SQLException {
        Figura f;
        switch (rs.getInt("tipo")) {
            case Figuras.CIRCULO:
                f = new Circulo(rs.getInt("x"), rs.getInt("y"), rs.getInt("largura"),
                        rs.getInt("tipo"),
                        new Color(rs.getInt("color_border")),
                        new Color(rs.getInt("color_internal")));
                break;
            case Figuras.ELIPSE:
                f = new Elipse(rs.getInt("x"), rs.getInt("y"), rs.getInt("largura"),
                        rs.getInt("altura"),
                        rs.getInt("tipo"),
                        new Color(rs.getInt("color_border")),
                        new Color(rs.getInt("color_internal")));
                break;

            case Figuras.QUADRADO:
                f = new Quadrado(rs.getInt("x"), rs.getInt("y"),
                        rs.getInt("largura"), rs.getInt("tipo"),
                        new Color(rs.getInt("color_border")),
                        new Color(rs.getInt("color_internal")));
                break;
            case Figuras.RETANGULO:
                f = new Retangulo(rs.getInt("x"), rs.getInt("y"),
                        rs.getInt("largura"), rs.getInt("altura"), rs.getInt("tipo"),
                        new Color(rs.getInt("color_border")),
                        new Color(rs.getInt("color_internal")));
                break;
            case Figuras.TRIANGULO:
                f = new Triangulo(rs.getInt("x"), rs.getInt("y"),
                        rs.getInt("largura"), rs.getInt("altura"), rs.getInt("tipo"),
                        new Color(rs.getInt("color_border")),
                        new Color(rs.getInt("color_internal")));
                break;
            default:
                throw new AssertionError();
        }
        f.setPkfigura(rs.getInt("pk_figura"));
        return f;
    }

    /**
     * O metodo retreve recupera uma figura do banco de dados usando sua chave
     * primaria.
     *
     * @param pkFigura
     * @return
     */
    public static Figura retreve(int pkFigura) {
        try {
            String sql = ("SELECT* FROM FIGURA WHERE PK_FIGURA=?");
            con = BancoDados.getConnection();

            preparar = con.prepareStatement(sql);

            preparar.setInt(1, pkFigura);

            ResultSet rs = preparar.executeQuery();
            rs.next();
            BancoDados.closeConnection();
            return toFigura(rs);
        } catch (SQLException ex) {
            Logger.getLogger(FiguraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

    }

    /**
     * Esse metodo recupera todas as figuras do banco de dados
     *
     * @return ListaFiguras
     */
    public static ArrayList<Figura> retreveAll() {
        ArrayList<Figura> listaFiguras = new ArrayList<>();

        try {
            String sql = ("SELECT * FROM FIGURA");
            con = BancoDados.getConnection();
            /**/
            preparar = con.prepareStatement(sql);

            ResultSet rs = preparar.executeQuery();
            while (rs.next()) {
                listaFiguras.add(toFigura(rs));
            }
            BancoDados.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(FiguraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaFiguras;

    }

    /**
     * metodo que atuliza figuras no banco de dados
     *
     * @param f
     */
    public static void update(Figura f) {
        if (f.getPkfigura() == -1) {
            try {
                throw new Exception("Objeto não persitido");
            } catch (Exception ex) {
                Logger.getLogger(FiguraDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        try {
            String sql = ("UPDATE FIGURA SET x=?, y=?, largura=?, altura=? "
                    + "WHERE PK_FIGURA =?");
            con = BancoDados.getConnection();
            /**/
            preparar = con.prepareStatement(sql);
            preparar.setInt(1, f.getX());
            preparar.setInt(2, f.getY());
            preparar.setInt(3, f.getLargura());
            preparar.setInt(4, f.getAltura());
            preparar.setInt(5, f.getPkfigura());

            preparar.execute();
            BancoDados.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(FiguraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * esse metodo deleta uma figura do banco de dados preciado
     *
     * @param f
     */
    public static void drop(Figura f) {
        if (f.getPkfigura() == -1) {
            try {
                throw new Exception("Objeto não persitido");
            } catch (Exception ex) {
                Logger.getLogger(FiguraDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            String sql = ("DELETE FROM FIGURA WHERE PK_FIGURA =?");
            con = BancoDados.getConnection();
            preparar = con.prepareStatement(sql);
            preparar.setInt(1, f.getPkfigura());
            preparar.execute();
            BancoDados.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(FiguraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
