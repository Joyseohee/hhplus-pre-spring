package com.hhplus.board.api.controller.reponse

import com.hhplus.board.domain.ArticleGetListItemResult

data class ArticleListGetResponseDto(
    val list: List<ArticleGetListItemResult>
) {

}
