package com.chenqiang.springrest.domain;

import java.util.Date;

/**
 * Created by chenqiang on 16-4-5.
 */
public class UserInfo {
    private String mobileNo;
    private String nickName;                 // 昵称
    private String portrait;         // 头像
    private Date createTime;       // 创建时间

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
