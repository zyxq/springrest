package com.chenqiang.springrest.dao;

import com.chenqiang.springrest.domain.UserInfo;

/**
 * Created by chenqiang on 16-4-5.
 */
public interface UserInfoDao {
    UserInfo getUserInfoByMobileNo(String mobileNo);
}
