package www.grapeaction.com.dao;

import org.apache.ibatis.annotations.Param;
import www.grapeaction.com.pojo.BodyAttachment;

import java.util.List;
import java.util.Map;

public interface BodyAttachmentDao {
    public List<BodyAttachment> getBodyAttachmentList(@Param("map") Map map);
    public int updateBodyAttachment(BodyAttachment bodyAttachment);
    public int insertBodyAttachment(BodyAttachment bodyAttachment);
    public int deleteBodyAttachment(BodyAttachment bodyAttachment);
}
