import java.sql.*;
import java.util.Stack;

public class MiPrimerSelect {
    //conexion a base de datos mysql
    static final String DB_URL="jdbc:mysql://localhost/RegistroEstudiantes"; //cadena de conexion
    static final String USER="root"; //usuario
    static final String PASS="root_bas3"; //password
    static final String QUERY="SELECT * from estudiantes"; //query

    public static void main(String[] args) {
        //primero establecer la conexion
        try(
                Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(QUERY);
            ){
            while (rs.next()){
                System.out.println("ID:"+rs.getInt("id_est"));
                System.out.println("Nombre:"+rs.getString("nombre_est"));
                System.out.println("Edad:"+rs.getInt("edad_est"));
                System.out.println("Ciudad:"+rs.getString("ciudad_est"));
                System.out.println("Cedula:"+rs.getInt("cedula_est")+"\n");
                //System.out.println("Password:"+rs.getInt("password_est")+"\n");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
