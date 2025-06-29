package com.hhplus.board.domain

import com.hhplus.board.api.controller.reponse.ArticlePostResponseDto
import com.hhplus.board.db.ArticleEntity

data class ArticlePostResult(
    val id: Long,
    val title: String,
    val author: String,
    val content: String? = null,
) {
    fun toArticlePostResponseDto(): ArticlePostResponseDto {
        return ArticlePostResponseDto(id, title, author, content)
    }

    companion object {
        fun fromArticleEntity(entity: ArticleEntity) = ArticlePostResult(
            id = entity.id!!,
            title = entity.currentTitle,
            author = entity.currentAuthor.userName,
            content = entity.currentContent
        )
    }
}
