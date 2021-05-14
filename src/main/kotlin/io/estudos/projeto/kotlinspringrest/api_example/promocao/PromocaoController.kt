package io.estudos.projeto.kotlinspringrest.api_example.promocao

import io.estudos.projeto.kotlinspringrest.api_example.exception.PromocaoNotFoundException
import io.estudos.projeto.kotlinspringrest.api_example.utils.RespostaJsonCustom
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import java.util.*
import java.util.concurrent.ConcurrentHashMap
import javax.validation.Valid

@RestController
@Validated
@RequestMapping("/promocoes")
class PromocaoController {

    @Autowired
    lateinit var promocaoService: PromocaoService

    @PostMapping()
    fun create(@RequestBody @Valid request: PromocaoRequest): ResponseEntity<RespostaJsonCustom>{


        val promocao = promocaoService.create(request)
        val respostaJson = RespostaJsonCustom("ok", Date())
        return ResponseEntity(respostaJson,HttpStatus.CREATED)
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<Promocao?>{
        val promocao = promocaoService.getById(id) ?:
            throw PromocaoNotFoundException("promocao ${id} nao localizada")
        return ResponseEntity(promocao,HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: Long): ResponseEntity<Any>{
        var promocao = promocaoService.getById(id)

        return if(promocao == null) {
            ResponseEntity("Parece que você informou algo errado",HttpStatus.BAD_REQUEST)
        } else {
            promocaoService.delete(id)
            ResponseEntity("Dados Deletados com Sucesso!",HttpStatus.OK)
        }
    }

    @PutMapping("/{id}")
    fun updateById(@PathVariable id: Long, @RequestBody request: PromocaoRequest): ResponseEntity<Promocao?>{
        promocaoService.delete(id)
        promocaoService.create(request)
        return ResponseEntity(promocaoService.getById(request.id),HttpStatus.OK)
    }

    @GetMapping()
    fun searchLocal(@RequestParam(required = false,defaultValue = "") local: String):ResponseEntity<List<Promocao>>{
        val busca= promocaoService.searchByLocal(local)
        if (busca.isEmpty()) {
            return ResponseEntity(HttpStatus.NOT_FOUND)
        }
        return ResponseEntity(busca,HttpStatus.OK)
    }

}