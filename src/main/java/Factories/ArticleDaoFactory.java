package Factories;

import DAO.ArticleDAO;
import DAO.Implementation.ArticleDAOimpl;

import java.util.Objects;

public class ArticleDaoFactory {

    private static ArticleDAO articleDAO;

    public static synchronized ArticleDAO getInstance() {
        if(Objects.isNull(articleDAO)) {
            articleDAO = new ArticleDAOimpl();
        }
        return articleDAO;
    }
}
