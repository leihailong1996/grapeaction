package www.grapeaction.com.service;

import www.grapeaction.com.pojo.GrapeUser;
import www.grapeaction.com.util.page.Page;

import java.util.List;


public interface GrapeUserService {
    List<GrapeUser> findAllGrapeUserGrapeUser(Page page);
    public int getGrapeUserSumNum(Page page);
    //111
    public int   insertGrapeUser(GrapeUser grapeUser);
    public int   updateGrapeUser(GrapeUser grapeUser);
}
