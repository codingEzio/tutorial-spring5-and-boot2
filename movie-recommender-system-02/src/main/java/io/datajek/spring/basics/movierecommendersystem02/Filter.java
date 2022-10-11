package io.datajek.spring.basics.movierecommendersystem02;

public interface Filter {
    public String[] getRecommendations(String movie);
}