package com.hhplus.board.api.controller.request

import com.hhplus.board.domain.ArticlePost

data class ArticlePostRequest(
    val title: String,
    val author: String,
    val content: String? = null,
    val password: String,
) {
    fun toArticlePost(): ArticlePost {
        return ArticlePost(title, author, content, password)
    }
}
