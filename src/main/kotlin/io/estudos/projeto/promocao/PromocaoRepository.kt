package io.estudos.projeto.promocao

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface PromocaoRepository: JpaRepository<Promocao, Long> {

    @Query(value= "select p from Promocao p where p.preco <= :preco and p.qtdDiarias > :dias")
    fun findByPrecoMenorQue(
        @Param("preco") preco: Double,
        @Param("dias") dias: Int
    ): List<Promocao>
}