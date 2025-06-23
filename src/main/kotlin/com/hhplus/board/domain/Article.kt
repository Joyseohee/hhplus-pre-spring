package com.hhplus.board.domain

import java.time.Instant

data class Article(
    var title: String? = null,
    var author: String? = null,
    var content: String? = null,
    var createdAt: Instant? = null,
//    var cursor: String? = null,
) {

}
