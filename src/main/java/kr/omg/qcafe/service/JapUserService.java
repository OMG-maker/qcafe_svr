package kr.omg.qcafe.service;

import kr.omg.qcafe.model.JpaUser;
import kr.omg.qcafe.repository.JpaUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JapUserService {

    @Autowired
    private JpaUserRepository jpaUserRepository;


    public JpaUser signup(JpaUser jpaUser) {
        JpaUser jpaUserResult = jpaUserRepository.save(jpaUser);
        return jpaUserResult;
    }
}
