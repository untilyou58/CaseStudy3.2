/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author AnhTTV
 */
public class Category implements java.io.Serializable{
    private String ID;
    private String name;
    private String describe;

    public Category() {
    }

    public Category(String ID, String name, String describe) {
        this.ID = ID;
        this.name = name;
        this.describe = describe;
    }
    /**
     * @return the ID
     */
    
    public String getID() {
        return ID;
    }
    /**
     * @param ID the ID to set
     */
    
    public void setID(String ID) {
        this.ID = ID;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the describe
     */
    public String getDescribe() {
        return describe;
    }
    /**
     * @param describe the describe to set
     */
    public void setDescribe(String describe) {
        this.describe = describe;
    }    
    public Object[] toOb(){
        return new Object[]{ID,name,describe};
    }
}
