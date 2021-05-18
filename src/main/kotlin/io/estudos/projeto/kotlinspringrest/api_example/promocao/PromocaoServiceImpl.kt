package io.estudos.projeto.kotlinspringrest.api_example.promocao

import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Component

@Component
class PromocaoServiceImpl(val promocaoRepository: PromocaoRepository): PromocaoService {

    override fun create(request: PromocaoRequest) {
        val promocoes: Promocao = request.toModel()
        promocaoRepository.save(promocoes)
    }

    override fun getById(id: Long): Promocao? =
        promocaoRepository.findById(id).orElseGet(null)

    override fun delete(id: Long) =
        promocaoRepository.deleteById(id)

    override fun update(id: Long, request: PromocaoRequest): Promocao? {
        delete(id)
        create(request)
        return Promocao()
    }

    override fun searchByLocal(): List<Promocao> =
        promocaoRepository.findAll(Sort.by("local").descending()).toList()

    override fun getAll(start: Int, size: Int): List<Promocao> {
        val pages = PageRequest.of(start, size)
        return promocaoRepository.findAll(pages).toList()
    }


}
