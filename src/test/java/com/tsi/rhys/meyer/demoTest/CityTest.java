package com.tsi.rhys.meyer.demoTest;

import com.tsi.rhys.meyer.DatabaseProject.City.City;
import com.tsi.rhys.meyer.DatabaseProject.Langauage.Language;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CityTest {

    City city = new City();

    @Test
    public void test_constructor(){
        assertTrue("Its not an instance of Actor", city instanceof City);
    }

    @Test
    public void test_cityInstantiation(){
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        city = new City(1,"Test",2,ts);
        assertEquals(1,city.getCity_id());
        assertEquals("test",city.getCity());
        assertEquals(2,city.getCountry_id());
        assertEquals(ts,city.getLast_update());
    }

    @Test
    public void test_getID(){
        city.setCity_id(1);
        assertEquals(1, city.getCity_id());
    }

    @Test
    public void test_getCountry(){
        city.setCity("TestName");
        assertEquals("TestName", city.getCity());
    }

    @Test
    public void test_getCountryID(){
        city.setCountry_id(1);
        assertEquals(1, city.getCountry_id());
    }

    @Test
    public void test_setTimeStamp(){
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        city.setLast_update(ts);
        assertEquals(ts,city.getLast_update());

    }
}
