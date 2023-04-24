package com.creatAccountApp.pojo;

import java.time.LocalDateTime;

//收支明细
public class IncomeExpense {

    private Integer IEID;//收支明细ID
    private Integer AccountBookID;//所属账本ID
    private String IEType;//收支类型：支出、收入
    private LocalDateTime IETime;// 收支时间
    private Double Amount;//收支金额
    private String Category;//收支分类
    private String Remark;//备注

    public Integer getIEID() {
        return IEID;
    }

    public void setIEID(Integer IEID) {
        this.IEID = IEID;
    }

    public Integer getAccountBookID() {
        return AccountBookID;
    }

    public void setAccountBookID(Integer accountBookID) {
        AccountBookID = accountBookID;
    }

    public String getIEType() {
        return IEType;
    }

    public void setIEType(String IEType) {
        this.IEType = IEType;
    }

    public LocalDateTime getIETime() {
        return IETime;
    }

    public void setIETime(LocalDateTime IETime) {
        this.IETime = IETime;
    }

    public Double getAmount() {
        return Amount;
    }

    public void setAmount(Double amount) {
        Amount = amount;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String remark) {
        Remark = remark;
    }
}
