import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class MySQL_Form {
    private JButton queryButton;
    private JPanel rootPanel;
    private JLabel labelID;
    private JLabel labelName;
    private JLabel showID;
    private JLabel showName;
    //conexion a base de datos mysql
    static final String DB_URL="jdbc:mysql://localhost/RegistroEstudiantes"; //cadena de conexion
    static final String USER="root"; //usuario
    static final String PASS="root_bas3"; //password
    static final String QUERY="SELECT * from estudiantes"; //query
    public MySQL_Form() {
        queryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    //primero establecer la conexion
                    try(
                            Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
                            Statement stmt = conn.createStatement();
                            ResultSet rs = stmt.executeQuery(QUERY);
                    ){
                        //muestraVentanaShowSQL();

                        //labelID.setText(rs.getString("id_est")+rs.getString("nombre_est"));


                        while (rs.next()){
                            System.out.println("ID:"+rs.getInt("id_est"));
                            System.out.println("Nombre:"+rs.getString("nombre_est"));
                            System.out.println("Edad:"+rs.getInt("edad_est"));
                            System.out.println("Ciudad:"+rs.getString("ciudad_est"));
                            System.out.println("Cedula:"+rs.getInt("cedula_est")+"\n");
                            //System.out.println("Password:"+rs.getInt("password_est")+"\n");
                        }

                        showID.setText(rs.getString("id_est"));
                        showName.setText(rs.getString("nombre_est"));


                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("MySQL_Form");
        frame.setContentPane(new MySQL_Form().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public void muestraVentanaShowSQL(){
        JFrame frame = new JFrame("Show_MySQL");
        frame.setContentPane(new Show_MySQL().showPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
