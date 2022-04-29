/*
 *  
 */

package datos;

import java.io.*;
//import java.sql.Time;
import java.util.Date;

/**
 *
 * @author Alarcon Olga
 */
public class ApptConsult implements Serializable {
    private String r_user, r_owner, r_pet, address, note;
    private Date date_appt, in_hour;
    private char r_sector;
    
    private int r_consult;
    private String addr, diagnosis, procedures, med;

    public ApptConsult() {
    }

    public ApptConsult(String r_user, String r_owner, String r_pet, String address, String note, Date date_appt, char r_sector, Date in_hour, int r_consult, String addr, String diagnosis, String procedures, String med) {
        this.r_user = r_user;
        this.r_owner = r_owner;
        this.r_pet = r_pet;
        this.address = address;
        this.note = note;
        this.date_appt = date_appt;
        this.r_sector = r_sector;
        this.in_hour = in_hour;
        this.r_consult = r_consult;
        this.addr = addr;
        this.diagnosis = diagnosis;
        this.procedures = procedures;
        this.med = med;
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
        return date_appt;
    }

    public char getR_sector() {
        return r_sector;
    }

    public Date getIn_hour() {
        return in_hour;
    }

    public int getR_consult() {
        return r_consult;
    }

    public String getAddr() {
        return addr;
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

    public void setDate_appt(Date date_appt) {
        this.date_appt = date_appt;
    }

    public void setR_sector(char r_sector) {
        this.r_sector = r_sector;
    }

    public void setIn_hour(Date in_hour) {
        this.in_hour = in_hour;
    }

    public void setR_consult(int r_consult) {
        this.r_consult = r_consult;
    }

    public void setAddr(String addr) {
        this.addr = addr;
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
