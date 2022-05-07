/*
 *  
 */

package model;

import java.sql.*;

/**
 *
 * @author Alarcon Olga
 */
public class Pet {
    private int id;
    private String name;
    private Date bdate;
    private String specie, race;
    private char r_sex;
    private String  color, r_owner, other;

    public Pet() {
    }

    public Pet(int id, String name, Date bdate, String specie, String race, char r_sex, String color, String r_owner, String other) {
        this.id = id;
        this.name = name;
        this.bdate = bdate;
        this.specie = specie;
        this.race = race;
        this.r_sex = r_sex;
        this.color = color;
        this.r_owner = r_owner;
        this.other = other;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBdate() {
        return bdate;
    }

    public void setBdate(Date bdate) {
        this.bdate = bdate;
    }

    public String getSpecie() {
        return specie;
    }

    public void setSpecie(String specie) {
        this.specie = specie;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public char getR_sex() {
        return r_sex;
    }

    public void setR_sex(char r_sex) {
        this.r_sex = r_sex;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getR_owner() {
        return r_owner;
    }

    public void setR_owner(String r_owner) {
        this.r_owner = r_owner;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }
}
