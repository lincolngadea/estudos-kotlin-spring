package io.estudos.projeto.kotlinspringrest

/**
 * Cria um exemplo que filtra uma lista com uma String que comece com uma letra específica
 */
fun main() {
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

    val filtro = lista.filter { it[0] == 'B' }
    println(filtro)
}