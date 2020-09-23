package com.example.demo1.dao.test.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

/**
 * @author shaoyayu
 * @date 2020/9/22
 * @E_Mail
 * @Version 1.0.0
 * @readme ：
 */
@Entity
@Table(name = "use_users", schema = "test", catalog = "")
public class UseUsers {
    private String email;
    private String name;
    private String nickname;
    private Integer sex;
    private Date birthday;
    private String avatarAddress;
    private String synopsis;
    private Integer logout;

    @Id
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "nickname")
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Basic
    @Column(name = "sex")
    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "birthday")
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Basic
    @Column(name = "avatar_address")
    public String getAvatarAddress() {
        return avatarAddress;
    }

    public void setAvatarAddress(String avatarAddress) {
        this.avatarAddress = avatarAddress;
    }

    @Basic
    @Column(name = "synopsis")
    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    @Basic
    @Column(name = "logout")
    public Integer getLogout() {
        return logout;
    }

    public void setLogout(Integer logout) {
        this.logout = logout;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UseUsers useUsers = (UseUsers) o;
        return Objects.equals(email, useUsers.email) &&
                Objects.equals(name, useUsers.name) &&
                Objects.equals(nickname, useUsers.nickname) &&
                Objects.equals(sex, useUsers.sex) &&
                Objects.equals(birthday, useUsers.birthday) &&
                Objects.equals(avatarAddress, useUsers.avatarAddress) &&
                Objects.equals(synopsis, useUsers.synopsis) &&
                Objects.equals(logout, useUsers.logout);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, name, nickname, sex, birthday, avatarAddress, synopsis, logout);
    }
}
