package kr.omg.qcafe.controller.RestController;


import kr.omg.qcafe.model.User;
import kr.omg.qcafe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public User signup(@RequestBody User user) {
        User userResult = userService.signup(user);
            return userResult;
    }


    /**
     * Post 요청에 id와 password가 넘어올 것이다.
     * 그럼 loginService 클래스의 userLoginTest 메소드를 실행한다. 인자는 폼에서 넘어온 User이다.
     * loginService에서 DB에 저장된 데이터와 비교를 한다.
     * 비교에서 성공하면 Home으로 간다.
     * 실패하면 다시 login 화면이 나온다.
     *
     * */
    @PostMapping("/userLoginTest")
    public String login(@RequestBody User user) {
        if (userService.login(user)){
            return "redirect:/";
        }
        return "login";
    }

}
