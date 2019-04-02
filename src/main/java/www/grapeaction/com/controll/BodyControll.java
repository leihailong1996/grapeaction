package www.grapeaction.com.controll;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import www.grapeaction.com.pojo.Body;
import www.grapeaction.com.pojo.Configuretion;
import www.grapeaction.com.service.BodyService;
import www.grapeaction.com.service.ConfiguretionService;
import www.grapeaction.com.util.page.Page;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/bodyControll")
public class BodyControll {
    @Resource
    private BodyService bodyService;

    @RequestMapping("/getBodyList")
    public List<Body> getBodyList(HttpServletRequest request){
        Page page =new Page();
        Map<String,String> map =new HashMap<String,String>();
       // map.put("bodyName","篮球");
        page.setParams(map);
        return   bodyService.getBodyList(page);
    }

    @RequestMapping("/updateBody")
    public int updateBody(Body body){
        return  0;
    }

    @RequestMapping("/insertBody")
    public int insertBody(Body body ){
        return  0;
    }

    @RequestMapping("/deleteBody")
    public int deleteBody(Body  body){
        return  0;
    }

}
