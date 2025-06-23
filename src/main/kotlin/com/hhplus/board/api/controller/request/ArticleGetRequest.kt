package com.hhplus.board.api.controller.request

import com.hhplus.board.domain.Article
import com.hhplus.board.domain.ArticleGetMeta
import java.time.Instant

data class ArticleGetRequest(
    var title: String? = null,
    var author: String? = null,
    var content: String? = null,
    var createdAt: Instant? = null,
    var cursor: String? = null,
    var size: Int? = null,
) {
    fun toArticle(): Article {
        return Article(title, author, content, createdAt)
    }
    fun toMeta(): ArticleGetMeta {
        return ArticleGetMeta(cursor, size)
    }
}
