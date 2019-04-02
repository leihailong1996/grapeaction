package www.grapeaction.com.controll;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import www.grapeaction.com.pojo.Body;
import www.grapeaction.com.pojo.BodyAttachment;
import www.grapeaction.com.service.BodyAttachmentService;
import www.grapeaction.com.service.BodyService;
import www.grapeaction.com.util.page.Page;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/bodyAttachmentControll")
public class BodyAttachmentControll {
    @Resource
    private BodyAttachmentService bodyAttachmentService;

    @RequestMapping("/getBodyAttachmentList")
    public List<BodyAttachment> getBodyAttachmentList(HttpServletRequest request){
        Page page =new Page();
        Map<String,String> map =new HashMap<String,String>();
        //map.put("bodyName","篮球");
        page.setParams(map);
        return   bodyAttachmentService.getBodyAttachmentList(page);
    }

    @RequestMapping("/updateBodyAttachment")
    public int updateBody(BodyAttachment bodyAttachment){
        return  0;
    }

    @RequestMapping("/insertBodyAttachment")
    public int insertBody(BodyAttachment bodyAttachment ){
        return  0;
    }

    @RequestMapping("/deleteBodyAttachment")
    public int deleteBody(BodyAttachment  bodyAttachment){
        return  0;
    }

}
