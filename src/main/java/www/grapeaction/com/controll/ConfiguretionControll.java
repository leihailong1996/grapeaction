package www.grapeaction.com.controll;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import www.grapeaction.com.pojo.Configuretion;
import www.grapeaction.com.pojo.Demo;
import www.grapeaction.com.service.ConfiguretionService;
import www.grapeaction.com.util.page.Page;
import www.grapeaction.com.util.page.PageSizeClass;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/configuretionController")
public class ConfiguretionControll {
    @Resource
    private ConfiguretionService  configuretionService;
    //获取配置项列表
    @RequestMapping("/getConfiguretionList")
    public List<Configuretion> getConfiguretionList(HttpServletRequest request){

        Page page =new Page();
        Map<String,String> map =new HashMap<String,String>();
        if(request.getParameter("pageNo")!=null &&request.getParameter("pageNo")!=""){
            int pageNo =Integer.parseInt(request.getParameter("pageNo"));
            page.setPageNo(pageNo);
        }
        if(request.getParameter("configid")!=null){
            String configid=request.getParameter("configid");
            map.put("configid",configid);
        }
        page.setParams(map);
        return   configuretionService.getConfiguretionList(page);
    }

    /**
     * 只获取当前页
     * @param request
     * @return
     */
    @RequestMapping("/getConfiguretionSumNum")
    public Page getConfiguretionSumNum(HttpServletRequest request){
        int pageNo =1;
        if(request.getParameter("pageNo")!=null && request.getParameter("pageNo")!=""){
            pageNo =Integer.parseInt(request.getParameter("pageNo"));
        }
        Page page =new Page();
        Map<String,String> map =new HashMap<String,String>();
        page.setParams(map);
        page.setPageNo(pageNo);
        int sumNum=configuretionService.getConfiguretionSumNum(page);
        page.setTotalRecord(sumNum);
        return   page;
    }


    @RequestMapping("/updateConfiguretion")
    public int updateConfiguretion(HttpServletRequest request){
        Configuretion configuretion=new Configuretion();
        if(!"".equals(request.getParameter("configid")) && request.getParameter("configid")!="0"){
            int configid =Integer.parseInt( request.getParameter("configid"));
            configuretion.setConfigid(configid);
        }
        String configname =request.getParameter("configname");
        if(!"".equals(configname) && configname!=""){
            configuretion.setConfigname(configname);
        }
        String configvalue =request.getParameter("configvalue");
        if(!"".equals(configvalue) && configvalue!=""){
            configuretion.setConfigvalue(configvalue);
        }
        char Flag =request.getParameter("flag").charAt(0);
        if(!"".equals(Flag) ){
            configuretion.setFlag(Flag);
        }
        String mean =request.getParameter("mean");
        if(!"".equals(mean) && mean!=""){
            configuretion.setMean(mean);
        }
        configuretion.setCreatedate(new Date());
        int num=configuretionService.updateConfiguretion(configuretion);
        if("pageSize".equals(configname)){
            PageSizeClass.DEFAULT_PAGESIZE=getConfigurationByName("pageSize");//设置每页行数
        }
        return  num;
    }

    @RequestMapping("/insertConfiguretion")
    public int insertConfiguretion(Configuretion  configuration){
        return  0;
    }

    @RequestMapping("/deleteConfiguretion")
    public int deleteConfiguretion(Configuretion  configuration){
        return  0;
    }

  //通过配置项名字获取值
  @RequestMapping("/getConfigurationByName")
  public String getConfigurationByName(HttpServletRequest request){
      String servletContext =request.getParameter("servletContext");
      Page page =new Page();
      Map<String,String> map =new HashMap<String,String>();
      map.put("configname",servletContext);
      map.put("flag","1");
      page.setParams(map);
      PageSizeClass.DEFAULT_PAGESIZE=getConfigurationByName("pageSize");//设置每页行数
      return   configuretionService.getConfiguretionList(page).get(0).getConfigvalue();
  }

    /**
     * 设置 每页行数
     * @param name
     * @return
     */
    public String getConfigurationByName(String name){
        Page page =new Page();
        Map<String,String> map =new HashMap<String,String>();
        map.put("configname",name);
        page.setParams(map);
        String configname= configuretionService.getConfiguretionList(page).get(0).getConfigvalue();
        return  configname;
    }
}
