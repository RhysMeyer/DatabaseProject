package com.tsi.rhys.meyer.demoTest;

import com.tsi.rhys.meyer.DatabaseProject.Actor.Actor;
import com.tsi.rhys.meyer.DatabaseProject.Actor.ActorRepository;
//import com.tsi.rhys.meyer.DatabaseProject.Address.Address;
//import com.tsi.rhys.meyer.DatabaseProject.Address.AddressRepository;
//import com.tsi.rhys.meyer.DatabaseProject.City.CityRepository;
//import com.tsi.rhys.meyer.DatabaseProject.Country.Country;
//import com.tsi.rhys.meyer.DatabaseProject.Country.CountryRepository;
import com.tsi.rhys.meyer.DatabaseProject.DatabaseProjectApplication;
import com.tsi.rhys.meyer.DatabaseProject.Film.Film;
import com.tsi.rhys.meyer.DatabaseProject.Film.FilmRepository;
import com.tsi.rhys.meyer.DatabaseProject.Langauage.LanguageRepository;
//import com.tsi.rhys.meyer.DatabaseProject.Store.StoreRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)//inhereting characteristics needed to use mockito
public class MockitoTest {

    private DatabaseProjectApplication databaseProjectApplication;

    @Mock
    private LanguageRepository languageRepository; // creating a fake version of the langRepo
    @Mock
    private ActorRepository actorRepository;
//    @Mock
//    private AddressRepository addressRepository;
//    @Mock
//    private CityRepository cityRepository;
//    @Mock
//    private CountryRepository countryRepository;
//    @Mock
//    private StoreRepository storeRepository;
    @Mock
    private FilmRepository filmRepository;

//    @BeforeEach
//    void Setup(){
//        databaseProjectApplication = new DatabaseProjectApplication(languageRepository,actorRepository,addressRepository,cityRepository,countryRepository,filmRepository);
//    }

    @BeforeEach
    void Setup(){
        databaseProjectApplication = new DatabaseProjectApplication(languageRepository,actorRepository,filmRepository);
    }

//    @Test
//    public void testAddCountry(){
//        Country saveCountry = new Country("Test Name");
//        String expected = "Saved";
//        String actual = databaseProjectApplication.addCountry(saveCountry.getCountry());
//        ArgumentCaptor<Country>countryArgumentCaptor = ArgumentCaptor.forClass(Country.class);
//        verify(countryRepository).save(countryArgumentCaptor.capture());
//        countryArgumentCaptor.getValue();
//        Assertions.assertEquals(expected,actual, "Data hasnt been added to mock DB");
//    }

//    @Test
//    public void testAddFilm(){
//        Film saveFilm = new Film("Test Name", "Description Test",2006, 1, "PG", 90);
//        String expected = "Saved";
//        //String addFilm(@RequestParam String title, String description, int release_year, int length, String rating, int language_id){
//        String actual = databaseProjectApplication.addFilm(saveFilm.getTitle(),saveFilm.getDescription(),saveFilm.getRelease_year(),saveFilm.getLength(),saveFilm.getRating(),saveFilm.getLanguage_id());
//        ArgumentCaptor<Film>filmArgumentCaptor = ArgumentCaptor.forClass(Film.class);
//        verify(filmRepository).save(filmArgumentCaptor.capture());
//        filmArgumentCaptor.getValue();
//        Assertions.assertEquals(expected,actual, "Data hasnt been added to mock DB");
 //   }

//    @Test
//    public void testDeleteFilm(){
//        Film saveFilm = new Film("Test Name", "Description Test",2006, 1, "PG", 90);
//        String expected = "Saved";
//        //String addFilm(@RequestParam String title, String description, int release_year, int length, String rating, int language_id){
//        String actual = databaseProjectApplication.addFilm(saveFilm.getTitle(),saveFilm.getDescription(),saveFilm.getRelease_year(),saveFilm.getLength(),saveFilm.getRating(),saveFilm.getLanguage_id());
//        ArgumentCaptor<Film>filmArgumentCaptor = ArgumentCaptor.forClass(Film.class);
//        verify(filmRepository).save(filmArgumentCaptor.capture());
//        filmArgumentCaptor.getValue();
//        Assertions.assertEquals(expected,actual, "Data hasnt been added to mock DB");
//    }

    @Test
    public void testGetActor(){
        Actor actor1 = new Actor("Actor","Test");
        Actor actor2 = new Actor("Test","Actor");
        List<Actor> actorList = new ArrayList<>();
        actorList.add(actor1);
        actorList.add(actor2);
        when(databaseProjectApplication.getAllActors()).thenReturn(actorList);
        Assertions.assertEquals(actorList,databaseProjectApplication.getAllActors(),"This test has not worked!");
    }

//    @Test
//    public void testGetAddress(){
//        Address address1 = new Address();
//        Actor actor1 = new Actor("Actor","Test");
//        Actor actor2 = new Actor("Test","Actor");
//        List<Actor> actorList = new ArrayList<>();
//        actorList.add(actor1);
//        actorList.add(actor2);
//        when(databaseProjectApplication.getAllActors()).thenReturn(actorList);
//        Assertions.assertEquals(actorList,databaseProjectApplication.getAllActors(),"This test has not worked!");
//    }

    @Test
    public void testGetFilm(){
        Film film1 = new Film("TestFilm");
        Film film2 = new Film("FilmTest");
        List<Film> filmList = new ArrayList<>();
        filmList.add(film1);
        filmList.add(film2);
        when(databaseProjectApplication.getAllFilm()).thenReturn(filmList);
        Assertions.assertEquals(filmList,databaseProjectApplication.getAllFilm(),"This test has not worked!");
    }

}
