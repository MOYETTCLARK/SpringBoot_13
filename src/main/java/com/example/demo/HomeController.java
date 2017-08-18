package com.example.demo;

// import com.example.demo.models.Actor;
// import com.example.demo.models.Movie;
// import com.example.demo.repositories.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {

    @Autowired
    ActorRepository actorRepository;

    @RequestMapping("/")
    public String index(Model model){
        // First create an actor
        Actor actor = new Actor();
        actor.setName("SandraBullock");
        actor.setRealname("Sandra Mae Bullowski");

        // Create a movie
        Movie movie = new Movie();
        movie.setTitle("Emoji Movie");
        movie.setYear(2017);
        movie.setDescription("About Emojis ........");

        // Add movie to empty list
        Set<Movie> movies = new HashSet<Movie>();
        movies.add(movie);

        // Add list of movies to actor's movie list
        actor.setMovies(movies);

        // Save actor to database
        actorRepository.save(actor);

        // Grave all actors from database and send them to template
        model.addAttribute("actors", actorRepository.findAll() );
        return "index";
    }
}
