package io.estudos.projeto.advice

import com.fasterxml.jackson.core.JsonParseException
import io.estudos.projeto.exception.PromocaoNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@ControllerAdvice
class ErrorHandler {
    @ExceptionHandler(JsonParseException::class)
    fun JsonFormatExceptionHandler(
        servletRequest: HttpServletRequest,
        servletResponse: HttpServletResponse,
        exception: Exception
    ):ResponseEntity<ErrorMessage>{
        return ResponseEntity(ErrorMessage("JSON ERROR", exception.message ?: "invalid json"), HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(PromocaoNotFoundException::class)
    fun PromocaoNotFoundExceptionHandler(
        servletRequest: HttpServletRequest,
        servletResponse: HttpServletResponse,
        exception: Exception
    ):ResponseEntity<ErrorMessage>{
        return ResponseEntity(
            ErrorMessage(
            "Promocao nao localizada",
            exception.message!!
        ), HttpStatus.NOT_FOUND)
    }
}