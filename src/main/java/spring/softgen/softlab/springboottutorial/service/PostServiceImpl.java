package spring.softgen.softlab.springboottutorial.service;

import org.springframework.stereotype.Service;
import spring.softgen.softlab.springboottutorial.entity.Post;
import spring.softgen.softlab.springboottutorial.repository.PostRepository;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post add(Post post) {
        return null;
    }

    @Override
    public Post updatePost(int id, Post post) {
        return null;
    }

    @Override
    public void deletePost(int id) {

    }

    @Override
    public List<Post> getPostsByUserId(int userId) {
        return postRepository.findByUserId(userId);
    }
}

