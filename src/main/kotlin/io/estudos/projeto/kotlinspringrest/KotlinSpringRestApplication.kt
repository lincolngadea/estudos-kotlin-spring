package io.estudos.projeto.kotlinspringrest

import io.estudos.projeto.kotlinspringrest.api_example.promocao.Promocao
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinSpringRestApplication{
	companion object{
		val initialPromocoes = arrayOf(
			Promocao(1,"Promoção dia das mães","Rio de Janeiro",true,5),
			Promocao(2,"Promoção Inverno","Campos",true,5),


		)
	}
}

fun main(args: Array<String>) {
	runApplication<KotlinSpringRestApplication>(*args)
}


