package www.grapeaction.com.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import www.grapeaction.com.dao.BodyDao;
import www.grapeaction.com.dao.BodyTypeDao;
import www.grapeaction.com.pojo.Body;
import www.grapeaction.com.pojo.BodyType;
import www.grapeaction.com.service.BodyService;
import www.grapeaction.com.service.BodyTypeService;
import www.grapeaction.com.util.page.Page;

import java.util.List;

@Service("/bodyTypeService")
public class BodyTypeServiceImpl implements BodyTypeService {
    @Autowired
    private BodyTypeDao bodyTypeDao;

    public List<BodyType> getBodyTypeList(Page page ){
        PageHelper.startPage(page.getPageNo(),page.getPageSize());
        System.out.println(page.getParams().size());
        return bodyTypeDao.getBodyTypeList(page.getParams());
    }
    public int updateBodyType(BodyType body){
        return bodyTypeDao.updateBodyType(body);
    }
    public int insertBodyType(BodyType body){
        return bodyTypeDao.insertBodyType(body);
    }
    public int deleteBodyType(BodyType body){
        return bodyTypeDao.deleteBodyType(body);
    }
}
