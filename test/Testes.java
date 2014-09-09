/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Set;
import jpaint.model.bean.Figura;
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

    @Test
    public void testSaveDaoRetriveListSave() {
        String name = "maria";
        ArrayList<Figura> list = SaveDAO.retreveSaveList(name);

        list.stream().forEach(f -> System.out.println(f));

        Assert.assertEquals(2, list.size());
    }

    @Test
    public void saveDAOListName() {
        Set nomes = SaveDAO.retreveSaveName();
        nomes.stream().forEach(f -> System.out.println(f));
        Assert.assertEquals(2, nomes.size());
    }
}
