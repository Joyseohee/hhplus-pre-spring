package com.hhplus.board.api.controller.request

import com.hhplus.board.domain.UserSignIn

data class UserSignInRequest(
    val username: String,
    val password: String
) {
    fun toUserSignIn(): UserSignIn {
        return UserSignIn(
            username = username,
            password = password
        )
    }

}
