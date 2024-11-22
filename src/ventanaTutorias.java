import entidades.Alumno;
import metodos.AlumnosCRUD;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ventanaTutorias extends JFrame {
    private JPanel miPanel;
    private JComboBox cmbAlumno;
    private JComboBox cmbProfesor;
    private JTextField txtFecha;
    private JTextArea txtObserv;
    private JButton btnIngresar;
    private JButton button2;
    private JButton button3;
    private JTextField txtAlumno;
    private JComboBox cmbDia;
    private JComboBox cmbMes;
    private JComboBox cmbAnio;
    ArrayList<Alumno> lista;

    public boolean validaFecha(String fecha){
        SimpleDateFormat formatoFecha =
                new SimpleDateFormat("dd/MM/yyyy");
        try {
            formatoFecha.setLenient(false);
            formatoFecha.parse(fecha);
            return true;
        } catch (ParseException e) {
            return false;
        }


    }


    //método constructor
    public ventanaTutorias(){
        //conectarme al archivo y extraer la lista
        try {
            FileInputStream leer =
                    new FileInputStream("c:\\temp\\basedatos\\alumnos.txt");
            ObjectInputStream lectorObjetos = new ObjectInputStream(leer);
            Object o = lectorObjetos.readObject();
            lista = (ArrayList<Alumno>) o;

            for(Alumno a: lista)
            {
                cmbAlumno.addItem(  a.getMatricula() ) ;
                lectorObjetos.close();
                leer.close();}

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        cmbAlumno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AlumnosCRUD crud=new AlumnosCRUD();
                String mat = cmbAlumno.getSelectedItem().toString();
                String nombreCompleto;
                Alumno a = crud.getInfoAlumnoPorMatricula(mat);
                nombreCompleto = a.getNombre() + " " + a.getApellidoPat();
                txtAlumno.setText(nombreCompleto);
            }
        });
        btnIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fecha = cmbDia.getSelectedItem().toString() + "/" + cmbMes.getSelectedItem().toString() + "/" + cmbAnio.getSelectedItem().toString() ;

                boolean resultado = validaFecha(fecha);
                if(resultado==true)
                {
                    JOptionPane.showMessageDialog(miPanel,"todo ok con la fecha");
                }
                else {
                    JOptionPane.showMessageDialog(miPanel,"Error en la fecha");
                }
            }
        });
    }

    public static void main(String[] args) {
        ventanaTutorias t = new ventanaTutorias();
        t.setContentPane(t.miPanel);
        t.setSize(500,500);
        t.setTitle("Tutorías");
        t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        t.setVisible(true);

    }

}
