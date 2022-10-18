package io.datajek.spring.basics.movierecommendersystem09externalproperties;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:app.properties")
public class MovieRecommenderSystem09ExternalPropertiesApplication {

	public static void main(String[] args) {
		ApplicationContext appContext = SpringApplication
				.run(MovieRecommenderSystem09ExternalPropertiesApplication.class, args);

		RecommenderImplementation recommender = appContext.getBean(RecommenderImplementation.class);

		String favMovie = recommender.returnFavMovie();
		System.out.println(favMovie);

		String[] result = recommender.recommendMovies(favMovie);
		System.out.println(Arrays.toString(result));
	}
}
