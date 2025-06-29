package com.hhplus.board.domain

import com.hhplus.board.db.UserEntity

data class UserSignIn(
    val username: String,
    val password: String
) {
    fun toUserEntity(): UserEntity {
        return UserEntity.create(
            username = username,
            password = password
        )
    }

}
