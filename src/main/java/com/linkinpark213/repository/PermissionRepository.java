package com.linkinpark213.repository;

import com.linkinpark213.model.ArticleEntity;
import com.linkinpark213.model.OperationEntity;
import com.linkinpark213.model.PermissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ooo on 2017/5/10 0010.
 */
public interface PermissionRepository extends JpaRepository<PermissionEntity, Integer> {
    public PermissionEntity findByArticleIdAndOperationId(int articleId, int operationId);
}
