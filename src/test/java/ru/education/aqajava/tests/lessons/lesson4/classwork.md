## Lesson 2. Hamcrest и Junit5

[Полный список hotkeys ](https://devcolibri.com/%D0%B3%D0%BE%D1%80%D1%8F%D1%87%D0%B8%D0%B5-%D0%BA%D0%BB%D0%B0%D0%B2%D0%B8%D1%88%D0%B8-intellij-idea/)

### Hamcrest

Добавление в проект зависимостей

```groovy
dependencies {
    testImplementation 'org.hamcrest:java-hamcrest:2.0.0.0'
}
```

Отличная статейка по [JsonPath](https://testerslittlehelper.wordpress.com/2019/01/20/jsonpath-in-rest-assured/)

Отличные статейки про Hamcrest

[Туториал по Hamcrest](http://hamcrest.org/JavaHamcrest/tutorial)  
[Testing with Hamcrest](https://www.baeldung.com/java-junit-hamcrest-guide)

### Junit5
Добавление в проект зависимостей

```groovy
dependencies {
    testImplementation 'org.junit.jupiter:junit-jupiter-api:5.8.2'
    testImplementation 'org.junit.jupiter:junit-jupiter-params:5.8.2'
    testRuntimeOnly 'org.junit.jupiter:junit-jupiter-engine:5.8.2'
}

test {
    // Находит и выполняет тесты построенные на платформе Junit
    useJUnitPlatform()
}

```
