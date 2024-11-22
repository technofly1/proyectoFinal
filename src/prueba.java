import entidades.Alumno;
import metodos.AlumnosCRUD;

public class prueba {

    public static void main(String[] args) {
        AlumnosCRUD aluCRUD = new AlumnosCRUD();
        Alumno resultado = aluCRUD.getInfoAlumnoPorMatricula("0000");
        if(resultado==null)
        {
            System.out.println("No se encuentra esa matricula");
        }else{
            System.out.println(resultado.getNombre());
            System.out.println(resultado.getApellidoPat());
            System.out.println(resultado.getEdad());
        }

    }
}
