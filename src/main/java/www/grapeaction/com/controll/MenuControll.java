package www.grapeaction.com.controll;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import www.grapeaction.com.pojo.Menu;
import www.grapeaction.com.pojo.Power;
import www.grapeaction.com.service.MenuService;
import www.grapeaction.com.service.PowerService;
import www.grapeaction.com.util.page.Page;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/menuControll")
public class MenuControll {

    @Resource
    private MenuService menuService;
    @Resource
    private PowerService powerService;

    @RequestMapping("/getMenuList")
    public List<Menu> getMenuList(HttpServletRequest request){
        Page page =new Page();
        Map<String,String> map=new HashMap<String, String>();
       /* String flag = request.getParameter("flag");
        if(!"".equals(flag) && flag!=null){
            map.put("flag",flag);
        }*/
        String menuId = request.getParameter("menuId");
        if(!"".equals(menuId) && menuId!=null){
            map.put("menuId",menuId);
        }
        page.setParams(map);
        List<Menu> list = menuService.getMenuList(page);
        List<Menu> returnMunuList = new ArrayList<Menu>();
        String userId = request.getParameter("userId");
        if(!"".equals(userId) && userId!=null){
            Page powerPage =new Page();
            Map<String,String> powerMap=new HashMap<String, String>();
            powerMap.put("userId",userId);
            powerMap.put("flag","1");
            powerPage.setParams(powerMap);
            List<Power> powerList=powerService.getPowerList(powerPage);
            Menu menu ;
            for (int i =0;i<list.size();i++){
                menu=list.get(i);
                if(menu.getFlag()=='1'){
                    returnMunuList.add(menu);
                }
                if(menu.getFlag()=='2'){
                    for (int j =0;j<powerList.size();j++){
                        if(menu.getMenuId()==powerList.get(j).getMenuId()){
                            returnMunuList.add(menu);
                        }
                    }
                }
            }
        }else{
            returnMunuList=list;
        }
        return returnMunuList;
    }
    @RequestMapping("/updateMenu")
    public int updateMenu(HttpServletRequest request){
        Menu menu =new Menu();

        if(!"".equals(request.getParameter("menuId")) && request.getParameter("menuId")!="0"){
            int menuId =Integer.parseInt( request.getParameter("menuId"));
            menu.setMenuId(menuId);
        }
        String menuName =request.getParameter("menuName");
        if(!"".equals(menuName) && menuName!=""){
            menu.setMenuName(menuName);
        }
        String menuUrl =request.getParameter("menuUrl");
        if(!"".equals(menuUrl) && menuUrl!=""){
            menu.setMenuUrl(menuUrl);
        }

        String mean =request.getParameter("mean");
        if(!"".equals(mean) && mean!=""){
            menu.setMean(mean);
        }

        char flag =request.getParameter("flag").charAt(0);
        if(!"".equals(flag)){
            menu.setFlag(flag);
        }

        int parentMenuId =Integer.parseInt( request.getParameter("parentMenuId"));
        if(!"".equals(parentMenuId) && parentMenuId!=0){
            menu.setParentMenuId(parentMenuId);
        }
        int menuLevel =Integer.parseInt( request.getParameter("menuLevel"));
        if(!"".equals(menuLevel) && menuLevel!=0){
            menu.setMenuLevel(menuLevel);
        }
        return menuService.updateMenu(menu);
    }
}
