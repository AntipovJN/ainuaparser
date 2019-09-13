package Factories;

import Service.ArticleService;
import Service.ArticleServiceImpl;

import java.util.Objects;

public class ArticleServiceFactory {

    private static ArticleService articleService;

    public static synchronized ArticleService getInstace() {
        if(Objects.isNull(articleService)) {
            articleService = new ArticleServiceImpl();
        }
        return articleService;
    }
}
