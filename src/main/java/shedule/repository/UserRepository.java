package shedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shedule.domain.MyUser;

public interface UserRepository extends JpaRepository<MyUser, Long> {
    MyUser findByUsername(String username);

    MyUser findByActivationCode(String code);
}
