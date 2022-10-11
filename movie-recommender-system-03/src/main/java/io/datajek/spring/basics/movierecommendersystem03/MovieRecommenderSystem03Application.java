package io.datajek.spring.basics.movierecommendersystem03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MovieRecommenderSystem03Application {

	public static void main(String[] args) {

		// Singleton always returns the same bean/object, and
		// Prototype returns different objects every time. How
		// would <a Singleton bean has Prototype dependencies>
		// work? Let's find out.

		ApplicationContext appContext = SpringApplication.run(
				MovieRecommenderSystem03Application.class,
				args);

		ContentBasedFilter cBasedFilter = appContext.getBean(
				ContentBasedFilter.class);
		System.out.println("[CBF] Singleton socpe " + cBasedFilter);

		Movie movie1 = cBasedFilter.getMovie();
		Movie movie2 = cBasedFilter.getMovie();
		Movie movie3 = cBasedFilter.getMovie();

		System.out.println();
		System.out.println("[MVI] Prototype socpe " + movie1);
		System.out.println("[MVI] Prototype socpe " + movie2);
		System.out.println("[MVI] Prototype socpe " + movie3);

		System.out.println();

		// They shall equal to each other, as the Prototype
		// dependency would lost its prototype behavior.
		System.out.println("[IST] Prototype by itself      " + ContentBasedFilter.getInstances());
		System.out.println("[IST] Prototype with singleton " + Movie.getInstances());
	}

}
