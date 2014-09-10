/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;
import jpaint.controller.SaveController;
import jpaint.model.bean.Figura;
import jpaint.model.bean.Figuras;
import jpaint.model.bean.Save;
import jpaint.model.bean.SaveDAO;
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
/*
    @Test
    public void testSaveDaoRetriveListSave() {
        String name = "maria";
        ArrayList<Figura> list = SaveDAO.retreveSaveList(name);
        list.stream().forEach(System.out::println);
        Assert.assertEquals(2, list.size());
    }

    @Test
    public void saveDAOListName() {
        List<Save> nomes = SaveDAO.retreveSaveName();
        nomes.stream().forEach(System.out::println);
        Assert.assertEquals(5, nomes.size());
    }
*/
    @Test
    public void testSaveRecuperarFiguras() {
        
        SaveController saveController = new SaveController();

        Figuras figs = saveController.recuperarFigurasNome("amora");
        
        Assert.assertEquals(5, figs.getFigs().size());
    }
       @Test
    public void testSaveRecuperarFigurasbyName() {
        String nome = "amora";      
        
        Assert.assertEquals(4, SaveDAO.recuperaPkKey(nome));
    }
}
