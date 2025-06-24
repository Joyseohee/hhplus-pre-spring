package com.hhplus.board.domain

import com.hhplus.board.api.controller.reponse.ArticleGetResponseDto
import com.hhplus.board.api.controller.reponse.ArticleListGetResponseDto
import com.hhplus.board.db.ArticleEntity
import java.time.Instant

data class ArticleGetListItemResult(
    val title: String,
    val author: String,
    val content: String? = null,
    val createdAt: Instant,
) {
    companion object {
        fun fromArticleEntity(article: ArticleEntity): ArticleGetListItemResult {
            return ArticleGetListItemResult(article.getTitle(), article.getAuthor(), article.getContent(), article.createdAt)
        }

        fun fromArticleEntityList(articles: List<ArticleEntity>): List<ArticleGetListItemResult> {
            return articles.map { fromArticleEntity(it) }
        }
    }

    fun toArticleGetResponseDto(): ArticleGetResponseDto {
        return ArticleGetResponseDto(title, author, content, createdAt)
    }
}
