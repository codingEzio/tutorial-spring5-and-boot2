package io.datajek.spring.basics.movierecommendersystem05alternativediframework;

public class CollaborativeFilter implements Filter {
	public String[] getRecommendations(String movies) {
		return new String[] { "Interstellar", "Matrix", "Blade Runner 2042" };
	}
}