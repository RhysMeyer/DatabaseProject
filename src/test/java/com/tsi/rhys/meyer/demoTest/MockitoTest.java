package com.tsi.rhys.meyer.demoTest;

import com.tsi.rhys.meyer.DatabaseProject.DatabaseProjectApplication;
import com.tsi.rhys.meyer.DatabaseProject.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.verify;
import org.springframework.beans.factory.annotation.Autowired;

@ExtendWith(MockitoExtension.class)//inhereting characteristics needed to use mockito
public class MockitoTest {

    private DatabaseProjectApplication databaseProjectApplication;

    @Mock
    private LanguageRepository languageRepository; // creating a fake version of the langRepo
    @Mock
    private ActorRepository actorRepository;
    @Mock
    private AddressRepository addressRepository;
    @Mock
    private CityRepository cityRepository;
    @Mock
    private CountryRepository countryRepository;
    @Mock
    private StoreRepository storeRepository;
    @Mock
    private FilmRepository filmRepository;

    @BeforeEach
    void Setup(){
        databaseProjectApplication = new DatabaseProjectApplication(languageRepository,actorRepository,addressRepository,cityRepository,countryRepository,filmRepository,storeRepository);
    }

    @Test
    public void testAddCountry(){
        Country saveCountry = new Country("Test Name");
        String expected = "Saved";
        String actual = databaseProjectApplication.addCountry(saveCountry.getCountry());
        ArgumentCaptor<Country>countryArgumentCaptor = ArgumentCaptor.forClass(Country.class);
        verify(countryRepository).save(countryArgumentCaptor.capture());
        countryArgumentCaptor.getValue();
        Assertions.assertEquals(expected,actual, "Data hasnt been added to mock DB");
    }

}
