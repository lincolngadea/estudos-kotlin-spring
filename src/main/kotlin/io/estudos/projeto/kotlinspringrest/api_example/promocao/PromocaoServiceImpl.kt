package io.estudos.projeto.kotlinspringrest.api_example.promocao

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
