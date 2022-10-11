package io.datajek.spring.basics.movierecommendersystem;

public class RecommenderImplementation {
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