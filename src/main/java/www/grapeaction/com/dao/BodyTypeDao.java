package www.grapeaction.com.dao;

import org.apache.ibatis.annotations.Param;
import www.grapeaction.com.pojo.BodyType;

import java.util.List;
import java.util.Map;

public interface BodyTypeDao {
    public List<BodyType> getBodyTypeList(@Param("map") Map map);
    public int updateBodyType(BodyType bodyType);
    public int insertBodyType(BodyType bodyType);
    public int deleteBodyType(BodyType bodyType);
}
