package paneles;

import utils.Datos;
import utils.Tabla;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Panel4 extends JPanel implements ActionListener {

    private JComboBox lista,jc;
    private DefaultComboBoxModel modelo;
    JTable tabla;
    Tabla miModelo;
    Container container;
    JButton alta,baja;
    JPanel panelinferior,panelCentro,panelSuperior,norte;
    JLabel l1,l2,l3,l4,l5,l6,l7;
    JTextField j1,j2,j3,j4,j5,j6,j7;
    ArrayList<Datos> listaDatos;
  //  DefaultListModel modelo;
   //  JList lista;

    public Panel4() {

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
        baja.addActionListener(this);
    }

    private void configurarPanel() {
        this.setLayout(new BorderLayout());
        this.add(panel0(),BorderLayout.NORTH);
        this.add(panel1(),BorderLayout.CENTER);
        this.add(panel2(),BorderLayout.SOUTH);
    }

    private JPanel panel0() {
    norte.setLayout(new GridLayout(1,1));
    norte.add(new JScrollPane(tabla),BorderLayout.NORTH);
    return norte;
    }

    private JPanel panel1() {
        panelSuperior.setLayout(new GridLayout(7,2));
        //panelSuperior.add();
        panelSuperior.add(l1);
        panelSuperior.add(j1);
        panelSuperior.add(l2);
        panelSuperior.add(j2);
        panelSuperior.add(l3);
        panelSuperior.add(j3);
        panelSuperior.add(l4);
        panelSuperior.add(j4);
        panelSuperior.add(l5);
        panelSuperior.add(j5);
        panelSuperior.add(l6);
        panelSuperior.add(j6);
        panelSuperior.add(l7);
        panelSuperior.add(j7);
        return panelSuperior;

    }

    private JPanel panel2() {
        panelinferior.add(alta,BorderLayout.CENTER);
        panelinferior.add(baja,BorderLayout.CENTER);
        return panelinferior;
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
        alta =new JButton("Dar de alta");
        baja =new JButton("Dar de baja");
        norte = new JPanel();
        panelCentro = new JPanel();
        panelCentro.setBorder(BorderFactory.createTitledBorder("Direccion"));
        panelinferior = new JPanel();
        panelSuperior = new JPanel();
        panelSuperior.setBorder(BorderFactory.createTitledBorder("Datos"));
       modelo = new DefaultComboBoxModel();
        lista = new JComboBox(modelo);
         listaDatos = new ArrayList();
        rellenarDatos();
        miModelo= new Tabla(listaDatos);
        tabla = new JTable(miModelo);

    }

    public DefaultComboBoxModel getModelo() {

        return modelo;
    }


    private void rellenarDatos() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == alta){
            //miModelo.addDatos(new Datos("123","Maria","243141","",12,12,32));
            //Datos d = (Datos) lista.getModel().getSelectedItem();
            String nombre = j2.getText();
            String apellido = j3.getText();
            String clave = j1.getText();
            String calle = j5.getText();
            int numero = Integer.valueOf(j6.getText());
            int edad = Integer.valueOf(j4.getText());
            int cd = Integer.valueOf(j7.getText());

            miModelo.addDatos(new Datos(clave, nombre, apellido, calle, edad, numero, cd));

        }
        else if (e.getSource() == baja){
            if (tabla.getSelectedRow() !=1) {
                miModelo.removeDatos(tabla.getSelectedRow());
            }
        }


    }
}
