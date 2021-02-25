/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Asmita
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class javaconnect {
    protected Connection connection;
    
    public static Connection ConnecrDb() {
        Connection connection = null;
        ResultSet rs = null;
        PreparedStatement pst = null;
        try{
            String url = "jdbc:mariadb://localhost:3306/bank_management_system";
            String dbUsername = "root";
            String dbPassword = "";
            connection = DriverManager.getConnection(url, dbUsername, dbPassword);
/*            Statement statement = connection.createStatement();*/
            return connection;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return null;
    }
}
