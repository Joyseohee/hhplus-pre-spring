package com.hhplus.board.db

import jakarta.persistence.Column
import jakarta.persistence.MappedSuperclass
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.Instant

@MappedSuperclass
abstract class BaseTimeEntity {
    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    open val createdAt: Instant = Instant.now()

    @UpdateTimestamp
    @Column(name = "modified_at")
    open val modifiedAt: Instant? = Instant.now()
}
