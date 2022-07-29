package kr.omg.qcafe.mapper;

import kr.omg.qcafe.model.AdminUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdminUserMapperImpl implements AdminUserMapper{

    @Autowired
    private AdminUserMapper adminUserMapper;
    /**
     * 쿠폰 리스트를 조회한다.
     *
     * @param adminUser
     * @return
     */
    public List<AdminUser> getAdminUserList(AdminUser adminUser){
        return this.adminUserMapper.getAdminUserList(adminUser);
    }
    public  void insertAdminUserList(AdminUser adminUser){
        this.adminUserMapper.insertAdminUserList(adminUser);
    }

    public void updateAdminUserList(AdminUser adminUser){
        this.adminUserMapper.updateAdminUserList(adminUser);
    }
}
