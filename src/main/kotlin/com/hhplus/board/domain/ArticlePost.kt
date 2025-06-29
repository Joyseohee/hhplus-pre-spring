package com.hhplus.board.domain

import com.hhplus.board.db.ArticleEntity
import com.hhplus.board.db.UserEntity

data class ArticlePost(
    val title: String,
    val authorId: Long,
    val content: String? = null,
) {
    fun toArticleEntity(articleAuthor: UserEntity): ArticleEntity {
        return ArticleEntity.create(title, articleAuthor, content)
    }
}
