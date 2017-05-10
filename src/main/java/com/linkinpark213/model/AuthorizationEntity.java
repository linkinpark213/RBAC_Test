package com.linkinpark213.model;

import javax.persistence.*;

/**
 * Created by ooo on 2017/5/10 0010.
 */
@Entity
@Table(name = "authorization", schema = "rbac")
public class AuthorizationEntity {
    private int id;
    private int roleId;
    private int permissionId;
    private RoleEntity roleByRoleId;
    private PermissionEntity permissionByPermissionId;

    public AuthorizationEntity() {
    }

    public AuthorizationEntity(int roleId, int permissionId) {
        this.roleId = roleId;
        this.permissionId = permissionId;
    }
    @Basic
    @Column(name = "role_id")
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "permission_id")
    public int getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(int permissionId) {
        this.permissionId = permissionId;
    }


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

        if (this.getRoleId() != that.getRoleId())
            return false;
        if (this.getPermissionId() != that.getPermissionId())
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public RoleEntity getRoleByRoleId() {
        return roleByRoleId;
    }

    public void setRoleByRoleId(RoleEntity roleByRoleId) {
        this.roleByRoleId = roleByRoleId;
    }

    @ManyToOne
    @JoinColumn(name = "permission_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public PermissionEntity getPermissionByPermissionId() {
        return permissionByPermissionId;
    }

    public void setPermissionByPermissionId(PermissionEntity permissionByPermissionId) {
        this.permissionByPermissionId = permissionByPermissionId;
    }
}
