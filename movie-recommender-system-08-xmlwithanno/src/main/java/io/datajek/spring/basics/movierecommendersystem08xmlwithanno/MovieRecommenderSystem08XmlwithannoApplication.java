package io.datajek.spring.basics.movierecommendersystem08xmlwithanno;

import java.util.Arrays;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MovieRecommenderSystem08XmlwithannoApplication {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext(
				"appContext.xml");

		System.out.println("\nBeans loaded:");
		System.out.println(Arrays.toString(appContext.getBeanDefinitionNames()));

		RecommenderImplementation recommender = appContext.getBean("recommenderImpl", RecommenderImplementation.class);

		System.out.println("\nDependency: " + recommender.getFilter());
		System.out.println();

		appContext.close();
	}

}
