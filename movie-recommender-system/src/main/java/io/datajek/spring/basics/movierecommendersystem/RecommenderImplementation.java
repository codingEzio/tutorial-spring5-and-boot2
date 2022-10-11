package io.datajek.spring.basics.movierecommendersystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RecommenderImplementation {

	// Marking classes with @Component lets Spring manage those objects, and
	// @Autowired marks the object being annotated is a dependency of the
	// component.

	@Autowired
	private Filter contentBasedFilter;

	public String[] recommendMovies(String movie) {
		System.out.println("Current filter being used: [ " + contentBasedFilter + " ]");

		// Calls the filter based the parameter passed down from the main app
		String[] results = contentBasedFilter.getRecommendations("n/a");

		return results;
	}
}