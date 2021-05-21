package io.estudos.projeto.promocao

import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Component

@Component
class PromocaoServiceImpl(val promocaoRepository: PromocaoRepository): PromocaoService {

    @CacheEvict("promocoes",allEntries = true)
    override fun create(request: PromocaoRequest) {
        val promocoes: Promocao = request.toModel()
        promocaoRepository.save(promocoes)
    }

    override fun getById(id: Long): Promocao? =
        promocaoRepository.findById(id).orElseGet(null)

    @CacheEvict("promocoes",allEntries = true)
    override fun delete(id: Long) =
        promocaoRepository.deleteById(id)

    @CacheEvict("promocoes",allEntries = true)
    override fun update(id: Long, request: PromocaoRequest): Promocao? {
        delete(id)
        create(request)
        return Promocao()
    }

    override fun searchByLocal(): List<Promocao> =
        promocaoRepository.findAll(Sort.by("local").descending()).toList()

    @Cacheable("promocoes")
    override fun getAll(start: Int, size: Int): List<Promocao> {
        val pages = PageRequest.of(start, size)
        return promocaoRepository.findAll(pages).toList()
    }

    override fun getPorPrecoMenorQue(preco: Double, dias: Int): List<Promocao> =
        promocaoRepository.findByPrecoMenorQue(preco,dias)

}
/*
Sempre que criamos um cache é importante que ele não seja utilizado em toda a aplicação,
pois estaríamos utilizando um recurso caro, que é a memória ram só para uso do cache e
sempre que precisarmos destruir o cache para reconstruir novamente em um DML da vida,
iríamos consumir mais tempo trabalhando o cache do que a própria operação requisitada.
Dessa forma é uma boa prática criar o cache apenas em tabelas que são pouco utilizadas
como uma tabela de cidade, cep, endereços...etc
 */