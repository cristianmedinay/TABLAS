import paneles.Panel1;
import paneles.Panel2;
import paneles.Panel3;
import paneles.Panel4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends JFrame implements ActionListener {

    Container container;
    Panel1 panel1;
    Panel2 panel2;
    Panel3 panel3;
    Panel4 panel4;
    JTabbedPane panelPestanias;

    public void initGUI(){
        instancias();
        configuradorContainer();
        acciones();
        this.setSize(new Dimension(350,400));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        setVisible(true);

    }

    private void acciones() {

    }

    private void instancias() {
        container = this.getContentPane();
        panelPestanias = new JTabbedPane(SwingConstants.TOP);
        panel3 = new Panel3();
        panel2= new Panel2();
        panel4 = new Panel4();
        panel1= new Panel1(panel2,panel3,panel4);

    }

    private void configuradorContainer() {
        container.add(panelPestanias);
        panelPestanias.addTab("Altas",panel1);
        panelPestanias.addTab("Bajas",panel2);
        panelPestanias.addTab("Modificaciones",panel3);
        panelPestanias.addTab("Resumen",panel4);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
