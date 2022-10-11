package io.datajek.spring.basics.movierecommendersystem02;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MovieRecommenderSystem02Application {

	public static void main(String[] args) {
		ApplicationContext appContext = SpringApplication.run(
				MovieRecommenderSystem02Application.class,
				args);

		// Default scope is Singleton (always the same object)
		ContentBasedFilter cbf1 = appContext.getBean(ContentBasedFilter.class);
		ContentBasedFilter cbf2 = appContext.getBean(ContentBasedFilter.class);

		// Prototype (every time a new object being returned)
		CollaborativeFilter cf1 = appContext.getBean(CollaborativeFilter.class);
		CollaborativeFilter cf2 = appContext.getBean(CollaborativeFilter.class);

		System.out.println("[CBF] " + cbf1);
		System.out.println("[CBF] " + cbf2);

		System.out.println("[CF]  " + cf1);
		System.out.println("[CF]  " + cf2);
	}

}
