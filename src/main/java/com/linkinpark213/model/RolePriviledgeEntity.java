package com.linkinpark213.model;

import javax.persistence.*;

/**
 * Created by ooo on 2017/5/8 0008.
 */
@Entity
@Table(name = "role_priviledge", schema = "rbac", catalog = "")
public class RolePriviledgeEntity {
    private int id;
    private RoleEntity roleByRoleid;
    private PriviledgeEntity priviledgeByPriviledgeid;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RolePriviledgeEntity that = (RolePriviledgeEntity) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @ManyToOne
    @JoinColumn(name = "roleid", referencedColumnName = "id", nullable = false)
    public RoleEntity getRoleByRoleid() {
        return roleByRoleid;
    }

    public void setRoleByRoleid(RoleEntity roleByRoleid) {
        this.roleByRoleid = roleByRoleid;
    }

    @ManyToOne
    @JoinColumn(name = "priviledgeid", referencedColumnName = "id", nullable = false)
    public PriviledgeEntity getPriviledgeByPriviledgeid() {
        return priviledgeByPriviledgeid;
    }

    public void setPriviledgeByPriviledgeid(PriviledgeEntity priviledgeByPriviledgeid) {
        this.priviledgeByPriviledgeid = priviledgeByPriviledgeid;
    }
}
