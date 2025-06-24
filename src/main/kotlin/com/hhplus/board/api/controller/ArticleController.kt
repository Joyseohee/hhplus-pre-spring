package com.hhplus.board.api.controller

import com.hhplus.board.api.controller.reponse.ArticleGetResponseDto
import com.hhplus.board.api.controller.reponse.ArticleListGetResponseDto
import com.hhplus.board.api.controller.reponse.ArticlePostResponseDto
import com.hhplus.board.api.controller.reponse.ArticlePutResponseDto
import com.hhplus.board.api.controller.request.ArticleDeleteRequest
import com.hhplus.board.api.controller.request.ArticlePostRequest
import com.hhplus.board.api.controller.request.ArticlePutRequest
import com.hhplus.board.domain.ArticleService
import com.hhplus.board.support.error.ApiResponse
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ArticleController(
    val articleService: ArticleService
) {
    @GetMapping("/board/articles")
    fun getArticlesList(): ApiResponse<ArticleListGetResponseDto> {
        val result = articleService.getArticleList()
        return ApiResponse.success(result.toArticleGetResponseDto())
    }

    @PostMapping("/board/articles")
    fun createArticles(@RequestBody request: ArticlePostRequest): ApiResponse<ArticlePostResponseDto> {
        val result = articleService.createArticle(request.toArticlePost())
        return ApiResponse.success(result.toArticlePostResponseDto())
    }

    @GetMapping("/board/articles/{id}")
    fun getArticles(@PathVariable id: Long): ApiResponse<ArticleGetResponseDto> {
        val result = articleService.getArticle(id)
        return ApiResponse.success(result.toArticleGetResponseDto())
    }

    @PutMapping("/board/articles/{id}")
    fun updateArticles(@RequestBody request: ArticlePutRequest, @PathVariable id: Long): ApiResponse<ArticlePutResponseDto> {
        val result = articleService.updateArticle(request.toArticlePut(id))
        return ApiResponse.success(result.toArticlePutResponseDto())
    }

    @DeleteMapping("/board/articles/{id}")
    fun deleteArticles(@RequestBody request: ArticleDeleteRequest, @PathVariable id: Long): ApiResponse<String> {
        articleService.deleteArticle(request.toArticleDelete(id))
        return ApiResponse.success("Article deleted successfully")
    }
}
