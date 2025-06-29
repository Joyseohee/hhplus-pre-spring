package com.hhplus.board.support.utils

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import org.springframework.stereotype.Component
import java.util.Date
import javax.crypto.SecretKey

@Component
class JwtTokenProvider {
    private val secretKey: SecretKey = Keys.hmacShaKeyFor("secret_key".toByteArray())
    private val validityInMs: Long = 3_600_000 // 1시간

    fun createToken(userId: Long, username: String): String {
        val claims = Jwts.claims().setSubject(userId.toString())
        claims["username"] = username

        val now = Date()
        val validity = Date(now.time + validityInMs)

        return Jwts.builder()
            .setClaims(claims)
            .setIssuedAt(now)
            .setExpiration(validity)
            .signWith(secretKey, SignatureAlgorithm.HS256)
            .compact()
    }

    fun validateToken(token: String): Boolean {
        return try {
            Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
            true
        } catch (e: Exception) {
            false
        }
    }

    fun getUsername(token: String): String? {
        return try {
            val claims = Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .body
            claims["username"] as String?
        } catch (e: Exception) {
            null
        }
    }
}
