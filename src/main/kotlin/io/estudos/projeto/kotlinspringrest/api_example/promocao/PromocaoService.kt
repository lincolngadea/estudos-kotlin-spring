package io.estudos.projeto.kotlinspringrest.api_example.promocao

interface PromocaoService {
    fun create(request: PromocaoRequest)
    fun getById(id:Long): Promocao?
    fun delete(id:Long)
    fun update(id:Long,request: PromocaoRequest): Promocao?
    fun searchByLocal(local:String): List<Promocao>
    fun getAll():List<Promocao>
}