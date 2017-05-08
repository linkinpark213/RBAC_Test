package com.linkinpark213.model;

import javax.persistence.*;

/**
 * Created by ooo on 2017/5/8 0008.
 */
@Entity
@Table(name = "role", schema = "rbac", catalog = "")
public class RoleEntity {
    private int id;
    private int type;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "type")
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoleEntity that = (RoleEntity) o;

        if (id != that.id) return false;
        if (type != that.type) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + type;
        return result;
    }
}
