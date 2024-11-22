import entidades.Alumno;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try {
            ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>();

            Alumno a1 = new Alumno();
            a1.setMatricula("0000");
            a1.setNombre("Pedro");
            a1.setApellidoPat("Jimenez");
            a1.setApellidoMat("Perez");
            a1.setEdad(19);

            Alumno a2 = new Alumno();
            a2.setMatricula("0001");
            a2.setNombre("Ana");
            a2.setApellidoPat("Gutierrez");
            a2.setApellidoMat("Sanchez");
            a2.setEdad(18);

            Alumno a3 = new Alumno();
            a3.setMatricula("0002");
            a3.setNombre("Juan");
            a3.setApellidoPat("Lopez");
            a3.setApellidoMat("Pedroza");
            a3.setEdad(21);

            listaAlumnos.add(a1);
            listaAlumnos.add(a2);
            listaAlumnos.add(a3);

            FileOutputStream escribir = new FileOutputStream("c:\\temp\\baseDatos\\alumnos.txt");
            ObjectOutputStream miStream = new ObjectOutputStream(escribir);
            miStream.writeObject(listaAlumnos);
            miStream.flush();
            miStream.close();
        }catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}