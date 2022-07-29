package kr.omg.qcafe.mapper;

import kr.omg.qcafe.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserMapperImpl implements UserMapper{

    @Autowired
    private UserMapper UserMapper;

    /**
     * @param user
     * @return
     */
    public List<User> getUserList(User user){
        return this.UserMapper.getUserList(user);
    }

    public void insertUser(User user){
        this.UserMapper.insertUser(user);
    }
}
