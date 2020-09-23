package com.example.demo1.dao.test.model;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author shaoyayu
 * @date 2020/9/22
 * @E_Mail
 * @Version 1.0.0
 * @readme ：
 */
@Entity
@Table(name = "use_server", schema = "test", catalog = "")
@IdClass(UseServerPK.class)
public class UseServer {
    private String userEmail;
    private String appName;
    private int permissionLevel;

    @Id
    @Column(name = "user_email")
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Id
    @Column(name = "app_name")
    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    @Basic
    @Column(name = "permission_level")
    public int getPermissionLevel() {
        return permissionLevel;
    }

    public void setPermissionLevel(int permissionLevel) {
        this.permissionLevel = permissionLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UseServer useServer = (UseServer) o;
        return permissionLevel == useServer.permissionLevel &&
                Objects.equals(userEmail, useServer.userEmail) &&
                Objects.equals(appName, useServer.appName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userEmail, appName, permissionLevel);
    }
}
