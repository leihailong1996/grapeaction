package www.grapeaction.com.pojo;

import java.util.Date;

public class Power {
    private int powerId;
    private int menuId;
    private int userId;
    private String  flag;
    private Date createdate;

    public int getPowerId() {
        return powerId;
    }

    public int getMenuId() {
        return menuId;
    }

    public int getUserId() {
        return userId;
    }

    public String getFlag() {
        return flag;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setPowerId(int powerId) {
        this.powerId = powerId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }
}
