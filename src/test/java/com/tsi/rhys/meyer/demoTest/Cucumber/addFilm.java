package com.tsi.rhys.meyer.demoTest.Cucumber;

import com.tsi.rhys.meyer.DatabaseProject.Actor.Actor;
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
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class addFilm {

    Film film = new Film(1,"Title","Desc",2000,1,100,9.99,10,9.99,"PG","Trailers");

    Actor actor1 = new Actor(1,"Test", "Test");
    Actor actor2 = new Actor(2,"Test1", "Test1");
    List<Actor> actorList = new ArrayList<Actor>();

    private DatabaseProjectApplication databaseProjectApplication;

    @Mock
    private LanguageRepository languageRepository;
    @Mock
    private ActorRepository actorRepository;
    @Mock
    private FilmRepository filmRepository;

    String expected = "expected";
    String actual;


    @BeforeEach
    void setup() {

        String expected = "save"; //String special_features,  int rental_duration, double replacement_cost
        filmRepository = mock(FilmRepository.class);
        actorRepository = mock(ActorRepository.class);
        languageRepository = mock(LanguageRepository.class);
        databaseProjectApplication = new DatabaseProjectApplication(languageRepository, actorRepository,filmRepository );

        actorList.add(actor1);
        actorList.add(actor2);
    }

    @Given("Have a valid film to add")
    public void have_a_valid_film_to_add() {
        setup();
    }
    @When("We add the new Film")
    public void we_add_the_new_film() {
        actual = databaseProjectApplication.addFilm(film.getTitle(), film.getDescription(), film.getRelease_year(),film.getLength(), film.getRating(), film.getLanguage_id(),film.getSpecial_features(),film.getRental_duration(),film.getReplacement_cost());

    }
    @Then("The new Film should be added and a saved message recieved")
    public void the_new_film_should_be_added_and_a_saved_message_recieved() {
        ArgumentCaptor<Film> filmArgumentCaptor = ArgumentCaptor.forClass(Film.class);
        verify(filmRepository).save(filmArgumentCaptor.capture());
        filmArgumentCaptor.getValue();
        Assertions.assertEquals("save",actual,"Data hasn't been entered into the mock database (Film)");
    }

}
