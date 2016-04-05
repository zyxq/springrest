package com.chenqiang.springrest.dao;

import com.chenqiang.springrest.domain.UserInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by chenqiang on 16-4-5.
 */
public class jdbcUserInfoDao implements UserInfoDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public UserInfo getUserInfoByMobileNo(String mobileNo) {
        String sql = "SELECT `ui_id`, `mobile_no`, `password`," +
                " `nick_name`, `portrait`, `create_time`, `last_update_time`, `last_login_time`," +
                " `sex`, `birthday`, `useragent`, `imei`, `idfv`, `sig`, `sig_date`, `version` FROM `USER_INFO` WHERE `mobile_no`=?";
        return jdbcTemplate.queryForObject(sql, new RowMapper<UserInfo>() {
            @Override
            public UserInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
                UserInfo userInfo = new UserInfo();
                userInfo.setNickName(rs.getString("nick_name"));
                userInfo.setPortrait(rs.getString("portrait"));
                userInfo.setMobileNo(rs.getString("mobile_no"));
                userInfo.setCreateTime(rs.getDate("create_time"));
                return userInfo;
            }
        }, mobileNo);
    }
}
