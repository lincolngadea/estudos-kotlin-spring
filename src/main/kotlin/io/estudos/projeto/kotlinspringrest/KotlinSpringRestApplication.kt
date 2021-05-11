package io.estudos.projeto.kotlinspringrest

import io.estudos.projeto.kotlinspringrest.api_example.promocao.Promocao
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import java.util.concurrent.ConcurrentHashMap

@SpringBootApplication
class KotlinSpringRestApplication{
	companion object{
		val initialPromocoes = arrayOf(
			Promocao(1,"Promoção dia das mães","Rio de Janeiro",true,5),
			Promocao(2,"Promoção Inverno","Campos",true,5),
			Promocao(3,"Promoção Radical","Amazônia",false,14),
			Promocao(4,"Promoção de família","Aracaju",false,14)
		)
	}
	@Bean
<<<<<<< HEAD
	fun promocoes() = ConcurrentHashMap<Long, Promocao>(initialPromocoes.associateBy(Promocao::id))
=======
	fun promocoes() = ConcurrentHashMap<Long,Promocao>(initialPromocoes.associateBy(Promocao::id))
>>>>>>> 827758abe292432942b5727af2e3cdf726b9e057
}

fun main(args: Array<String>) {
	runApplication<KotlinSpringRestApplication>(*args)
}


