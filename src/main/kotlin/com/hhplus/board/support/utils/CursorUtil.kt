package com.hhplus.board.support.utils

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.hhplus.board.domain.Cursor
import java.util.*

object CursorUtil {
    private val objectMapper = jacksonObjectMapper()

    fun encode(cursor: Cursor): String {
        val json = objectMapper.writeValueAsString(cursor)
        return Base64.getUrlEncoder().encodeToString(json.toByteArray())
    }

    fun decode(encoded: String): Cursor {
        val json = String(Base64.getUrlDecoder().decode(encoded))
        return objectMapper.readValue(json, Cursor::class.java)
    }
}
