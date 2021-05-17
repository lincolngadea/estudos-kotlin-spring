package io.estudos.projeto.kotlinspringrest.api_example.promocao

import org.springframework.stereotype.Component

@Component
class PromocaoServiceImpl(val promocaoRepository: PromocaoRepository): PromocaoService {

    override fun create(request: PromocaoRequest) {
        val promocoes: Promocao = request.toModel()
        promocaoRepository.save(promocoes)
    }

    override fun getById(id: Long): Promocao? {
        return promocaoRepository.findById(id).orElseGet(null)
    }

    override fun delete(id: Long) {
        promocaoRepository.deleteById(id)
    }

    override fun update(id: Long, request: PromocaoRequest): Promocao? {
        delete(id)
        create(request)
        return Promocao()
    }

    override fun searchByLocal(local: String): List<Promocao> {
        TODO("Not yet implemented")
    }

    override fun getAll(): List<Promocao> {
        return promocaoRepository.findAll()
    }
}
