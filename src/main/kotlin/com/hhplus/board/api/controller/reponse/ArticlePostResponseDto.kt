package com.hhplus.board.api.controller.reponse

import com.hhplus.board.domain.ArticleGetListItemResult
import com.hhplus.board.domain.ArticleGetMetaResult

data class ArticlePostResponseDto(
    var meta: ArticleGetMetaResult,
    val list: List<ArticleGetListItemResult>,
) {

}
