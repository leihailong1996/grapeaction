package www.grapeaction.com.pojo;

import java.util.Date;

public class BodyType {
    private int bodyTypeId;
    private String bodyTypeName;
    private int ParentBodyTypeId;
    private int bodyTypeLevel;
    private  char  flag;
    private Date createDate;

    @Override
    public String toString() {
        return "BodyType{" +
                "bodyTypeId=" + bodyTypeId +
                ", bodyTypeName='" + bodyTypeName + '\'' +
                ", ParentBodyTypeId=" + ParentBodyTypeId +
                ", bodyTypeLevel=" + bodyTypeLevel +
                ", flag=" + flag +
                ", createDate=" + createDate +
                '}';
    }

    public void setBodyTypeId(int bodyTypeId) {
        this.bodyTypeId = bodyTypeId;
    }

    public void setBodyTypeName(String bodyTypeName) {
        this.bodyTypeName = bodyTypeName;
    }

    public void setParentBodyTypeId(int parentBodyTypeId) {
        ParentBodyTypeId = parentBodyTypeId;
    }

    public void setBodyTypeLevel(int bodyTypeLevel) {
        this.bodyTypeLevel = bodyTypeLevel;
    }

    public void setFlag(char flag) {
        this.flag = flag;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getBodyTypeId() {
        return bodyTypeId;
    }

    public String getBodyTypeName() {
        return bodyTypeName;
    }

    public int getParentBodyTypeId() {
        return ParentBodyTypeId;
    }

    public int getBodyTypeLevel() {
        return bodyTypeLevel;
    }

    public char getFlag() {
        return flag;
    }

    public Date getCreateDate() {
        return createDate;
    }
}
