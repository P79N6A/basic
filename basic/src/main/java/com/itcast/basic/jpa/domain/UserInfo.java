package com.itcast.basic.jpa.domain;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "t_user_info")
public class UserInfo implements Serializable {
    private static final long serialVersionUID = -684143631427714824L;

    @Id
    @GeneratedValue
    private Integer id;

    private String nickName;

    private String constell;

    private boolean isMarried;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    private String liveAddress;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    private String homeAddress;

    @Column(precision = 5, scale = 2)
    private Double height;
    @Column(precision = 5, scale = 2)
    private Double weight;

    private String post;
    /**
     * 教育经历
     */
    private String middleSchool;
    private String highSchool;
    private String college;


    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getConstell() {
        return constell;
    }

    public void setConstell(String constell) {
        this.constell = constell;
    }

    public boolean isMarried() {
        return isMarried;
    }

    public void setMarried(boolean isMarried) {
        this.isMarried = isMarried;
    }

    public String getLiveAddress() {
        return liveAddress;
    }

    public void setLiveAddress(String liveAddress) {
        this.liveAddress = liveAddress;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getMiddleSchool() {
        return middleSchool;
    }

    public void setMiddleSchool(String middleSchool) {
        this.middleSchool = middleSchool;
    }

    public String getHighSchool() {
        return highSchool;
    }

    public void setHighSchool(String highSchool) {
        this.highSchool = highSchool;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", nickName='" + nickName + '\'' +
                ", constell='" + constell + '\'' +
                ", isMarried=" + isMarried +
                ", liveAddress='" + liveAddress + '\'' +
                ", homeAddress='" + homeAddress + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", post='" + post + '\'' +
                ", middleSchool='" + middleSchool + '\'' +
                ", highSchool='" + highSchool + '\'' +
                ", college='" + college + '\'' +
                ", user=" + user +
                '}';
    }
}
