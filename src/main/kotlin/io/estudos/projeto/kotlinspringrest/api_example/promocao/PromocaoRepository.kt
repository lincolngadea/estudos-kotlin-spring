package io.estudos.projeto.kotlinspringrest.api_example.promocao

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PromocaoRepository: JpaRepository<Promocao, Long> {
}