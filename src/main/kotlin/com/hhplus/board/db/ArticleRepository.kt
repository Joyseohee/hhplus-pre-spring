package com.hhplus.board.db

import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import java.lang.Long

interface ArticleRepository : JpaRepository<ArticleEntity, Long> {
    fun findByIdLessThan(id: Long, pageable: Pageable): List<ArticleEntity>
}
