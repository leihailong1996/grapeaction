package www.grapeaction.com.service;

import www.grapeaction.com.pojo.Power;
import www.grapeaction.com.util.page.Page;

import java.util.List;

public interface PowerService {
    public List<Power> getPowerList(Page page);
    public int updatePower(Power power);
    public int insertPower(Power power);
    public int deletePower(Power power);
}
