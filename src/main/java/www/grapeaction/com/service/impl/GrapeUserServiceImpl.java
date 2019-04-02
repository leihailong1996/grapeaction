package www.grapeaction.com.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import www.grapeaction.com.dao.DemoDao;
import www.grapeaction.com.dao.GrapeUserDao;
import www.grapeaction.com.pojo.Demo;
import www.grapeaction.com.pojo.GrapeUser;
import www.grapeaction.com.service.DemoService;
import www.grapeaction.com.service.GrapeUserService;
import www.grapeaction.com.util.page.Page;

import java.util.List;

@Service("/grapeUserService")
public class GrapeUserServiceImpl implements GrapeUserService {
    @Autowired
    private GrapeUserDao grapeUserDao;


    @Override
    public List<GrapeUser> findAllGrapeUserGrapeUser(Page page) {
        if("0".equals(page.getIsAll())){
            PageHelper.startPage(page.getPageNo(),page.getPageSize());
        }
        return grapeUserDao.findAllGrapeUserGrapeUser(page.getParams());
    }

    public int getGrapeUserSumNum(Page page){
        return  grapeUserDao.getGrapeUserSumNum(page.getParams());
    }

    @Override
    public int insertGrapeUser(GrapeUser grapeUser) {
        return grapeUserDao.insertGrapeUser(grapeUser);
    }

    @Override
    public int updateGrapeUser(GrapeUser grapeUser) {
        return grapeUserDao.updateGrapeUser(grapeUser);
    }

    @Override
    public int updateGrapeUser1(GrapeUser grapeUser) {
        return 0;
    }
}

