package com.hhplus.board.api.controller.request

import com.hhplus.board.domain.Article
import java.time.Instant

data class ArticleListGetRequest(
    val title: String? = null,
    val author: String? = null,
    val content: String? = null,
    val createdAt: Instant? = null,
) {
    fun toArticle(): Article {
        return Article(title, author, content, createdAt)
    }
}
