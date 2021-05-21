package io.estudos.projeto.promocao

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Promocao(
    val descricao: String ="",
    val local: String = "",
    val isAllInclusive: Boolean = false,
    val qtdDiarias: Int = 0,
    val preco: Double = 0.0
){
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
}