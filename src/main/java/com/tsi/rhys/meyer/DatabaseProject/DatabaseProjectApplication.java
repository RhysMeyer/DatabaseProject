package com.tsi.rhys.meyer.DatabaseProject;

import com.amazonaws.services.secretsmanager.AWSSecretsManager;
import com.amazonaws.services.secretsmanager.AWSSecretsManagerClientBuilder;
import com.amazonaws.services.secretsmanager.model.*;
import com.tsi.rhys.meyer.DatabaseProject.Actor.Actor;
import com.tsi.rhys.meyer.DatabaseProject.Actor.ActorRepository;
//import com.tsi.rhys.meyer.DatabaseProject.Address.Address;
//import com.tsi.rhys.meyer.DatabaseProject.Address.AddressRepository;
//import com.tsi.rhys.meyer.DatabaseProject.City.City;
//import com.tsi.rhys.meyer.DatabaseProject.City.CityRepository;
//import com.tsi.rhys.meyer.DatabaseProject.Country.Country;
//import com.tsi.rhys.meyer.DatabaseProject.Country.CountryRepository;
import com.tsi.rhys.meyer.DatabaseProject.Film.Film;
import com.tsi.rhys.meyer.DatabaseProject.Film.FilmRepository;
import com.tsi.rhys.meyer.DatabaseProject.Langauage.Language;
import com.tsi.rhys.meyer.DatabaseProject.Langauage.LanguageRepository;
//import com.tsi.rhys.meyer.DatabaseProject.Store.Store;
//import com.tsi.rhys.meyer.DatabaseProject.Store.StoreRepository;
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
import java.util.*;

//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@SpringBootApplication
@RestController
@RequestMapping("/index")
public class DatabaseProjectApplication {

	@Autowired
	private LanguageRepository languageRepository;
	@Autowired
	private ActorRepository actorRepository;
//	@Autowired
//	private AddressRepository addressRepository;
//	@Autowired
//	private CityRepository cityRepository;
//	@Autowired
//	private CountryRepository countryRepository;
	@Autowired
	private FilmRepository filmRepository;
//	@Autowired
//	private StoreRepository storeRepository;

	private String saved = "save";

//	public DatabaseProjectApplication(LanguageRepository languageRepository, ActorRepository actorRepository, AddressRepository addressRepository,
//		CityRepository cityRepository, CountryRepository countryRepository, FilmRepository filmRepository){
//		this.languageRepository = languageRepository;
//		this.actorRepository = actorRepository;
//		this.addressRepository = addressRepository;
//		this.cityRepository = cityRepository;
//		this.countryRepository = countryRepository;
//		this.filmRepository = filmRepository;
////		this.storeRepository = storeRepository;
//	}

	public DatabaseProjectApplication(LanguageRepository languageRepository, ActorRepository actorRepository, FilmRepository filmRepository){
		this.languageRepository = languageRepository;
		this.actorRepository = actorRepository;
		this.filmRepository = filmRepository;
	}

//	public DatabaseProjectApplication(LanguageRepository languageRepository, ActorRepository actorRepository){
//		this.languageRepository = languageRepository;
//		this.actorRepository = actorRepository;
//	}

	public static void main(String[] args) {SpringApplication.run(DatabaseProjectApplication.class, args);
	}


	////////////////////////ACTOR////////////////////////
	@CrossOrigin(origins = "*")
	@GetMapping("/actor/all")
	public  @ResponseBody
	Iterable<Actor> getAllActors(){
		return actorRepository.findAll();
	}

