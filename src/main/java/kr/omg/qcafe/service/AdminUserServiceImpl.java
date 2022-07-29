package kr.omg.qcafe.service;

import kr.omg.qcafe.mapper.AdminUserMapper;
import kr.omg.qcafe.model.AdminUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional // 얜 기능이 따로 있음
@Service
public class AdminUserServiceImpl implements AdminUserService{

    @Autowired
    private AdminUserMapper adminUserMapper;

    public List<AdminUser> getAdminUserList(AdminUser adminUser) {
        return adminUserMapper.getAdminUserList(adminUser);
    }

    public  void insertAdminUserList(AdminUser adminUser){
        adminUserMapper.insertAdminUserList(adminUser);
    }

    public void updateAdminUserList(AdminUser adminUser){adminUserMapper.updateAdminUserList(adminUser);
    }

}
