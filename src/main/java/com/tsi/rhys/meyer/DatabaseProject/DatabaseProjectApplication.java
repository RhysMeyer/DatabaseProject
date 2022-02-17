package com.tsi.rhys.meyer.DatabaseProject;

import com.amazonaws.services.secretsmanager.AWSSecretsManager;
import com.amazonaws.services.secretsmanager.AWSSecretsManagerClientBuilder;
import com.amazonaws.services.secretsmanager.model.*;
import com.tsi.rhys.meyer.DatabaseProject.Actor.Actor;
import com.tsi.rhys.meyer.DatabaseProject.Actor.ActorRepository;
import com.tsi.rhys.meyer.DatabaseProject.Address.Address;
import com.tsi.rhys.meyer.DatabaseProject.Address.AddressRepository;
import com.tsi.rhys.meyer.DatabaseProject.City.City;
import com.tsi.rhys.meyer.DatabaseProject.City.CityRepository;
import com.tsi.rhys.meyer.DatabaseProject.Country.Country;
import com.tsi.rhys.meyer.DatabaseProject.Country.CountryRepository;
import com.tsi.rhys.meyer.DatabaseProject.Film.Film;
import com.tsi.rhys.meyer.DatabaseProject.Film.FilmRepository;
import com.tsi.rhys.meyer.DatabaseProject.Langauage.Language;
import com.tsi.rhys.meyer.DatabaseProject.Langauage.LanguageRepository;
import com.tsi.rhys.meyer.DatabaseProject.Store.Store;
import com.tsi.rhys.meyer.DatabaseProject.Store.StoreRepository;
import org.apache.maven.plugin.descriptor.InvalidParameterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.model.ResourceNotFoundException;

import java.sql.Timestamp;
import java.util.Base64;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;

//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@SpringBootApplication
@RestController
@RequestMapping("/index")
public class DatabaseProjectApplication {

	@Autowired
	private LanguageRepository languageRepository;
	@Autowired
	private ActorRepository actorRepository;
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private CityRepository cityRepository;
	@Autowired
	private CountryRepository countryRepository;
	@Autowired
	private FilmRepository filmRepository;
	@Autowired
	private StoreRepository storeRepository;

	public DatabaseProjectApplication(LanguageRepository languageRepository, ActorRepository actorRepository, AddressRepository addressRepository,
		CityRepository cityRepository, CountryRepository countryRepository, FilmRepository filmRepository, StoreRepository storeRepository){
		this.languageRepository = languageRepository;
		this.actorRepository = actorRepository;
		this.addressRepository = addressRepository;
		this.cityRepository = cityRepository;
		this.countryRepository = countryRepository;
		this.filmRepository = filmRepository;
		this.storeRepository = storeRepository;
	}

//	public DatabaseProjectApplication(LanguageRepository languageRepository, ActorRepository actorRepository){
//		this.languageRepository = languageRepository;
//		this.actorRepository = actorRepository;
//	}

	public static void main(String[] args) {SpringApplication.run(DatabaseProjectApplication.class, args);
	}


	////////////////////////ACTOR////////////////////////
	@GetMapping("/AllActors")
	public  @ResponseBody
	Iterable<Actor> getAllActors(){
		return actorRepository.findAll();
	}

	@RequestMapping(value="/actor/{actor_id}", method = RequestMethod.GET)
	public @ResponseBody
	Optional<Actor> getActorID(@PathVariable("actor_id") int actorID) {
		return actorRepository.	findById(actorID);
	}

	////////////////////////Address////////////////////////
	@GetMapping("/AllAddress")
	public  @ResponseBody
	Iterable<Address> getAllAddress(){
		return addressRepository.findAll();
	}

	@RequestMapping(value="/address/{address_id}", method = RequestMethod.GET)
	public @ResponseBody
	Optional<Address> getAddressID(@PathVariable("address_id") int addressID) {
		return addressRepository.findById(addressID);
	}

	////////////////////////City////////////////////////
	@GetMapping("/AllCities")
	public  @ResponseBody
	Iterable<City> getAllCity(){
		return cityRepository.findAll();
	}

	@RequestMapping(value="/city/{city_id}", method = RequestMethod.GET)
	public @ResponseBody
	Optional<City> getCityID(@PathVariable("city_id") int cityID) {
		return cityRepository.findById(cityID);
	}

	////////////////////////Country////////////////////////

	@GetMapping("/AllCountry")
	public  @ResponseBody
	Iterable<Country> getAllCountry(){
		return countryRepository.findAll();
	}

	@RequestMapping(value="/country/{country_id}", method = RequestMethod.GET)
	public @ResponseBody
	Optional<Country> getCountryID(@PathVariable("country_id") int countryID) {
		return countryRepository.findById(countryID);
	}

	@PostMapping("/addCountry")
	public @ResponseBody String addCountry (@RequestParam String country) {
		Date date = new Date();
		Country addCountry = new Country(country, new Timestamp(date.getTime()));
		countryRepository.save(addCountry);
		return "Saved";

	}

//	@Query("from Auction a join a.category c where c.name=:categoryName")
//	public Iterable<Country> findByCategory(@Param("categoryName") String categoryName);

	@GetMapping("/Country")
	public @ResponseBody
	Collection<Country> getCountryByID(){return countryRepository.findCountryByID();}

	////////////////////////Film////////////////////////
	@GetMapping("/AllFilm")
	public  @ResponseBody
	Iterable<Film> getAllFilm(){
		return filmRepository.findAll();
	}

	@RequestMapping(value="/film/{film_id}", method = RequestMethod.GET)
	public @ResponseBody
	Optional<Film> getFilmID(@PathVariable("film_id") int filmID) {
		return filmRepository.findById(filmID);
	}

	@PostMapping("/addFilm")
	public @ResponseBody String addFilm(@RequestParam String title, String description, int release_year, int length, String rating, int language_id){
		Film addFilm = new Film(title, description, release_year, length, rating, language_id);
		//Film addFilm = new Film();
		filmRepository.save(addFilm);
		return "Saved";
	}


	@DeleteMapping("/removeFilm")
	public @ResponseBody String deleteFilms(@RequestParam int id)
	{
		filmRepository.findById(id).orElseThrow();
		filmRepository.deleteById(id);
		return "Deleted";
	}

//	@PostMapping("/addFilm")
//	public @ResponseBody String addFilm(@RequestParam String title) {
//		Date date = new Date();
//		Film addCountry = new Film(title);
//		filmRepository.save(addCountry);
//		return "Saved";
//
//	}



	////////////////////////Language////////////////////////

	@GetMapping("/AllLanguages")
	public  @ResponseBody
	Iterable<Language> getAllLanguages(){
		return  languageRepository.findAll();
	}

	@RequestMapping(value="/language/{language_id}", method = RequestMethod.GET)
	public @ResponseBody
	Optional<Language> getLanguageID(@PathVariable("language_id") int languageID) {
		return languageRepository.findById(languageID);
	}


	////////////////////////Store////////////////////////
	@GetMapping("/AllStores")
	public  @ResponseBody
	Iterable<Store> getAllStores(){
		return storeRepository.findAll();
	}

	@RequestMapping(value="/store/{store_id}", method = RequestMethod.GET)
	public @ResponseBody
	Optional<Store> getStoreID(@PathVariable("store_id") int languageID) {
		return storeRepository.findById(languageID);
	}





}
