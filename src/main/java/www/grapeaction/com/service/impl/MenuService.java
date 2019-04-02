package www.grapeaction.com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import www.grapeaction.com.dao.MenuDao;
import www.grapeaction.com.pojo.Menu;
import www.grapeaction.com.util.page.Page;

import java.util.List;
import java.util.Map;

@Service("/menuService")
public class MenuService implements www.grapeaction.com.service.MenuService {

    @Autowired
    private MenuDao menuDao;


    public List<Menu> getMenuList(Page page){
        return menuDao.getMenuList(page.getParams());
    }
    public int updateMenu(Menu menu){
        return  menuDao.updateMenu(menu);
    }
    public int insertMenu(Menu  menu){
        return  menuDao.insertMenu(menu);
    }
    public int deleteMenu(Menu  menu){
        return  deleteMenu(menu);
    }
}
