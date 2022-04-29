/*
 *  
 */

package model;

import java.io.*;
import java.util.*;

/**
 *
 * @author Alarcon Olga
 */
public class MedUpdate implements Serializable {
    private int r_id;
    private Date updatedAt;
    private String r_user, updates;

    public MedUpdate() {
    }

    public MedUpdate(int r_id, Date updatedAt, String r_user, String updates) {
        this.r_id = r_id;
        this.updatedAt = updatedAt;
        this.r_user = r_user;
        this.updates = updates;
    }

    public int getR_id() {
        return r_id;
    }

    public Date getUpdated_at() {
        return updatedAt;
    }

    public String getR_user() {
        return r_user;
    }

    public String getUpdates() {
        return updates;
    }

    public void setR_id(int r_id) {
        this.r_id = r_id;
    }

    public void setUpdated_at(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setR_user(String r_user) {
        this.r_user = r_user;
    }

    public void setUpdates(String updates) {
        this.updates = updates;
    }
    
    

}
