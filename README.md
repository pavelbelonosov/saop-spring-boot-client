## SOAP Spring Boot Client

Приложение представляет небольшой веб-клиент для работы с публичным SOAP API.  
Каждые 30 минут приложение отправляет POST запрос на эндпоинт:  
`http://webservices.oorsprong.org/websamples.countryinfo/CountryInfoService.wso`  
и сохраняет полученный из респонса список стран с сопутствующими атрибутами в базу данных.

Spring Boot, Gradle, H2

Сгенерировать объекты из WSDL `./gradlew compileJava`  
Сборка `./gradlew build`  
Старт `java -jar build/libs/saop-spring-boot-client-0.0.1.jar`  
