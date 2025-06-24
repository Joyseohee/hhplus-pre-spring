package com.hhplus.board.domain

data class ArticlePut(
    val id: Long,
    val title: String? = null,
    val author: String? = null,
    val content: String? = null,
    val password: String,
) {

}
