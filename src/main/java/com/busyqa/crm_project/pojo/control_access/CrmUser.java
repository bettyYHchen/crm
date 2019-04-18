package com.busyqa.crm_project.pojo.control_access;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "CrmUser")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CrmUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private long id;

    private String userName;
    private String password;
    private String role;

    public CrmUser() {
    }

    public CrmUser(String userName, String userPwd) {
        this.userName = userName;
        this.password = userPwd;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
