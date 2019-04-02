package www.grapeaction.com.dao;

import org.apache.ibatis.annotations.Param;
import www.grapeaction.com.pojo.Body;

import java.util.List;
import java.util.Map;

public interface BodyDao {
    public List<Body> getBodyList(@Param("map") Map map);
    public int updateBody(Body body);
    public int insertBody(Body body);
    public int deleteBody(Body body);
}
