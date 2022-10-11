package io.datajek.spring.basics.movierecommendersystem02;

import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Scope;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CollaborativeFilter implements Filter {
    public CollaborativeFilter() {
        super();

        System.out.println("[CF]  Prototype initialized");
    }

    public String[] getRecommendations(String movie) {
        return new String[] { "Interstellar", "Blade Runner 2042" };
    }
}