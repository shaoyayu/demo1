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
@Table(name = "app_server", schema = "test", catalog = "")
@IdClass(AppServerPK.class)
public class AppServer {
    private String name;
    private String nickname;
    private String synopsis;
    private String address;
    private String callback;
    private int status;
    private String clientId;
    private String secretKey;

    @Id
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
    @Column(name = "synopsis")
    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Id
    @Column(name = "callback")
    public String getCallback() {
        return callback;
    }

    public void setCallback(String callback) {
        this.callback = callback;
    }

    @Basic
    @Column(name = "status")
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Id
    @Column(name = "client_id")
    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    @Id
    @Column(name = "secret_key")
    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppServer appServer = (AppServer) o;
        return status == appServer.status &&
                Objects.equals(name, appServer.name) &&
                Objects.equals(nickname, appServer.nickname) &&
                Objects.equals(synopsis, appServer.synopsis) &&
                Objects.equals(address, appServer.address) &&
                Objects.equals(callback, appServer.callback) &&
                Objects.equals(clientId, appServer.clientId) &&
                Objects.equals(secretKey, appServer.secretKey);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, nickname, synopsis, address, callback, status, clientId, secretKey);
    }
}
