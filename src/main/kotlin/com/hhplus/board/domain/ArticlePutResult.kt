package com.hhplus.board.domain

import com.hhplus.board.api.controller.reponse.ArticlePutResponseDto
import com.hhplus.board.db.ArticleEntity

data class ArticlePutResult(
    val id: Long,
    val title: String,
    val author: String,
    val content: String? = null,
) {
    fun toArticlePutResponseDto(): ArticlePutResponseDto {
        return ArticlePutResponseDto(id, title, author, content)
    }

    companion object {
        fun fromArticleEntity(entity: ArticleEntity) = ArticlePutResult(
            id = entity.id!!,
            title = entity.currentTitle,
            author = entity.currentAuthor.userName,
            content = entity.currentContent
        )
    }
}
