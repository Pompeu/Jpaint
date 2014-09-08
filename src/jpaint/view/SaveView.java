/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpaint.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author pompeu
 */
public class SaveView extends JFrame {

    private JLabel iName;
    private JLabel iMenssage;
    private JTextField tfName;
    private JButton btnSave;

    public SaveView() {
        super("Salvar");
        initComponents();

    }

    private void initComponents() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(300, 100);
        this.setLayout(new BorderLayout());
        this.setResizable(false);

        this.setLocationRelativeTo(null);
        this.setVisible(true);

        iName = new JLabel("Digite o nome");
        iMenssage = new JLabel("");
        tfName = new JTextField();
        btnSave = new JButton("Salvar");
        tfName.setFont(new Font(Font.SERIF, Font.BOLD, 25));
        
        this.add(iName,BorderLayout.NORTH);
        this.add(tfName, BorderLayout.CENTER);
        this.add(iMenssage, BorderLayout.SOUTH);
        this.add(btnSave, BorderLayout.AFTER_LINE_ENDS);

        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SaveView.this.dispose();
            }
        });

        tfName.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                iMenssage.setText(tfName.getText());
            }
        });
    }

    public static void main(String[] args) {
        new SaveView().setVisible(true);

    }
}
