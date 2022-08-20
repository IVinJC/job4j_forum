package ru.job4j.service;

import org.springframework.stereotype.Service;
import ru.job4j.model.Post;
import ru.job4j.repository.PostRepository;

import java.util.*;
import java.util.stream.StreamSupport;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
        /**posts.add(new Post(0, "Продажа машины", """
                Продаю машину ВАЗ 2109 1987 года серого цвета, не битая, не крашенная))))
                """, new GregorianCalendar(2022, Calendar.AUGUST, 19)));
        posts.add(new Post(1, "Пропала собака", """
                Пропала собака по кличке Шарик
                """, new GregorianCalendar(2022, Calendar.AUGUST, 23)));
        posts.add(new Post(2, "Прогноз погоды на завтра", """
                Ожидаются местами осадки, температура воздуха 24 градуса
                """, new GregorianCalendar(2022, Calendar.AUGUST, 24)));*/
    }

    public List<Post> getAll() {
        return StreamSupport
                .stream(postRepository.findAll().spliterator(), false)
                .toList();
    }

    public Post findById(int id) {
        return postRepository.findById(id).orElse(null);
    }

    public void edit(Post post, int id) {
        post.setId(id);
        postRepository.save(post);
    }
}