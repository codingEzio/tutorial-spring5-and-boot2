package io.datajek.spring.basics.movierecommendersystem;

public class ContentBasedFilter implements Filter {
	public String[] getRecommendations(String movie) {
		return new String[] {"Interstellar", "Matrix", "Blade Runner 2042"};
	}
}