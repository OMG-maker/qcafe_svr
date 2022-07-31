package kr.omg.qcafe.model;

//public class User {
//    private String userId;
//    private String userPassword;
//    private String userNickname;
//
//    public String getUserId() {
//        return userId;
//    }
//
//    public void setUserId(String userId) {
//        this.userId = userId;
//    }
//
//    public String getUserPassword() {
//        return userPassword;
//    }
//
//    public void setUserPassword(String userPassword) {
//        this.userPassword = userPassword;
//    }
//
//    public String getUserNickname() {
//        return userNickname;
//    }
//
//    public void setUserNickname(String userNickname) {
//        this.userNickname = userNickname;
//    }
//}


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@ToString
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int num;
    private String userId;
    private String userPassword;
    private String userNickname;
}
