package com.tsi.rhys.meyer.DatabaseProject;

import com.tsi.rhys.meyer.DatabaseProject.Actor.Actor;
import com.tsi.rhys.meyer.DatabaseProject.Actor.ActorRepository;
import com.tsi.rhys.meyer.DatabaseProject.Film.Film;
import com.tsi.rhys.meyer.DatabaseProject.Film.FilmRepository;
import com.tsi.rhys.meyer.DatabaseProject.Langauage.Language;
import com.tsi.rhys.meyer.DatabaseProject.Langauage.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@SpringBootApplication
@RestController
@RequestMapping("/index")
public class DatabaseProjectApplication {

	@Autowired
	private LanguageRepository languageRepository;
	@Autowired
	private ActorRepository actorRepository;
	@Autowired
	private FilmRepository filmRepository;

	private String saved = "save";

	public DatabaseProjectApplication(LanguageRepository languageRepository, ActorRepository actorRepository, FilmRepository filmRepository){
		this.languageRepository = languageRepository;
		this.actorRepository = actorRepository;
		this.filmRepository = filmRepository;
	}

	public static void main(String[] args) {SpringApplication.run(DatabaseProjectApplication.class, args);
	}

	@CrossOrigin(origins = "*")
	@GetMapping("/actor/all")
	public  @ResponseBody
	Iterable<Actor> getAllActors(){
		return actorRepository.findAll();
	}

	@GetMapping(value="/actor/{actor_id}")
	public @ResponseBody
	Optional<Actor> getActorID(@PathVariable("actor_id") int actorID) {
		return actorRepository.	findById(actorID);
	}


	@CrossOrigin(origins = "*")
	@GetMapping("/film/all")
	public  @ResponseBody
	Iterable<Film> getAllFilm(){
		return filmRepository.findAll();
	}

	@GetMapping("/film/{film_id}")
	public @ResponseBody
	Optional<Film> getFilmID(@PathVariable("film_id") int filmID) {
		return filmRepository.findById(filmID);
	}

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
		Film updatedFilm = filmRepository.findById(film_id).get();
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

		filmRepository.save(updatedFilm);
		return saved;
	}

	@CrossOrigin(origins = "*")
	@DeleteMapping("/film/delete")
	public @ResponseBody String deleteFilm(@RequestParam int id)
	{
		filmRepository.deleteById(id);
		return "deleted";
	}

	@GetMapping("/AllLanguages")
	public  @ResponseBody
	Iterable<Language> getAllLanguages(){
		return  languageRepository.findAll();
	}

	@GetMapping("/language/{language_id}")
	public @ResponseBody
	Optional<Language> getLanguageID(@PathVariable("language_id") int languageID) {
		return languageRepository.findById(languageID);
	}

}
