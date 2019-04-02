package www.grapeaction.com.dao;

import org.apache.ibatis.annotations.Param;
import www.grapeaction.com.pojo.Configuretion;
import www.grapeaction.com.util.page.Page;

import java.util.List;
import java.util.Map;

public interface ConfiguretionDao {
    public List<Configuretion> getConfiguretionList(@Param("map") Map map);
    public int getConfiguretionSumNum(@Param("map") Map map);
    public int updateConfiguretion(Configuretion configuration);
    public int insertConfiguretion(Configuretion  configuration);
    public int deleteConfiguretion(Configuretion  configuration);
}
