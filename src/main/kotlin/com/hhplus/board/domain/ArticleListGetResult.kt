package com.hhplus.board.domain

import com.hhplus.board.api.controller.reponse.ArticleListGetResponseDto

data class ArticleListGetResult(
    val list: List<ArticleGetListItemResult>,
    ) {

    fun toArticleGetResponseDto(): ArticleListGetResponseDto {
        return ArticleListGetResponseDto(list)
    }
}
