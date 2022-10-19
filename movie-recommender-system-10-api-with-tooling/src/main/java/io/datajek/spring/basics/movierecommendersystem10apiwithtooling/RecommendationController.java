package io.datajek.spring.basics.movierecommendersystem10apiwithtooling;

import java.util.List;
import java.util.Arrays;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecommendationController {

    @GetMapping("/movies")
    public List<Movie> getAllMovies() {
        return Arrays.asList(
                new Movie(1, "Interstellar", 9.5),
                new Movie(2, "Blade Runner 2042", 8.2),
                new Movie(3, "Avengers", 8.3));
    }
}
