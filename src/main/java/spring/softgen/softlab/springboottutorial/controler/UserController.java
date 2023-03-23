package spring.softgen.softlab.springboottutorial.controler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import spring.softgen.softlab.springboottutorial.entity.Post;
import spring.softgen.softlab.springboottutorial.entity.User;
import spring.softgen.softlab.springboottutorial.service.PostService;
import spring.softgen.softlab.springboottutorial.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final PostService postService;

    public UserController(UserService userService, PostService postService) {
        this.userService = userService;
        this.postService = postService;
    }

    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/deleted")
    public List<User> deletedUsers() {
        return userService.deletedUsers();
    }

    @PostMapping
    public ResponseEntity<User> add(@RequestBody User user) {
        userService.add(user);
        var location = UriComponentsBuilder.fromPath("/users/" + user.getId()).build().toUri();
        return ResponseEntity.created(location).body(user);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {
        return userService.getUser(id);
    }

    @PutMapping("/{id}")
    public User updateUser(@RequestBody User user, @PathVariable int id) {
        return userService.update(id, user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable int id) {
        userService.delete(id);
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}/posts")
    public List<Post> getUserPosts(@PathVariable int id) {
        return postService.getPostsByUserId(id);
    }
}
