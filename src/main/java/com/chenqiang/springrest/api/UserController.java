package com.chenqiang.springrest.api;

import com.chenqiang.springrest.dao.UserInfoDao;
import com.chenqiang.springrest.domain.UserInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by chenqiang on 16-4-5.
 */
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserInfoDao userInfoDao;

    @RequestMapping("/userInfo")
    public UserInfo getUserInfo(@RequestParam(value = "mobile_no", defaultValue = "18321640141") String mobile_no) {
        UserInfo userInfo = userInfoDao.getUserInfoByMobileNo(mobile_no);
        return userInfo;
    }


}
