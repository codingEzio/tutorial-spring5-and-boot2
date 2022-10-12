package io.datajek.spring.basics.movierecommendersystem06springcore;

public interface Filter {
	public String[] getRecommendations(String movie);
}