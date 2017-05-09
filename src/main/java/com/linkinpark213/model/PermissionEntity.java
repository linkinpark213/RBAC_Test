package com.linkinpark213.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by ooo on 2017/5/10 0010.
 */
@Entity
@Table(name = "permission", schema = "rbac", catalog = "")
public class PermissionEntity {
    private int id;
    private Collection<AuthorizationEntity> authorizationsById;
    private ArticleEntity articleByArticleId;
    private OperationEntity operationByOperationId;

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

        PermissionEntity that = (PermissionEntity) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @OneToMany(mappedBy = "permissionByPermissionId")
    public Collection<AuthorizationEntity> getAuthorizationsById() {
        return authorizationsById;
    }

    public void setAuthorizationsById(Collection<AuthorizationEntity> authorizationsById) {
        this.authorizationsById = authorizationsById;
    }

    @ManyToOne
    @JoinColumn(name = "article_id", referencedColumnName = "id", nullable = false)
    public ArticleEntity getArticleByArticleId() {
        return articleByArticleId;
    }

    public void setArticleByArticleId(ArticleEntity articleByArticleId) {
        this.articleByArticleId = articleByArticleId;
    }

    @ManyToOne
    @JoinColumn(name = "operation_id", referencedColumnName = "id", nullable = false)
    public OperationEntity getOperationByOperationId() {
        return operationByOperationId;
    }

    public void setOperationByOperationId(OperationEntity operationByOperationId) {
        this.operationByOperationId = operationByOperationId;
    }
}
