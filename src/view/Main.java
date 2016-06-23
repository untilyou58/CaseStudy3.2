/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Category;
import model.CategoryDAO;
import model.MySQLConnect;
import model.Product;
import model.ProductDAO;

/**
 *
 * @author AnhTTV
 */
public class Main {
   public static void main(String args[]) {
       CategoryDAO cdao= new CategoryDAO();
     List<Category> list = cdao.getAllCategories();
     System.out.println("Mã      Tên      Miêu tả");
     System.out.println("------------------------------------");
     for (Category c : list) {
         System.out.print(c.getID()+"     "+c.getName()+"    "+c.getDescribe());
         System.out.println();
     }
}
}
