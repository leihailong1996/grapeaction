package www.grapeaction.com.controll;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import www.grapeaction.com.pojo.Body;
import www.grapeaction.com.pojo.BodyType;
import www.grapeaction.com.service.BodyService;
import www.grapeaction.com.service.BodyTypeService;
import www.grapeaction.com.util.page.Page;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/bodyTypeControll")
public class BodyTypeControll {
    @Resource
    private BodyTypeService bodyTypeService;

    @RequestMapping("/getBodyTypeList")
    public List<BodyType> getBodyTypeList(HttpServletRequest request){
        Page page =new Page();
        Map<String,String> map =new HashMap<String,String>();
        map.put("bodyTypeName","篮球");
        page.setParams(map);
        return   bodyTypeService.getBodyTypeList(page);
    }

    @RequestMapping("/updateBodyType")
    public int updateBodyType(BodyType bodyType){
        return  0;
    }

    @RequestMapping("/insertBodyType")
    public int insertBody(BodyType bodyType ){
        return  0;
    }

    @RequestMapping("/deleteBodyType")
    public int deleteBody(BodyType  bodyType){
        return  0;
    }

}
