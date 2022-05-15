package ru.job4j.grabber;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.job4j.grabber.utils.DateTimeParser;
import ru.job4j.grabber.utils.HarbCareerDateTimeParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HabrCareerParse implements Parse {
    private static final String SOURCE_LINK = "https://career.habr.com";
    private static final String PAGE_LINK = String.format("%s/vacancies/java_developer", SOURCE_LINK);
    private final DateTimeParser dateTimeParser;

    public HabrCareerParse(DateTimeParser dateTimeParser) {
        this.dateTimeParser = dateTimeParser;
    }

    @Override
    public List<Post> list(String link) {
        List<Post> posts = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            try {
                Connection connection = Jsoup.connect(link + "?page=" + i);
                Document document = connection.get();
                Elements rows = document.select(".vacancy-card__inner");
                rows.forEach(row -> posts.add(post(row)));
            } catch (IOException ie) {
                ie.printStackTrace();
            }
        }
        return posts;
    }

    private Post post(Element row) {
        Element titleElement = row.select(".vacancy-card__title").first();
        Element linkElement = titleElement.child(0);
        Element dateElement = row.select(".vacancy-card__date").first();
        String linkVC = String.format("%s%s", SOURCE_LINK, linkElement.attr("href"));
        return new Post(
                titleElement.text(),
                linkVC,
                retrieveDescription(linkVC),
                dateTimeParser.parse(dateElement.child(0).attr("datetime")));
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

    public static void main(String[] args) {
        DateTimeParser dateTimeParser = new HarbCareerDateTimeParser();
        HabrCareerParse hcp = new HabrCareerParse(dateTimeParser);
        List<Post> posts = hcp.list(PAGE_LINK);
        for (Post post : posts) {
            System.out.println(post);
        }
    }
}