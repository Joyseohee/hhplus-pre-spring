package com.hhplus.board.api.controller

import com.hhplus.board.support.error.ApiResponse
import com.hhplus.board.support.error.ErrorType
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ApiControllerAdvice {
    private val log: Logger = LoggerFactory.getLogger(javaClass)

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleCoreException(e: IllegalArgumentException): ResponseEntity<ApiResponse<Any>> {
        return ResponseEntity(ApiResponse.error(ErrorType.UNAUTHORIZED, e.message), ErrorType.UNAUTHORIZED.status)
    }


    @ExceptionHandler(NoSuchElementException::class)
    fun handleCoreException(e: NoSuchElementException): ResponseEntity<ApiResponse<Any>> {
        return ResponseEntity(ApiResponse.error(ErrorType.NOT_FOUND, e.message), ErrorType.NOT_FOUND.status)
    }

    @ExceptionHandler(Exception::class)
    fun handleException(e: Exception): ResponseEntity<ApiResponse<Any>> {
        log.error("Exception : {}", e.message, e)
        return ResponseEntity(ApiResponse.error(ErrorType.DEFAULT_ERROR), ErrorType.DEFAULT_ERROR.status)
    }
}
