package io.estudos.projeto.kotlinspringrest.api_example.promocao

import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import java.util.concurrent.ConcurrentHashMap

@Component
class PromocaoServiceImpl: PromocaoService {
    companion object{
        val initialPromocoes = arrayOf(
            Promocao(1,"Promoção dia das mães","Rio de Janeiro",true,5),
            Promocao(2,"Promoção Inverno","Campos",true,5),
            Promocao(3,"Promoção Radical","Amazônia",false,14),
            Promocao(4,"Promoção de família","Aracaju",false,14)
        )
    }

    var promocoes = ConcurrentHashMap<Long,Promocao>(initialPromocoes.associateBy(Promocao::id))

    override fun create(request: PromocaoRequest) {
        promocoes[request.id] = request.toModel()
    }

    override fun getById(id: Long): Promocao? {
        return promocoes[id]
    }

    override fun delete(id: Long) {
        promocoes.remove(id)
    }

    override fun update(id: Long, request: PromocaoRequest): Promocao? {
        delete(id)
        create(request)
        return promocoes[id]
    }

    override fun searchByLocal(local: String): List<Promocao> =
        promocoes.filter {
            it.value.local.contains(local, true)
        }.map(Map.Entry<Long, Promocao>::value).toList()

}