package com.linkinpark213.repository;

import com.linkinpark213.model.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ooo on 2017/5/10 0010.
 */
@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Integer> {
    public List<CommentEntity> findByArticleId(int articleId);
}
