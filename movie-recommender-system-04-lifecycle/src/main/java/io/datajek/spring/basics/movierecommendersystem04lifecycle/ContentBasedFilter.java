package io.datajek.spring.basics.movierecommendersystem04lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ContentBasedFilter implements Filter {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public ContentBasedFilter() {
		super();

		logger.info("[CBF] Constructor method");
	}

	@PostConstruct
	private void postConstruct() {
		logger.info("[CBF] postConstruct method");
	}

	@PreDestroy
	private void preDestroy() {
		logger.info("[CBF] preDestroy method");
	}

	public String[] getRecommendations(String movie) {
		return new String[] { "Interstellar", "Matrix", "Blade Runner 2042" };
	}
}