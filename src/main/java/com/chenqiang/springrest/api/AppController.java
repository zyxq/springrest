package com.chenqiang.springrest.api;

import com.chenqiang.springrest.domain.AppInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by chenqiang on 16/4/4.
 */
@RestController
@RequestMapping("/api")
public class AppController {

    @Autowired
    private DataSource dataSource;

    @RequestMapping("/appinfo")
    public AppInfo getAppInfo(@RequestParam(value="packageName", defaultValue="ctrip.android.view") String packageName) {
        AppInfo appInfo = getAppInfoByPackageName(packageName);
        return appInfo;
    }

    private AppInfo getAppInfoByPackageName(String packageName) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = dataSource.getConnection();
            String sql = "select name, packagename, install_count_string,install_count, update_time from app where packagename=?";

            statement = connection.prepareStatement(sql);
            statement.setString(1, packageName);

            resultSet = statement.executeQuery();

            AppInfo appInfo = null;
            if (resultSet.next()) {
                appInfo = new AppInfo();
                appInfo.setName(resultSet.getString("name"));
                appInfo.setInstall_count_string(resultSet.getString("install_count_string"));
                appInfo.setInstall_count(resultSet.getLong("install_count"));
                appInfo.setUpdate_time(resultSet.getDate("update_time"));
                appInfo.setPackageName(resultSet.getString("packagename"));
            }
            return appInfo;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
