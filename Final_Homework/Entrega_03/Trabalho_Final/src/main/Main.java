package main;
import JDBC.ConnectionJDBC;
import define.define;
import java.sql.SQLException;
import telas.*;
public class Main {    
    public static void main(String[] args) {
        try{
            define.connectionJDBC = new ConnectionJDBC(define.host, define.port, define.database, define.user, define.password);                        
            Login login = new Login();
            login.setLocationRelativeTo(null);
            login.setVisible(true);            
        }catch(SQLException e){
            System.out.println("Erro ao conectar");
            System.exit(0);
        }
    }
}
