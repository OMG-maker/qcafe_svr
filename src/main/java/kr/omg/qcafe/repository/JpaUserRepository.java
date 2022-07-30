package kr.omg.qcafe.repository;

import kr.omg.qcafe.model.JpaUser;
import org.springframework.data.repository.CrudRepository;

public interface JpaUserRepository extends CrudRepository<JpaUser, Long> {

}
