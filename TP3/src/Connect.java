import java.sql.Connection;
import java.sql.DriverManager;

class Connect{
private static Connection con;
    static{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver ok");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/catalogue","root","");
            System.out.println("Connection ok");
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() {
        return con;
    }
}