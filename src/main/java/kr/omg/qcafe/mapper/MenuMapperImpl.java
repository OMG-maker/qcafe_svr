package kr.omg.qcafe.mapper;

import kr.omg.qcafe.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MenuMapperImpl implements MenuMapper{

    @Autowired
    private MenuMapper MenuMapper;

    /**
     * @param menu
     * @return
     */
    public List<Menu> getMenuList(Menu menu){
        return this.MenuMapper.getMenuList(menu);
    }

    public List<Menu> getMenuOne(Menu menu){
        return this.MenuMapper.getMenuOne(menu);
    }

    public void insertMenu(Menu menu){
        this.MenuMapper.insertMenu(menu);
    }

    public void deleteMenu(Menu menu){this.MenuMapper.deleteMenu(menu);}

    public void insertMenuSimple(Menu menu){
        this.MenuMapper.insertMenuSimple(menu);
    };

    public void updateMenuData(Menu menu){this.MenuMapper.updateMenuData(menu);}
}
