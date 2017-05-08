package com.linkinpark213.repository;

import com.linkinpark213.model.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ooo on 2017/5/8 0008.
 */
@Repository
public interface ArticleRepository extends JpaRepository<ArticleEntity, Integer> {
}
