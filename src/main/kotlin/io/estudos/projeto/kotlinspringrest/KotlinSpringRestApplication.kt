package io.estudos.projeto.kotlinspringrest

import io.estudos.projeto.kotlinspringrest.api_example.promocao.Promocao
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import java.util.concurrent.ConcurrentHashMap

@SpringBootApplication
class KotlinSpringRestApplication

fun main(args: Array<String>) {
	runApplication<KotlinSpringRestApplication>(*args)
}


