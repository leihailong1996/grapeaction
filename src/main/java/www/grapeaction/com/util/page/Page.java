package www.grapeaction.com.util.page;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import www.grapeaction.com.controll.ConfiguretionControll;
import www.grapeaction.com.service.ConfiguretionService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Page {
    private static final Logger logger = LoggerFactory.getLogger(Page.class);
    private static ObjectMapper mapper = new ObjectMapper();
    @Resource
    private ConfiguretionService  configuretionService;
    public  String DEFAULT_PAGESIZE =PageSizeClass.DEFAULT_PAGESIZE;//每页行数 默认是值
    private int pageNo;          //当前页码
    private int pageSize;        //每页行数
    private int totalRecord;      //总记录数
    private Map<String, String> params;  //查询条件
    private int totalPage;        //总页数
    private Map<String, List<String>> paramLists;  //数组查询条件
    private String searchUrl;      //Url地址
    private String pageNoDisp;       //可以显示的页号(分隔符"|"，总页数变更时更新)
    private String  isAll;//是否查询全部数据，：1：是，0不是（就是分页）。
    public  Page() {
        isAll="0";
        pageNo = 1;
        pageSize = Integer.valueOf(DEFAULT_PAGESIZE);
        totalRecord = 0;
        totalPage = 0;
        params = new HashMap<String, String>();
        paramLists = new HashMap<String, List<String>>();
        searchUrl = "";
        pageNoDisp = "";
    }

    public String getIsAll() {
        return isAll;
    }

    public void setIsAll(String isAll) {
        this.isAll = isAll;
    }

    public int getPageNo() {
        return pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public Map<String, List<String>> getParamLists() {
        return paramLists;
    }

    public String getSearchUrl() {
        return searchUrl;
    }

    public String getPageNoDisp() {
        return pageNoDisp;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalPage=totalRecord%pageSize==0?totalRecord/pageSize:totalRecord/pageSize+1;
        this.totalRecord = totalRecord;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    public void setParamLists(Map<String, List<String>> paramLists) {
        this.paramLists = paramLists;
    }

    public void setSearchUrl(String searchUrl) {
        this.searchUrl = searchUrl;
    }

    public void setPageNoDisp(String pageNoDisp) {
        this.pageNoDisp = pageNoDisp;
    }
}
