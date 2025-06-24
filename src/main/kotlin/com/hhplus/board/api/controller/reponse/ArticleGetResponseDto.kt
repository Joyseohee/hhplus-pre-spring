package com.hhplus.board.api.controller.reponse

import java.time.Instant

data class ArticleGetResponseDto(
    val title: String,
    val author: String,
    val content: String? = null,
    val createdAt: Instant,
) {

}
