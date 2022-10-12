package io.datajek.spring.basics.movierecommendersystem07xmlconfig;

public class CollaborativeFilter implements Filter {
	public String[] getRecommendations(String movies) {
		return new String[] { "Interstellar", "Matrix", "Blade Runner 2042" };
	}
}