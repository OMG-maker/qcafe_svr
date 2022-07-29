package kr.omg.qcafe.service;

import kr.omg.qcafe.mapper.MenuMapper;
import kr.omg.qcafe.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class MenuServiceImpl implements MenuService{

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<Menu> getMenuList(Menu menu) {
        return menuMapper.getMenuList(menu);
    }
    public List<Menu> getMenuOne(Menu menu){
        return menuMapper.getMenuOne(menu);
    }


    @Override
    public void insertMenu(Menu menu) {
        menuMapper.insertMenu(menu);
    }

    public void deleteMenu(Menu menu){
        menuMapper.deleteMenu(menu);
    }

    public void insertMenuSimple(Menu menu){
        menuMapper.insertMenuSimple(menu);
    };

    public void updateMenuData(Menu menu){menuMapper.updateMenuData(menu);}

}

