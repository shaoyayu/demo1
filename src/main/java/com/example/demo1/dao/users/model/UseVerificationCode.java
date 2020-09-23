package com.example.demo1.dao.users.model;

import javax.persistence.*;
import java.sql.Time;
import java.util.Objects;

/**
 * @author shaoyayu
 * @date 2020/9/22
 * @E_Mail
 * @Version 1.0.0
 * @readme ：
 */
@Entity
@Table(name = "use_verification_code", schema = "test", catalog = "")
public class UseVerificationCode {
    private String userEmail;
    private String code;
    private Time staTime;
    private int validTime;

    @Id
    @Column(name = "user_email")
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Basic
    @Column(name = "code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "sta_time")
    public Time getStaTime() {
        return staTime;
    }

    public void setStaTime(Time staTime) {
        this.staTime = staTime;
    }

    @Basic
    @Column(name = "valid_time")
    public int getValidTime() {
        return validTime;
    }

    public void setValidTime(int validTime) {
        this.validTime = validTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UseVerificationCode that = (UseVerificationCode) o;
        return validTime == that.validTime &&
                Objects.equals(userEmail, that.userEmail) &&
                Objects.equals(code, that.code) &&
                Objects.equals(staTime, that.staTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userEmail, code, staTime, validTime);
    }
}
