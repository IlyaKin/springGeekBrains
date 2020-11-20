package geekbrains.lesson5.service;

import geekbrains.lesson5.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    User getById(Long id);
    User auth(String name, String password);

    List<User> getAll();
}
