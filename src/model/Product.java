/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author CuuArsNo1
 */
public class Product implements java.io.Serializable{
    private String ID;
        private String name;
        private String cat_ID;
        private String image;
        private float price;
        private int quantity;
        private String describe;
        private String status;
        private String adddate;
        private String cat_name;

    public Product() {
    }

    public Product(String ID, String name, String cat_ID, String image, float price, int quantity, String describe, String status, String adddate, String cat_name) {
        this.ID = ID;
        this.name = name;
        this.cat_ID = cat_ID;
        this.image = image;
        this.price = price;
        this.quantity = quantity;
        this.describe = describe;
        this.status = status;
        this.adddate = adddate;
        this.cat_name = cat_name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCat_ID() {
        return cat_ID;
    }

    public void setCat_ID(String cat_ID) {
        this.cat_ID = cat_ID;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAdddate() {
        return adddate;
    }

    public void setAdddate(String adddate) {
        this.adddate = adddate;
    }

    public String getCat_name() {
        return cat_name;
    }

    public void setCat_name(String cat_name) {
        this.cat_name = cat_name;
    }
    public Object[] toOb(){
        return new Object[]{ID,name, cat_ID,cat_name,  image,  price,  quantity,  describe,  status,  adddate};
    }    
}
