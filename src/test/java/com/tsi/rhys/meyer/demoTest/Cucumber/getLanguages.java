package com.tsi.rhys.meyer.demoTest.Cucumber;

import com.tsi.rhys.meyer.DatabaseProject.Actor.Actor;
import com.tsi.rhys.meyer.DatabaseProject.Actor.ActorRepository;
import com.tsi.rhys.meyer.DatabaseProject.DatabaseProjectApplication;
import com.tsi.rhys.meyer.DatabaseProject.Film.Film;
import com.tsi.rhys.meyer.DatabaseProject.Film.FilmRepository;
import com.tsi.rhys.meyer.DatabaseProject.Langauage.Language;
import com.tsi.rhys.meyer.DatabaseProject.Langauage.LanguageRepository;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class getLanguages {

    Language l1 = new Language("English");
    Language l2 = new Language("French");
    List<Language> languageList = new ArrayList<Language>();

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

        languageList.add(l1);
        languageList.add(l2);
    }

    @Given("There are languages available")
    public void there_are_languages_available() {
        setup();
    }
    @When("All languages are requested")
    public void all_languages_are_requested() {
        when(databaseProjectApplication.getAllLanguages()).thenReturn(languageList);
    }
    @Then("All languages should be returned")
    public void all_languages_should_be_returned() {
        Assertions.assertEquals(languageList, databaseProjectApplication.getAllLanguages(), "The Languages were not received as expected");
    }

    @Given("The specific language is available")
    public void the_specific_language_is_available() {
        setup();
    }
    @When("The user requests a language")
    public void the_user_requests_a_language() {
        when(databaseProjectApplication.getLanguageID(1)).thenReturn(Optional.of(l1));
    }
    @Then("The language will be returned")
    public void the_language_will_be_returned() {
        Assertions.assertEquals(Optional.of(l1), databaseProjectApplication.getLanguageID(1), "The Language were not received as expected");
    }

}
