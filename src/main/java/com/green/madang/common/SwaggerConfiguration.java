package com.green.madang.common;

//Swagger 타이틀 바꾸기 설정. 기본패키지 안이라면 클래스 위치가 어디든 상관없이 에노테이션만 잘쓰면됨.

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
             title= "마당서점",
             description ="Madang API",
             version="v0.0.1"
        )
)
public class SwaggerConfiguration {
}
