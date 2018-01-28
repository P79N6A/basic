package com.itcast.basic.jpa.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by qfl on 16/6/10.
 */
@Entity
@Table(name = "t_work_experiences")
public class WorkExperience {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "company_name", nullable = false)
    private String companeName;

    @Column(name = "enter_at")
    @Temporal(TemporalType.DATE)
    private Date enterAt;

    @Column(name = "leave_at")
    @Temporal(TemporalType.DATE)
    private Date leaveAt;

    private BigDecimal salary;

    @ManyToMany
    @JoinTable(name = "user_to_work", inverseJoinColumns = @JoinColumn(name = "work_experience_id", referencedColumnName = "id"), joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"))
    private List<User> users;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompaneName() {
        return companeName;
    }

    public void setCompaneName(String companeName) {
        this.companeName = companeName;
    }

    public Date getEnterAt() {
        return enterAt;
    }

    public void setEnterAt(Date enterAt) {
        this.enterAt = enterAt;
    }

    public Date getLeaveAt() {
        return leaveAt;
    }

    public void setLeaveAt(Date leaveAt) {
        this.leaveAt = leaveAt;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
