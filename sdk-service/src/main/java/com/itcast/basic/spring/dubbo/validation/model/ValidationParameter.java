package com.itcast.basic.spring.dubbo.validation.model;

import com.itcast.basic.spring.dubbo.validation.service.ValidationService;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;

public class ValidationParameter implements Serializable {
    private static final long serialVersionUID = 7158911668568000392L;

    private int id;

    @NotNull(groups = ValidationService.Save.class, message = "名字不能为空") // 不允许为空
    @Size(min = 1, max = 20, message = "name长度必须在1到20个字符之间") // ⻓度或⼤⼩范围
    private String name;

    @NotNull(groups = ValidationService.Save.class, message = "邮箱不能为空") // 保存时不允许为空，更新时允许为空 ，表示不更新该字段
    @Pattern(message = "邮箱格式不合法", groups = ValidationService.Save.class, regexp = "^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$")
    private String email;

    @Past(groups = ValidationService.Save.class, message = "登录时间必须小于当前时间") // 必须为⼀个过去的时间
    private Date loginDate;

    @Future(groups = ValidationService.Save.class, message = "过期时间必须大于当前时间") // 必须为⼀个未来的时间
    private Date expiryDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return "ValidationParameter{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", loginDate=" + loginDate +
                ", expiryDate=" + expiryDate +
                '}';
    }
}
