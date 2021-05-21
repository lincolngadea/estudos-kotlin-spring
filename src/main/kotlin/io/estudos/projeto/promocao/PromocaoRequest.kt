package io.estudos.projeto.promocao

  data class PromocaoRequest(
    private val descricao: String,
    private val local: String,
    private val isAllInclusive: Boolean,
    private val qtdDiarias: Int,
    private val preco: Double
  ) {

    fun toModel(): Promocao {
        return Promocao(descricao,local,isAllInclusive,qtdDiarias,preco)
    }
}
