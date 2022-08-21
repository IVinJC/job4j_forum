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
    }

    public void create(Post post) {
        postRepository.save(post);
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