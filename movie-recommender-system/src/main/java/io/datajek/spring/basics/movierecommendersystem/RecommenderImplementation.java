package io.datajek.spring.basics.movierecommendersystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class RecommenderImplementation {

	// This is called 'Field Injection' (injected by @Qualifier in order to
	// choose an appropriate bean), simple in the first sight, though it
	// would be more complicated later on. Here's why:
	//  1. Testing became more complex as we're doing IoC for fields right now
	//  2. The amount of code and effort would become huge if your application
	//     grows more complicated, basically it means if there were a lot of
	//     fields other than the one for choosing filter, the constructor would
	//     become quite complex and unmaintainable.
	@Autowired
	@Qualifier("CF")
	private Filter filter;

	public String[] recommendMovies(String movie) {
		System.out.println("Current filter being used: [ " + filter + " ]");

		String[] results = filter.getRecommendations("n/a");

		return results;
	}
}