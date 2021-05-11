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
    fun cria(@RequestBody @Valid request: PromocaoRequest): ConcurrentHashMap<Long, Promocao>{

        promocoes[request.id] = request.toModel()
        return promocoes
    }

    @GetMapping("/promocoes/{id}")
    fun lista(@PathVariable id: Long): Promocao? {
        return promocoes[id]
    }

    @DeleteMapping("/promocoes/{id}")
    fun deleta(@PathVariable id: Long): ConcurrentHashMap<Long, Promocao>{
        promocoes.remove(id)
        return promocoes
    }

    @PutMapping("/promocoes/{id}")
    fun atualiza(@PathVariable id: Long, @RequestBody request: PromocaoRequest): ConcurrentHashMap<Long, Promocao>{
        promocoes.remove(id)
        promocoes[id] = request.toModel()
        return promocoes
    }
}