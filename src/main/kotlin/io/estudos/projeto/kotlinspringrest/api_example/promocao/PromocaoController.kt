package io.estudos.projeto.kotlinspringrest.api_example.promocao

import io.estudos.projeto.kotlinspringrest.api_example.exception.PromocaoNotFoundException
import io.estudos.projeto.kotlinspringrest.api_example.utils.RespostaJsonCustom
import net.bytebuddy.implementation.bytecode.Throw
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid

@RestController
@Validated
@RequestMapping("/promocoes")
class PromocaoController {

    @Autowired
    lateinit var promocaoService: PromocaoService

    @PostMapping
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
        try {
            var promocao = promocaoService.getById(id)
            var respostaJson = RespostaJsonCustom("DELETED OK", Date())
            promocaoService.delete(id)
            return ResponseEntity("Dados Deletados com Sucesso!",HttpStatus.OK)
        }catch (e: Exception){
            return ResponseEntity(e.message,HttpStatus.BAD_REQUEST)
        }
    }

    @PutMapping("/{id}")
    fun updateById(@PathVariable id: Long, @RequestBody request: PromocaoRequest): ResponseEntity<Promocao?>{
        promocaoService.delete(id)
        promocaoService.create(request)
        return ResponseEntity(promocaoService.getById(id),HttpStatus.OK)
    }

    @GetMapping
    fun getAll(): List<Promocao?>{
        return promocaoService.getAll()
    }

}