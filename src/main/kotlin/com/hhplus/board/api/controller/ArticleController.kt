package com.hhplus.board.api.controller

import com.hhplus.board.api.controller.reponse.ArticleGetResponseDto
import com.hhplus.board.api.controller.reponse.ArticlePostResponseDto
import com.hhplus.board.api.controller.request.ArticleGetRequest
import com.hhplus.board.domain.ArticleService
import com.hhplus.board.support.error.ApiResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ArticleController(
    val articleService: ArticleService
) {
    @GetMapping("/board/post")
    fun getPost(@ModelAttribute request: ArticleGetRequest): ApiResponse<ArticleGetResponseDto> {
        val result = articleService.getArticles(request.toArticle(), request.toMeta())
        return ApiResponse.success(result.toPostGetResponseDto())
    }

    @PostMapping("/board/post")
    fun createPost(): ApiResponse<ArticlePostResponseDto> {
        val result = articleService.createArticle()
        return ApiResponse.error(result.toPostGetResponseDto())
    }
}
