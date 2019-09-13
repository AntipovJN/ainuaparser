package DAO.Implementation;

import DAO.ArticleDAO;
import Entity.Article;
import Utils.ConnectionJDBC;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class ArticleDAOimpl implements ArticleDAO {

    Logger logger = Logger.getLogger(ArticleDAOimpl.class);


    public void addArticle(Article article) {
        try (Connection connection = ConnectionJDBC.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO articles (url, title, content) VALUES (?,?,?)");
            statement.setString(1,article.getUrl());
            statement.setString(2, article.getTitle());
            statement.setString(3, article.getContent());
            statement.execute();
            logger.info("Success added article");
        } catch (SQLException e) {
            logger.error("Failed adding order", e);
        }
    }

    public List<Article> getAll() {
        return null;
    }

    public Article getById(int id) {
        return null;
    }

    public Article getByURL(String url) {
        return null;
    }
}
