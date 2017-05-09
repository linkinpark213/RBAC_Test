package com.linkinpark213.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by ooo on 2017/5/10 0010.
 */
@Entity
@Table(name = "role", schema = "rbac", catalog = "")
public class RoleEntity {
    private int id;
    private String name;
    private Collection<AuthorizationEntity> authorizationsById;
    private Collection<UserEntity> usersById;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoleEntity that = (RoleEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "roleByRoleId")
    public Collection<AuthorizationEntity> getAuthorizationsById() {
        return authorizationsById;
    }

    public void setAuthorizationsById(Collection<AuthorizationEntity> authorizationsById) {
        this.authorizationsById = authorizationsById;
    }

    @OneToMany(mappedBy = "roleByRoleId")
    public Collection<UserEntity> getUsersById() {
        return usersById;
    }

    public void setUsersById(Collection<UserEntity> usersById) {
        this.usersById = usersById;
    }
}
