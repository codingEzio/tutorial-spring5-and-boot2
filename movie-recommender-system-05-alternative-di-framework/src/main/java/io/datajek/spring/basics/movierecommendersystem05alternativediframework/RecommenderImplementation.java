package io.datajek.spring.basics.movierecommendersystem05alternativediframework;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.springframework.beans.factory.annotation.Qualifier;

@Named
@Singleton
public class RecommenderImplementation {

	@Inject
	@Qualifier("CBF")
	private Filter filter;

	public Filter getFilter() {
		return filter;
	}

	public String[] recommendMovies(String movie) {
		System.out.println("Current filter being used: [ " + filter + " ]");

		String[] results = filter.getRecommendations("n/a");

		return results;
	}
}