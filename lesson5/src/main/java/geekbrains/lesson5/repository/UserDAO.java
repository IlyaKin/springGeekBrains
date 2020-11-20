package geekbrains.lesson5.repository;

import geekbrains.lesson5.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Long> {
    User findFirstByName(String username);
}
