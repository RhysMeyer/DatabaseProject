package com.tsi.rhys.meyer.DatabaseProject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Time;
import java.sql.Timestamp;

@Entity
public class Store {

    @Id
    @GeneratedValue
    private int store_id;
    private int manager_staff_id;
    private int address_id;
    private Timestamp last_update;

    public Store(){

    }

    public Store(int store_id, int manager_staff_id, int address_id, Timestamp last_update)
    {
        this.store_id = store_id;
        this.manager_staff_id = manager_staff_id;
        this.address_id = address_id;
        this.last_update = last_update;
    }



    public int getStore_id() {
        return store_id;
    }

    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }

    public int getManager_staff_id() {
        return manager_staff_id;
    }

    public void setManager_staff_id(int manager_staff_id) {
        this.manager_staff_id = manager_staff_id;
    }

    public int getAddress_id() {
        return address_id;
    }

    public void setLast_update(Timestamp last_update) {
        this.last_update = last_update;
    }

    public Timestamp getLast_update() {
        return last_update;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }
}
