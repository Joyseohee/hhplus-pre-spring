package com.hhplus.board.security

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.util.*
import javax.crypto.SecretKey

@Component
class JwtTokenProvider(
    @Value("\${jwt.secret-key}")
    key: String,
) {
    private val secretKey: SecretKey = Keys.hmacShaKeyFor(key.toByteArray(Charsets.UTF_8))
    private val validityInMs: Long = 3600000L // 기본값 1시간

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
            getClaims(token)  // 파싱 성공하면 유효
            true
        } catch (e: Exception) {
            false
        }
    }

    fun getUserId(token: String): Long =
        getClaims(token).subject.toLong()

    fun getUsername(token: String): String =
        getClaims(token)["username"].toString()

    private fun getClaims(token: String) =
        Jwts.parserBuilder()
            .setSigningKey(secretKey)
            .build()
            .parseClaimsJws(token)
            .body
}
