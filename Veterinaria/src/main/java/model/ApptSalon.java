/*
 *  
 */

package model;

import java.io.*;
//import java.sql.Time;
import java.util.Date;

/**
 *
 * @author Alarcon Olga
 */
public class ApptSalon implements Serializable {
    private String r_user, r_owner, r_pet, address, note;
    private Date dateAppt, inHour;
    private char r_sector;
    
    private int r_service;
    private Date outHour;
    private String products;

    public ApptSalon() {
    }

    public ApptSalon(String r_user, String r_owner, String r_pet, String address, String note, Date dateAppt, Date inHour, char r_sector, int r_service, Date outHour, String products) {
        this.r_user = r_user;
        this.r_owner = r_owner;
        this.r_pet = r_pet;
        this.address = address;
        this.note = note;
        this.dateAppt = dateAppt;
        this.inHour = inHour;
        this.r_sector = r_sector;
        this.r_service = r_service;
        this.outHour = outHour;
        this.products = products;
    }

    public String getR_user() {
        return r_user;
    }

    public String getR_owner() {
        return r_owner;
    }

    public String getR_pet() {
        return r_pet;
    }

    public String getAddress() {
        return address;
    }

    public String getNote() {
        return note;
    }

    public Date getDate_appt() {
        return dateAppt;
    }

    public Date getIn_hour() {
        return inHour;
    }

    public char getR_sector() {
        return r_sector;
    }

    public int getR_service() {
        return r_service;
    }

    public Date getOut_hour() {
        return outHour;
    }

    public String getProducts() {
        return products;
    }

    public void setR_user(String r_user) {
        this.r_user = r_user;
    }

    public void setR_owner(String r_owner) {
        this.r_owner = r_owner;
    }

    public void setR_pet(String r_pet) {
        this.r_pet = r_pet;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setDate_appt(Date dateAppt) {
        this.dateAppt = dateAppt;
    }

    public void setIn_hour(Date inHour) {
        this.inHour = inHour;
    }

    public void setR_sector(char r_sector) {
        this.r_sector = r_sector;
    }

    public void setR_service(int r_service) {
        this.r_service = r_service;
    }

    public void setOut_hour(Date outHour) {
        this.outHour = outHour;
    }

    public void setProducts(String products) {
        this.products = products;
    }
    
    
    
}
