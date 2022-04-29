/*
 *  
 */

package model;

/**
 *
 * @author Alarcon Olga
 */
public class Consult{
    private int id;
    private String typeConsult;

    public Consult() {
    }

    public Consult(int id, String typeConsult) {
        this.id = id;
        this.typeConsult = typeConsult;
    }

    public int getId() {
        return id;
    }

    public String getTypeConsult() {
        return typeConsult;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTypeConsult(String typeConsult) {
        this.typeConsult = typeConsult;
    }
    
    
}
