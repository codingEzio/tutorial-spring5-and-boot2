package io.datajek.spring.basics.movierecommendersystem05alternativediframework;

import javax.inject.Named;
import javax.inject.Singleton;

import org.springframework.beans.factory.annotation.Qualifier;

@Named
@Singleton
@Qualifier("CBF")
public class ContentBasedFilter implements Filter {
	public String[] getRecommendations(String movie) {
		return new String[] { "Interstellar", "Matrix", "Blade Runner 2042" };
	}
}