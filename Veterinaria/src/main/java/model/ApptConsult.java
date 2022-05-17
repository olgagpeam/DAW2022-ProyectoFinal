/*
 *  
 */

package model;

import java.sql.*;

/**
 *
 * @author Alarcon Olga
 */

public class ApptConsult {
    private int id;
    private String r_user, r_owner;
    private int r_pet;
    private String addr;
    private Date dateAppt;
    private Time inHour;
    private char r_sector;
    private String note;
    
    private int r_consult;
    private String addrRef, diagnosis, procedures, med;

    public ApptConsult() {
    }

    public ApptConsult(int id, String r_user, String r_owner, int r_pet, String addr, Date dateAppt, Time inHour, char r_sector, String note, int r_consult, String addrRef, String diagnosis, String procedures, String med) {
        this.id = id;
        this.r_user = r_user;
        this.r_owner = r_owner;
        this.r_pet = r_pet;
        this.addr = addr;
        this.dateAppt = dateAppt;
        this.inHour = inHour;
        this.r_sector = r_sector;
        this.note = note;
        this.r_consult = r_consult;
        this.addrRef = addrRef;
        this.diagnosis = diagnosis;
        this.procedures = procedures;
        this.med = med;
    }
    
    public ApptConsult(String r_user, String r_owner, int r_pet, String addr, Date dateAppt, Time inHour, char r_sector, String note, int r_consult, String addrRef, String diagnosis, String procedures, String med) {
        this.r_user = r_user;
        this.r_owner = r_owner;
        this.r_pet = r_pet;
        this.addr = addr;
        this.dateAppt = dateAppt;
        this.inHour = inHour;
        this.r_sector = r_sector;
        this.note = note;
        this.r_consult = r_consult;
        this.addrRef = addrRef;
        this.diagnosis = diagnosis;
        this.procedures = procedures;
        this.med = med;
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

    public int getR_consult() {
        return r_consult;
    }

    public String getAddrRef() {
        return addrRef;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public String getProcedures() {
        return procedures;
    }

    public String getMed() {
        return med;
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

    public void setAddr(String addr) {
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

    public void setR_consult(int r_consult) {
        this.r_consult = r_consult;
    }

    public void setAddrRef(String addrRef) {
        this.addrRef = addrRef;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public void setProcedures(String procedures) {
        this.procedures = procedures;
    }

    public void setMed(String med) {
        this.med = med;
    }

    
}
