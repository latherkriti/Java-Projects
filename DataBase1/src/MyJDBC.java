

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MyJDBC {
    public static void main(String[] args) {
        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/firstjava","root","root");
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("select * from person where name='Kriti'");
            while(rs.next()){
                System.out.println(rs.getString("name")+" is of age"+rs.getInt("age"));
            }
            //String stmt1 = "insert into firstjava.person values(null ,'harpreet',34)";
            //s.executeUpdate(stmt1);
            // String stmt2 = "delete from firstjava.person where name='harpreet'";
            // s.executeUpdate(stmt2);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

