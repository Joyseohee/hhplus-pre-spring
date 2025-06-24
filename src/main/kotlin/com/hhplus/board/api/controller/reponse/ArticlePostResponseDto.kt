package com.hhplus.board.api.controller.reponse

data class ArticlePostResponseDto(
    val id: Long,
    val title: String,
    val author: String,
    val content: String?,
) {

}
