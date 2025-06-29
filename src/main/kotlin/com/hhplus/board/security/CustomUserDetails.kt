package com.hhplus.board.security

import java.io.Serializable

data class CustomUserDetails(
    val userId: Long,
    val username: String
) : Serializable