	@RequestMapping(value="/actor/{actor_id}", method = RequestMethod.GET)
	public @ResponseBody
	Optional<Actor> getActorID(@PathVariable("actor_id") int actorID) {
		return actorRepository.	findById(actorID);
	}

//	@CrossOrigin(origins = "*")
//	@GetMapping("get_actor")
//	public @ResponseBody
//	Iterable<Actor> getActor(@RequestParam(value = "id", required = false) Integer id,
//							 @RequestParam(value = "nameQuery", required = false) String actorQuery,
//							 @RequestParam(value = "film_id", required = false) Integer film_id)
//	{
//		Iterable<Actor> table;
//		if(id != null)
//		{
//			table = actorRepository.findAll();
//		}
//		else
//		{
//			table = actorRepository.findAll();
//		}
//
//		if(actorQuery != null)
//		{
//			actorQuery = actorQuery.toUpperCase();
//			Iterator<Actor> actorIt = table.iterator();
//			ArrayList<Actor> returnActors = new ArrayList<>();
//			while(actorIt.hasNext())
//			{
//				Actor a = actorIt.next();
//				if(a.getFirst_name().contains(actorQuery) || a.getLast_name().contains(actorQuery))
//				{
//					returnActors.add(a);
//				}
//			}
//			table = returnActors;
//		}
//		if(film_id != null)
//		{
//			Iterator<Film> filmIt = getFilms(film_id, null, null).iterator();
//			if(!filmIt.hasNext()) // No film of this id found
//			{
//				//throw new ResourceNotFoundException("Film of id " + film_id + " does not exist");
//			}
//			Film f = filmIt.next();
//			Set<Actor> actorFilms = f.getActor();
//			ArrayList<Actor> returnActors = new ArrayList<>();
//			for(Actor a : table)
//			{
//				if(actorFilms.contains(a))
//				{
//					returnActors.add(a);
//				}
//			}
//			table = returnActors;
//		}
//		return table;
//	}

	////////////////////////Address////////////////////////
//	@GetMapping("/AllAddress")
//	public  @ResponseBody
//	Iterable<Address> getAllAddress(){
//		return addressRepository.findAll();
//	}
//
//	@RequestMapping(value="/address/{address_id}", method = RequestMethod.GET)
//	public @ResponseBody
//	Optional<Address> getAddressID(@PathVariable("address_id") int addressID) {
//		return addressRepository.findById(addressID);
//	}
//
//	////////////////////////City////////////////////////
//	@GetMapping("/AllCities")
//	public  @ResponseBody
//	Iterable<City> getAllCity(){
//		return cityRepository.findAll();
//	}
//
//	@RequestMapping(value="/city/{city_id}", method = RequestMethod.GET)
//	public @ResponseBody
//	Optional<City> getCityID(@PathVariable("city_id") int cityID) {
//		return cityRepository.findById(cityID);
//	}
//
//	////////////////////////Country////////////////////////
//
//	@GetMapping("/AllCountry")
//	public  @ResponseBody
//	Iterable<Country> getAllCountry(){
//		return countryRepository.findAll();
//	}
//
//	@RequestMapping(value="/country/{country_id}", method = RequestMethod.GET)
//	public @ResponseBody
//	Optional<Country> getCountryID(@PathVariable("country_id") int countryID) {
//		return countryRepository.findById(countryID);
//	}
//
//	@PostMapping("/addCountry")
//	public @ResponseBody String addCountry (@RequestParam String country) {
//		Date date = new Date();
//		Country addCountry = new Country(country, new Timestamp(date.getTime()));
//		countryRepository.save(addCountry);
//		return "Saved";
//
//	}
//
////	@Query("from Auction a join a.category c where c.name=:categoryName")
////	public Iterable<Country> findByCategory(@Param("categoryName") String categoryName);
//
//	@GetMapping("/Country")
//	public @ResponseBody
//	Collection<Country> getCountryByID(){return countryRepository.findCountryByID();}
//
	////////////////////////Film////////////////////////
	@CrossOrigin(origins = "*")
	@GetMapping("/film/all")
	public  @ResponseBody
	Iterable<Film> getAllFilm(){
		return filmRepository.findAll();
	}

	@RequestMapping(value="/film/{film_id}", method = RequestMethod.GET)
	public @ResponseBody
	Optional<Film> getFilmID(@PathVariable("film_id") int filmID) {
		//filmRepository.findById(filmID).orElseThrow();
		return filmRepository.findById(filmID);
	}

//	//@PostMapping("/addFilm")
//	@RequestMapping(path="/addFilm", method = RequestMethod.POST)
//	public @ResponseBody String addFilm (@RequestParam String title,
//	@RequestParam String description,
//	@RequestParam int language_id,
//	@RequestParam(value = "original_language_id", required = false) Integer original_language_id,
//	@RequestParam int rental_duration,
//	@RequestParam float rental_rate,
//	@RequestParam(value = "length", required = false) Integer length,
//	@RequestParam float replacement_cost,
//	@RequestParam String rating){//Film addFilm = new Film(title, description, release_year, length, rating, language_id);
//		Film addFilm = new Film();
//		filmRepository.save(addFilm);
//		return "Saved";
//	}

