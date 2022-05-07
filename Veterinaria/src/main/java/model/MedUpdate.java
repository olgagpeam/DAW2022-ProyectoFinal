/*
 *  
 */

package model;

import java.sql.Timestamp;

/**
 *
 * @author Alarcon Olga
 */
public class MedUpdate {
    private int id, r_id;
    private Timestamp updatedAt;
    private String r_user, updates;

    public MedUpdate() {
    }

    public MedUpdate(int id, int r_id, Timestamp updatedAt, String r_user, String updates) {
        this.id = id;
        this.r_id = r_id;
        this.updatedAt = updatedAt;
        this.r_user = r_user;
        this.updates = updates;
    }

    public int getId() {
        return id;
    }
    
    public int getR_id() {
        return r_id;
    }

    public Timestamp getUpdated_at() {
        return updatedAt;
    }

    public String getR_user() {
        return r_user;
    }

    public String getUpdates() {
        return updates;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setR_id(int r_id) {
        this.r_id = r_id;
    }

    public void setUpdated_at(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setR_user(String r_user) {
        this.r_user = r_user;
    }

    public void setUpdates(String updates) {
        this.updates = updates;
    }
    
    

}
