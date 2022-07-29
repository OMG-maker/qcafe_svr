package kr.omg.qcafe.mapper;

import kr.omg.qcafe.model.Menu;

import java.util.List;

public interface MenuMapper {

    /**
     *
     * @param menu
     * @return
     */
    public List<Menu> getMenuList(Menu menu);
    public List<Menu> getMenuOne(Menu menu);
    public void insertMenu(Menu menu);
    public void insertMenuSimple(Menu menu);
    public void deleteMenu(Menu menu);
    public void updateMenuData(Menu menu);

}