	@CrossOrigin(origins = "*")
	@PostMapping("/film/add")
	public @ResponseBody
	String addFilm(@RequestParam String title, String description, int release_year, int length, String rating, int language_id, String special_features,  int rental_duration, double replacement_cost) {
		Film addFilm = new Film(title, description, release_year, length, rating, language_id, special_features, rental_duration, replacement_cost);
		filmRepository.save(addFilm);
		return saved;
	}
	@CrossOrigin(origins = "*")
	@PutMapping("/film/update")
	public @ResponseBody
	String updateFilm(@RequestParam int film_id, String title, String description, int release_year, int length, String rating, int language_id, String special_features,  int rental_duration, double replacement_cost) {
		Film updatedFilm = filmRepository.findById(film_id).orElseThrow();
//		try {
//			updatedFilm = filmRepository.findById(film_id);
//		} catch (Exception e) {
//
//		}
		updatedFilm.setTitle(title);
		updatedFilm.setTitle(title);
		updatedFilm.setDescription(description);
		updatedFilm.setRelease_year(release_year);
		updatedFilm.setLength(length);
		updatedFilm.setRating(rating);
		updatedFilm.setLanguage_id(language_id);
		updatedFilm.setSpecial_features(special_features);
		updatedFilm.setRental_duration(rental_duration);
		updatedFilm.setReplacement_cost(replacement_cost);
		//Film addFilm = new Film(title, description, release_year, length, rating, language_id, special_features, rental_duration, replacement_cost);

		filmRepository.save(updatedFilm);
		return saved;
	}



////	@CrossOrigin(origins = "*")
////	@GetMapping("get_film")
////	public @ResponseBody
////	Iterable<Film> getFilms
////			(
////					@RequestParam(value = "id", required = false) Integer id,
////					@RequestParam(value = "titleQuery", required = false) String titleQuery,
////					@RequestParam(value = "actor_id", required = false) Integer actor_id
////			)
////	{
////		Iterable<Film> table;
////		// Get the film with the given id
////		if(id != null)
////		{
//////			table = filmRepository.getAllFilmsById(id);
////			table = filmRepository.findAll();
////		}
////		else
////		{
////			table = filmRepository.findAll();
////		}
////
////		// Make the table only contain films that fit the title query
////		if(titleQuery != null)
////		{
////			titleQuery = titleQuery.toUpperCase();
////			Iterator<Film> filmIt = table.iterator();
////			ArrayList<Film> returnFilms = new ArrayList<>();
////			while(filmIt.hasNext())
////			{
////				Film f = filmIt.next();
////				if(f.getTitle().contains(titleQuery))
////				{
////					returnFilms.add(f);
////				}
////			}
////			table = returnFilms;
////		}
//
//		if(actor_id != null)
//		{
//			Iterator<Actor> actorIt = getActor(actor_id, null, null).iterator();
//			if(!actorIt.hasNext()) // No actor of this id found
//			{
//				//throw new ResourceNotFoundException("Actor of id " + actor_id + " does not exist");
//			}
//			Actor a = actorIt.next();
//			Set<Film> actorFilms = a.getFilms();
//			ArrayList<Film> returnFilms = new ArrayList<>();
//			for(Film f : table)
//			{
//				if(actorFilms.contains(f)) {
//					returnFilms.add(f);
//				}
//			}
//			table = returnFilms;
//		}
//		return table;
//	}


	@CrossOrigin(origins = "*")
	@DeleteMapping("/film/delete")
	public @ResponseBody String deleteFilm(@RequestParam int id)
	{
		//filmRepository.findById(id).orElseThrow();
		filmRepository.deleteById(id);
		return "deleted";
	}

//	@PostMapping("/addFilm")
//	public @ResponseBody String addFilm(@RequestParam String title) {
//		Date date = new Date();
//		Film addFilm = new Film(title);
//		addFilm.setLanguage_id(1);
//		filmRepository.save(addFilm);
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
//	@GetMapping("/AllStores")
//	public  @ResponseBody
//	Iterable<Store> getAllStores(){
//		return storeRepository.findAll();
//	}
//
//	@RequestMapping(value="/store/{store_id}", method = RequestMethod.GET)
//	public @ResponseBody
//	Optional<Store> getStoreID(@PathVariable("store_id") int languageID) {
//		return storeRepository.findById(languageID);
//	}





}
