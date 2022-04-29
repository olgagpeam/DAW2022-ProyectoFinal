/*
 *  
 */

package datos;

import java.io.*;
import java.util.*;


/**
 *
 * @author Alarcon Olga
 */
public class Owner implements Serializable {
    private String ine, name, addr, cel, tel, email;
    private Date bdate;

    public Owner() {
    }

    public Owner(String ine, String name, String addr, String cel, String tel, String email, Date bdate) {
        this.ine = ine;
        this.name = name;
        this.addr = addr;
        this.cel = cel;
        this.tel = tel;
        this.email = email;
        this.bdate = bdate;
    }

    public String getIne() {
        return ine;
    }

    public String getName() {
        return name;
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

    public Date getBdate() {
        return bdate;
    }

    public void setIne(String ine) {
        this.ine = ine;
    }

    public void setName(String name) {
        this.name = name;
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

    public void setBdate(Date bdate) {
        this.bdate = bdate;
    }
    
    
}
