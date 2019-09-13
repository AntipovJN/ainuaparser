package DAO;

import Entity.Article;

import java.util.List;

public interface ArticleDAO {

    void addArticle(Article article);

    List<Article> getAll() ;

    Article getById(int id);

    Article getByURL(String url);
}
