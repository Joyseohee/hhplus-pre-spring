package com.hhplus.board.domain

import jakarta.persistence.Column
import jakarta.persistence.MappedSuperclass
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.Instant

@MappedSuperclass
abstract class BaseTimeEntity {
    @CreationTimestamp
    @Column(updatable = false)
    open val createdAt: Instant = Instant.now()

    @UpdateTimestamp
    open val updatedAt: Instant? = null
}
