package www.grapeaction.com.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import www.grapeaction.com.dao.DemoDao;
import www.grapeaction.com.pojo.Demo;
import www.grapeaction.com.service.DemoService;
import www.grapeaction.com.util.page.Page;

import java.util.List;
@Service("/demoService")
public class DemoServiceImpl implements DemoService {
    @Autowired
    private DemoDao demoDao;
    public List<Demo> findAllDemo(Page page){
        PageHelper.startPage(page.getPageNo(),page.getPageSize());
        return demoDao.findAllDemo( page.getParams());
    }

    public int   insertDemo(Demo demo){
        return demoDao.insertDemo(demo);
    }

    public int   updateDemo(Demo demo){
        return demoDao.updateDemo(demo);
    }
    public int  deleteDemo(Integer id){
        return demoDao.deleteDemo(id);
    }
}

