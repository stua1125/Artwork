package lezhin.lezhinproject.user.repository;

import lezhin.lezhinproject.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
