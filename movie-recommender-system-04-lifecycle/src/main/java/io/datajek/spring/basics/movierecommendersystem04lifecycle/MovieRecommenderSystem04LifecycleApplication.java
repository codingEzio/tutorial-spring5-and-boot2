package io.datajek.spring.basics.movierecommendersystem04lifecycle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MovieRecommenderSystem04LifecycleApplication {

	public static void main(String[] args) {
		ApplicationContext appContext = SpringApplication.run(
				MovieRecommenderSystem04LifecycleApplication.class, args);

		RecommenderImplementation recommender = appContext.getBean(
				RecommenderImplementation.class);

		System.out.println(recommender);
	}

}
