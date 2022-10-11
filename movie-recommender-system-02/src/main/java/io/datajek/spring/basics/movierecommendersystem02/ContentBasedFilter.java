package io.datajek.spring.basics.movierecommendersystem02;

import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Scope;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;

@Component
public class ContentBasedFilter implements Filter {
    public ContentBasedFilter() {
        super();
    }

    public String[] getRecommendations(String movie) {
        return new String[] { "Interstellar", "Blade Runner 2042" };
    }
}