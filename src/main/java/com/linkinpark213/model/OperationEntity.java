package com.linkinpark213.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by ooo on 2017/5/10 0010.
 */
@Entity
@Table(name = "operation", schema = "rbac", catalog = "")
public class OperationEntity {
    private int id;
    private Integer type;
    private Collection<PermissionEntity> permissionsById;
    public static final int EDIT = 1;
    public static final int READ = 2;
    public static final int COMMENT = 3;

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
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OperationEntity that = (OperationEntity) o;

        if (id != that.id) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "operationByOperationId")
    public Collection<PermissionEntity> getPermissionsById() {
        return permissionsById;
    }

    public void setPermissionsById(Collection<PermissionEntity> permissionsById) {
        this.permissionsById = permissionsById;
    }
}
