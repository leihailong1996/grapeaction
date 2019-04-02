package www.grapeaction.com.pojo;

import java.util.Date;

public class Body {
    private int bodyId;
    private String  bodyName;
    private int bodyTypeId;
    private String bodyNo;
    private  char  flag;
    private Date  createDate;
    private double importPrice;
    private double sellPrice;

    @Override
    public String toString() {
        return "Body{" +
                "bodyId=" + bodyId +
                ", bodyName='" + bodyName + '\'' +
                ", bodyTypeId=" + bodyTypeId +
                ", bodyNo=" + bodyNo +
                ", flag=" + flag +
                ", createDate=" + createDate +
                ", importPrice=" + importPrice +
                ", sellPrice=" + sellPrice +
                '}';
    }

    public void setBodyId(int bodyId) {
        this.bodyId = bodyId;
    }

    public void setBodyName(String bodyName) {
        this.bodyName = bodyName;
    }

    public void setBodyTypeId(int bodyTypeId) {
        this.bodyTypeId = bodyTypeId;
    }

    public void setBodyNo(String bodyNo) {
        this.bodyNo = bodyNo;
    }

    public void setFlag(char flag) {
        this.flag = flag;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public void setImportPrice(double importPrice) {
        this.importPrice = importPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public int getBodyId() {
        return bodyId;
    }

    public String getBodyName() {
        return bodyName;
    }

    public int getBodyTypeId() {
        return bodyTypeId;
    }

    public String getBodyNo() {
        return bodyNo;
    }

    public char getFlag() {
        return flag;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public double getImportPrice() {
        return importPrice;
    }

    public double getSellPrice() {
        return sellPrice;
    }
}
