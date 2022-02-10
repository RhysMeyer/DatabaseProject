package com.tsi.rhys.meyer.demoTest;

import com.tsi.rhys.meyer.DatabaseProject.Country;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
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
        assertEquals("TestCountry",country.getCountry());
    }

    @SpringBootTest
    static
    class SakilaMicroserviceApplicationTests {

        //	@Test
        //	void contextLoads() {
        //	}

    }


}
