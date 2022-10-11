package io.datajek.spring.basics.movierecommendersystem;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class CollaborativeFilter implements Filter {
	public String[] getRecommendations(String movies) {
		return new String[] {"Interstellar", "Matrix", "Blade Runner 2042"};
	}
}