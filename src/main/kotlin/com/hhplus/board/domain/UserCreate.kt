package com.hhplus.board.domain

import com.hhplus.board.db.UserEntity

data class UserCreate(
    val username: String,
    val password: String,
) {
    fun toUserEntity(): UserEntity   {
        return UserEntity.create(username, password)
    }

}
