package com.hhplus.board.domain

import com.hhplus.board.db.ArticleEntity

data class ArticlePost(
    val title: String,
    val author: String,
    val content: String? = null,
    val password: String,
) {
    fun toArticleEntity(): ArticleEntity {
        return ArticleEntity(title, author, content, password)
    }
}
