package com.lm.springsecurity.model;

import javax.persistence.*;

/**
 * @author lm
 * @description TODO
 * @date 2020/4/7 9:37
 */
@Entity
@Table(name = "role_info")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String roleName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
