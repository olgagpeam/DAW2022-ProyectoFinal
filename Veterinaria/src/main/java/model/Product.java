/*
 *  
 */

package model;

import java.sql.*;

/**
 *
 * @author Alarcon Olga
 */

public class Product {
    private String id, name, description;
    private int inStock, minStock;
    private float priceIn, priceOut;
    private int r_category;
    private Timestamp createdAt, updatedAt;
    private boolean isActive;

    public Product() {
    }

    public Product(String id, String name, String description, int inStock, int minStock, float priceIn, float priceOut, int r_category, Timestamp createdAt, Timestamp updatedAt, boolean isActive) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.inStock = inStock;
        this.minStock = minStock;
        this.priceIn = priceIn;
        this.priceOut = priceOut;
        this.r_category = r_category;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.isActive = isActive;
    }
    
    public Product(String name, String description, int inStock, int minStock, float priceIn, float priceOut, int r_category, Timestamp updatedAt, boolean isActive) {
        this.name = name;
        this.description = description;
        this.inStock = inStock;
        this.minStock = minStock;
        this.priceIn = priceIn;
        this.priceOut = priceOut;
        this.r_category = r_category;
        this.updatedAt = updatedAt;
        this.isActive = isActive;
    }
    
    public Product(boolean isActive) {
        this.isActive = isActive;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getInStock() {
        return inStock;
    }

    public void setInStock(int inStock) {
        this.inStock = inStock;
    }

    public int getMinStock() {
        return minStock;
    }

    public void setMinStock(int minStock) {
        this.minStock = minStock;
    }

    public float getPriceIn() {
        return priceIn;
    }

    public void setPriceIn(float priceIn) {
        this.priceIn = priceIn;
    }

    public float getPriceOut() {
        return priceOut;
    }

    public void setPriceOut(float priceOut) {
        this.priceOut = priceOut;
    }

    public int getR_category() {
        return r_category;
    }

    public void setR_category(int r_category) {
        this.r_category = r_category;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
    
}
