import entidades.Alumno;
import metodos.AlumnosCRUD;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ventanaAlumnos extends JFrame {
    private JPanel miPanel;
    private JTextField txtMatricula;
    private JTextField txtNombre;
    private JTextField txtApPaterno;
    private JTextField txtApMaterno;
    private JTextField txtEdad;
    private JButton btnBuscar;
    private JButton btnAgregar;
    private JButton btnGuardar;
    private JButton btnEliminar;
    private JComboBox comboBox1;

    public ventanaAlumnos() {
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AlumnosCRUD crud = new AlumnosCRUD();
                String matricula = txtMatricula.getText();
                Alumno a = crud.getInfoAlumnoPorMatricula(matricula);
                if(a == null){
                    int respuesta = JOptionPane.showConfirmDialog(miPanel,"No se encuentra información del alumno con matrícula " + matricula + ". ¿Desea ingresarlo?","Alumnos",JOptionPane.YES_NO_OPTION);
                    if(respuesta == 0){
                        //sí quiere dar de alta el alumno inexistente
                        btnAgregar.setEnabled(true);
                        txtNombre.requestFocus();
                    }else if(respuesta == 1) {
                        //no quiere dar de alta
                        //limpiar formulario
                        //invocamos metodo para limpiar
                    }

                }
                else{
                    //se encontro el alumno
                    txtNombre.setText( a.getNombre() );
                    txtApPaterno.setText( a.getApellidoPat() );
                    txtApMaterno.setText(a.getApellidoMat());
                    txtEdad.setText( String.valueOf( a.getEdad() ) );
                    btnGuardar.setEnabled(true);
                    btnEliminar.setEnabled(true);
                }
            }
        });
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //instanciar objeto de la clase Alumno
                Alumno miAlumno = new Alumno();
                miAlumno.setMatricula( txtMatricula.getText() );
                miAlumno.setNombre( txtNombre.getText() );
                miAlumno.setApellidoPat(txtApPaterno.getText());
                miAlumno.setApellidoMat(txtApMaterno.getText());
                miAlumno.setEdad( Integer.parseInt( txtEdad.getText() ) );

                //invocar metodo de agregarAlumno
                AlumnosCRUD crud = new AlumnosCRUD();
                crud.agregarAlumno(miAlumno);
            }
        });
    }

    public static void main(String[] args) {
        ventanaAlumnos v = new ventanaAlumnos();
        v.setContentPane(v.miPanel);
        v.setSize(500,500);
        v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        v.setVisible(true);
    }
}
