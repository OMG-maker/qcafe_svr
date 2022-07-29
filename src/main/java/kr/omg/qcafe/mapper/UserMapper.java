package kr.omg.qcafe.mapper;

import kr.omg.qcafe.model.User;

import java.util.List;

public interface UserMapper {

    /**
     *
     * @param user
     * @return
     */
    public List<User> getUserList(User user);

    public  void insertUser(User user);
}
