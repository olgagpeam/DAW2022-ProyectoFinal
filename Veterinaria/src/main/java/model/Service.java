/*
 *  
 */

package model;

/**
 *
 * @author Alarcon Olga
 */

public class Service {
    private int id;
    private String service;

    public Service() {
    }

    public Service(int id, String service) {
        this.id = id;
        this.service = service;
    }

    public int getId() {
        return id;
    }

    public String getService() {
        return service;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setService(String service) {
        this.service = service;
    }
    
}
