package com.tsi.rhys.meyer.demoTest;

import com.tsi.rhys.meyer.DatabaseProject.Country;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CountryTest {

    private Country country = new Country();

    @Test
    public void test_constructor(){
        assertTrue("Its not an instance of Country", country instanceof Country);
    }

    @Test
    public void test_getName(){
        country.setCountry("TestCountry");
        assertEquals("TestCountry", country.getCountry());
    }

    public void test_getID(){
        country.setCountry_id(100);
        assertEquals(100,country.getCountry_id());
    }

    public void test_setTimeStamp(){
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        country.setLast_update(ts);
        assertEquals(ts,country.getLast_update());

    }



}
