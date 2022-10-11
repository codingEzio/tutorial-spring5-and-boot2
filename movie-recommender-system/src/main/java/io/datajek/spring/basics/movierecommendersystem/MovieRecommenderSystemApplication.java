package io.datajek.spring.basics.movierecommendersystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

// It is equivalent to three annotations
//  1. @ComponentScan
//      which is a part of @SpringBootApplication, tells Spring where to find
//      the objects which are annotated by @Component.
//  2. @Configuration
//      the source class for bean definitions (aka. the class who has an object
//      who is about to be managed by the Spring container). This is quite like
//      the relationship between (Component <> Autowired) and (@this <> @Bean).
//  3. @EnableAutoConfiguration
//      Enable auto-configuration of 'Spring Application Context', and attempt
//      to guess and configure beans you're likely to need
@SpringBootApplication
public class MovieRecommenderSystemApplication {

	public static void main(String[] args) {
		// Overview of Recommender
		// -> it calls .recommendMovies
		// ->     then .recommendMovies bases on types/names(<- filter)

		ApplicationContext appContext = SpringApplication.run(
				MovieRecommenderSystemApplication.class,
				args
		);

		RecommenderImplementation recommender = appContext.getBean(
				RecommenderImplementation.class
		);

		String[] results = recommender.recommendMovies("n/a");
		System.out.println(Arrays.toString(results));
	}
}