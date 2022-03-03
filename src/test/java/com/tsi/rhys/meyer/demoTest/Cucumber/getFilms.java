package com.tsi.rhys.meyer.demoTest.Cucumber;

import com.tsi.rhys.meyer.DatabaseProject.Actor.ActorRepository;
import com.tsi.rhys.meyer.DatabaseProject.DatabaseProjectApplication;
import com.tsi.rhys.meyer.DatabaseProject.Film.Film;
import com.tsi.rhys.meyer.DatabaseProject.Film.FilmRepository;
import com.tsi.rhys.meyer.DatabaseProject.Langauage.LanguageRepository;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

//@CucumberContextConfiguration
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(MockitoExtension.class)
public class getFilms {

    Film film1 = new Film(1,"Title","Desc",2000,1,100,9.99,10,9.99,"PG","Trailers");
    Film film2 = new Film(1,"Title","Desc",2000,1,100,9.99,10,9.99,"PG","Trailers");
    List<Film> filmList = new ArrayList<Film>();

    private DatabaseProjectApplication databaseProjectApplication;

    @Mock
    private LanguageRepository languageRepository;
    @Mock
    private ActorRepository actorRepository;
    @Mock
    private FilmRepository filmRepository;


    @BeforeEach
    void setup() {

        filmRepository = mock(FilmRepository.class);
        actorRepository = mock(ActorRepository.class);
        languageRepository = mock(LanguageRepository.class);
        databaseProjectApplication = new DatabaseProjectApplication(languageRepository, actorRepository,filmRepository );

        filmList.add(film1);
        filmList.add(film2);
    }



    @Given("There are films available")
    public void there_are_films_available() {
        setup();

    }
    @When("All films are requested")
    public void all_films_are_requested() {
        when(databaseProjectApplication.getAllFilm()).thenReturn(filmList);
    }
    @Then("All films should be returned")
    public void all_films_should_be_returned() {
        Assertions.assertEquals(filmList, databaseProjectApplication.getAllFilm(), "The Films were not received as expected");
    }



    @Given("The specific film is available")
    public void the_specific_film_is_available() {
        setup();
    }
    @When("The user requests a film")
    public void the_user_requests_a_film() {
        when(databaseProjectApplication.getFilmID(1)).thenReturn(Optional.of(film1));

    }
    @Then("The film will be returned")
    public void the_film_will_be_returned() {
        Assertions.assertEquals(Optional.of(film1), databaseProjectApplication.getFilmID(1), "The Film were not received as expected");
    }



}
