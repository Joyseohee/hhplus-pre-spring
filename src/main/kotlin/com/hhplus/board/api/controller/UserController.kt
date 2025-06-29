package com.hhplus.board.api.controller

import com.hhplus.board.api.controller.request.UserCreateRequest
import com.hhplus.board.api.controller.request.UserSignInRequest
import com.hhplus.board.domain.UserService
import com.hhplus.board.support.error.ApiResponse
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController()
class UserController(
    val userService: UserService
) {
    @PostMapping("/auth/signup")
    fun signUp(@RequestBody request: UserCreateRequest): ApiResponse<Any> {
        userService.createUser(request.toUserCreate())
        return ApiResponse.success()
    }

    @PostMapping("/auth/signin")
    fun signIn(
        @RequestBody request: UserSignInRequest,
        response: HttpServletResponse
    ): ResponseEntity<ApiResponse<Any>> {
        val result = userService.signIn(request.toUserSignIn())

        response.setHeader("Authorization", "Bearer ${result.token}")

        return ResponseEntity.ok(ApiResponse.success())
    }
}
