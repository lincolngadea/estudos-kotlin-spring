package io.estudos.projeto.kotlinspringrest

/**
 * Cria um exemplo que filtra uma lista com uma String que comece com uma letra específica
 */
fun main(){
    val lista = listOf(
        "Lincoln",
        "Rafael",
        "Pedro",
        "Jackeline",
        "Christiny",
        "Jackson",
        "Eugrácia",
        "Ananias",
        "Shara",
        "Belizário",
        "Bárbara"
    )

    val filtro = lista.filter { primeiro(it,"B")}
    println(filtro)

//    val substring = lista[0].substring(0,1) == "L"
//    println(substring)
}
fun primeiro(iterador: String, letra: String)= (iterador.substring(0,1)=="B")