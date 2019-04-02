package www.grapeaction.com.pojo;

import  java.util.Date;

public class GrapeUser {
    private int userId;
    private String userName;
    private String password;
    private char flag;
    private Date createDate;

    @Override
    public String toString() {
        System.out.println("GrapeUser{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", flag=" +flag +
                ", createDate=" + createDate +
                '}');
        return "GrapeUser{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", flag=" +flag +
                ", createdate=" + createDate +
                '}';
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public char getFlag() {
        return flag;
    }

    public Date getCreatedate() {
        return createDate;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFlag(char flag) {
        this.flag = flag;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
