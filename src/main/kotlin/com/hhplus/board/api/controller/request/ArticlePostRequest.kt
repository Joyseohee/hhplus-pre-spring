package com.hhplus.board.api.controller.request

import com.hhplus.board.domain.Article

data class ArticlePostRequest(
    var title: String,
    var author: String,
    var content: String,
    var password: String,
) {
    fun toBoardGetData(): Article {
        return Article(title, author, content, password)
    }
}
