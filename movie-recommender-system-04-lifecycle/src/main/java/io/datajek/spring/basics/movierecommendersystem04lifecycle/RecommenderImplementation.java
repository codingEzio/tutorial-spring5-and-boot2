package io.datajek.spring.basics.movierecommendersystem04lifecycle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RecommenderImplementation {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private Filter filter;

	@Autowired
	public void setFilter(Filter filter) {
		logger.info("[RCM] Setter method <> Dep Injection");

		this.filter = filter;
	}

	public String[] recommendMovies(String movie) {
		String[] results = filter.getRecommendations("n/a");

		return results;
	}
}