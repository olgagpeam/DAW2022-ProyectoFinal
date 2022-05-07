/*
 *  
 */

package model;

import java.sql.*;

/**
 *
 * @author Alarcon Olga
 */
public class User {
    private String id, pwd, name, lname1, lname2;
    private Date bdate;
    private String addr, tel, cel, email, r_acct;
    
    public User() {
    }

    public User(String id, String pwd, String name, String lname1, String lname2, Date bdate, String addr, String tel, String cel, String email, String r_acct) {
        this.id = id;
        this.pwd = pwd;
        this.name = name;
        this.lname1 = lname1;
        this.lname2 = lname2;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLname1() {
        return lname1;
    }

    public void setLname1(String lname1) {
        this.lname1 = lname1;
    }
    
    public String getLname2() {
        return lname2;
    }

    public void setLname2(String lname2) {
        this.lname2 = lname2;
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
