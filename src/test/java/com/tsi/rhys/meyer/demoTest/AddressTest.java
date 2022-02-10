package com.tsi.rhys.meyer.demoTest;

import com.tsi.rhys.meyer.DatabaseProject.Address;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class AddressTest {

    Address address = new Address();

    @Test
    public void test_getID(){
        address.setAddress_id(1);
        assertEquals(1, address.getAddress_id());
    }

    @Test
    public void test_getAddres(){
        address.setAddress("TestAddress");
        assertEquals("TestAddress", address.getAddress());
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
}
