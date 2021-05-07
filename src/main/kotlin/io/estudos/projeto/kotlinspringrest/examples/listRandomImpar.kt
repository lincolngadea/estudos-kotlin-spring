package io.estudos.projeto.kotlinspringrest.examples

import kotlin.random.Random

/**
 * Cria uma lista randômica de 100 inteiros aleatórios de 0 a 100 e devolve apenas os elementos ímpares
 */
fun main(){

    val listRandom = List(100){ Random.nextInt(0,100)}

    val impar = listRandom.filter { it % 2 != 0 }
    println(impar)

}