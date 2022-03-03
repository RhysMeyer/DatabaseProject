package com.tsi.rhys.meyer.demoTest.Cucumber;

import com.tsi.rhys.meyer.DatabaseProject.Actor.Actor;
import com.tsi.rhys.meyer.DatabaseProject.Actor.ActorRepository;
import com.tsi.rhys.meyer.DatabaseProject.DatabaseProjectApplication;
import com.tsi.rhys.meyer.DatabaseProject.Film.FilmRepository;
import com.tsi.rhys.meyer.DatabaseProject.Langauage.LanguageRepository;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class getActors {

    //Film film1 = new Film(1,"Title","Desc",2000,1,100,9.99,10,9.99,"PG","Trailers");
    //        Film film2 = new Film(1,"Title","Desc",2000,1,100,9.99,10,9.99,"PG","Trailers");
//        List<Film> filmList = new ArrayList<Film>();
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


    @BeforeEach
    void setup() {

        filmRepository = mock(FilmRepository.class);
        actorRepository = mock(ActorRepository.class);
        languageRepository = mock(LanguageRepository.class);
        databaseProjectApplication = new DatabaseProjectApplication(languageRepository, actorRepository,filmRepository );

        actorList.add(actor1);
        actorList.add(actor2);
    }



    @Given("There are actors available")
    public void there_are_actors_available() {
        setup();

    }
    @When("All actors are requested")
    public void all_actors_are_requested() {
        when(databaseProjectApplication.getAllActors()).thenReturn(actorList);
    }
    @Then("All available actors should be returned")
    public void all_available_actors_should_be_returned() {
        Assertions.assertEquals(actorList, databaseProjectApplication.getAllActors(), "The Films were not received as expected");
    }



    @Given("The specific actor is available")
    public void the_specific_actor_is_available() {
        setup();
    }
    @When("The user requests a actor")
    public void the_user_requests_a_actor() {
        when(databaseProjectApplication.getActorID(1)).thenReturn(Optional.of(actor1));

    }
    @Then("The actor will be returned")
    public void the_actor_will_be_returned() {
        Assertions.assertEquals(Optional.of(actor1), databaseProjectApplication.getActorID(1), "The Film were not received as expected");
    }

}
