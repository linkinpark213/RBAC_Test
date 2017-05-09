package com.linkinpark213.model;

import javax.persistence.*;

/**
 * Created by ooo on 2017/5/10 0010.
 */
@Entity
@Table(name = "authorization", schema = "rbac", catalog = "")
public class AuthorizationEntity {
    private int id;
    private RoleEntity roleByRoleId;
    private PermissionEntity permissionByPermissionId;

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

        AuthorizationEntity that = (AuthorizationEntity) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false)
    public RoleEntity getRoleByRoleId() {
        return roleByRoleId;
    }

    public void setRoleByRoleId(RoleEntity roleByRoleId) {
        this.roleByRoleId = roleByRoleId;
    }

    @ManyToOne
    @JoinColumn(name = "permission_id", referencedColumnName = "id", nullable = false)
    public PermissionEntity getPermissionByPermissionId() {
        return permissionByPermissionId;
    }

    public void setPermissionByPermissionId(PermissionEntity permissionByPermissionId) {
        this.permissionByPermissionId = permissionByPermissionId;
    }
}
