package ru.job4j.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.model.Post;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class PostDAO {
    private final Map<Integer, Post> posts = new ConcurrentHashMap<>();

    public PostDAO() {
        posts.put(1, new Post(1, "Продажа машины", """
                Продаю машину ВАЗ 2109 1987 года серого цвета, не битая, не крашенная))))
                """, new GregorianCalendar(2022, Calendar.AUGUST, 19)));
        posts.put(2, new Post(2, "Пропала собака", """
                Пропала собака по кличке Шарик
                """, new GregorianCalendar(2022, Calendar.AUGUST, 23)));
        posts.put(3, new Post(3, "Прогноз погоды на завтра", """
                Ожидаются местами осадки, температура воздуха 24 градуса
                """, new GregorianCalendar(2022, Calendar.AUGUST, 24)));
    }

    public List<Post> getAll() {
        return posts.values().stream().toList();
    }

    public Post findById(int id) {
        return posts.get(id);
    }

    public void edit(Post post, int id) {
        posts.replace(id, post);
    }
}
