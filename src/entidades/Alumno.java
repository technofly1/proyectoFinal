package entidades;

import java.io.Serializable;

public class Alumno implements Serializable {
    private String matricula, nombre, apellidoPat, apellidoMat;
    private int edad;

    public Alumno(){
        System.out.println("Se mandó llamar el constructor");
    }
    public Alumno(String n){
        this.nombre = n;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPat() {
        return apellidoPat;
    }

    public void setApellidoPat(String apellidoPat) {
        this.apellidoPat = apellidoPat;
    }

    public String getApellidoMat() {
        return apellidoMat;
    }

    public void setApellidoMat(String apellidoMat) {
        this.apellidoMat = apellidoMat;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
