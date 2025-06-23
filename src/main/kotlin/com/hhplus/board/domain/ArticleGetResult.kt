package com.hhplus.board.domain

import com.hhplus.board.api.controller.reponse.ArticleGetResponseDto

data class ArticleGetResult(
    var meta: ArticleGetMetaResult,
    var list: List<ArticleGetListItemResult>,
    ) {

    fun toArticleGetResponseDto(): ArticleGetResponseDto {
        return ArticleGetResponseDto(meta, list)
    }
}
