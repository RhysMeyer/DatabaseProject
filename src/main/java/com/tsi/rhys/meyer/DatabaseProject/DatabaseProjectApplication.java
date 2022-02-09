package com.tsi.rhys.meyer.DatabaseProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Optional;

@SpringBootApplication
@RestController
@RequestMapping("/Home")
public class DatabaseProjectApplication {

	@Autowired
	private  LanguageRepository languageRepository;
	@Autowired
	private  ActorRepository actorRepository;
	@Autowired
	private  AddressRepository addressRepository;
	@Autowired
	private  CityRepository cityRepository;
	@Autowired
	private  CountryRepository countryRepository;
	@Autowired
	private  FilmRepository filmRepository;
	@Autowired
	private  StoreRepository storeRepository;

//	public DatabaseProjectApplication(LanguageRepository languageRepository, ActorRepository actorRepository, AddressRepository addressRepository,
//		CityRepository cityRepository, CountryRepository countryRepository, FilmRepository filmRepository, StoreRepository storeRepository){
//		this.languageRepository = languageRepository;
//		this.actorRepository = actorRepository;
//		this.addressRepository = addressRepository;
//		this.cityRepository = cityRepository;
//		this.countryRepository = countryRepository;
//		this.filmRepository = filmRepository;
//		this.storeRepository = storeRepository;
//	}

	public DatabaseProjectApplication(LanguageRepository languageRepository, ActorRepository actorRepository){
		this.languageRepository = languageRepository;
		this.actorRepository = actorRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(DatabaseProjectApplication.class, args);
	}
	@GetMapping("/AllLanguages")
	public  @ResponseBody
	Iterable<Language> getAllLanguages(){
		return  languageRepository.findAll();
	}

	@GetMapping("/AllActors")
	public  @ResponseBody
	Iterable<Actor> getAllActors(){
		return actorRepository.findAll();
	}

	@GetMapping("/AllAddress")
	public  @ResponseBody
	Iterable<Address> getAllAddress(){
		return addressRepository.findAll();
	}

	@GetMapping("/AllCities")
	public  @ResponseBody
	Iterable<City> getAllCity(){
		return cityRepository.findAll();
	}

	@GetMapping("/AllCountry")
	public  @ResponseBody
	Iterable<Country> getAllCountry(){
		return countryRepository.findAll();
	}

	@GetMapping("/AllFilm")
	public  @ResponseBody
	Iterable<Film> getAllFilm(){
		return filmRepository.findAll();
	}

	@GetMapping("/AllStores")
	public  @ResponseBody
	Iterable<Store> getAllStores(){
		return storeRepository.findAll();
	}

//	findById

	@RequestMapping(value="/data/{itemid}", method = RequestMethod.GET)
	public @ResponseBody
	String getitem(@PathVariable("itemid") String itemid) {
		return itemid;
	}

	@RequestMapping(value="/actor/{actor_id}", method = RequestMethod.GET)
	public @ResponseBody
	Optional<Actor> getActorID(@PathVariable("actor_id") int actorID) {
		return actorRepository.	findById(actorID);
	}

	@PostMapping("/addCountry")
	public @ResponseBody String addCountry (@RequestParam String country) {
		Date date = new Date();
		Country addCountry = new Country(country, new Timestamp(date.getTime()));
		countryRepository.save(addCountry);
		return "Saved";

	}

}
