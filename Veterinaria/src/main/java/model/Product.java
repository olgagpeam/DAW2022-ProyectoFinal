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

public class Product implements Serializable {
    private String id, name, description;
    private int inStock, minStock, r_category;
    private float priceIn, priceOut;
    private Date createdAt, updatedAt;
    private boolean isActive;

    public Product() {
    }

    public Product(String id, String name, String description, int inStock, int minStock, int r_category, float priceIn, float priceOut, Date createdAt, Date updatedAt, boolean isActive) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.inStock = inStock;
        this.minStock = minStock;
        this.r_category = r_category;
        this.priceIn = priceIn;
        this.priceOut = priceOut;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.isActive = isActive;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getInStock() {
        return inStock;
    }

    public int getMinStock() {
        return minStock;
    }

    public int getR_category() {
        return r_category;
    }

    public float getPriceIn() {
        return priceIn;
    }

    public float getPriceOut() {
        return priceOut;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setInStock(int inStock) {
        this.inStock = inStock;
    }

    public void setMinStock(int minStock) {
        this.minStock = minStock;
    }

    public void setR_category(int r_category) {
        this.r_category = r_category;
    }

    public void setPriceIn(float priceIn) {
        this.priceIn = priceIn;
    }

    public void setPriceOut(float priceOut) {
        this.priceOut = priceOut;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
    
    
    
    
}
