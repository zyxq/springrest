package com.chenqiang.springrest.domain;
import java.sql.Date;

/**
 * Created by chenqiang on 16/4/4.
 */
public class AppInfo {
    private String name;
    private String packageName;
    private String install_count_string;
    private long install_count;
    private Date update_time;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getInstall_count_string() {
        return install_count_string;
    }

    public void setInstall_count_string(String install_count_string) {
        this.install_count_string = install_count_string;
    }

    public long getInstall_count() {
        return install_count;
    }

    public void setInstall_count(long install_count) {
        this.install_count = install_count;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    @Override
    public int hashCode() {
        return packageName.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof AppInfo)) {
            return false;
        }

        AppInfo appInfo = (AppInfo)obj;
        return  (appInfo.packageName.equals(packageName));
    }

    @Override
    public String toString() {
        if (update_time != null) {
            return name + "   " + packageName + "  " + install_count_string + "   " + install_count + " " + update_time.toString();
        } else {
            return name + "   " + packageName + "  " + install_count_string + "   " + install_count;
        }
    }
}
