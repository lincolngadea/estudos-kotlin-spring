package io.estudos.projeto.kotlinspringrest.api_example.promocao

  data class PromocaoRequest(
    private val descricao: String,
    private val local: String,
    private val isAllInclusive: Boolean,
    private val qtdDiarias: Int
  ) {

    fun toModel(): Promocao {
        return Promocao(descricao,local,isAllInclusive,qtdDiarias)
    }
}
