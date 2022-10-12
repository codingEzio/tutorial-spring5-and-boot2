package io.datajek.spring.basics.movierecommendersystem06springcore;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// @SpringBootApplication
@Configuration
@ComponentScan
public class MovieRecommenderSystem06SpringcoreApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(
				MovieRecommenderSystem06SpringcoreApplication.class);

		RecommenderImplementation recommender = appContext.getBean(RecommenderImplementation.class);

		String[] result = recommender.recommendMovies("n/a");
		System.out.println(Arrays.toString(result));

		appContext.close();
	}

}
