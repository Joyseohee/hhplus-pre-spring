package com.hhplus.board.api.controller.request

import com.hhplus.board.domain.ArticlePost

data class ArticlePostRequest(
    val title: String,
    val content: String? = null,
) {
    fun toArticlePost(authorUserNo: Long): ArticlePost {
        return ArticlePost(title, authorUserNo, content)
    }
}
