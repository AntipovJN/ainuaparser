package Service;

import DAO.ArticleDAO;
import Entity.Article;
import Factories.ArticleDaoFactory;

import java.util.List;

public class ArticleServiceImpl implements ArticleService {

    private ArticleDAO articleDAO = ArticleDaoFactory.getInstance();

    @Override
    public void addArticles(List<Article> articleList) {
        for (Article article : articleList) {
            articleDAO.addArticle(article);
        }
    }
}
