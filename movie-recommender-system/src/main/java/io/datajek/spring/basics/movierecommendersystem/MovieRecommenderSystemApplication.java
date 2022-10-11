package io.datajek.spring.basics.movierecommendersystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class MovieRecommenderSystemApplication {

	public static void main(String[] args) {
		// Overview of Recommender
		// -> it calls .recommendMovies
		// ->     then .recommendMovies bases on types/names(<- filter)

		// [When not using the 'Filter' interface]
		// Currently we are "recommending" based on the 'Content' Filter, and
		// it's already hardcoded in the implementation filter, every time we
		// want to change it to other filters (e.g. like based on 'Genre'), we
		// have to edit it again. But what we want to achieve is that change the
		// tweak level to the top (i.e. here), so it's more like changing an
		// method parameter, instead of changing the underlying code.
		// RecommenderImplementation recommender = new RecommenderImplementation();

		RecommenderImplementation recommender = new RecommenderImplementation(
				new ContentBasedFilter()
		);

		String[] results = recommender.recommendMovies("n/a");
		System.out.println(Arrays.toString(results));
	}
}