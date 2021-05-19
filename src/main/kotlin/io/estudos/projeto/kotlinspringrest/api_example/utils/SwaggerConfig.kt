package io.estudos.projeto.kotlinspringrest.api_example.utils

import org.springframework.context.annotation.Configuration
import springfox.documentation.service.ApiInfo
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Configuration
@EnableSwagger2
class SwaggerConfig {
    private fun metaData(): ApiInfo{
        return ApiInfo()
            .title("API DE VIAGENS")
    }
}