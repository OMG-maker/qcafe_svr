//package kr.omg.qcafe.service;
//
//import kr.omg.qcafe.mapper.UserMapper;
//import kr.omg.qcafe.model.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
//@Transactional // 얜 기능이 따로 있음
//@Service
//public class UserServiceImpl implements UserService{
//
//    @Autowired
//    private UserMapper userMapper;
//
//    //xml 파일에 코딩되어있는 id=getUserList 인 Select 구문을 실행
//    public List<User> getUserList(User user) {
//        return userMapper.getUserList(user);
//    }
//
//    //xml 파일에 코딩되어있는 id=insertUser 인 Insert 구문을 실행
//    public void insertUser(User user){
//        userMapper.insertUser(user);
//    }
//
//}

