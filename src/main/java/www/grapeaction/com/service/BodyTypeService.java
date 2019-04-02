package www.grapeaction.com.service;

import www.grapeaction.com.pojo.BodyType;
import www.grapeaction.com.util.page.Page;

import java.util.List;

public interface BodyTypeService {
    public List<BodyType> getBodyTypeList(Page page);
    public int updateBodyType(BodyType bodyType);
    public int insertBodyType(BodyType bodyType);
    public int deleteBodyType(BodyType bodyType);
}
