package spring.softgen.softlab.springboottutorial.service;

import org.springframework.stereotype.Service;
import spring.softgen.softlab.springboottutorial.entity.User;
import spring.softgen.softlab.springboottutorial.exception.NotFoundException;
import spring.softgen.softlab.springboottutorial.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findActive(true);
    }

    public List<User> deletedUsers(){
        return userRepository.findActive(false);
    }

    @Override
    public User add(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(int id, User user) {
        var foundUser = getUser(id);
        foundUser.setUsername(user.getUsername());
        foundUser.setPassword(user.getPassword());
        foundUser.setEmail(user.getEmail());
        foundUser.setCreateDate(LocalDateTime.now());
        return userRepository.save(foundUser);
    }

    @Override
    public void delete(int id) {
        var foundUser = getUser(id);
        foundUser.setActive(false);
        userRepository.save(foundUser);
    }

    @Override
    public User getUser(int id) {
        return userRepository.findById(id).orElseThrow(() -> new NotFoundException("User not found"));
    }
}
