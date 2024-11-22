package metodos;

import entidades.Alumno;

import java.io.*;
import java.util.ArrayList;

public class AlumnosCRUD {

    public void agregarAlumno(Alumno a){
        //1) leer lista desde el archivo
        try{
            FileInputStream leer =
                    new FileInputStream("c:\\temp\\basedatos\\alumnos.txt");
            ObjectInputStream lectorObjetos = new ObjectInputStream(leer);
            Object o = lectorObjetos.readObject();
            ArrayList<Alumno> lista = (ArrayList<Alumno>) o;

            //2) Agregar alumno a la lista
            lista.add(a);
            lectorObjetos.close();
            leer.close();

            //3) Escribir lista al archivo
            FileOutputStream escribir =
                    new FileOutputStream("c:\\temp\\basedatos\\alumnos.txt");
            ObjectOutputStream escritorObjetos = new ObjectOutputStream(escribir);
            escritorObjetos.writeObject(lista);
            escritorObjetos.flush();

            escritorObjetos.close();
            escribir.close();

        }catch(FileNotFoundException e){
            System.out.println("Error al leer el archivo");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Alumno getInfoAlumnoPorMatricula(String matricula){
        //leer el archivo y traerse la lista de alumnos
        FileInputStream leer;
        try {
             leer = new FileInputStream("c:\\temp\\basedatos\\alumnos.txt");
            ObjectInputStream miStream2 = new ObjectInputStream(leer);
            Object miLista = miStream2.readObject();
            ArrayList<Alumno> listaAlumnos = (ArrayList<Alumno>) miLista;
            Alumno k;
            for(int i=0; i<listaAlumnos.size();i++)
            {
                k = listaAlumnos.get(i);
                if(matricula.equals(k.getMatricula()))
                {
                    leer.close();
                   return k;
                }

            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            leer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public void actualizarAlumno(){

    }

    public void eliminarAlumno(){

    }
}
