package com.hhplus.board.db

import org.springframework.data.jpa.repository.JpaRepository

interface ArticleRepository : JpaRepository<ArticleEntity, Long> {
    fun findByIdAndAuthorId(articleId: Long, userId: Long): ArticleEntity?
}
