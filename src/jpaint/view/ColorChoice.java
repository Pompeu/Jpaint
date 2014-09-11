/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpaint.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.colorchooser.ColorSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author pompeu
 */
public class ColorChoice extends JFrame {

    private final JButton btnSelect = new JButton("Selecionar");
    private final JColorChooser selectColor = new JColorChooser();
    private Color color;

    public ColorChoice() {
        super("Escolha a Cor");
        initComponentes();

    }

    private void initComponentes() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.add(btnSelect, BorderLayout.SOUTH);
        this.add(selectColor, BorderLayout.CENTER);
        this.pack();
        this.setVisible(true);
        selectColor.setBorder(BorderFactory.createTitledBorder("Selecione uma cor"));

        ColorSelectionModel modelSelection = selectColor.getSelectionModel();
        ChangeListener escutaCampos = new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                btnSelect.setForeground(selectColor.getColor());
                btnSelect.setBackground(selectColor.getColor().darker());
            }
        };

        final JLabel visaoPrevia = new JLabel("COR SELECIONADA", JLabel.CENTER);
        visaoPrevia.setFont(new Font("serif", Font.BOLD | Font.CENTER_BASELINE, 48));
        visaoPrevia.setSize(visaoPrevia.getPreferredSize());
        visaoPrevia.setBorder(BorderFactory.createEmptyBorder(0, 0, 1, 0));
        selectColor.setPreviewPanel(visaoPrevia);

        modelSelection.addChangeListener(escutaCampos);

    }

    public JButton getBtnSelect() {
        return btnSelect;
    }

}
