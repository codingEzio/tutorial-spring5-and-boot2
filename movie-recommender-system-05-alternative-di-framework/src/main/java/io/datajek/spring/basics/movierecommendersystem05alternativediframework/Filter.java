package io.datajek.spring.basics.movierecommendersystem05alternativediframework;

public interface Filter {
	public String[] getRecommendations(String movie);
}