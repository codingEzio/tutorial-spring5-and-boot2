package io.datajek.spring.basics.movierecommendersystem04lifecycle;

public interface Filter {
	public String[] getRecommendations(String movie);
}