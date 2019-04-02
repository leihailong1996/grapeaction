package www.grapeaction.com.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import www.grapeaction.com.dao.BodyAttachmentDao;
import www.grapeaction.com.dao.BodyDao;
import www.grapeaction.com.pojo.Body;
import www.grapeaction.com.pojo.BodyAttachment;
import www.grapeaction.com.service.BodyAttachmentService;
import www.grapeaction.com.service.BodyService;
import www.grapeaction.com.util.page.Page;

import java.util.List;

@Service("/bodyAttachmentService")
public class BodyAttachmentServiceImpl implements BodyAttachmentService {
    @Autowired
    private BodyAttachmentDao bodyAttachmentDao;

    public List<BodyAttachment> getBodyAttachmentList(Page page){
        return  bodyAttachmentDao.getBodyAttachmentList(page.getParams());
    }
    public int updateBodyAttachment(BodyAttachment bodyAttachment){
        return  bodyAttachmentDao.updateBodyAttachment(bodyAttachment);
    }
    public int insertBodyAttachment(BodyAttachment bodyAttachment){
        return  bodyAttachmentDao.insertBodyAttachment(bodyAttachment);
    }
    public int deleteBodyAttachment(BodyAttachment bodyAttachment){
        return  bodyAttachmentDao.deleteBodyAttachment(bodyAttachment);
    }

}
