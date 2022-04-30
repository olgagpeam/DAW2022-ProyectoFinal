/*
 *  
 */

package model;

/**
 *
 * @author Alarcon Olga
 */
public class Sex {
    private char id;
    private String sex;

    public Sex() {
    }
    
    public Sex(char id, String sex) {
        this.id = id;
        this.sex = sex;
    }

    public char getId() {
        return id;
    }

    public String getSex() {
        return sex;
    }

    public void setId(char id) {
        this.id = id;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
    
    

}
