package io.datajek.spring.basics.movierecommendersystem08xmlwithanno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class RecommenderImplementation {

	@Autowired
	@Qualifier("contentBasedFilter")
	private Filter filter;

	public Filter getFilter() {
		return filter;
	}

	public void setFilter(Filter filter) {
		this.filter = filter;
	}

	public String[] recommendMovies(String movie) {
		System.out.println("Current filter being used: [ " + filter + " ]");

		String[] results = filter.getRecommendations("n/a");

		return results;
	}
}