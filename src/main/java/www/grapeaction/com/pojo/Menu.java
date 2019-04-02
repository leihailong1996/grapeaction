package www.grapeaction.com.pojo;

import java.util.Date;

public class Menu {
    private int menuId;
    private String menuName;
    private String menuUrl;
    private String mean;
    private char flag;
    private Date createdate;
    private int parentMenuId;
    private int menuLevel;

    @Override
    public String toString() {
        System.out.println("Menu{" +
                "menuId=" + menuId +
                ", menuName='" + menuName + '\'' +
                ", menuUrl='" + menuUrl + '\'' +
                ", mean='" + mean + '\'' +
                ", flag=" + flag +
                ", createdate=" + createdate +
                ", parentMenuId=" + parentMenuId +
                ", menuLevel=" + menuLevel +
                '}');
        return "Menu{" +
                "menuId=" + menuId +
                ", menuName='" + menuName + '\'' +
                ", menuUrl='" + menuUrl + '\'' +
                ", mean='" + mean + '\'' +
                ", flag=" + flag +
                ", createdate=" + createdate +
                ", parentMenuId=" + parentMenuId +
                ", menuLevel=" + menuLevel +
                '}';
    }

    public int getMenuId() {
        return menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public String getMean() {
        return mean;
    }

    public char getFlag() {
        return flag;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public int getParentMenuId() {
        return parentMenuId;
    }

    public int getMenuLevel() {
        return menuLevel;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public void setMean(String mean) {
        this.mean = mean;
    }

    public void setFlag(char flag) {
        this.flag = flag;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public void setParentMenuId(int parentMenuId) {
        this.parentMenuId = parentMenuId;
    }

    public void setMenuLevel(int menuLevel) {
        this.menuLevel = menuLevel;
    }
}
