/*
 *  
 */

package model;

import java.io.*;
import java.sql.*;


/**
 *
 * @author Alarcon Olga
 */
public class Owner {
    private String ine, name;
    private Date bdate;
    private String addr, cel, tel, email;

    public Owner() {
    }

    public Owner(String ine, String name, Date bdate, String addr, String cel, String tel, String email) {
        this.ine = ine;
        this.name = name;
        this.bdate = bdate;
        this.addr = addr;
        this.cel = cel;
        this.tel = tel;
        this.email = email;
    }

    public String getIne() {
        return ine;
    }

    public String getName() {
        return name;
    }

    public Date getBdate() {
        return bdate;
    }

    public String getAddr() {
        return addr;
    }

    public String getCel() {
        return cel;
    }

    public String getTel() {
        return tel;
    }

    public String getEmail() {
        return email;
    }

    public void setIne(String ine) {
        this.ine = ine;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBdate(Date bdate) {
        this.bdate = bdate;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public void setCel(String cel) {
        this.cel = cel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
