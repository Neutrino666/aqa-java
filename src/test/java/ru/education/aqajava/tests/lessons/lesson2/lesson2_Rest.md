##Lesson 2. Пишем тесты с использованием Rest Assured

Добавление в проект зависимостей

```groovy
dependencies {
    //Добавление библиотеки Rest Assured в проект
    testImplementation 'io.rest-assured:rest-assured:5.0.1'
    //Добавление библиотеки json
    implementation 'org.json:json:20210307'
}
```

**Структура запросов Rest Assured**

```java

@Test
void checkStoreInventoryStatusCode() {

    given()
            //формирование запроса(Request)
            .when()
            //выполнение запроса
            .then()
    //получение ответа(Response) от сервера и работа с ним
}

```

send **GET** request and check status code

```java

@Test
void checkStoreInventoryStatusCode() {

    given()
            .when()
            //вывод в консоль запроса
            .log().all()
            //выполнение метода get(url)
            .get("https://petstore.swagger.io/v2/store/inventory")
            .then()
            //вывод в консоль ответа
            .log().all()
            //проверка кода ответа от сервера
            .statusCode(200);
}

```

```java

@Test
void printResponseBody() {
    String body = given()
            .when()
            .log().all()
            .get("https://petstore.swagger.io/v2/store/inventory")
            .then()
            .statusCode(200)
            .log().all()
            //извлекаем ответ
            .extract()
            .body()
            .asString();

    //вывод в консоль
    System.out.println(body);
}

```

```java

@Test
void getStoreOrder() {
    given()
            .when()
            .log().all()
            //передача параметра в метод
            .pathParam("id", 2)
            .get("https://petstore.swagger.io/v2/store/order/{id}")
            .then()
            .log().all()
            .statusCode(200);
}
```

send **POST** request and check status code

```java

@Test
void postNewStoreOrder() {

    // формируем тело запроса, в строковом формате
    String body = "{\n" +
            "  \"id\": 1,\n" +
            "  \"petId\": 1,\n" +
            "  \"quantity\": 1,\n" +
            "  \"shipDate\": \"2022-04-11T04:23:19.390Z\",\n" +
            "  \"status\": \"placed\",\n" +
            "  \"complete\": true\n" +
            "}";
    // формируем тело запроса с использованием объекта JSONObject
    JSONObject bodyJO = new JSONObject()
            .put("id", 5)
            .put("petId", 1)
            .put("quantity", 1)
            .put("shipDate", "2022-04-11T04:23:19.390Z")
            .put("status", "placed")
            .put("complete", true);

    given()
            .when()
            //определяем header Content-Type, т.к шлем json
            .contentType(ContentType.JSON)
            .log().all()
            //указываем тело запроса
            .body(bodyJO.toString())
            .post("https://petstore.swagger.io/v2/store/order")
            .then()
            .log().all()
            .statusCode(200);
}

```

send **DELETE** request and check status code

```java

@Test
void deleteStoreOrder() {
    given()
            .when()
            .log().all()
            .pathParam("orderId", 5)
            .delete("https://petstore.swagger.io/v2/store/order/{orderId}")
            .then()
            .log().all()
            .statusCode(200);
}

```

send **PUT** request and check status code

```java

@Test
void updatePet() {
    String dogsName = "chappi";
    JSONObject bodyJO = new JSONObject()
            .put("id", 5)
            .put("name", dogsName)
            .put("status", "available");


    given()
            .when()
            .contentType(ContentType.JSON)
            .log().all()
            .body(bodyJO.toString())
            .put("https://petstore.swagger.io/v2/pet")
            .then()
            .log().all()
            .statusCode(200);
}

```
