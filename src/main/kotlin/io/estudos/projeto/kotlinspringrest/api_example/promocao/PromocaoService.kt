package io.estudos.projeto.kotlinspringrest.api_example.promocao

interface PromocaoService {
    fun create(request: PromocaoRequest)
    fun getById(id:Long): Promocao?
    fun delete(id:Long)
    fun update(id:Long,request: PromocaoRequest): Promocao?
    fun searchByLocal(): List<Promocao>
    fun getAll(start:Int,size:Int):List<Promocao>
    fun getPorPrecoMenorQue(preco: Double, dias: Int): List<Promocao>
}