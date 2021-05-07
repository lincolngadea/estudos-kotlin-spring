package io.estudos.projeto.kotlinspringrest.api_example.promocao

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class PromocaoController {

    @GetMapping("/promocoes")
    fun helloWord(): String {
        return "Hello World"
    }
}