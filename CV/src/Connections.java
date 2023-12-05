import java.sql.Connection;
import java.sql.DriverManager;
public class Connections {
    public static Connection con;
    static {
        try
        {
            String url="jdbc:mysql://localhost/GestionCV";
            String login="root";
            String passwd="";
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(url,login,passwd);
            System.out.println("Connected successfully");
        }catch(Exception e) {
            e.getMessage();
        }
    }
    public static Connection getConnection() {
        return con;
    }
}