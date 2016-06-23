/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import model.MySQLConnect;
import model.Category;
import java.beans.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author AnhTTV
 */
public class CategoryDAO {
    MySQLConnect con =new MySQLConnect();    
    public List<Category> getAllCategories(){
        ResultSet rs = null;
        Category c = null;
        List<Category> li = new ArrayList<Category>();
        try {
            String sql = "Select * From Categories";
            rs = con.executeQuery(sql);
            while (rs.next()) {
                c = new Category();

                c.setID(rs.getString("ID"));
                c.setName(rs.getString("name"));
                c.setDescribe(rs.getString("Describe"));

                li.add(c);
            }
            return li;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return null;
        }
    }
    public boolean insert(Category c){
        String insert = "Insert into Categories values(?,?,?)";
        try {
            PreparedStatement prest = con.getConnect().prepareStatement(insert);
            prest.setString(1, c.getID());
            prest.setString(2, c.getName());
            prest.setString(3, c.getDescribe());

            return (prest.executeUpdate() == 1);
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }
    public boolean update(Category c) {
        String update = "UPDATE categories SET name=?, `Describe`=? " +
                "WHERE ID=?";

        try {
            PreparedStatement prest = con.getConnect().prepareStatement(update);
            prest.setString(1,c.getName());
            prest.setString(2, c.getDescribe());
            prest.setString(3, c.getID());
            
            System.out.println(prest.toString());
            System.out.println(update);
            return (prest.executeUpdate() == 1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return false;
        }
    }
    public boolean delete(Category c) {
        String delete = "DELETE from Categories Where ID=?";
        
        try {
            PreparedStatement prest = con.getConnect().prepareStatement(delete);
            prest.setString(1, c.getID());
            System.out.println(prest.toString());
            System.out.println(delete);
            return (prest.executeUpdate() == 1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return false;
        }
    }
}
