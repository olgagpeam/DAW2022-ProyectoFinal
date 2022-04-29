/*
 *  
 */

package model;

import java.io.*;
import java.sql.Time;
import java.util.*;

/**
 *
 * @author Alarcon Olga
 */
public class ApptHospital implements Serializable{
    private String r_user, r_owner, r_pet, address, note;
    private Date dateAppt;
    private char r_sector;
    private Time inHour;
    
    private String illness, procedures, medicaments;

    public ApptHospital() {
    }

    public ApptHospital(String r_user, String r_owner, String r_pet, String address, String note, Date dateAppt, char r_sector, Time inHour, String illness, String procedures, String medicaments) {
        this.r_user = r_user;
        this.r_owner = r_owner;
        this.r_pet = r_pet;
        this.address = address;
        this.note = note;
        this.dateAppt = dateAppt;
        this.r_sector = r_sector;
        this.inHour = inHour;
        this.illness = illness;
        this.procedures = procedures;
        this.medicaments = medicaments;
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

    public char getR_sector() {
        return r_sector;
    }

    public Time getIn_hour() {
        return inHour;
    }

    public String getIllness() {
        return illness;
    }

    public String getProcedures() {
        return procedures;
    }

    public String getMedicaments() {
        return medicaments;
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

    public void setR_sector(char r_sector) {
        this.r_sector = r_sector;
    }

    public void setIn_hour(Time inHour) {
        this.inHour = inHour;
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }

    public void setProcedures(String procedures) {
        this.procedures = procedures;
    }

    public void setMedicaments(String medicaments) {
        this.medicaments = medicaments;
    }
    
    
}
