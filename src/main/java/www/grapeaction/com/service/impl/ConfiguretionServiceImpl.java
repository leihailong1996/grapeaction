package www.grapeaction.com.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import www.grapeaction.com.dao.ConfiguretionDao;
import www.grapeaction.com.pojo.Configuretion;
import www.grapeaction.com.service.ConfiguretionService;
import www.grapeaction.com.util.page.Page;

import java.util.List;

@Service("/configuretionService")
public class ConfiguretionServiceImpl implements ConfiguretionService {
    @Autowired
    private  ConfiguretionDao configuretionDao;

    public List<Configuretion> getConfiguretionList(Page page){
        PageHelper.startPage(page.getPageNo(),page.getPageSize());
        return configuretionDao.getConfiguretionList(page.getParams());
    }

    @Override
    public int getConfiguretionSumNum(Page page) {
        return configuretionDao.getConfiguretionSumNum(page.getParams());
    }

    public int updateConfiguretion(Configuretion configuration){
        return configuretionDao.updateConfiguretion(configuration);
    }
    public int insertConfiguretion(Configuretion  configuration){
        return configuretionDao.insertConfiguretion(configuration);
    }
    public int deleteConfiguretion(Configuretion  configuration){
        return configuretionDao.deleteConfiguretion(configuration);
    }
}
