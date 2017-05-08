package com.linkinpark213.model;

import javax.persistence.*;

/**
 * Created by ooo on 2017/5/8 0008.
 */
@Entity
@Table(name = "role_privilege", schema = "rbac", catalog = "")
public class RolePrivilegeEntity {
    private int id;
    private RoleEntity roleByRoleid;
    private PrivilegeEntity privilegeByPriviledgeid;

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

        RolePrivilegeEntity that = (RolePrivilegeEntity) o;

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
    @JoinColumn(name = "privilegeid", referencedColumnName = "id", nullable = false)
    public PrivilegeEntity getPriviledgeByPriviledgeid() {
        return privilegeByPriviledgeid;
    }

    public void setPriviledgeByPriviledgeid(PrivilegeEntity privilegeByPriviledgeid) {
        this.privilegeByPriviledgeid = privilegeByPriviledgeid;
    }
}
