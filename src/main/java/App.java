import Factories.ArticleServiceFactory;
import Factories.ParserHtmlFactory;
import Parsers.HtmlParser;
import Service.ArticleService;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {
        ArticleService articleService = ArticleServiceFactory.getInstace();
        HtmlParser htmlParser = ParserHtmlFactory.getInstace();
        articleService.addArticles(htmlParser.getNewestArticles());
    }
}
