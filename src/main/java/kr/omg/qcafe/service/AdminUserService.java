package kr.omg.qcafe.service;

import kr.omg.qcafe.model.AdminUser;

import java.util.List;

public interface AdminUserService {
    public  List<AdminUser> getAdminUserList(AdminUser adminUser);

    public  void insertAdminUserList(AdminUser adminUser);

    public void updateAdminUserList(AdminUser adminUser);

}
