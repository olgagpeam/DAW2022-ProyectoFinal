/*
 *  
 */
package model;

import java.sql.Timestamp;

/**
 *
 * @author Alarcon Olga
 */
public class ProdUpdate {

    int id;
    private String r_prod;
    private Timestamp updatedAt;
    private String r_user;
    private String notes;

    public ProdUpdate() {
    }

    public ProdUpdate(int id, String r_prod, Timestamp updatedAt, String r_user, String notes) {
        this.id = id;
        this.r_prod = r_prod;
        this.updatedAt = updatedAt;
        this.r_user = r_user;
        this.notes = notes;
    }
    
    public ProdUpdate(String r_prod, Timestamp updatedAt, String r_user, String notes) {
        this.r_prod = r_prod;
        this.updatedAt = updatedAt;
        this.r_user = r_user;
        this.notes = notes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getR_prod() {
        return r_prod;
    }

    public String getR_user() {
        return r_user;
    }
    
    public Timestamp getUpdatedAt() {
        return updatedAt;
    }
    
    public String getNotes() {
        return notes;
    }

    public void setR_prod(String r_prod) {
        this.r_prod = r_prod;
    }

    public void setR_user(String r_user) {
        this.r_user = r_user;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
    
    public void setNotes(String notes) {
        this.notes = notes;
    }
}
