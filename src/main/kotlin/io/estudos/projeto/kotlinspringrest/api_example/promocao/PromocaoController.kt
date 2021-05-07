package io.estudos.projeto.kotlinspringrest.api_example.promocao

import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@Validated
class PromocaoController {

    @PostMapping("/promocoes")
    fun criaPromocao(@RequestBody @Valid request: PromocaoRequest?): Promocao? {
        return request?.toModel()
    }
}