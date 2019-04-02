package www.grapeaction.com.service;

import www.grapeaction.com.pojo.Menu;
import www.grapeaction.com.util.page.Page;

import java.util.List;
import java.util.Map;

public interface MenuService {
    public List<Menu> getMenuList(Page page);
    public int updateMenu(Menu menu);
    public int insertMenu(Menu  menu);
    public int deleteMenu(Menu  menu);
}
