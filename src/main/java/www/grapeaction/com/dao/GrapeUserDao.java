package www.grapeaction.com.dao;

import org.apache.ibatis.annotations.Param;
import www.grapeaction.com.pojo.GrapeUser;
import www.grapeaction.com.util.page.Page;

import java.util.List;
import java.util.Map;

public interface GrapeUserDao {
    List<GrapeUser> findAllGrapeUserGrapeUser(@Param("map") Map map);
    public int getGrapeUserSumNum(@Param("map") Map map);
    public int   insertGrapeUser(GrapeUser grapeUser);
    public int   updateGrapeUser(GrapeUser grapeUser);
}
