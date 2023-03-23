package spring.softgen.softlab.springboottutorial.controler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import spring.softgen.softlab.springboottutorial.entity.User;
import spring.softgen.softlab.springboottutorial.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
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
}
