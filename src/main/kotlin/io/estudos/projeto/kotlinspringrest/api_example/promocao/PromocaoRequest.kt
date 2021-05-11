package io.estudos.projeto.kotlinspringrest.api_example.promocao

  class PromocaoRequest(
    val id: Long,
    private val descricao: String,
    private val local: String,
    private val isAllInclusive: Boolean,
    private val qtdDiarias: Int
  ) {

    fun toModel(): Promocao {
        return Promocao(id,descricao,local,isAllInclusive,qtdDiarias)
    }
}
