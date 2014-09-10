/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpaint.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import jpaint.model.bean.Figura;
import jpaint.model.bean.Figuras;
import jpaint.model.bean.SaveDAO;

/**
 *
 * @author pompeu
 */
public final class RecuperarSaves {

    private final JFrame j = new JFrame("Carregar um Save");
    private final JLabel iNome = new JLabel("Nome do Save");
    private final JButton btnCerragar = new JButton("Carregar");
    private final JTextField tfNomeSave = new JTextField(10);
    private ArrayList<Figura> figs;

    public RecuperarSaves() {
        initItens();
    }

    public void initItens() {
        j.setTitle("Pegar Saves");
        j.setSize(200, 100);
        j.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        j.setLocationRelativeTo(null);
        j.setVisible(true);
        j.setLayout(new BorderLayout());
        j.add(iNome, BorderLayout.NORTH);
        j.add(btnCerragar, BorderLayout.SOUTH);
        j.add(tfNomeSave, BorderLayout.CENTER);
        btnCarregarAction();

    }

    public void btnCarregarAction() {
        btnCerragar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                figs = SaveDAO.retreveSaveList(tfNomeSave.getText());
                j.dispose();
            }
        });
    }

    public ArrayList<Figura> getFigs() {
        return figs;
    }

    public void setFigs(ArrayList<Figura> figs) {
        this.figs = figs;
    }
    

}
