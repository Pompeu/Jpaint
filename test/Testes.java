/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Color;
import java.util.List;
import jpaint.controller.SaveController;
import jpaint.model.bean.DAO.SaveDAO;
import jpaint.model.bean.Figura;
import jpaint.model.bean.Figuras;
import jpaint.model.bean.Triangulo;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author pompeu
 */
public class Testes {

    public Testes() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void teseSaveNovasFiguras() {
        
        int tamhoAtualListFiguras = SaveDAO.retreveSaveListItens(2).getFigs().size();

        Figuras listFigurasNovas = SaveDAO.retreveSaveListItens(2);
        /*for (final Figura f : listFigurasNovas.getFigs()) {
            System.out.println(f);
        }*/
        listFigurasNovas.getFigs().add(new Triangulo(20,
                20, 35, 35,
                45, Color.RED, Color.BLACK));
        listFigurasNovas.getFigs().add(new Triangulo(20,
                20, 35, 32,
                45, Color.RED, Color.BLACK));
        SaveController save = new SaveController();
        List<Figura> figuras = listFigurasNovas.getFigs().subList(tamhoAtualListFiguras, listFigurasNovas.getFigs().size());
        for (Figura figura : figuras) {
            System.out.println(figura);
        }
        Assert.assertEquals(2, figuras.size());
        
    }
}
