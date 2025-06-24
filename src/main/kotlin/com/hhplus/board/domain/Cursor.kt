package com.hhplus.board.domain

import java.time.Instant

data class Cursor(
    val createdAt: Instant,
    val id: Long
)
