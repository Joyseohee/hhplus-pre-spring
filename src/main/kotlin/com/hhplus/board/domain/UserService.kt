package com.hhplus.board.domain

import com.hhplus.board.db.UserEntity
import com.hhplus.board.db.UserRepository
import com.hhplus.board.security.JwtTokenProvider
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
    private val jwtTokenProvider: JwtTokenProvider
) {
    fun createUser(userCreate: UserCreate)  {
        val userEntity = userCreate.toUserEntity()
        if (userRepository.existsByUsername(userEntity.userName)) {
            throw IllegalArgumentException("Username already exists")
        }
        userRepository.save(userEntity)
    }

    fun signIn(toUserSignIn: UserSignIn): LoginResponse {
        val userEntity = userRepository.findByUsername(toUserSignIn.username)
            ?: throw IllegalArgumentException("User not found")
        userEntity.verifyPassword(toUserSignIn.password)


        val token = jwtTokenProvider.createToken(userEntity.id, userEntity.userName)

        return LoginResponse(token = token)
    }

    fun findUserById(id: Long): UserEntity = userRepository.findById(id).orElseThrow {
        NoSuchElementException("User not found with id: $id")
    }
}
