package utils;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class Tabla extends AbstractTableModel {

    ArrayList<Datos>datoslista;

    private String[] columnas;
    private Class[] tipos = {String.class, String.class, String.class, String.class, String.class, String.class, String.class};
    public Tabla(ArrayList<Datos> datoslista) {
        this.datoslista = datoslista;
        this.columnas = new String[]{"Clave", "Nombre", "Apellido", "Edad","Numero","Calle","Cd"};
    }

    @Override
    public int getRowCount() {
        return datoslista.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
            Datos  actual= datoslista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return actual.getClave();
            case 1:
                return actual.getNombre();
            case 2:
                return actual.getApellido();
            case 3:
                return actual.getEdad();
            case 4:
                return actual.getNumero();
            case 5:
                return actual.getCalle();
            case 6:
                return actual.getCd();
            default:
                return null;
        }
    }
    public void addDatos(Datos datos){
        datoslista.add(datos);
        fireTableDataChanged();
    }

    public void removeDatos(int index){
        datoslista.remove(index);
        fireTableDataChanged();
    }

    public Datos getPersona(int index){
        Datos encontrada = datoslista.get(index);
        return encontrada;
    }

    public Datos personaSeleccionada(int index){
        return datoslista.get(index);
    }

    public Datos[] getPersonaMultiple(int[] index){
        Datos[] personas= new Datos[index.length];
        for (int i=0; i<index.length;i++){
            personas[i]=getPersona(i);
        }
        return personas;
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return tipos[columnIndex];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

}
