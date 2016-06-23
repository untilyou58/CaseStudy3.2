/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
 * @author CuuArsNo1
 */
public class ProductDAO {
    MySQLConnect con =new MySQLConnect();    
    public List<Product> getAllProduct(){
        ResultSet rs = null;
        Product p = null;
        List<Product> li = new ArrayList<Product>();
        try {
            String sql = "Select p.ID, p.name,p.cat_ID,c.Name as cat_name, p.image,p.price, p.quanity,p.`describe`,p.status,  p.adddate "
                    + "From Products  as p  inner join Categories as c on p.cat_ID=c.ID";
            
            rs = con.executeQuery(sql);
            while (rs.next()) {
                p = new Product();

                p.setID(rs.getString("ID"));
                p.setName(rs.getString("name"));
                p.setCat_ID(rs.getString("cat_ID"));
                p.setCat_name(rs.getString("cat_name"));
                p.setImage(rs.getString("image"));
                p.setPrice(Float.parseFloat(rs.getString("price")));
                p.setQuantity(Integer.parseInt(rs.getString("quanity")));                
                p.setDescribe(rs.getString("describe"));
                p.setStatus(rs.getString("status"));
                p.setAdddate(rs.getString("adddate"));
                li.add(p);
            }
            return li;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return null;
        }
    }
        public List<Product> getAllProductsByNameOfC(String nameofc){
            PreparedStatement prest = null;
        ResultSet rs = null;
        Product p = null;
            System.out.println(nameofc+"abc");
        List<Product> list = new ArrayList<Product>();
        try {
            String sql = "Select p.ID, p.name,p.cat_ID,c.Name as cat_name, p.image,p.price, p.quanity,p.`describe`,p.status,  p.adddate "
                    + "From Products  as p  inner join Categories as c on p.cat_ID=c.ID Where c.name= ?";

            prest =con.getConnect().prepareStatement(sql);
            prest.setString(1,nameofc);
           System.out.println(prest.toString());
           rs = prest.executeQuery();

            while (rs.next()) {
                p = new Product();

                p.setID(rs.getString("ID"));
                p.setName(rs.getString("name"));
                p.setCat_ID(rs.getString("cat_ID"));
                p.setCat_name(rs.getString("cat_name"));
                p.setImage(rs.getString("image"));
                p.setPrice(Float.parseFloat(rs.getString("price")));
                p.setQuantity(Integer.parseInt(rs.getString("quanity")));                
                p.setDescribe(rs.getString("describe"));
                p.setStatus(rs.getString("status"));
                p.setAdddate(rs.getString("adddate"));
                list.add(p);
            }
            return list;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return null;
        }
    }
        public List<Product> getAllProductsByString(String s){
            PreparedStatement prest = null;
        ResultSet rs = null;
        Product p = null;
            System.out.println(s+"abc");
        List<Product> list = new ArrayList<Product>();
        try {
            String sql = "Select p.ID, p.name,p.cat_ID,c.Name as cat_name, p.image,p.price, p.quanity,p.`describe`,p.status,  p.adddate "
                    + "From Products  as p  inner join Categories as c on p.cat_ID=c.ID Where c.name LIKE ?";
            
            prest =con.getConnect().prepareStatement(sql);
            prest.setString(1,"%" + s + "%");
           System.out.println(prest.toString());
            rs= prest.executeQuery();
            while (rs.next()) {
                p = new Product();

                p.setID(rs.getString("ID"));
                p.setName(rs.getString("name"));
                p.setCat_ID(rs.getString("cat_ID"));
                p.setCat_name(rs.getString("cat_name"));
                p.setImage(rs.getString("image"));
                p.setPrice(Float.parseFloat(rs.getString("price")));
                p.setQuantity(Integer.parseInt(rs.getString("quanity")));                
                p.setDescribe(rs.getString("describe"));
                p.setStatus(rs.getString("status"));
                p.setAdddate(rs.getString("adddate"));
                list.add(p);
            }
            return list;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return null;
        }
    }
    public boolean insert(Product p){
        String insert = "Insert into Products values(?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement prest = con.getConnect().prepareStatement(insert);
            prest.setString(1, p.getID());
            prest.setString(2, p.getName());
            prest.setString(3, p.getCat_ID());
            prest.setString(4, p.getImage());
            prest.setString(5, p.getPrice()+"");
            prest.setString(6, p.getQuantity()+"");
            prest.setString(7, p.getStatus());
            prest.setString(8, p.getDescribe());
            prest.setString(9, p.getAdddate());
            return (prest.executeUpdate() == 1);
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }
}
