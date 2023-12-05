import java.sql.Connection;

import java.sql.DriverManager;

public class Connexion {

    private static Connection con;
    static{
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/catalogue","root","");
            System.out.println("Connection ok");

        }catch(Exception e){
            System.out.println(e.getMessage());        }
    }
    public static Connection getConnexion(){
        return  con;
    }
}