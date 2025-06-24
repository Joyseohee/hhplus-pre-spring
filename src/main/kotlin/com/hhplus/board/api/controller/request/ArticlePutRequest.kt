package com.hhplus.board.api.controller.request

import com.hhplus.board.domain.ArticlePut

data class ArticlePutRequest(
    val title: String? = null,
    val author: String? = null,
    val content: String? = null,
    val password: String,
) {
    fun toArticlePut(id: Long): ArticlePut {
        return ArticlePut(id, title, author, content, password)
    }
}
