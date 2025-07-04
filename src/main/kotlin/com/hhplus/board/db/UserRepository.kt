package com.hhplus.board.db

import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<UserEntity, Long> {
    fun existsByUsername(username: String): Boolean {
        return findByUsername(username) != null
    }

    fun findByUsername(username: String): UserEntity?
}
