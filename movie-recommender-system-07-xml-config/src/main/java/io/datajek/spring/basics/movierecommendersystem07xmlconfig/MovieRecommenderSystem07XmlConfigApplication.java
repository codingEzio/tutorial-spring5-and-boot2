package io.datajek.spring.basics.movierecommendersystem07xmlconfig;

import java.util.Arrays;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MovieRecommenderSystem07XmlConfigApplication {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("appContext.xml");

		System.out.println("\nBeans loaded via XML");
		System.out.println(Arrays.toString(appContext.getBeanDefinitionNames()) + "\n");

		appContext.close();
	}

}
