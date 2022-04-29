/*
 *  
 */

package model;

/**
 *
 * @author Alarcon Olga
 */

public class Sector {
    private char id;
    private String sector;

    public Sector() {
    }

    public Sector(char id, String sector) {
        this.id = id;
        this.sector = sector;
    }

    public char getId() {
        return id;
    }

    public String getSector() {
        return sector;
    }

    public void setId(char id) {
        this.id = id;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }
    
    
}
