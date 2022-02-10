package com.tsi.rhys.meyer.demoTest;

import com.tsi.rhys.meyer.DatabaseProject.Actor;
import com.tsi.rhys.meyer.DatabaseProject.Address;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AddressTest {

    Address address = new Address();

    @Test
    public void test_constructor(){
        assertTrue("Its not an instance of Actor", address instanceof Address);
    }

    @Test
    public void test_getID(){
        address.setAddress_id(1);
        assertEquals(1, address.getAddress_id());
    }

    @Test
    public void test_getAddress(){
        address.setAddress("TestAddress");
        assertEquals("TestAddress", address.getAddress());
    }

    @Test
    public void test_Address2(){
        address.setAddress2("TestAddress2");
        assertEquals("TestAddress2", address.getAddress2());
    }

    @Test
    public void test_getDistrict(){
        address.setDistrict("TestDistrict");
        assertEquals("TestDistrict", address.getDistrict());
    }

    @Test
    public void test_getCityID(){
        address.setCity_id(1);
        assertEquals(1, address.getCity_id());
    }

    @Test
    public void test_postalCode(){
        address.setPostal_code("T3st C0d3");
        assertEquals("T3st C0d3", address.getPostal_code());
    }

    @Test
    public void test_getPhone(){
        address.setPhone("0774853134");
        assertEquals("0774853134", address.getPhone());
    }

    @Test
    public void test_setTimeStamp(){
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        address.setLast_update(ts);
        assertEquals(ts,address.getLast_update());

    }
}
