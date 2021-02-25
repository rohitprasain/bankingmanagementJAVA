
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Asmita
 */
public class Crud extends javaconnect{

    public Crud() throws SQLException{
        super();
    }

    boolean login(String username, String password) throws SQLException {
        Connection connection=ConnecrDb();
        Statement statement = connection.createStatement();
        String sql = String.format("select * from admin_login where username = '%s' and password = '%s'", username, password);
        ResultSet rs = statement.executeQuery(sql);
        return rs.next(); 
    }
    boolean login1(String username, String password) throws SQLException {
        Connection connection=ConnecrDb();
        Statement statement = connection.createStatement();
        String sql = String.format("select * from staff_login where username = '%s' and password = '%s'", username, password);
        ResultSet rs = statement.executeQuery(sql);
        return rs.next(); 
    }

    

    void balance_update(String value1, double value2) throws SQLException {
        Connection connection=ConnecrDb();
        Statement statement = connection.createStatement();
        String sql = String.format("UPDATE `customer_details` SET `Total Balance`='%f' WHERE Name='%s'",value2,value1);
        
        ResultSet rs = statement.executeQuery(sql);
        
    }

    

    void pin(Integer value2, String value4) throws SQLException {
        Connection connection=ConnecrDb();
        Statement statement = connection.createStatement();
        String sql = String.format("UPDATE `customer_details` SET `Pin`='%d' WHERE Name='%s'",value2,value4);
        ResultSet rs = statement.executeQuery(sql);
    }

    

    void edit(String value1, String value2, String value3, String value4, String value5, String value6, String value7, String value8, String value9, String value10) throws SQLException {
        Connection connection=ConnecrDb();
        Statement statement = connection.createStatement();
        String sql = String.format("UPDATE `customer_details` SET `Date of Birth`='%s',`Nationality`='%s',`Religion`='%s',`Gender`='%s',`Account_No`='%s',`Account Type`='%s',`Address`='%s',`Marital Status`='%s',`Mobile`='%s' WHERE `Name`='%s'", value2, value3, value4, value5, value6, value7, value8, value9, value10,value1);
        ResultSet rs = statement.executeQuery(sql);
    }

    void edit_staff(String value1, String value2, String value3, String value4, String value5, String value6, String value7, Float value8, String value9, String value10, String value11) throws SQLException {
        Connection connection=ConnecrDb();
        Statement statement = connection.createStatement();
        String sql = String.format("UPDATE `staff_info` SET `Date of Birth`='%s',`Nationality`='%s',`Religion`='%s',`Gender`='%s',`Address`='%s',`Post`='%s',`Salary`='%f',`Hired Date`='%s',`Marital Status`='%s',`Mobile`='%s' WHERE `Name`='%s'", value2, value3, value4, value5, value6, value7, value8, value9, value10,value11,value1);
        ResultSet rs = statement.executeQuery(sql);
    }

    void balance_update_t(String value1, double value2,String value4, double value3) throws SQLException {
        Connection connection=ConnecrDb();
        Statement statement = connection.createStatement();
        String sql = String.format("UPDATE `customer_details` SET `Total Balance`='%f' WHERE Name='%s'",value2,value1);
        String sql1 = String.format("UPDATE `customer_details` SET `Total Balance`='%f' WHERE Name='%s'",value3,value4);
        
        ResultSet rs = statement.executeQuery(sql);
        ResultSet rs1 = statement.executeQuery(sql1);
    }

    void act(String name) throws SQLException {
        Connection connection=ConnecrDb();
        Statement statement = connection.createStatement();
        String sql = String.format("UPDATE `customer_details` SET `acc_a/d`='%d' WHERE `Name`='%s'",1, name);
        ResultSet rs = statement.executeQuery(sql);
    }

    void deact(String name) throws SQLException {
        Connection connection=ConnecrDb();
        Statement statement = connection.createStatement();
        String sql = String.format("UPDATE `customer_details` SET `acc_a/d`='%d' WHERE `Name`='%s'", 0, name);
        ResultSet rs = statement.executeQuery(sql);
    }

    void act_s(Integer id) throws SQLException {
       Connection connection=ConnecrDb();
       Statement statement = connection.createStatement();
       String sql = String.format("UPDATE `staff_info` SET `acc_a/d`='%d' WHERE `ID`='%s'",1, id);
       ResultSet rs = statement.executeQuery(sql);
     
    }

    void deact_s(Integer id) throws SQLException {
       Connection connection=ConnecrDb();
       Statement statement = connection.createStatement();
       String sql = String.format("UPDATE `staff_info` SET `acc_a/d`='%d' WHERE `ID`='%s'", 0, id);
       ResultSet rs = statement.executeQuery(sql);
     
    }

    void create_acc_staff(String value1, String value2, String value3, String value4, String value5, String value6, String value7, Float value8, String value9, String value10, String value11, byte[] value12) throws SQLException {
        Connection connection=ConnecrDb();
        Statement statement = connection.createStatement();
        String sql = String.format("insert into staff_info(Name, `Date of Birth`, Nationality, Religion, Address, Gender, Post, Salary, `Hired Date`, `Marital Status`, Mobile,images) values ('%s', '%s', '%s', '%s', '%s', '%s', '%s', %f, '%s', '%s', '%s', '')",value1, value2, value3, value4, value5, value6, value7, value8, value9, value10, value11, value12);
        ResultSet rs = statement.executeQuery(sql);
        }

    

    void create_acc(String value1, String value2, String value3, String value4, String value5, String value6, String value7, Integer value8, String value9, String value10, String value11, String value12) throws SQLException {
        Connection connection=ConnecrDb();
        Statement statement = connection.createStatement();
        String sql = String.format("insert into customer_details(Name, `Date of Birth`, Nationality, Religion, Address, Gender, `Account_No`, Pin, `Account Type`, `Marital Status`, Mobile,images) values ('%s', '%s', '%s', '%s', '%s', '%s', '%s', %d, '%s', '%s', '%s','%s')",value1, value2, value3, value4, value5, value6, value7, value8, value9, value10, value11, value12);
//        String sql1 = statement.setBinaryStream(3,value12,ilen);
        ResultSet rs = statement.executeQuery(sql);
//        boolean rs1 = statement.execute(sql1);
    }
   
}
