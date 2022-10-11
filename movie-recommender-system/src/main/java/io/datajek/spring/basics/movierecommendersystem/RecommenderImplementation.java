package io.datajek.spring.basics.movierecommendersystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RecommenderImplementation {

	// Marking classes with @Component lets Spring manage those objects, and
	// @Autowired marks the object being annotated is a dependency of the
	// component.

	@Autowired
	private Filter filter;

	// Now you can choose (passing in) different filters when calling this
	// implementation (in the main application, aka. the top level).
	public RecommenderImplementation(Filter filter) {
		super();

		this.filter = filter;
	}

	public String[] recommendMovies(String movie) {
		System.out.println("Current filter being used: [ " + filter + " ]");

		// Calls the filter based the parameter passed down from the main app
		String[] results = filter.getRecommendations("n/a");

		return results;
	}
}