package ru.job4j.grabber;

import java.io.InputStream;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class PsqlStore implements Store, AutoCloseable {
    private Connection connection;

    public PsqlStore(Properties cfg) throws SQLException {
        try {
            Class.forName(cfg.getProperty("driver"));
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        connection = DriverManager.getConnection(
                cfg.getProperty("url"),
                cfg.getProperty("login"),
                cfg.getProperty("password"));
    }

    @Override
    public void save(Post post) {
        try (PreparedStatement ps = connection.prepareStatement(
                "INSERT INTO post (title, description, link, created) "
                + "VALUES (?, ?, ?, ?);",
                Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, post.getTitle());
            ps.setString(2, post.getDescription());
            ps.setString(3, post.getLink());
            ps.setTimestamp(4, Timestamp.valueOf(post.getCreated()));
            ps.execute();
            try (ResultSet genKeys =  ps.getGeneratedKeys()) {
                if (genKeys.next()) {
                    post.setId(genKeys.getInt(1));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Post> getAll() {
        List<Post> list = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement("select * from post")) {
            try (ResultSet rs =  ps.executeQuery()) {
                while (rs.next()) {
                    list.add(getPost(rs));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Post findById(int id) {
        Post post = null;
        try (PreparedStatement ps = connection.prepareStatement("select * from post where id = ?")) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    post = getPost(rs);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return post;
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    private Post getPost(ResultSet rs) throws SQLException {
        return new Post(rs.getInt("id"),
                rs.getString("title"),
                rs.getString("description"),
                rs.getString("link"),
                rs.getTimestamp("created").toLocalDateTime());
    }

    public static void main(String[] args) {
        try (InputStream is = PsqlStore
                .class
                .getClassLoader()
                .getResourceAsStream("post.properties")) {
            Properties cfg = new Properties();
            cfg.load(is);
            PsqlStore query = new PsqlStore(cfg);
            LocalDateTime ldt = LocalDateTime.now();
            Post post = new Post(
                    "Java разработчик",
                    "https://career.habr.com/vacancies/1000092387",
                    "java",
                    ldt);
            Post post1 = new Post(
                    "Java программист",
                    "https://career.habr.com/vacancies/1000100675",
                    "java",
                    ldt);
            query.save(post);
            query.save(post1);
            System.out.println(query.getAll());
            System.out.println(query.findById(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
