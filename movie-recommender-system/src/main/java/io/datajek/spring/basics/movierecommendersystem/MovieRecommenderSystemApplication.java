package io.datajek.spring.basics.movierecommendersystem;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class MovieRecommenderSystemApplication {

	public static void main(String[] args) {
		// Overview of Recommender
		// -> it calls .recommendMovies
		// ->     then .recommendMovies bases on types/names(<- filter)

		RecommenderImplementation recommender = new RecommenderImplementation(
				new ContentBasedFilter()
		);

		String[] results = recommender.recommendMovies("n/a");
		System.out.println(Arrays.toString(results));
	}
}