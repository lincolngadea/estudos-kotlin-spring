package io.estudos.projeto.kotlinspringrest.examples

import kotlin.random.Random
import kotlin.collections.List as List

/**
 * Cria uma lista randômica de 100 inteiros aleatórios de 0 a 100
 */
fun main(){

    val listRandom = List(100){Random.nextInt(0,100)}

    println(listRandom)

}

