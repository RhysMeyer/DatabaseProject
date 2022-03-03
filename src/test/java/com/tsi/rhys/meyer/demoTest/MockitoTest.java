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
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)//inhereting characteristics needed to use mockito
class MockitoTest {

    private DatabaseProjectApplication databaseProjectApplication;
    MockMvc mockMvc;

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

    @Test
    void testGetFilm(){
        Film film1 = new Film("TestFilm");
        Film film2 = new Film("FilmTest");
        List<Film> filmList = new ArrayList<>();
        filmList.add(film1);
        filmList.add(film2);
        when(databaseProjectApplication.getAllFilm()).thenReturn(filmList);
        Assertions.assertEquals(filmList,databaseProjectApplication.getAllFilm(),"This test has not worked!");
    }

    @Test
    void testAddFilm()
    {
        Film film = new Film(1,"Title","Desc",2000,1,100,9.99,10,9.99,"PG","Trailers");
        String expected = "save"; //String special_features,  int rental_duration, double replacement_cost
        String actual = databaseProjectApplication.addFilm(film.getTitle(), film.getDescription(), film.getRelease_year(),film.getLength(), film.getRating(), film.getLanguage_id(),film.getSpecial_features(),film.getRental_duration(),film.getReplacement_cost());
        ArgumentCaptor<Film>filmArgumentCaptor = ArgumentCaptor.forClass(Film.class);
        verify(filmRepository).save(filmArgumentCaptor.capture());
        filmArgumentCaptor.getValue();
        Assertions.assertEquals(expected,actual,"Data hasn't been entered into the mock database (Film)");
    }

//    @Test
//    void testUpdateFilm() throws Exception {
//        Film film1 = new Film(1,"Title","Desc",2000,1,100,9.99,10,9.99,"PG","Trailers");
//        Film film2 = new Film(1,"Title","Desc",2000,1,100,9.99,10,9.99,"PG","Trailers");
//        Film film = databaseProjectApplication.getFilmID(1);
//        //film_id, String title, String description, int release_year, int length, String rating, int language_id, String special_features,  int rental_duration, float replacement_cost) {
//        String actual = databaseProjectApplication.updateFilm(film.getFilm_id(),"Updated",film.getDescription(),film.getRelease_year(),film.getLength(),film.getRating(),film.getLanguage_id(),film.getSpecial_features(),film.getRental_duration(),film.getReplacement_cost());
//        String expected = "deleted";
//        ArgumentCaptor<Film> filmArgumentCaptor = ArgumentCaptor.forClass(Film.class);
//        verify(filmRepository).save(filmArgumentCaptor.capture());
//        filmArgumentCaptor.getValue();
//        Assertions.assertEquals(expected,actual,"Data hasn't been entered into the mock database (Film)");
//
//    }

    @Test
    void testDeleteFilm(){
        String actual = databaseProjectApplication.deleteFilm(1);
        String expected = "deleted";
        ArgumentCaptor<Integer> filmArgumentCaptor = ArgumentCaptor.forClass(Integer.class);
        verify(filmRepository).deleteById(filmArgumentCaptor.capture());
        filmArgumentCaptor.getValue();
        Assertions.assertEquals(expected, actual, "The specified category was not successfully deleted.");
    }

    @Test
    void testGetActor(){
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



}
