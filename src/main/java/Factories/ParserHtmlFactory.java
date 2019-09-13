package Factories;

import Parsers.HtmlParser;

import java.util.Objects;

public class ParserHtmlFactory {

    private static HtmlParser parserHtml ;

    public static synchronized HtmlParser getInstace() {
        if(Objects.isNull(parserHtml)) {
            parserHtml = new HtmlParser();
        }
        return parserHtml;
    }
}
