package com.example.demo1.dao.users.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @author shaoyayu
 * @date 2020/9/22
 * @E_Mail
 * @Version 1.0.0
 * @readme ：
 */
@Entity
@Data
@Table(name = "use_registry", schema = "test", catalog = "")
public class UseRegistry {
    private String email;
    private String password;
    private Timestamp rTime;
    private Integer canLogin;

    @Id
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "r_time")
    public Timestamp getrTime() {
        return rTime;
    }

    public void setrTime(Timestamp rTime) {
        this.rTime = rTime;
    }

    @Basic
    @Column(name = "can_login")
    public Integer getCanLogin() {
        return canLogin;
    }

    public void setCanLogin(Integer canLogin) {
        this.canLogin = canLogin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UseRegistry that = (UseRegistry) o;
        return Objects.equals(email, that.email) &&
                Objects.equals(password, that.password) &&
                Objects.equals(rTime, that.rTime) &&
                Objects.equals(canLogin, that.canLogin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, password, rTime, canLogin);
    }
}
