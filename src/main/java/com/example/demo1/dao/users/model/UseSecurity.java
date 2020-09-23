package com.example.demo1.dao.users.model;

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
@Table(name = "use_security", schema = "test", catalog = "")
public class UseSecurity {
    private String useEmail;
    private String useCookie;

    @Id
    @Column(name = "use_email")
    public String getUseEmail() {
        return useEmail;
    }

    public void setUseEmail(String useEmail) {
        this.useEmail = useEmail;
    }

    @Basic
    @Column(name = "use_cookie")
    public String getUseCookie() {
        return useCookie;
    }

    public void setUseCookie(String useCookie) {
        this.useCookie = useCookie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UseSecurity that = (UseSecurity) o;
        return Objects.equals(useEmail, that.useEmail) &&
                Objects.equals(useCookie, that.useCookie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(useEmail, useCookie);
    }
}
