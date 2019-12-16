package utils;

public class Datos {

    String clave,nombre,apellido,calle;
    int edad,numero,cd;

    public Datos(String clave, String nombre, String apellido, String calle, int edad, int numero, int cd) {
        this.clave = clave;
        this.nombre = nombre;
        this.apellido = apellido;
        this.calle = calle;
        this.edad = edad;
        this.numero = numero;
        this.cd = cd;
    }


    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCd() {
        return cd;
    }

    public void setCd(int cd) {
        this.cd = cd;
    }

    @Override
    public String toString() {
        return getClave();
    }


}
