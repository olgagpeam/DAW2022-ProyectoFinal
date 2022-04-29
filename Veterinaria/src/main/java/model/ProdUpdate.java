/*
 *  
 */

package model;

import java.io.*;
import java.util.Date;

/**
 *
 * @author Alarcon Olga
 */

public class ProdUpdate implements Serializable{
    private String r_prod, r_user;
    private Date updatedAt;
    
    public ProdUpdate() {
    }
    
    public ProdUpdate(String r_prod, String r_user, Date updatedAt) {
        this.r_prod = r_prod;
        this.r_user = r_user;
        this.updatedAt = updatedAt;
    }

    public String getR_prod() {
        return r_prod;
    }

    public String getR_user() {
        return r_user;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setR_prod(String r_prod) {
        this.r_prod = r_prod;
    }

    public void setR_user(String r_user) {
        this.r_user = r_user;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    
    
    
}
