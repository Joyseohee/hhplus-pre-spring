package com.hhplus.board.api.controller

import com.hhplus.board.api.controller.reponse.ArticleGetResponseDto
import com.hhplus.board.api.controller.reponse.ArticleListGetResponseDto
import com.hhplus.board.api.controller.reponse.ArticlePostResponseDto
import com.hhplus.board.api.controller.reponse.ArticlePutResponseDto
import com.hhplus.board.api.controller.request.ArticlePostRequest
import com.hhplus.board.api.controller.request.ArticlePutRequest
import com.hhplus.board.domain.ArticleDelete
import com.hhplus.board.domain.ArticleService
import com.hhplus.board.security.CustomUserDetails
import com.hhplus.board.support.error.ApiResponse
import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.*

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
    fun createArticles(@RequestBody request: ArticlePostRequest, authentication: Authentication): ApiResponse<ArticlePostResponseDto> {
        val user = authentication.principal as CustomUserDetails
        val result = articleService.createArticle(request.toArticlePost(user.userId))
        return ApiResponse.success(result.toArticlePostResponseDto())
    }

    @GetMapping("/board/articles/{id}")
    fun getArticles(@PathVariable id: Long): ApiResponse<ArticleGetResponseDto> {
        val result = articleService.getArticle(id)
        return ApiResponse.success(result.toArticleGetResponseDto())
    }

    @PutMapping("/board/articles/{id}")
    fun updateArticles(@RequestBody request: ArticlePutRequest, @PathVariable id: Long, authentication: Authentication): ApiResponse<ArticlePutResponseDto> {
        val user = authentication.principal as CustomUserDetails
        val result = articleService.updateArticle(request.toArticlePut(id, user.userId))
        return ApiResponse.success(result.toArticlePutResponseDto())
    }

    @DeleteMapping("/board/articles/{id}")
    fun deleteArticles(@PathVariable id: Long, authentication: Authentication): ApiResponse<String> {
        val user = authentication.principal as CustomUserDetails
        articleService.deleteArticle(ArticleDelete(id, user.userId))
        return ApiResponse.success("Article deleted successfully")
    }
}
