package kr.omg.qcafe.repository;

import kr.omg.qcafe.model.JpaUser;
import kr.omg.qcafe.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUserId(String userId);
}
