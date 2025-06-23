package com.hhplus.board.domain

import com.hhplus.board.db.ArticleEntity
import java.time.Instant

class ArticlePostListItemResult(
    var title: String? = null,
    var author: String? = null,
    var content: String? = null,
    var createdAt: Instant? = null,
) {
    companion object {
        fun fromArticles(article: ArticleEntity): ArticlePostListItemResult {
            return ArticlePostListItemResult(article.title, article.author, article.content, article.createdAt)
        }
    }

}
