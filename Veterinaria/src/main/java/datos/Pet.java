/*
 *  
 */

package datos;

import java.io.*;
import java.util.*;

/**
 *
 * @author Alarcon Olga
 */
public class Pet implements Serializable{
    private String id, name, specie, race, color, r_owner, other;
    private char r_sex;
    private Date bdate;

    public Pet() {
    }

    public Pet(String id, String name, String specie, String race, String color, String r_owner, String other, char r_sex, Date bdate) {
        this.id = id;
        this.name = name;
        this.specie = specie;
        this.race = race;
        this.color = color;
        this.r_owner = r_owner;
        this.other = other;
        this.r_sex = r_sex;
        this.bdate = bdate;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSpecie() {
        return specie;
    }

    public String getRace() {
        return race;
    }

    public String getColor() {
        return color;
    }

    public String getR_owner() {
        return r_owner;
    }

    public String getOther() {
        return other;
    }

    public char getR_sex() {
        return r_sex;
    }

    public Date getBdate() {
        return bdate;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpecie(String specie) {
        this.specie = specie;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setR_owner(String r_owner) {
        this.r_owner = r_owner;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public void setR_sex(char r_sex) {
        this.r_sex = r_sex;
    }

    public void setBdate(Date bdate) {
        this.bdate = bdate;
    }
    
    
}
