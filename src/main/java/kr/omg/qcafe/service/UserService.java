package kr.omg.qcafe.service;

import kr.omg.qcafe.model.User;
import kr.omg.qcafe.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//package kr.omg.qcafe.service;
//
//import kr.omg.qcafe.model.User;
//
//import java.util.List;
//
//public interface UserService {
//    public  List<User> getUserList(User user);
//
//    public  void insertUser(User user);
//
//
//}

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

// jpa 로그인 강의 : https://bestkingit.tistory.com/144
// findByUserId - 임의로 생성 : https://devfunny.tistory.com/426
    public boolean login(User user) {

        User findUser = userRepository.findByUserId(user.getUserId());

        if(findUser == null){
            return false;

        }

        if(!findUser.getUserPassword().equals(user.getUserPassword())){
            return false;
        }
        return true;

    }


    public User signup(User user) {
        User userResult = userRepository.save(user);
        return userResult;
    }
}
