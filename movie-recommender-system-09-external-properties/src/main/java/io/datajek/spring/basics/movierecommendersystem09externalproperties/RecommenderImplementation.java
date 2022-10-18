package io.datajek.spring.basics.movierecommendersystem09externalproperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RecommenderImplementation {
    @Autowired
    private Filter filter;

    @Value("${recommender.implementation.favMovie: n/a}")
    private String favMovie;

    public RecommenderImplementation(Filter filter) {
        this.filter = filter;
    }

    public Filter getFilter() {
        return this.filter;
    }

    public String returnFavMovie() {
        return favMovie;
    }

    public String[] recommendMovies(String movie) {
        System.out.println("\nName of the filter is in use: " + filter + "\n");

        String[] results = filter.getRecommendations(movie);

        return results;
    }
}
