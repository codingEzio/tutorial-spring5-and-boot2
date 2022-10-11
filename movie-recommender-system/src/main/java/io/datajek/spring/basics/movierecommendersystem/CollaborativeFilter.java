package io.datajek.spring.basics.movierecommendersystem;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("CF")
public class CollaborativeFilter implements Filter {
	public String[] getRecommendations(String movies) {
		return new String[] {"Interstellar", "Matrix", "Blade Runner 2042"};
	}
}