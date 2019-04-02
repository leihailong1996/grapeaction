package www.grapeaction.com.service;

import org.apache.ibatis.annotations.Param;
import www.grapeaction.com.pojo.Body;
import www.grapeaction.com.util.page.Page;

import java.util.List;
import java.util.Map;

public interface BodyService {
    public List<Body> getBodyList(Page page );
    public int updateBody(Body body);
    public int insertBody(Body body);
    public int deleteBody(Body body);
}
