package www.grapeaction.com.util.defaultPage;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import www.grapeaction.com.pojo.Configuretion;
import www.grapeaction.com.service.ConfiguretionService;
import www.grapeaction.com.util.page.Page;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 设置默认页面
 */
@RestController
@RequestMapping("/MVCConfiguration")
public class MVCConfiguration extends HttpServlet implements ServletContextListener  , WebMvcConfigurer {
    @Resource
    private ConfiguretionService configuretionService;

    @Autowired
    private transient ServletContext servletContext;

    @RequestMapping("/getConfiguration")
    public String getConfiguration(HttpServletRequest request){
        String value =request.getParameter("servletContext");
        String servletContextValue=servletContext.getAttribute(value).toString();
        return  servletContextValue;
    }

    // 初始化时执行该方法
    @PostConstruct
    public void init(){
        Page page =new Page();
        Map<String,String> map =new HashMap<String, String>();
        map.put("Flag","1");
        page.setParams(map);
        List<Configuretion> list= configuretionService.getConfiguretionList(page);
        for (Configuretion configuretion :list){
            servletContext.setAttribute(configuretion.getConfigname(), configuretion.getConfigvalue());
        }
    }

    public synchronized void contextInitialized(ServletContextEvent sce)
    {
        this.servletContext = sce.getServletContext();
    }

    public synchronized void contextDestroyed(ServletContextEvent event) {
    }

    /**
     * 继承了HttpServlet
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().removeAttribute("user");
        response.sendRedirect("/Project01/IndexServlet");
    }

    /**
     * 继承了HttpServlet
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("/views/index.html");
    }
}
