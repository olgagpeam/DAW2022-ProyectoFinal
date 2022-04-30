/*
 *  
 */

package model;

import java.io.*;
import java.util.*;

/**
 *
 * @author Alarcon Olga
 */
public class User {
    private String id, pwd, nam;
    private Date bdate;
    private String addr, tel, cel, email, r_acct;
    
    public User() {
    }

    public User(String id, String pwd, String nam, Date bdate, String addr, String tel, String cel, String email, String r_acct) {
        this.id = id;
        this.pwd = pwd;
        this.nam = nam;
        this.bdate = bdate;
        this.addr = addr;
        this.tel = tel;
        this.cel = cel;
        this.email = email;
        this.r_acct = r_acct;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getNam() {
        return nam;
    }

    public void setNam(String nam) {
        this.nam = nam;
    }

    public Date getBdate() {
        return bdate;
    }

    public void setBdate(Date bdate) {
        this.bdate = bdate;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCel() {
        return cel;
    }

    public void setCel(String cel) {
        this.cel = cel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getR_acct() {
        return r_acct;
    }

    public void setR_acct(String r_acct) {
        this.r_acct = r_acct;
    }

}
