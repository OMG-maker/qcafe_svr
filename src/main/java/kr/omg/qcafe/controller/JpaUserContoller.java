package kr.omg.qcafe.controller;

import kr.omg.qcafe.model.JpaUser;
import kr.omg.qcafe.service.JapUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class JpaUserContoller {

    @Autowired
    private JapUserService japUserService;

    @PostMapping("/signup")
    public JpaUser signup(@RequestBody JpaUser jpaUser) {
        JpaUser jpaUserResult = japUserService.signup(jpaUser);
        return jpaUserResult;
    }

}
