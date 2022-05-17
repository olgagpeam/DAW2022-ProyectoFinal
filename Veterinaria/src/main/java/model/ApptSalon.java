/*
 *  
 */

package model;

import java.sql.*;

/**
 *
 * @author Alarcon Olga
 */
public class ApptSalon {
    private int id;
    private String r_user, r_owner;
    private int r_pet;
    private String addr;
    private Date dateAppt;
    private Time inHour;
    private char r_sector;
    private String note;
    
    private int r_service;
    private Time outHour;
    private String products;

    public ApptSalon() {
    }

    public ApptSalon(int id, String r_user, String r_owner, int r_pet, String addr, Date dateAppt, Time inHour, char r_sector, String note, int r_service, Time outHour, String products) {
        this.id = id;
        this.r_user = r_user;
        this.r_owner = r_owner;
        this.r_pet = r_pet;
        this.addr = addr;
        this.dateAppt = dateAppt;
        this.inHour = inHour;
        this.r_sector = r_sector;
        this.note = note;
        this.r_service = r_service;
        this.outHour = outHour;
        this.products = products;
    }
    public ApptSalon(String r_user, String r_owner, int r_pet, String addr, Date dateAppt, Time inHour, char r_sector, String note, int r_service, Time outHour, String products) {
        this.r_user = r_user;
        this.r_owner = r_owner;
        this.r_pet = r_pet;
        this.addr = addr;
        this.dateAppt = dateAppt;
        this.inHour = inHour;
        this.r_sector = r_sector;
        this.note = note;
        this.r_service = r_service;
        this.outHour = outHour;
        this.products = products;
    }
    
    public int getId() {
        return id;
    }

    public String getR_user() {
        return r_user;
    }

    public String getR_owner() {
        return r_owner;
    }

    public int getR_pet() {
        return r_pet;
    }

    public String getAddr() {
        return addr;
    }

    public Date getDateAppt() {
        return dateAppt;
    }

    public Time getInHour() {
        return inHour;
    }

    public char getR_sector() {
        return r_sector;
    }

    public String getNote() {
        return note;
    }

    public int getR_service() {
        return r_service;
    }

    public Time getOutHour() {
        return outHour;
    }

    public String getProducts() {
        return products;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setR_user(String r_user) {
        this.r_user = r_user;
    }

    public void setR_owner(String r_owner) {
        this.r_owner = r_owner;
    }

    public void setR_pet(int r_pet) {
        this.r_pet = r_pet;
    }

    public void setAddress(String addr) {
        this.addr = addr;
    }

    public void setDateAppt(Date dateAppt) {
        this.dateAppt = dateAppt;
    }

    public void setInHour(Time inHour) {
        this.inHour = inHour;
    }

    public void setR_sector(char r_sector) {
        this.r_sector = r_sector;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setR_service(int r_service) {
        this.r_service = r_service;
    }

    public void setOutHour(Time outHour) {
        this.outHour = outHour;
    }

    public void setProducts(String products) {
        this.products = products;
    }
    
}
