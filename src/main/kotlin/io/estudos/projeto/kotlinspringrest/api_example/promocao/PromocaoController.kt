package io.estudos.projeto.kotlinspringrest.api_example.promocao

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import java.util.concurrent.ConcurrentHashMap
import javax.validation.Valid

@RestController
@Validated
class PromocaoController {

    @Autowired
    lateinit var  promocoes: ConcurrentHashMap<Long,Promocao>

    @PostMapping("/promocoes")
    fun criaPromocao(@RequestBody @Valid request: PromocaoRequest): Promocao?{

        promocoes[request.id] = request.toModel()

        return promocoes[request.id]
    }

    @GetMapping("/promocoes/{id}")
    fun listaPromocao(@PathVariable id: Long): Promocao? {
        return promocoes[id]
    }
}