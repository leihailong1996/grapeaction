package www.grapeaction.com.controll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import www.grapeaction.com.pojo.Power;
import www.grapeaction.com.service.PowerService;
import www.grapeaction.com.util.page.Page;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/powerControll")
public class PowerControll {

    @Resource
    private PowerService powerService;

    @RequestMapping("/getPowerList")
    public List<Power> getPowerList(HttpServletRequest request){
        Page page =new Page();
        Map map =new HashMap();
        String userId=request.getParameter("userId");
        if(!"".equals(userId) && userId!=""){
            map.put("userId",userId);
        }
        String flag = request.getParameter("flag");
        if(!"".equals(flag) && flag!=null){
            map.put("flag",flag);
        }
        page.setParams(map);
        List<Power> list =powerService.getPowerList(page);
        return list;
    }
}
