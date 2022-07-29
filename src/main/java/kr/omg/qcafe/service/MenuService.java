package kr.omg.qcafe.service;

import kr.omg.qcafe.model.Menu;

import java.util.List;

public interface MenuService {
    public List<Menu> getMenuList(Menu menu);
    public List<Menu> getMenuOne(Menu menu);
    public void insertMenu(Menu menu);
    public void insertMenuSimple(Menu menu);
    public void deleteMenu(Menu menu);
    public void updateMenuData(Menu menu);


}
