package www.grapeaction.com.dao;

import org.apache.ibatis.annotations.Param;
import www.grapeaction.com.pojo.Menu;

import java.util.List;
import java.util.Map;

//
public interface MenuDao {
    public List<Menu> getMenuList(@Param("map") Map map);

    public int updateMenu(Menu menu);

    public int insertMenu(Menu  menu);

    public int deleteMenu(Menu  menu);
}
