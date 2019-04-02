package www.grapeaction.com.controll;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import www.grapeaction.com.pojo.Demo;
import www.grapeaction.com.service.DemoService;
import www.grapeaction.com.util.page.Page;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/demoController")
public class DemoController {

    @RequestMapping("/getWorld")
    public String  getWorld(HttpServletRequest request){
        String userName =request.getParameter("userName");
        String password =request.getParameter("password");
        return "hi  deal"+userName+" your password is "+password;
    }

    @RequestMapping("/getDemo")
    public Demo  getDemo(){
        Demo demo=new Demo();
        demo.setName("demo");
        demo.setOld("21");
        demo.setSex("男");
        return demo;
    }

    @Resource
    private DemoService demoService;

    @RequestMapping("/findAllDemo")
    public List<Demo>   findAllDemo(){
        Page page =new Page();
        Map<String,String> map =new HashMap<String,String>();
        map.put("name","小");
        map.put("old","1");
        page.setParams(map);
        List<Demo> list = demoService.findAllDemo(page);
        return list;
    }

    @RequestMapping("/insertDemo")
    public Demo   insertDemo(){
        System.out.println("insert 开始");
        Demo demo=new Demo();
        demo.setName("张三");
        demo.setOld("22");
        demo.setSex("男");
        int i  = demoService.insertDemo(demo);
        return demo;
    }

    @RequestMapping("/updateDemo")
    public void    updateDemo(){
        System.out.println("insert 开始");
        Demo demo=new Demo();
        demo.setId(3);
        demo.setName("demo");
        demo.setOld("21");
        demo.setSex("男");
        int i=demoService.updateDemo(demo);
        System.out.println(i);
    }

    @RequestMapping("/deleteDemo")
    public void  deleteDemo(){
        System.out.println("删除");
        Integer id =7;
        int i = demoService.deleteDemo(id);
        System.out.println(i);
    }
}
