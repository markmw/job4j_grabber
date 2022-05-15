package ru.job4j.grabber;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class HabrCareerParse {
    private static final String SOURCE_LINK = "https://career.habr.com";

    private static final String PAGE_LINK = String.format("%s/vacancies/java_developer", SOURCE_LINK);

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 6; i++) {
            Connection connection = Jsoup.connect(PAGE_LINK + "?page=" + i);
            HabrCareerParse hcp = new HabrCareerParse();
            Document document = connection.get();
            Elements rows = document.select(".vacancy-card__inner");
            rows.forEach(row -> {
                Element dateElement = row.select(".vacancy-card__date").first();
                Element date = dateElement.child(0);
                String time = date.attr("datetime");
                Element titleElement = row.select(".vacancy-card__title").first();
                Element linkElement = titleElement.child(0);
                String vacancyName = titleElement.text();
                String link = String.format("%s%s", SOURCE_LINK, linkElement.attr("href"));
                String desc = hcp.retrieveDescription(link);
                System.out.printf("%s -  %s%n%s%n%s%n%n", time, vacancyName, desc, link);
            });
        }
    }

    private String retrieveDescription(String link) {
        String result = null;
        try {
            Connection connection = Jsoup.connect(link);
            Document document = connection.get();
            Element descElement = document.selectFirst(".style-ugc");
            result = descElement.text();
        } catch (IOException ie) {
            ie.printStackTrace();
        }
        return result;
    }
}