package www.grapeaction.com.dao;

import org.apache.ibatis.annotations.Param;
import www.grapeaction.com.pojo.Power;

import java.util.List;
import java.util.Map;
public interface PowerDao {
    public List<Power> getPowerList(@Param("map") Map map);
    public int updatePower(Power power);
    public int insertPower(Power power);
    public int deletePower(Power power);
}
