package Parsers;

import Entity.Article;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HtmlParser {

    public List<Article> getNewestArticles() throws IOException {
        return getArticles(getNewestArticlesLinks());
    }

    private List<String> getNewestArticlesLinks() throws IOException {
        List<String> listURL = new ArrayList<String>();
        Document document = Jsoup.connect("https://ain.ua").get();
        Element content = document.getElementsByAttributeValue("class", "container").get(0);
        Elements containers = content.getElementsByAttributeValue("class", "tags-block web-view");
            for (Element columns : containers) {
                Elements articles = columns.getElementsByAttributeValue("class", "tag");
                for (Element categoriesElement : articles) {
                    if(listURL.size() == 5) {
                        break;
                    }
                    Element articleElement = categoriesElement.
                            getElementsByAttributeValue("class", "post-item ordinary-post").get(0);
                    Elements articlesUrl = articleElement.
                            getElementsByAttributeValue("class", "post-link with-labels");
                    for (Element element : articlesUrl) {
                        listURL.add(element.attr("href"));
                    }
                }
        }
        return listURL;
    }

    private List<Article> getArticles(List<String> articlesURL) throws IOException {
        List<Article> articlesList = new ArrayList<Article>();
        for (String articleURL : articlesURL) {
            Document document = Jsoup.connect(articleURL).get();
            Element articleElement = document.
                    getElementsByAttributeValue("class", "post-content").first();
            Elements pElements = articleElement.getElementsByTag("p");
            Elements h3Elements = articleElement.getElementsByTag("h3");
            StringBuilder articleContentStringBuffer = new StringBuilder();
            for (Element element : pElements) {
                articleContentStringBuffer.append(element.text());
            }
            for (Element element : h3Elements) {
                articleContentStringBuffer.append(element.text());
            }
            String content = articleContentStringBuffer.toString().replace(
                    "Заметили ошибку? Выделите ее и нажмите Ctrl+Enter," +
                            " чтобы сообщить нам.", "")
                    .replaceAll("[^a-zA-Zа-яА-я\\- ]", "").toLowerCase();
            articlesList.add(new Article(articleURL,
                    articleElement.getElementsByTag("h1").first().text(),content));
        }
        return articlesList;
    }
}
