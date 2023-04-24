package com.creatAccountApp.pojo;
//账本实体类
public class AccountBook {

    private Integer AccountBookID;//账本ID
    private String AccountBookName;//账本名称

    private Integer UserID;//账本用户ID
    private boolean IsFree;//是否是免费账本

    public Integer getAccountBookID() {
        return AccountBookID;
    }

    public void setAccountBookID(Integer accountBookID) {
        AccountBookID = accountBookID;
    }

    public String getAccountBookName() {
        return AccountBookName;
    }

    public void setAccountBookName(String accountBookName) {
        AccountBookName = accountBookName;
    }

    public Integer getUserID() {
        return UserID;
    }

    public void setUserID(Integer userID) {
        UserID = userID;
    }

    public boolean isFree() {
        return IsFree;
    }

    public void setFree(boolean free) {
        IsFree = free;
    }
}
