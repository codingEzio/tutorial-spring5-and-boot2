package io.datajek.spring.basics.movierecommendersystem05alternativediframework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MovieRecommenderSystem05AlternativeDiFrameworkApplication {

	// Think of this way, Spring itself is a Dependency Injection, now
	// and the 'Contexts and Dependency Injection (CDI)' is another one
	// provided by Java itself. For the most notable ones
	// 1. @Named instead of @Component
	// 2. @Inject instead of @Autowired

	public static void main(String[] args) {
		ApplicationContext appContext = SpringApplication.run(
				MovieRecommenderSystem05AlternativeDiFrameworkApplication.class,
				args);

		RecommenderImplementation recommender = appContext.getBean(
				RecommenderImplementation.class);

		System.out.println(recommender);
		System.out.println(recommender.getFilter());

	}
}
