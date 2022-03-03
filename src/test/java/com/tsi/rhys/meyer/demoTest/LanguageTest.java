package com.tsi.rhys.meyer.demoTest;

//import com.tsi.rhys.meyer.DatabaseProject.Country.Country;
import com.tsi.rhys.meyer.DatabaseProject.Film.Film;
import com.tsi.rhys.meyer.DatabaseProject.Langauage.Language;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LanguageTest {

    private Language language = new Language();

    @Test
    void test_constructor(){
        assertTrue("Its not an instance of Language", language instanceof Language);
    }

    @Test
    void test_languageInstantiation(){
        language = new Language("test");
        assertEquals("test",language.getName());
    }

    @Test
    void test_getLanguageID(){
        language.setLanguage_id(1);
        assertEquals(1, language.getLanguage_id());
    }

    @Test
    void test_getName(){
        language.setName("TestLan");
        assertEquals("TestLan", language.getName());
    }


}
