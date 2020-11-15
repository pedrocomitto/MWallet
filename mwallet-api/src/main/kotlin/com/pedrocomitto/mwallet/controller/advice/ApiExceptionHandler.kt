package com.pedrocomitto.mwallet.controller.advice

import com.pedrocomitto.mwallet.exception.AssetNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ApiExceptionHandler {

    @ExceptionHandler(AssetNotFoundException::class)
    fun handleAssetNotFoundException(exception: Exception) =
        ResponseEntity.status(HttpStatus.NOT_FOUND)
}