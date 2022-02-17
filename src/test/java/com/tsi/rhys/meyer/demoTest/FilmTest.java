package com.tsi.rhys.meyer.demoTest;

import com.tsi.rhys.meyer.DatabaseProject.Actor.Actor;
import com.tsi.rhys.meyer.DatabaseProject.Film.Film;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FilmTest {

    private Film film = new Film();

    @Test
    public void test_constructor(){
        assertTrue("Its not an instance of Actor", film instanceof Film);
    }

    @Test
    public void test_getFilmID(){
        film.setFilm_id(1);
        assertEquals(1, film.getFilm_id());
    }

    @Test
    public void test_getTitle(){
        film.setTitle("Test");
        assertEquals("Test", film.getTitle());
    }

    @Test
    public void test_getDescription(){
        film.setDescription("TestDesc");
        assertEquals("TestDesc", film.getDescription());
    }

    @Test
    public void test_getReleaseYear(){
        film.setRelease_year(2000);
        assertEquals(2000, film.getRelease_year());
    }

    @Test
    public void test_getLanguageID(){
        film.setLanguage_id(1);
        assertEquals(1, film.getLanguage_id());
    }

    @Test
    public void test_getRentalDuration(){
        film.setRental_duration(2);
        assertEquals(2, film.getRental_duration());
    }

//    @Test
//    public void test_getRentalRate(){
//        film.setRental_rate(10.0f);
//        assertEquals(10.0f, film.getRental_rate());
//    }

    @Test
    public void test_getLength(){
        film.setLength(200);
        assertEquals(200, film.getLength());
    }

//    @Test
//    public void test_getReplacementCost(){
//        film.setReplacement_cost(20.23f);
//        assertEquals(20.23f, film.getReplacement_cost());
//    }

    @Test
    public void test_getRating(){
        film.setRating("PG13");
        assertEquals("PG13", film.getRating());
    }

    @Test
    public void test_getSpecialFeatures(){
        film.setSpecial_features("Trailers");
        assertEquals("Trailers", film.getSpecial_features());
    }



}
