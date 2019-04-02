package www.grapeaction.com.service;

import www.grapeaction.com.pojo.BodyAttachment;
import www.grapeaction.com.util.page.Page;

import java.util.List;

public interface BodyAttachmentService {
    public List<BodyAttachment> getBodyAttachmentList(Page page);
    public int updateBodyAttachment(BodyAttachment bodyAttachment);
    public int insertBodyAttachment(BodyAttachment bodyAttachment);
    public int deleteBodyAttachment(BodyAttachment bodyAttachment);
}
