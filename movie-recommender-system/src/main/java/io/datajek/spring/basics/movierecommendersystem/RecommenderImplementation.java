package io.datajek.spring.basics.movierecommendersystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class RecommenderImplementation {

	@Autowired
	@Qualifier("CF")
	private Filter filter;

	public String[] recommendMovies(String movie) {
		System.out.println("Current filter being used: [ " + filter + " ]");

		String[] results = filter.getRecommendations("n/a");

		return results;
	}
}