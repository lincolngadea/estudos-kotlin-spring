package io.estudos.projeto.kotlinspringrest.examples

import kotlin.random.Random

/**
 * Cria uma lista de 50 inteiros aleatórios e calcula a média deles. (Utilizando Reduce)
 */
fun main(){

    val listRandom = List(50){ Random.nextInt(0,100)}
    val soma = listRandom.reduce{acc,valor -> acc + valor}
    println("Media da Turma: ${soma/listRandom.size}")
}
