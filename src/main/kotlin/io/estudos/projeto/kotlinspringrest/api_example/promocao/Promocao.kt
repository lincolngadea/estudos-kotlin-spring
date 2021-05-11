package io.estudos.projeto.kotlinspringrest.api_example.promocao

class Promocao(
    val id: Long,
    val descricao: String,
    val local: String,
    val allInclusive: Boolean,
    val qtdDiarias: Int
)