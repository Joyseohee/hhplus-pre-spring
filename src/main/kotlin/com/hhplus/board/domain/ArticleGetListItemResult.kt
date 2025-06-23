package com.hhplus.board.domain

import com.hhplus.board.db.ArticleEntity
import java.time.Instant

class ArticleGetListItemResult(
    var title: String? = null,
    var author: String? = null,
    var content: String? = null,
    var createdAt: Instant? = null,
) {
    companion object {
        fun fromArticleEntity(article: ArticleEntity): ArticleGetListItemResult {
            return ArticleGetListItemResult(article.title, article.author, article.content, article.createdAt)
        }

        fun fromArticleEntityList(articles: List<ArticleEntity>): List<ArticleGetListItemResult> {
            return articles.map { fromArticleEntity(it) }
        }
    }

}
