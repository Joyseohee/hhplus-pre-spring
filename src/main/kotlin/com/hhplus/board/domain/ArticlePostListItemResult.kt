package com.hhplus.board.domain

import com.hhplus.board.db.ArticleEntity
import java.time.Instant

data class ArticlePostListItemResult(
    val title: String,
    val author: String,
    val content: String? = null,
    val createdAt: Instant,
) {
    companion object {
        fun fromArticles(article: ArticleEntity): ArticlePostListItemResult {
            return ArticlePostListItemResult(article.getTitle(), article.getAuthor(), article.getContent(), article.createdAt)
        }
    }

}
