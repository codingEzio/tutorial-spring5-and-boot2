package io.datajek.spring.basics.movierecommendersystem05alternativediframework;

public class RecommenderImplementation {

	private Filter filter;

	public String[] recommendMovies(String movie) {
		System.out.println("Current filter being used: [ " + filter + " ]");

		String[] results = filter.getRecommendations("n/a");

		return results;
	}
}