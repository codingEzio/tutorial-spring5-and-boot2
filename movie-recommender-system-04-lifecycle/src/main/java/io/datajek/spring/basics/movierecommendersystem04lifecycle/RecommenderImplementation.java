package io.datajek.spring.basics.movierecommendersystem04lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RecommenderImplementation {

	// Firstly, this is not a full overview of the lifecycle methods,
	// it only shows the most notable ones, i.e. creation and destruction.
	//
	// <postConstruct>
	// - Container started (i.e. IoC libs who manage the beans)
	// - Bean Instantiation (aka. Object, marked with @STUFF)
	// - Dependency Injection (different @WAYS to do it)
	// - postConstruct Method (before you could use the obj)
	// - Bean is Ready (able to call stuff)
	//
	// <preDestroy>
	// - Container shutdown (i.e. IoC libs who manage the beans)
	// - Methods with @preDestroy (maybe some cleanup work)
	// - Bean Destroyed (no longer able to use the object)

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private Filter filter;

	@Autowired
	public void setFilter(Filter filter) {
		logger.info("[RCM] Setter method <> Dep Injection");

		this.filter = filter;
	}

	//
	@PostConstruct
	public void postConstruct() {
		logger.info("[RCM] postConstruct method");
	}

	@PreDestroy
	public void preDestroy() {
		logger.info("[RCM] preDedestroy method");
	}

	public String[] recommendMovies(String movie) {
		String[] results = filter.getRecommendations("n/a");

		return results;
	}
}