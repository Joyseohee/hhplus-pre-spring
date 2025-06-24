package com.hhplus.board.db

import com.hhplus.board.domain.BaseTimeEntity
import jakarta.persistence.*

@Entity
@Table(name = "articles", schema = "board")
@SequenceGenerator(name = "article_no_generator", sequenceName = "articles_article_no_seq", allocationSize = 1)
class ArticleEntity(
    @Column(name = "title", nullable = false, length = 150)
    private var title: String,

    @Column(name = "author", nullable = false, length = 24)
    private var author: String,

    @Column(name = "content", columnDefinition = "TEXT")
    private var content: String?,

    @Column(name = "password", nullable = false, length = 244)
    private var password: String,
) : BaseTimeEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "article_no_generator")
    @Column(name = "article_no", nullable = false)
    val id: Long = 0

    companion object {
        fun create(title: String, author: String, content: String?, password: String): ArticleEntity {
            return ArticleEntity(title, author, content, password)
        }
    }

    fun verifyPassword(input: String?) {
        if (input != password) {
            throw IllegalArgumentException("비밀번호가 일치하지 않습니다.")
        }
    }

    fun changePassword(oldPassword: String, newPassword: String) {
        verifyPassword(oldPassword)
        password = newPassword
    }

    fun update(newTitle: String?, newAuthor: String?, newContent: String?, password: String?): ArticleEntity {
        verifyPassword(password)
        if (newTitle != null) this.title = newTitle
        if (newAuthor != null) this.author = newAuthor
        if (newContent != null) this.content = newContent
        return this
    }

    fun getTitle() = title
    fun getAuthor() = author
    fun getContent() = content
}
