package com.hhplus.board.security

import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.filter.OncePerRequestFilter

class JwtAuthenticationFilter(private val jwtTokenProvider: JwtTokenProvider) : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val path = request.requestURI
        if (path.startsWith("/auth")) {  // 🔥 회원가입/로그인 요청은 필터 패스
            filterChain.doFilter(request, response)
            return
        }

        val token = resolveToken(request)
        if (token != null && jwtTokenProvider.validateToken(token)) {
            val userId = jwtTokenProvider.getUserId(token)
            val username = jwtTokenProvider.getUsername(token)
            val authentication = UsernamePasswordAuthenticationToken(
                CustomUserDetails(userId, username),
                null,
                emptyList()
            )
            SecurityContextHolder.getContext().authentication = authentication
        }
        filterChain.doFilter(request, response)
    }

    private fun resolveToken(request: HttpServletRequest): String? {
        val bearer = request.getHeader("Authorization") ?: return null
        return if (bearer.startsWith("Bearer ")) bearer.substring(7) else null
    }

}
