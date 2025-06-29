package com.hhplus.board.domain

data class ArticlePut(
    val id: Long,
    val title: String? = null,
    val authorId: Long,
    val content: String? = null,
) {

}
