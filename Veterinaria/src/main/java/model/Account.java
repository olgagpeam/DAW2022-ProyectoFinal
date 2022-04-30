/*
 *  
 */

package model;

/**
 *
 * @author Alarcon Olga
 */
public class Account {
    private String id, typeAcct;

    public Account() {
    }

    public Account(String id, String typeAcct) {
        this.id = id;
        this.typeAcct = typeAcct;
    }

    public String getId() {
        return id;
    }

    public String getTypeAcct() {
        return typeAcct;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTypeAcct(String typeAcct) {
        this.typeAcct = typeAcct;
    }
    
    
}
