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
public class User implements Serializable {
    private String id, pwd,name, addr, tel, cel, email, r_acct;
    private Date bdate;

    public User() {
    }

    public User(String id, String pwd, String name, String addr, String tel, String cel, String email, String r_acct, Date bdate) {
        this.id = id;
        this.pwd = pwd;
        this.name = name;
        this.addr = addr;
        this.tel = tel;
        this.cel = cel;
        this.email = email;
        this.r_acct = r_acct;
        this.bdate = bdate;
    }

    public String getId() {
        return id;
    }

    public String getPwd() {
        return pwd;
    }

    public String getName() {
        return name;
    }

    public String getAddr() {
        return addr;
    }

    public String getTel() {
        return tel;
    }

    public String getCel() {
        return cel;
    }

    public String getEmail() {
        return email;
    }

    public String getR_acct() {
        return r_acct;
    }

    public Date getBdate() {
        return bdate;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setCel(String cel) {
        this.cel = cel;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setR_acct(String r_acct) {
        this.r_acct = r_acct;
    }

    public void setBdate(Date bdate) {
        this.bdate = bdate;
    }
    
    
}
