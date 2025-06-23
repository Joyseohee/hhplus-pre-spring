package com.hhplus.board.db

import jakarta.persistence.*
import org.hibernate.annotations.ColumnDefault
import java.time.Instant

@Entity
@Table(name = "articles", schema = "board")
open class ArticleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "article_no", nullable = false)
    open var id: Long? = null

    @Column(name = "title", nullable = false, length = 150)
    open var title: String? = null

    @Column(name = "author", nullable = false, length = 24)
    open var author: String? = null

    @Column(name = "content", length = Integer.MAX_VALUE)
    open var content: String? = null

    @Column(name = "password", nullable = false, length = 244)
    open var password: String? = null

    @ColumnDefault("now()")
    @Column(name = "created_at", nullable = false)
    open var createdAt: Instant? = null

    @Column(name = "modified_at")
    open var modifiedAt: Instant? = null
}
