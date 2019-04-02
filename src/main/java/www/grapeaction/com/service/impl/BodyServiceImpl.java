package www.grapeaction.com.service.impl;

import com.github.pagehelper.PageHelper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import www.grapeaction.com.dao.BodyDao;
import www.grapeaction.com.dao.ConfiguretionDao;
import www.grapeaction.com.pojo.Body;
import www.grapeaction.com.pojo.Configuretion;
import www.grapeaction.com.service.BodyService;
import www.grapeaction.com.service.ConfiguretionService;
import www.grapeaction.com.util.page.Page;

import java.util.List;
import java.util.Map;@Service("/bodyService")


public class BodyServiceImpl implements BodyService {
    @Autowired
    private BodyDao bodyDao;

    public List<Body> getBodyList(Page page ){
        PageHelper.startPage(page.getPageNo(),page.getPageSize());
        System.out.println(page.getParams().size());
        return bodyDao.getBodyList(page.getParams());
    }
    public int updateBody(Body body){
        return bodyDao.updateBody(body);
    }
    public int insertBody(Body body){
        return bodyDao.insertBody(body);
    }
    public int deleteBody(Body body){
        return bodyDao.deleteBody(body);
    }
}
