package www.grapeaction.com.service;

import www.grapeaction.com.pojo.Demo;
import www.grapeaction.com.util.page.Page;

import java.util.List;


public interface DemoService {
    List<Demo> findAllDemo(Page page);
    public int   insertDemo(Demo demo);
    public int   updateDemo(Demo demo);
    public int  deleteDemo(Integer id);

}
