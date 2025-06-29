package com.hhplus.board.db

import jakarta.persistence.*

@Entity
@Table(name = "articles", schema = "board")
@SequenceGenerator(
    name = "article_seq",
    sequenceName = "articles_article_no_seq",
    allocationSize = 1
)
class ArticleEntity(
    @Column(name = "title", nullable = false, length = 100)
    private var title: String,

    @Column(name = "user_no", nullable = false)
    private var author: Long,

    @Column(name = "content", columnDefinition = "TEXT")
    private var content: String?,
) : BaseTimeEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "article_seq")
    @Column(name = "article_no", nullable = false)
    val id: Long? = null


    companion object {
        fun create(title: String, author: Long, content: String?): ArticleEntity {
            return ArticleEntity(title, author, content)
        }
    }

    fun update(title: String, author: Long, content: String?) {
        this.title = title
        this.author = author
        this.content = content
    }

    val currentTitle get() = title
    val currentAuthor get() = author
    val currentContent get() = content
}
