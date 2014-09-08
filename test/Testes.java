/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import jpaint.controller.SaveController;
import jpaint.model.bean.Figura;
import jpaint.model.bean.FiguraDAO;
import jpaint.model.bean.Figuras;
import jpaint.model.bean.Quadrado;
import jpaint.model.bean.SaveDAO;
import jpaint.model.connection.BancoDados;
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
    public void testarSaveController() {
        String nome = "Pompeu5";

        Figura f = new Quadrado(10, 15, 20, 15, Color.darkGray, Color.lightGray);
        ArrayList<Figura> figuras = new ArrayList<>();
        int quantidade = 10;
        for (int i = 0; i < quantidade; i++) {
            figuras.add(f);
        }
        Figuras figs = new Figuras();
        figs.setFigs(figuras);
        int sizeAnterior = FiguraDAO.retreveAll().size();
        SaveController saveController = new SaveController();

        saveController.savarFigurasNome(figs, nome);

        Assert.assertTrue(FiguraDAO.retreveAll().size() == sizeAnterior + quantidade);

    }
}
