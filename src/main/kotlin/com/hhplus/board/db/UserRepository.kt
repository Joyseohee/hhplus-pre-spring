package com.hhplus.board.db

import org.springframework.data.jpa.repository.JpaRepository
import java.lang.Long

interface UserRepository : JpaRepository<UserEntity, Long> {
}
