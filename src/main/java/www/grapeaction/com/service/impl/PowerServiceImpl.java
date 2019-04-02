package www.grapeaction.com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import www.grapeaction.com.dao.PowerDao;
import www.grapeaction.com.pojo.Power;
import www.grapeaction.com.service.PowerService;
import www.grapeaction.com.util.page.Page;

import java.util.List;

@Service("/powerService")
public class PowerServiceImpl   implements PowerService {
    @Autowired
    private PowerDao powerDao;

    @Override
    public List<Power> getPowerList(Page page) {
        return powerDao.getPowerList(page.getParams());
    }

    @Override
    public int updatePower(Power power) {
        return powerDao.updatePower(power);
    }

    @Override
    public int insertPower(Power power) {
        return powerDao.insertPower(power);
    }

    @Override
    public int deletePower(Power power) {
        return powerDao.deletePower(power);
    }
}
