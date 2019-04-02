package www.grapeaction.com.pojo;

import java.util.Date;

public class Configuretion {
    private int configid;
    private String configname;
    private String configvalue;
    private char Flag;
    private String mean;
    private Date createdate;

    @Override
    public String toString() {
        return "Configuretion{" +
                "configid=" + configid +
                ", configname='" + configname + '\'' +
                ", configvalue='" + configvalue + '\'' +
                ", Flag=" + Flag +
                ", mean='" + mean + '\'' +
                ", createdate=" + createdate +
                '}';
    }

    public int getConfigid() {
        return configid;
    }

    public String getConfigname() {
        return configname;
    }

    public String getConfigvalue() {
        return configvalue;
    }

    public char getFlag() {
        return Flag;
    }

    public String getMean() {
        return mean;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setConfigid(int configid) {
        this.configid = configid;
    }

    public void setConfigname(String configname) {
        this.configname = configname;
    }

    public void setConfigvalue(String configvalue) {
        this.configvalue = configvalue;
    }

    public void setFlag(char flag) {
        Flag = flag;
    }

    public void setMean(String mean) {
        this.mean = mean;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }
}
