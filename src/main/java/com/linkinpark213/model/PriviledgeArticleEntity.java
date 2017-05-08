package com.linkinpark213.model;

import javax.persistence.*;

/**
 * Created by ooo on 2017/5/8 0008.
 */
@Entity
@Table(name = "priviledge_article", schema = "rbac", catalog = "")
public class PriviledgeArticleEntity {
    private int id;
    private PriviledgeEntity priviledgeByPriviledgeid;
    private ArticleEntity articleByArticleid;

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

        PriviledgeArticleEntity that = (PriviledgeArticleEntity) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @ManyToOne
    @JoinColumn(name = "priviledgeid", referencedColumnName = "id", nullable = false)
    public PriviledgeEntity getPriviledgeByPriviledgeid() {
        return priviledgeByPriviledgeid;
    }

    public void setPriviledgeByPriviledgeid(PriviledgeEntity priviledgeByPriviledgeid) {
        this.priviledgeByPriviledgeid = priviledgeByPriviledgeid;
    }

    @ManyToOne
    @JoinColumn(name = "articleid", referencedColumnName = "id", nullable = false)
    public ArticleEntity getArticleByArticleid() {
        return articleByArticleid;
    }

    public void setArticleByArticleid(ArticleEntity articleByArticleid) {
        this.articleByArticleid = articleByArticleid;
    }
}
