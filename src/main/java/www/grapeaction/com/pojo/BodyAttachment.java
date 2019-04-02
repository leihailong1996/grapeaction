package www.grapeaction.com.pojo;

import java.sql.Blob;
import java.util.Date;

public class BodyAttachment {
    private int bodyAttachmentId;
    private String  bodyAttachmentName;
    private byte[]   bodyAttachmentValue;
    private int bodyId;
    private  char  flag;
    private Date createDate;
    private int bodyAttachmentSort;
    private int bodyAttachmentType;

    @Override
    public String toString() {
        return "BodyAttachment{" +
                "bodyAttachmentId=" + bodyAttachmentId +
                ", bodyAttachmentName='" + bodyAttachmentName + '\'' +
                ", bodyAttachmentValue=" + bodyAttachmentValue +
                ", bodyId=" + bodyId +
                ", flag=" + flag +
                ", createDate=" + createDate +
                ", bodyAttachmentSort=" + bodyAttachmentSort +
                ", bodyAttachmentType=" + bodyAttachmentType +
                '}';
    }

    public void setBodyAttachmentId(int bodyAttachmentId) {
        this.bodyAttachmentId = bodyAttachmentId;
    }

    public void setBodyAttachmentName(String bodyAttachmentName) {
        this.bodyAttachmentName = bodyAttachmentName;
    }

    public void setBodyAttachmentValue(byte[] bodyAttachmentValue) {
        this.bodyAttachmentValue = bodyAttachmentValue;
    }

    public void setBodyId(int bodyId) {
        this.bodyId = bodyId;
    }

    public void setFlag(char flag) {
        this.flag = flag;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public void setBodyAttachmentSort(int bodyAttachmentSort) {
        this.bodyAttachmentSort = bodyAttachmentSort;
    }

    public void setBodyAttachmentType(int bodyAttachmentType) {
        this.bodyAttachmentType = bodyAttachmentType;
    }

    public int getBodyAttachmentId() {
        return bodyAttachmentId;
    }

    public String getBodyAttachmentName() {
        return bodyAttachmentName;
    }

    public byte[] getBodyAttachmentValue() {
        return bodyAttachmentValue;
    }

    public int getBodyId() {
        return bodyId;
    }

    public char getFlag() {
        return flag;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public int getBodyAttachmentSort() {
        return bodyAttachmentSort;
    }

    public int getBodyAttachmentType() {
        return bodyAttachmentType;
    }
}
