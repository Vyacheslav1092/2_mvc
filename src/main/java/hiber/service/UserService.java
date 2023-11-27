package hiber.service;

import hiber.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void add(User user);
    List<User> listUsers();
    void deleteAllUsers();
    Optional<User> findOwner(String carName, String carSeries);
}
