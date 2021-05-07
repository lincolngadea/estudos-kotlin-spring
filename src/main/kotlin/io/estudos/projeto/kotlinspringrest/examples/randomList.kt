package io.estudos.projeto.kotlinspringrest.examples

import kotlin.math.sqrt
import kotlin.random.Random
import kotlin.collections.List as List

/**
 * Cria uma lista randômica de 100 inteiros aleatórios de 0 a 100
 */
fun main(){

    val listRandom = List(100){Random.nextInt(0,100)}

    println(listRandom)

    println()
    doubleList()

    println()
    mediaList()
}

/**
 * Cria uma lista randômica de 100 doubles aleatórios de 0 a 100 e calcula a raiz quadrada de cada elemento da lista
 */
fun doubleList(){
    val listRandom = List(100){ Random.nextDouble(0.0,100.0)}
    val calcRaizQuadrada = listRandom.map { sqrt(it) }
    println("Lista com a raiz Quadrada:\n $calcRaizQuadrada")
}

/**
 * Cria uma lista de 50 inteiros aleatórios e calcula a média deles. (Utilizando Reduce)
 */

fun mediaList(){
    val listRandom = List(50){ Random.nextInt(0,100)}
    val soma = listRandom.reduce{acc,valor -> acc + valor}
    println("Media da Turma: ${soma/listRandom.size}")
}
