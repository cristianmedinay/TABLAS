package paneles;

import utils.Datos;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import static java.awt.BorderLayout.NORTH;

public class Panel1 extends JPanel implements ActionListener {

    Container container;
    JButton alta;
    JPanel panelinferior, panelCentro, panelSuperior;
    JLabel l1, l2, l3, l4, l5, l6, l7;
    JTextField j1, j2, j3, j4, j5, j6, j7;
    Panel2 panel2;
    Panel3 panel3;
    Panel4 panel4;
    public Panel1(Panel2 panel2, Panel3 panel3,Panel4 panel4) {
        this.panel2 = panel2;
        this.panel3 = panel3;
        this.panel4 = panel4;
        initGUI();
    }

    public void initGUI() {

        instancias();

        // rellenarEstilos();
        configurarPanel();
        acciones();
    }


    private void acciones() {
        alta.addActionListener(this);

    }

    private void configurarPanel() {
        this.setLayout(new BorderLayout());
        this.add(panel0(), BorderLayout.NORTH);
        this.add(panel1(), BorderLayout.CENTER);
        this.add(panel2(), BorderLayout.SOUTH);
    }

    public void configurarConstraint(int posX, int posY, int fill, int anchor
            , double pesX, double pesY, int tamX, int tamY, JComponent component) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = posX;
        constraints.gridy = posY;
        constraints.fill = fill;
        constraints.anchor = anchor;
        constraints.weightx = pesX;
        constraints.weighty = pesY;
        constraints.gridwidth = tamX;
        constraints.gridheight = tamY;
        panelinferior.add(component, constraints);
    }


    private JPanel panel0() {
        panelSuperior.setLayout(new GridLayout(4, 2));
        panelSuperior.add(l1);
        panelSuperior.add(j1);
        panelSuperior.add(l2);
        panelSuperior.add(j2);
        panelSuperior.add(l3);
        panelSuperior.add(j3);
        panelSuperior.add(l4);
        panelSuperior.add(j4);
        return panelSuperior;
    }

    private JPanel panel2() {

        panelinferior.add(alta, BorderLayout.CENTER);
        return panelinferior;
    }

    public JPanel panel1() {
        panelCentro.setLayout(new GridLayout(3, 2));
        panelCentro.add(l5);
        panelCentro.add(j5);
        panelCentro.add(l6);
        panelCentro.add(j6);
        panelCentro.add(l7);
        panelCentro.add(j7);
        return panelCentro;
    }

    private void instancias() {
        l1 = new JLabel("Clave:");
        l2 = new JLabel("Nombre:");
        l3 = new JLabel("Apellidos:");
        l4 = new JLabel("Edad:");
        l5 = new JLabel("Calle:");
        l6 = new JLabel("Numero:");
        l7 = new JLabel("Codigo Postal:");
        j1 = new JTextField();
        j2 = new JTextField();
        j3 = new JTextField();
        j4 = new JTextField();
        j5 = new JTextField();
        j6 = new JTextField();
        j7 = new JTextField();
        alta = new JButton("Dar de alta");
        panelCentro = new JPanel();
        panelCentro.setBorder(BorderFactory.createTitledBorder("Direccion"));
        panelinferior = new JPanel();
        panelSuperior = new JPanel();
        panelSuperior.setBorder(BorderFactory.createTitledBorder("Datos Personales"));
        //datosSpinner = new ArrayList();
        //l = new JLabel("Clave");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == alta) {
            if (j1.getText().isEmpty() || j2.getText().isEmpty() || j3.getText().isEmpty() ||
                    j4.getText().isEmpty() || j5.getText().isEmpty() || j6.getText().isEmpty() || j7.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Mensaje de WARNING", "Titulo", JOptionPane.INFORMATION_MESSAGE, null);
            } else {
                //System.out.println(spinnerEdad.getModel().getValue());
                String nombre = j2.getText();
                String apellido = j3.getText();
                String clave = j1.getText();
                String calle = j5.getText();
                int numero = Integer.valueOf(j6.getText());
                int edad = Integer.valueOf(j4.getText());
                int cd = Integer.valueOf(j7.getText());
                //boolean disponibilidad = cDisponible.isSelected();
                panel2.getModelo().addElement(new Datos(clave, nombre, apellido, calle, edad, numero, cd));
                panel3.getModelo().addElement(new Datos(clave, nombre, apellido, calle, edad, numero, cd));
                panel4.getModelo().addElement(new Datos(clave, nombre, apellido, calle, edad, numero, cd));

            }


            //panel2.getModelo().addElement(new Datos("ewq","saff", "asd","asd", 123,123,213));
        }

    }
}



