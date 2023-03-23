package spring.softgen.softlab.springboottutorial.service;

import spring.softgen.softlab.springboottutorial.entity.Post;

import java.util.List;

public interface PostService {
    List<Post> getPosts();

    Post add(Post post);

    Post updatePost(int id, Post post);

    void deletePost(int id);

    List<Post> getPostsByUserId(int userId);
}
