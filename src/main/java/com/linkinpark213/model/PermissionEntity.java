package com.linkinpark213.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by ooo on 2017/5/10 0010.
 */
@Entity
@Table(name = "permission", schema = "rbac")
public class PermissionEntity {
    private int id;
    private int articleId;
    private int operationId;
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

    @Basic
    @Column(name = "article_id")
    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    @Basic
    @Column(name = "operation_id")
    public int getOperationId() {
        return operationId;
    }

    public void setOperationId(int operationId) {
        this.operationId = operationId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PermissionEntity that = (PermissionEntity) o;

        if (this.getArticleId() != that.getArticleId())
            return false;
        if (this.getOperationId() != that.getOperationId())
            return false;

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
    @JoinColumn(name = "article_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public ArticleEntity getArticleByArticleId() {
        return articleByArticleId;
    }

    public void setArticleByArticleId(ArticleEntity articleByArticleId) {
        this.articleByArticleId = articleByArticleId;
    }

    @ManyToOne
    @JoinColumn(name = "operation_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public OperationEntity getOperationByOperationId() {
        return operationByOperationId;
    }

    public void setOperationByOperationId(OperationEntity operationByOperationId) {
        this.operationByOperationId = operationByOperationId;
    }
}
