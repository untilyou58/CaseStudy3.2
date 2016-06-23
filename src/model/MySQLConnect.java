/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AnhTTV
 */
public class MySQLConnect {
    String host="localhost";
    String username="root";
    String password="123456";
    String database="Trading";
    Connection con=null;
    Statement st=null;
    ResultSet rs=null;
    public MySQLConnect(){}
    public Connection getConnect() {
        if(con==null){
           try {
            Class.forName("com.mysql.jdbc.Driver");
               } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MySQLConnect.class.getName()).log(Level.SEVERE, null, ex);
                    }
           String url="jdbc:mysql://localhost:3306/trading";
            try {
                 con = DriverManager.getConnection(url, username, password);
                 //System.out.println("ket noi ok");
            } catch (SQLException ex) {
                Logger.getLogger(MySQLConnect.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return con;
    }
    
    protected Statement getStatement() throws SQLException{
        if(st==null){
            try {
                st = getConnect().createStatement();
            } catch (SQLException ex) {
                Logger.getLogger(MySQLConnect.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return st;
    }
    public ResultSet executeQuery(String query) throws SQLException{
            return getStatement().executeQuery(query);
    }
    
}
