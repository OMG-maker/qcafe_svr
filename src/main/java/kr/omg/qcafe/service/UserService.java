package kr.omg.qcafe.service;

import kr.omg.qcafe.model.User;

import java.util.List;

public interface UserService {
    public  List<User> getUserList(User user);

    public  void insertUser(User user);


}
