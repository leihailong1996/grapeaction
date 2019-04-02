package www.grapeaction.com.dao;

import org.apache.ibatis.annotations.Param;
import www.grapeaction.com.pojo.Demo;

import java.util.List;
import java.util.Map;

public interface DemoDao {
    List<Demo> findAllDemo(@Param("map") Map map);
    public int   insertDemo(Demo demo);
    public int   updateDemo(Demo demo);
    public int  deleteDemo(Integer id);
}
