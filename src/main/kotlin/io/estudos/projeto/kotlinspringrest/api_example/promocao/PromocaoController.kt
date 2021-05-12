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
    lateinit var promocoes: ConcurrentHashMap<Long, Promocao>

    @PostMapping("/promocoes")
    fun cria(@RequestBody @Valid request: PromocaoRequest): Promocao? {

        promocoes[request.id] = request.toModel()
        return promocoes[request.id]
    }

    @GetMapping("/promocoes/{id}")
    fun lista(@PathVariable id: Long): Promocao? {
        return promocoes[id]
    }

    @DeleteMapping("/promocoes/{id}")
    fun deleta(@PathVariable id: Long): Promocao? {
        promocoes.remove(id)
        return promocoes[id]
    }

    @PutMapping("/promocoes/{id}")
    fun atualiza(@PathVariable id: Long, @RequestBody request: PromocaoRequest): Promocao? {
        promocoes.remove(id)
        promocoes[id] = request.toModel()
        return promocoes[id]
    }

    @GetMapping("/promocoes")
    fun listaTudo(@RequestParam(required = false, defaultValue = "") localFilter: String) =
        promocoes.filter {
            it.value.local.contains(localFilter, true)
        }.map(Map.Entry<Long, Promocao>::value).toList()
}