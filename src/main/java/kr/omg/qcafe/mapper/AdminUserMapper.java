package kr.omg.qcafe.mapper;

import kr.omg.qcafe.model.AdminUser;

import java.util.List;

public interface AdminUserMapper {
    /**
     * 쿠폰 리스트를 조회한다.
     *
     * @param adminUser
     * @return
     */
    public List<AdminUser> getAdminUserList(AdminUser adminUser);

    public  void insertAdminUserList(AdminUser adminUser);

    public void updateAdminUserList(AdminUser adminUser);
}
