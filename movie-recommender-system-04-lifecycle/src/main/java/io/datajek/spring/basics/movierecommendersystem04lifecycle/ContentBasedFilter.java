package io.datajek.spring.basics.movierecommendersystem04lifecycle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ContentBasedFilter implements Filter {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public String[] getRecommendations(String movie) {
		return new String[] { "Interstellar", "Matrix", "Blade Runner 2042" };
	}
}