package com.creatAccountApp.pojo;
//用户实体类
import java.time.LocalDateTime;

public class User {

    private Integer UserID;//用户ID
    private String UserName;//用户名称
    private String PasswordHash;//加密后用户密码
    private String Email;//用户邮箱
    private String Phone;//用户手机
    private LocalDateTime CreatTime;//用户创建时间
    private Integer FreeAccountBookID;//免费账本ID

    public Integer getUserID() {
        return UserID;
    }

    public void setUserID(Integer userID) {
        UserID = userID;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPasswordHash() {
        return PasswordHash;
    }

    public void setPasswordHash(String passwordHash) {
        PasswordHash = passwordHash;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public LocalDateTime getCreatTime() {
        return CreatTime;
    }

    public void setCreatTime(LocalDateTime creatTime) {
        CreatTime = creatTime;
    }

    public Integer getFreeAccountBookID() {
        return FreeAccountBookID;
    }

    public void setFreeAccountBookID(Integer freeAccountBookID) {
        FreeAccountBookID = freeAccountBookID;
    }
}
