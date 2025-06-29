package com.hhplus.board.db

import jakarta.persistence.*
import org.springframework.security.crypto.bcrypt.BCrypt

@Entity
@Table(name = "users")
@SequenceGenerator(
    name = "user_seq",
    sequenceName = "users_user_no_seq",
    allocationSize = 1
)
class UserEntity(
    @Column(name = "username", nullable = false, length = 50, unique = true)
    private var username: String,

    @Column(name = "password", nullable = false, length = 244)
    private var password: String,
) : BaseTimeEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @Column(name = "user_no", nullable = false)
    val id: Long = 0L

    companion object {
        fun create(username: String, password: String): UserEntity {
            return UserEntity(username, encodePassword(password))
        }

        private fun encodePassword(rawPassword: String): String {
            return BCrypt.hashpw(rawPassword, BCrypt.gensalt())
        }
    }

    fun verifyPassword(input: String?) {
        if (!BCrypt.checkpw(input, password)) {
            throw IllegalArgumentException("비밀번호가 일치하지 않습니다.")
        }
    }

    fun changePassword(oldPassword: String, newPassword: String) {
        verifyPassword(oldPassword)
        password = encodePassword(newPassword)
    }

    val userName: String get() = username
}
