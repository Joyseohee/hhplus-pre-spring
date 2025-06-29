package com.hhplus.board.api.controller.request

import com.hhplus.board.domain.ArticlePut

data class ArticlePutRequest(
    val title: String? = null,
    val content: String? = null,
) {
    fun toArticlePut(id: Long, authorUserNo: Long): ArticlePut {
        return ArticlePut(id, title, authorUserNo, content)
    }
}
