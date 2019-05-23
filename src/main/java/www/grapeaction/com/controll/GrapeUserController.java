package www.grapeaction.com.controll;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import www.grapeaction.com.pojo.Demo;
import www.grapeaction.com.pojo.GrapeUser;
import www.grapeaction.com.pojo.Menu;
import www.grapeaction.com.pojo.Power;
import www.grapeaction.com.service.DemoService;
import www.grapeaction.com.service.GrapeUserService;
import www.grapeaction.com.service.MenuService;
import www.grapeaction.com.service.PowerService;
import www.grapeaction.com.util.page.Page;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@RestController
@RequestMapping("/grapeUserController")
public class GrapeUserController {
    @Resource
    private GrapeUserService grapeUserService;
    @Resource
    private PowerService powerService;
    @Resource
    private MenuService menuService;

    @RequestMapping("/findAllGrapeUserGrapeUser")
    public GrapeUser loginDo(HttpServletRequest request, HttpSession session) {
        String userName =request.getParameter("userName");
        String password =request.getParameter("password");
        Page page =new Page();
        Map<String,String> map =new HashMap<String,String>();
        map.put("userName",userName);
        map.put("password",password);
        page.setParams(map);
        GrapeUser grapeUser;
        if(grapeUserService.findAllGrapeUserGrapeUser(page) !=null && grapeUserService.findAllGrapeUserGrapeUser(page) .size()>=1){
            grapeUser=grapeUserService.findAllGrapeUserGrapeUser(page).get(0);
            //暂时没有用 html5好像没有用
            session.setAttribute("grapeUser1", grapeUser.getUserName());
            //System.out.println("session=="+session.getAttribute("grapeUser1"));
        }else{
            grapeUser=null;
        }
        return  grapeUser;
    }

    @RequestMapping("/getConfiguretionSumNum")
    public Page getConfiguretionSumNum(HttpServletRequest request){
        int pageNo =Integer.parseInt(request.getParameter("pageNo"));
        Page page =new Page();
        Map<String,String> map =new HashMap<String,String>();
        page.setParams(map);
        page.setPageNo(pageNo);
        int sumNum=grapeUserService.getGrapeUserSumNum(page);
        page.setTotalRecord(sumNum);
        return   page;
    }
    @RequestMapping("/getGrapeUserList")
    public List<GrapeUser> getGrapeUserList(HttpServletRequest request, HttpSession session) {
        System.out.println("sessionList==" + session.getAttribute("grapeUser1"));
        Page page =new Page();
        Map<String,String> map=new HashMap<String, String>();
        String userId = request.getParameter("userId");
        if(!"".equals(userId) && userId!=null){
            map.put("userId",userId);
        }
        if(request.getParameter("pageNo")!=null && request.getParameter("pageNo")!="" ){
            int pageNo =Integer.parseInt(request.getParameter("pageNo"));
            page.setPageNo(pageNo);
        }
        page.setParams(map);
        List<GrapeUser> list =grapeUserService.findAllGrapeUserGrapeUser(page);
        return list;
    }
    @RequestMapping("/updateGrapeUser")
    public int updateGrapeUser(HttpServletRequest request){
        GrapeUser grapeUser=new GrapeUser();
        Map<String,String> map=new HashMap<String, String>();
        String password=request.getParameter("password");
        if(!"".equals(password) && password!=""){
            grapeUser.setPassword(password);
        }
        String flag = request.getParameter("flag");
        if(!"".equals(flag) && flag!=null){
            grapeUser.setFlag(flag.charAt(0));
        }
        String userId = request.getParameter("userId");
        if(!"".equals(flag) && flag!=null){
            grapeUser.setUserId(Integer.parseInt(userId));
        }
        if(!"".equals(flag) && flag!=null){
            grapeUser.setUserId(Integer.parseInt(userId));
        }
        String userName = request.getParameter("userName");
        if(!"".equals(userName) && flag!=null){
            grapeUser.setUserName(userName);
        }
        int num =grapeUserService.updateGrapeUser(grapeUser);
        String[] powerListByUserId = request.getParameterValues("powerListByUserId[]");//页面权限的值
        List<String> powerList;//判断是否包括
        //给用户修改权限：把选择角色的赋值
        if (powerListByUserId != null && powerListByUserId.length>0){
            powerList=Arrays.asList(powerListByUserId);
            for (int i =0;i<powerListByUserId.length;i++){
                Power power=new Power();
                power.setFlag("1");
                if(!"".equals(flag) && flag!=null){
                    power.setUserId(Integer.parseInt(userId));
                }
                if(!"".equals(powerListByUserId[i]) && powerListByUserId[i]!=null){
                    power.setMenuId(Integer.parseInt(powerListByUserId[i]));
                }
                powerService.updatePower(power);
            }
        }else{
            //避免报错
            powerList=new ArrayList<String>();
            powerList.add("");
        }

        Page pageMenu=new Page();
        List<Menu> menuList=menuService.getMenuList(pageMenu);
        Menu menu;
        for(int i =0;i<menuList.size();i++){
            menu=menuList.get(i);
            if(!powerList.contains(menu.getMenuId()+"")){
                Power power=new Power();
                power.setFlag("0");
                if(!"".equals(flag) && flag!=null){
                    power.setUserId(Integer.parseInt(userId));
                }
                power.setMenuId(menu.getMenuId());
                powerService.updatePower(power);
            }
        }
        return num;
    }

    @RequestMapping("/checkPowerEveryOne")
    public int checkPowerEveryOne(){
        Page pageMenu=new Page();
        Page pageUser=new Page();
        Page pagePower;
        Map<String,String > mapPower;
        List<Menu> menuList=menuService.getMenuList(pageMenu);
        List<GrapeUser> userList =grapeUserService.findAllGrapeUserGrapeUser(pageUser);
        GrapeUser user;
        Menu menu;
        Power power;
        int num=0;
        for (int i =0;i<userList.size();i++){
            user=userList.get(i);
            for (int j =0;j<menuList.size();j++){
                menu=menuList.get(j);
                pagePower=new Page();
                mapPower=new HashMap<String,String>();
                mapPower.put("menuId",menu.getMenuId()+"");
                mapPower.put("userId",user.getUserId()+"");
                pagePower.setParams(mapPower);
                List<Power>powerList =powerService.getPowerList(pagePower);
                //power表里没有某一个菜单的属性，需要添加一个
                if(powerList.size()==0){
                    power=new Power();
                    power.setMenuId(menu.getMenuId());
                    power.setUserId(user.getUserId());
                    power.setFlag("0");
                    power.setCreatedate(new Date());
                    powerService.insertPower(power);
                    num++;
                }
            }
        }
        return num;
    }

    @RequestMapping("/newUser")
    public int newUser(HttpServletRequest request){
       String userName=request.getParameter("userName");
       int num=0;
        if(!"".equals(userName) && userName!=null){
           GrapeUser grapeUser=new GrapeUser();
           grapeUser.setUserName(userName);
           grapeUser.setFlag('1');
           grapeUser.setCreateDate(new Date());
           grapeUser.setPassword("123456");
           num =grapeUserService.insertGrapeUser(grapeUser);
       }
        return num;
    }
}
