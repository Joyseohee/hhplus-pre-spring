package com.hhplus.board.api.controller.request

import com.hhplus.board.domain.UserCreate

data class UserCreateRequest(
    val username: String,
    val password: String,
) {
    fun toUserCreate(): UserCreate {
        return UserCreate(username, password)
    }
}
