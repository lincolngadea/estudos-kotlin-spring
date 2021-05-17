package io.estudos.projeto.kotlinspringrest.api_example.promocao

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Promocao(
    val descricao: String ="",
    val local: String = "",
    val allInclusive: Boolean = false,
    val qtdDiarias: Int = 0
){
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
}