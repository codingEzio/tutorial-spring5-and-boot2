package io.datajek.spring.basics.movierecommendersystem06springcore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class RecommenderImplementation {

	private Filter filter;

	@Autowired
	@Qualifier("collaborativeFilter")
	public void setFilter(Filter filter) {
		this.filter = filter;
	}

	public String[] recommendMovies(String movie) {
		System.out.println("Current filter being used: [ " + filter + " ]");

		String[] results = filter.getRecommendations("n/a");

		return results;
	}
}