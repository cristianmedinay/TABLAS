package paneles;

import utils.Datos;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

public class Panel3 extends JPanel implements ActionListener, ChangeListener {
    private JComboBox lista,jc;
    private DefaultComboBoxModel modelo;
    Container container;
    ButtonGroup buttonGroup;
    JButton modificar,limpiar;
    JPanel panelinferior,panelCentro,panelSuperior,panelinferior2,centro;
    JLabel l1,l2,l3,l4,l5,l6,l7;
    JTextField j1,j2,j3,j4,j5,j6,j7;
    public Panel3() {

        initGUI();
    }

    public void initGUI() {
        instancias();

        // rellenarEstilos();
        configurarPanel();
        acciones();
    }

    private void acciones() {
        lista.addActionListener(this);
        modificar.addActionListener(this);
        limpiar.addActionListener(this);
    }

    private void configurarPanel() {
        this.setLayout(new BorderLayout());
        this.add(panel0(),BorderLayout.NORTH);
        this.add(panel(),BorderLayout.CENTER);

        this.add(panel3(),BorderLayout.SOUTH);

    }

    private JPanel panel() {
        centro.setLayout(new GridLayout(2,1));
        centro.add(panelCentro);
        centro.add(panelinferior);
        panel1();
        panel2();
        return centro;
    }


    private JPanel panel0() {
        panelSuperior.setLayout(new GridLayout(1,2));
        panelSuperior.add(lista);

        return panelSuperior;
    }

    private JPanel panel3(){
        panelinferior2.add(modificar,BorderLayout.CENTER);
        panelinferior2.add(limpiar,BorderLayout.CENTER);
        return panelinferior2;
    }
    private void panel2() {

        panelinferior.setLayout(new GridLayout(3, 2));
        panelinferior.add(l5);
        panelinferior.add(j5);
        panelinferior.add(l6);
        panelinferior.add(j6);
        panelinferior.add(l7);
        panelinferior.add(j7);

    }

    public void panel1(){
        panelCentro.setLayout(new GridLayout(3,2));
        panelCentro.add(l2);
        panelCentro.add(j2);
        panelCentro.add(l3);
        panelCentro.add(j3);
        panelCentro.add(l4);
        panelCentro.add(j4);


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
        modificar=new JButton("Modificar");
        limpiar =new JButton("Limpiar");

        panelCentro = new JPanel();
        panelCentro.setBorder(BorderFactory.createTitledBorder("Datos Personales"));
        panelinferior = new JPanel();
        panelinferior.setBorder(BorderFactory.createTitledBorder("Direccion"));
        centro = new JPanel();
        panelinferior2 = new JPanel();
        panelSuperior = new JPanel();
        panelSuperior.setBorder(BorderFactory.createTitledBorder("Seccion clave"));
        modelo = new DefaultComboBoxModel();
        lista = new JComboBox(modelo);
        //l = new JLabel("Clave");
        j2.setEditable(false);
        j3.setEditable(false);
        j4.setEditable(false);
        j5.setEditable(false);
        j6.setEditable(false);
        j7.setEditable(false);

    }
    public DefaultComboBoxModel getModelo() {

        return modelo;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == lista) {
            Datos d = (Datos) lista.getModel().getSelectedItem();
            String nombre = d.getNombre();
            String apellido = d.getApellido();
            String calle = d.getCalle();
            int numero = d.getNumero();
            int edad = d.getEdad();
            int cd = d.getCd();
            j2.setText(nombre);j3.setText(apellido);j4.setText(calle);j5.setText(Integer.toString(numero));
            j6.setText(Integer.toString(edad));j7.setText(Integer.toString(cd));
        } else if (e.getSource()== modificar){
                j2.setEditable(true);
                j3.setEditable(true);
                j4.setEditable(true);
                j5.setEditable(true);
                j6.setEditable(true);
                j7.setEditable(true);
        }else if (e.getSource() == limpiar){

        }

    }

    @Override
    public void stateChanged(ChangeEvent e) {

    }
}
